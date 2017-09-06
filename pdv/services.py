import json
from functools import partial

from .models import (
    Address as ModelAddress,
    Pdv as ModelPdv,
    CoverageArea as ModelCoverageArea
)


class Pdv(object):

    def __init__(self, **args):
        self.id = args.get('id')
        self.trading_name = args.get('trading_name')
        self.owner_name = args.get('owner_name')
        self.document = args.get('document')
        self.coverage_coordinates = json.dumps(
            args.get('coverage_area_coords')
        )
        self.address_coordinates = json.dumps(args.get('address_coords'))
        self.model = ModelPdv()

    def save(self):
        if self.id:
            model_pdv = self.get_by(self.id)
        else:
            model_pdv = self.model

        model_pdv.trading_name = self.trading_name
        model_pdv.owner_name = self.owner_name
        model_pdv.document = self.document
        model_pdv.coverage_area = ModelCoverageArea()
        model_pdv.coverage_area.coordinates = self.coverage_coordinates
        model_pdv.address = ModelAddress()
        model_pdv.address.coordinates = self.address_coordinates

        model_pdv.query.session.add(model_pdv)
        model_pdv.query.session.commit()
        model_pdv.query.session.flush()

        return model_pdv

    def get_by_id(self, id):
        return self.model.query.get(id)

    def _find_nearest_coordinate(self, coordinates, lat, lng):
        def distance(source, dest):
            return (source[0]-dest[0])**2+(source[1]-dest[1])**2

        return min(coordinates, key=partial(distance, (lat, lng)))

    def _get_pdv_from_list_by_coordinates(self, pdvs, coordinates):
        found = None
        for pdv in pdvs:
            if coordinates == [pdv_coord for pdv_coord in pdv.values()][0]:
                found = [pdv_id for pdv_id in pdv.keys()][0]
                return self.get_by_id(found)

        return None

    def find_near_by_location(self, latitude, longitude):
        cursor = self.model.query
        areas = None
        lt_pdv = None
        lng_pdv = None
        coordinates_to_find = []
        pdvs_coordinates = []
        for reg in cursor:
            areas = json.loads(reg.coverage_area.coordinates)[0][0]
            if [latitude, longitude] in areas:
                lt_pdv = json.loads(reg.address.coordinates)[0]
                lng_pdv = json.loads(reg.address.coordinates)[1]
                coordinates_to_find.append((lt_pdv, lng_pdv))
                pdvs_coordinates.append({reg.id: (lt_pdv, lng_pdv)})

        if not coordinates_to_find:
            return None

        min_coordinate = self._find_nearest_coordinate(coordinates_to_find,
                                                       latitude,
                                                       longitude)

        found = self._get_pdv_from_list_by_coordinates(pdvs_coordinates,
                                                       min_coordinate)

        return found
