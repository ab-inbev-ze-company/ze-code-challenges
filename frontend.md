# Desafio front-end (EM CONSTRUÇÃO)

## About the Challenge 

You will need to mount a map similar to the one above. We're using GraphQL here, so thats gonna be the way your going to receive the data(sounds good, right?). You can see a sample of the payload above:


```javascript
{
  "pdvs": [ 
    {
        "id": 1, 
        "tradingName": "Adega da Cerveja - Pinheiros",
        "ownerName": "Zé da Silva",
        "document": "1432132123891/0001", //CNPJ
        "coverageArea": { 
          "type": "MultiPolygon", 
          "coordinates": [
            [[[30, 20], [45, 40], [10, 40], [30, 20]]], 
            [[[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]]]
          ]
        }, //Área de Cobertura
        "address": { 
          "type": "Point",
          "coordinates": [-46.57421, -21.785741]
        }, // Localização do PDV
    }
  ]
}
```

And the map: (dont worry too much about the icons and stuff)

![PDVs no mapa](files/images/pdvs.png)

Some more infos:

1. About the PDV:
    - The location its defined by a `GeoJSON Point` (https://en.wikipedia.org/wiki/GeoJSON)
    - The coverage area its defined by a `GeoJSON MultiPolygon` (https://en.wikipedia.org/wiki/GeoJSON) 


Usando as informações anteriores, crie uma API em REST ou GraphQL(se estiver ligado nas novas tendências :wink:) que execute as funções abaixo. Você pode utilizar qualquer linguagem de programação e também qualquer banco de dados. Faça da forma como preferir, ou que se sinta mais confortável.

### 1. Crie PDV: 

Todos os campos são obrigatórios e devem respeitar as regras enunciadas neste desafio.

### 2. Mostre um PDV específico:

Busque um PDV específico a partir de seu `id`.

### 3. Busque PDV:

Dado uma localização (`lng`, `lat`), busque o PDV mais próximo e que atenda à mesma, conforme sua área de cobertura.

### 4. Documentação e Deploy:

O seu projeto deve ser **mutiplataforma**.
Crie uma documentação e explique como como rodar localmente e também como realizar o deploy.
Quanto mais simples for para realizar o deploy, melhor!

## Modo de avaliação

Seu código será avaliado pelo time de engenharia da ZX-Ventures e alguns critérios serão levados em conta:
- **Desempenho**
- **Testes**
- **Manutenabilidade**
- **Separação de responsabilidades**


Você tem total liberdade para incrementar o projeto da forma como quiser.

BOA SORTE!
