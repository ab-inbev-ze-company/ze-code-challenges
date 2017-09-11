from . import BaseTestCase
from pdv.services import Pdv


class TestPdv(BaseTestCase):

    def setUp(self):
        super().setUp()

    def test_save_should_successful(self):
        service = Pdv(trading_name='Teste Pdv',
                      owner_name='Teste Da Silva',
                      document='03.736.374/0001-68',
                      coverage_area_coords=[[
                          [-43.99557, -19.90842],
                          [-43.99582, -19.90285],
                      ]],
                      address_coords=[-43.512479, -19.887214])
        saved_pdv = service.save()

        pdv = service.get_by_id(saved_pdv.id)
        self.assertEqual(pdv.id, saved_pdv.id)

    def test_find_near_by_location_should_found_pdv(self):
        service = Pdv(trading_name='Teste Pdv do Barulho',
                      owner_name='Teste Da Silva Sauro',
                      document='62.287.833/0001-32',
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
                      document='38.460.613/0001-84',
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

        found = service.find_near_by_location(-44.04912, -19.87743)
        self.assertEqual(found.trading_name, 'Teste Pdv da Farra')

    def tearDown(self):
        super().tearDown()
