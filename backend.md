# Desafio back-end

## Sobre o desafio

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
        }, // Localização do PDV,
        "deliveryCapacity": 5
    }
  ]
}
```

Esses PDVs são representados no mapa da seguinte forma:

![PDVs no mapa](files/images/pdvs.png)

Temos as seguintes regras:

1. Um PDV tem as seguintes características:
    - A localização é definida pelo formato `GeoJSON Point` (https://en.wikipedia.org/wiki/GeoJSON)
    - A área de cobertura é definida pelo formato `GeoJSON MultiPolygon` (https://en.wikipedia.org/wiki/GeoJSON) 
2. CNPJ deverá ser um campo único por PDV

Usando as informações anteriores, crie uma API em REST ou GraphQL(se estiver ligado nas novas tendências :wink:) que execute as funções abaixo. Você pode utilizar qualquer linguagem de programação e também qualquer banco de dados. Faça da forma como preferir, ou que se sinta mais confortável.

### 1. Crie PDV: 

Todos os campos são obrigatórios e devem respeitar as regras enunciadas neste desafio.

### 2. Mostre um PDV específico:

Busque um PDV específico a partir de seu `id`.

### 3. Busque PDV:

Dado uma localização (`lat`, `lng`), busque o PDV mais próximo e que atenda à mesma, conforme sua área de cobertura.

### 4. Documentação e Deploy:

Crie uma documentação e explique como como rodar o seu projeto.

## Modo de avaliação

Seu código será avaliado pelo time de engenharia da ZX-Ventures e alguns critérios serão levados em conta:
- **Desempenho**
- **Testes**
- **Manutenabilidade**
- **Separação de responsabilidades**


Você tem total liberdade para incrementar o projeto da forma como quiser.

BOA SORTE!