Sobre a app
===========
* Teste para ZX Ventures
* Desafio utilizando GEOJSON


Instruções para instalação
* Dependências: docker e docker-compose
* Para instalar docker confira nesse [link](https://docs.docker.com/engine/installation/#supported-platforms)

```

sudo pip install docker-compose

docker-compose up -d

```

Para rodar os testes
```
docker exec -it app bash -c 'python -m unittest discover'
```

Para incluir novo PDV:
```

curl --header 'content-type: application/json' -X POST -d '{"tradingName":"Adega Budega","ownerName":"Ze da Breja","document":"14.604.833/0001-76",  "coverageArea": { "type": "MultiPolygon", "coordinates":  [[[[-43.36556,-22.99669],[-43.36539,-23.01928],[-43.26583,-23.01802],[-43.25724,-23.00649],[-43.23355,-23.00127],[-43.2381,-22.99716],[-43.23866,-22.99649],[-43.24063,-22.99756],[-43.24634,-22.99736],[-43.24677,-22.99606],[-43.24067,-22.99381],[-43.24886,-22.99121],[-43.25617,-22.99456],[-43.25625,-22.99203],[-43.25346,-22.99065],[-43.29599,-22.98283],[-43.3262,-22.96481],[-43.33427,-22.96402],[-43.33616,-22.96829],[-43.342,-22.98157],[-43.34817,-22.97967],[-43.35142,-22.98062],[-43.3573,-22.98084],[-43.36522,-22.98032],[-43.36696,-22.98422],[-43.36717,-22.98855],[-43.36636,-22.99351],[-43.36556,-22.99669]]]] }, "address": {"type": "Point", "coordinates":  [-43.297335,-23.013539]} }' localhost:54000/include-pdv

```

Para obter um PDV mais próximo por coordenadas:
```
curl -X GET localhost:54000/find-near-by-coordinates/-44.04912/-19.87743
```

Para obter um PDV por ID:
```
curl -X GET localhost:54000/find-by-id/1
```

Para realizar deploy do container, utilizar o docker-swarm de acordo com o [link](https://docs.docker.com/engine/swarm/swarm-tutorial/deploy-service/)
