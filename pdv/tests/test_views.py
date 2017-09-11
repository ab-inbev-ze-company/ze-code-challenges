import json
from unittest import mock
from . import BaseTestCase
from pdv.services import Pdv


class TestViews(BaseTestCase):

    def test_include_pdv_should_retrieve_200_status(self):
        data = {
            'tradingName': 'Teste Fulano',
            'ownerName': 'Dono de Fulano',
            'document': '29.715.677/0001-98',
            'coverageArea': {
                'type': 'MultiPolygon',
                'coordinates': [
                    [
                        [[-43.36556, -22.99669],
                         [-43.36539, -23.01928],
                         [-43.26583, -23.01802],
                         [-43.25724, -23.00649],
                         [-43.23355, -23.00127],
                         [-43.2381, -22.99716],
                         [-43.23866, -22.99649],
                         [-43.24063, -22.99756],
                         [-43.24634, -22.99736],
                         [-43.24677, -22.99606],
                         [-43.24067, -22.99381],
                         [-43.24886, -22.99121],
                         [-43.25617, -22.99456],
                         [-43.25625, -22.99203],
                         [-43.25346, -22.99065],
                         [-43.29599, -22.98283],
                         [-43.3262, -22.96481],
                         [-43.33427, -22.96402],
                         [-43.33616, -22.96829],
                         [-43.342, -22.98157],
                         [-43.34817, -22.97967],
                         [-43.35142, -22.98062],
                         [-43.3573, -22.98084],
                         [-43.36522, -22.98032],
                         [-43.36696, -22.98422],
                         [-43.36717, -22.98855],
                         [-43.36636, -22.99351],
                         [-43.36556, -22.99669]]
                    ]
                ]
            },
            'address': {
                'type': 'Point',
                'coordinates': [-43.297335, -23.013539]
            }
        }
        response = self.app.post('/include-pdv', data=json.dumps(data))
        self.assertEqual(response.status_code, 201)

    @mock.patch.object(Pdv, 'save')
    def test_include_pdv_should_retrieve_400_status(self, pdv_save):
        pdv_save.side_effect = ValueError()
        data = {
            'tradingName': 'Teste Fulano',
            'coverageArea': {},
            'address': {},
        }
        response = self.app.post('/include-pdv', data=json.dumps(data))
        self.assertEqual(response.status_code, 400)

    def test_find_by_id_should_retrieve_200_status(self):
        response = self.app.get('/find-by-id/1')
        self.assertEqual(response.status_code, 200)

    def test_find_by_id_should_retrieve_404_status(self):
        response = self.app.get('/find-by-id/10000')
        self.assertEqual(response.status_code, 404)

    def test_find_by_coordinates_should_retrieve_200_status(self):
        service = Pdv(trading_name='Teste Pdv do Barulho',
                      owner_name='Teste Da Silva Sauro',
                      document='87.297.862/0001-06',
                      address_coords=[-44.012479, -19.887214],
                      coverage_area_coords=[
                          [[
                              [-44.04912, -19.87743],
                              [-44.0493, -19.89438],
                              [-44.04758, -19.90212],
                              [-44.04346, -19.90922],
                              [-44.03385, -19.91923],
                              [-44.01891, -19.92165],
                              [-44.01647, -19.92306],
                              [-44.01436, -19.92319],
                              [-44.01175, -19.92427],
                              [-44.00724, -19.92585],
                              [-43.99909, -19.9185],
                              [-43.99432, -19.91403],
                              [-43.99557, -19.90842],
                              [-43.99582, -19.90285],
                              [-43.99436, -19.89002],
                              [-43.99316, -19.8792],
                              [-43.99436, -19.87371],
                              [-43.99951, -19.86532],
                              [-44.01917, -19.85135],
                              [-44.02801, -19.8545],
                              [-44.03745, -19.85668],
                              [-44.04397, -19.8608],
                              [-44.04912, -19.87743]
                          ]]
                      ])
        service.save()
        service = Pdv(trading_name='Teste Pdv da Farra',
                      owner_name='Teste Da Fanfarra',
                      document='85.814.333/0001-07',
                      address_coords=[-44.04911, -19.887742],
                      coverage_area_coords=[
                          [[
                              [-44.04912, -19.87743],
                              [-44.0493, -19.89438],
                              [-44.04758, -19.90212],
                              [-44.04346, -19.90922],
                              [-44.03385, -19.91923],
                              [-44.01891, -19.92165],
                              [-44.01647, -19.92306],
                              [-44.01436, -19.92319],
                              [-44.01175, -19.92427],
                              [-44.00724, -19.92585],
                              [-43.99909, -19.9185],
                              [-43.99432, -19.91403],
                              [-43.99557, -19.90842],
                              [-43.99582, -19.90285],
                              [-43.99436, -19.89002],
                              [-43.99316, -19.8792],
                              [-43.99436, -19.87371],
                              [-43.99951, -19.86532],
                              [-44.01917, -19.85135],
                              [-44.02801, -19.8545],
                              [-44.03745, -19.85668],
                              [-44.04397, -19.8608],
                              [-44.04912, -19.87743]
                          ]]
                      ])
        service.save()

        response = self.app.get(
            '/find-near-by-coordinates/-44.04912/-19.87743'
        )
        self.assertEqual(response.status_code, 200)

    def test_find_by_coordinates_should_retrieve_404_status(self):
        response = self.app.get('/find-near-by-coordinates/99/99')
        self.assertEqual(response.status_code, 404)
