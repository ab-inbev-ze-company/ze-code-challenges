# Back-end Challenge

## About the Challenge

Vamos fornecer para você alguns dados. Neste [json](files/pdvs.json) você encontra centenas de PDVs listados com a seguinte estrutura:

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

Esses PDVs são representados no mapa da seguinte forma:

![PDVs no mapa](files/images/pdvs.png)

Temos as seguintes regras:

1. Um PDV tem as seguintes características:
    - The location is defined by the format `GeoJSON Point` (https://en.wikipedia.org/wiki/GeoJSON)
    - The coverage area is defined by the format `GeoJSON MultiPolygon` (https://en.wikipedia.org/wiki/GeoJSON) 
2. CNPJ must be a unique field by PDV

Usando as informações anteriores, crie uma API em REST ou **GraphQL**(se estiver ligado nas novas tendências :wink:) que execute as funções abaixo. Você pode utilizar qualquer linguagem de programação e também qualquer banco de dados. Faça da forma como preferir, ou que se sinta mais confortável.

### 1. Create PDV: 

All fields are required and must follow the rules set in this challenge.

### 2. Get PDV by id:

Get a specific PDV by `id`.

### 3. Search PDV:

Dado uma localização (`lng`, `lat`), busque o PDV mais próximo e que atenda à mesma, conforme sua área de cobertura.

### 4. Tech Requirements, Docs and Deploy:

* Your project must be **cross-platform**.
* Crie uma documentação e explique como como rodar localmente e também como realizar o deploy.
* Quanto mais simples for para realizar o deploy, melhor!

## Evaluation Method

Your code will be under review of the Zx's Global Engineering team. What we will look for:
- **Desempenho**
- **Testes**
- **Manutenabilidade**
- **Separação de responsabilidades**
- **Engenharia de software**


Feel free to implement it the way you feel more confortable :)

GOOD LUCK!
