**importante:** esta é uma nova versão do nosso code challenge e deve ser usada apenas por pessoas que estão começando o desafio agora. Se você já começou, você ainda pode ler as instruções antigas [aqui](https://github.com/ZXVentures/ze-code-challenges/blob/e8937d04b2dcda1c06db39f7b085dbe7e27cc440/frontend-mobile_pt.md)

# Desafio de Frontend/Mobile

You can read this challenge in English here: https://github.com/ZXVentures/ze-code-challenges/blob/master/frontend-mobile.md 

## Sobre o desafio 

Nós usamos GraphQL aqui (dê uma olhada em https://www.graphql.com/guides/), então essa será a forma
que você receberá os dados (bem legal né?).

### O que você deve desenvolver?
É simples. O usuário precisa escrever o seu endereço dentro de um campo e ser redirecionado
para a página de listagem de produtos. O seu trabalho como frontend é desenvolver 2 telas simples consumindo e enviando dados para nossa API.

Temos um exemplo desse fluxo aqui: https://ze.delivery/ (nosso ambiente de produção)

### Visual
Nós queremos que você se sinta livre para desenvolver o modelo do jeito que você quiser, nós não temos _wireframes_ ou algo do tipo para essa tarefa. Você irá criar duas telas:
  - Página Home:
    - Precisa ter um cabeçalho, um rodapé e um input para o usuário preencher seu endereço
  - Página Products:
    - Nós queremos ver os produtos em _cards_, com o título do produto, preço e botões para adicionar e remover o produto.

### Sobre a API
O link da API que você irá utilizar: https://frontend-code-challenge-api.ze.delivery/graphql
(Se você abrir isso em um navegador irá aparecer "Missing Authentication Token", você precisa utilizar no código)
  - Página Home:
    - Para encontrar a latitude e longitude do endereço, você pode utilizar a API do Google Maps ou utilizar qualquer outra API de Geocoder que você quiser.
    - Utilize o seguinte endereço para encontrar o distribuidor (PoC): Rua Américo Brasiliense, São Paulo.
    - A Query necessária para obter o distribuidor correto (obtém o primeiro distribuidor):
        - [Query](https://studio.apollographql.com/sandbox/explorer?endpoint=https%3A%2F%2Ffrontend-code-challenge-api.ze.delivery%2Fgraphql&explorerURLState=N4IgJg9gxgrgtgUwHYBcQC4QEcYIE4CeABAArQDKCAhnlABYAUAJAA4XW10AyESA5uiLkUeAJb8AhABoirdjXpcqKQcLGSAlEWAAdJESJsolBYwA2vAbKMnOPfjLPLBc4x0XKtu-QaKiwer5EAM4oyjDBgb5IVIhRAL56iUggUiAAbjSiVABGZgjBGCDeBjogNu7clmWCZQC0ACwAbAB0TQCc7Q0ArADMZVJRZRWmSig1RPUATL1tvVPtAIztA3pJIPFAA)
        - Argumentos:
          - pocSearchLat: Envie como String.
          - pocSearchLong: Envie como String.
  - Página Products:
      - A Query necessária para obter os produtos
        - [Query](https://studio.apollographql.com/sandbox/explorer?endpoint=https%3A%2F%2Ffrontend-code-challenge-api.ze.delivery%2Fgraphql&explorerURLState=N4IgJg9gxgrgtgUwHYBcQC4QEcYIE4CeABAArQAUAJAA7QCSY6RAyingJZIDmAhADREaeCGBhQUAZ2YIAhnigALJqw7cBQkWMkBhGSgRcIhBsracuASiLAAOkiJFaUcu0aCnDK7fsOiru75EEih6MBIBvkgyiBEO1MKi4hLkErLySu4JWlJpigJQegZGBCaZmkm6%2BobGYF6xvv4%2BgSjsKAA2CPUO7HAyXJ1NvvHsUAOBDgVVxdZdDWCzDi3tY%2BMAvvXrPpurIHwgAG5y7DIARh0SGCDeDjYgHvMYRLcArADMAEy3fBG38eWS0jkiluTCQMDabW%2BPl%2BWQqhWqJQeoPBbTsO1WQA)
        - Argumentos:
          - pocId: id do distribuidor recebido na query anterior (PocSearch)
          - productsSearch: se "" (vazio), não filtra por 'search'.
          - productsCategoryId: se null, não filtra por 'category'.
      - A Query necessária para obter a lista de categorias
        - [Query](https://studio.apollographql.com/sandbox/explorer?endpoint=https%3A%2F%2Ffrontend-code-challenge-api.ze.delivery%2Fgraphql&explorerURLState=N4IgJg9gxgrgtgUwHYBcQC4QEcYIE4CeABAMICGKCA5hHgJYIDORwAOkkUVBdbQ82w6cidMO2FEUdFABsE4ogF92ikABoQANzL0yAIzmMMIEIqA)


### Requerimentos técnicos (para as duas posições):
- Você precisa criar um repositório no GitHub para hospedar seu código
  - Usuários do Github:
      - @ze-engineering-code-challenge
- Evite usar _scaffolds_ (Create React App etc.), nós queremos ver como você cria a estrutura do projeto
- Mantenha simples, não há necessidade de coisas extravagantes :)
- TESTES 💛 Nós realmente amamos testar nosso código e suas características aqui!

#### Se você desejar fazer o teste com frontend web:
- Você não deve usar Framework CSS (Bootstrap, Tailwind, Bulma, PureCSS etc.)
- React é um _plus_, mas você pode usar o que quiser =)
- Quero ser capaz de executar o projeto localmente usando `npm start`

#### Se você desejar fazer o teste em mobile:
- Você deve usar React Native para desenvolver sua aplicação
- Quero ser capaz de executar o projeto com um único comando
- Hospedá-lo é um GRANDE _plus_ (Expo deve fazer o trabalho para você)

## Método de Avaliação

Seu código estará sob análise do time de Engenharia do Zé. O que vamos procurar:
- **Boas práticas e padrões**
- **Código e estrutura de pastas**
- **Componentização e fluxo de dados**
- **Código fácil de entender (novamente, não precisa de coisas extravagantes)**
- **TESTES**

Sinta-se à vontade para implementar da maneira que você se sentir mais confortável :)

## Como entregá-lo

Por favor, utilize o Github para hospedar seu código e adicione @ze-engineering-code-challenge como um colaborador do repositório. Essa conta do Github (@ze-engineering-code-challenge) é usado exclusivamente pelo time de Engenharia do Zé para baixar o seu código e revisá-lo

**Depois de terminar o desafio, siga estas [instruções](https://github.com/ZXVentures/ze-code-challenges#how-to-deliver).**
