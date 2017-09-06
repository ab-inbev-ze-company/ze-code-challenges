import json
from . import app
from flask import make_response, jsonify, request
from pdv.services import Pdv


@app.route('/', methods=['GET'])
def healthcheck():
    return make_response(jsonify({'msg': 'OK'}), 200)


@app.route('/find-by-id/<id>', methods=['GET'])
def find_by_id(id):
    service = Pdv()
    result = service.get_by_id(id)

    if not result:
        response = {
            "error": "No pdv found for id %s" % id
        }
        return make_response(jsonify(response), 404)

    response = {
        "id": result.id,
        "tradingName": result.trading_name,
        "ownerName": result.owner_name,
        "document": result.document,
        "coverageArea": {
            "type": result.coverage_area.type,
            "coordinates": result.coverage_area.coordinates
        },
        "address": {
            "type": result.address.type,
            "coordinates": result.address.coordinates
        },
    }

    return make_response(jsonify(response), 200)


@app.route('/find-near-by-coordinates/<latitude>/<longitude>',
           methods=['GET'])
def find_near_by_coordinates(latitude, longitude):
    service = Pdv()
    result = service.find_near_by_location(float(latitude),
                                           float(longitude))

    if not result:
        response = {
            "error": "No PDV Found for coordinates %s and %s" % (latitude,
                                                                 longitude)
        }
        return make_response(jsonify(response), 404)

    response = {
        "id": result.id,
        "tradingName": result.trading_name,
        "ownerName": result.owner_name,
        "document": result.document,
        "coverageArea": {
            "type": result.coverage_area.type,
            "coordinates": result.coverage_area.coordinates
        },
        "address": {
            "type": result.address.type,
            "coordinates": result.address.coordinates
        },
    }

    return make_response(jsonify(response), 200)


@app.route('/include-pdv', methods=['POST'])
def include_pdv():
    data = json.loads(request.data.decode())
    response = None

    try:
        address = data.get('address', None).get('coordinates')
        coverage_area = data.get('coverageArea', None).get('coordinates')

        service = Pdv(trading_name=request.args.get('tradingName'),
                      owner_name=request.args.get('ownerName'),
                      document=request.args.get('document', None),
                      address_coords=address,
                      coverage_area_coords=coverage_area)

        ret = service.save().id
    except:
        response = {
            "error": "Error when include PDV"
        }

    if response:
        return make_response(jsonify(response), 400)

    response = jsonify(
        {
            "message": "PDV %d was succesfully registered!" % ret
        }
    )
    return make_response(response, 201)
