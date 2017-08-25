# Desafio front-end (EM CONSTRUÇÃO)

## About the Challenge 

We're using GraphQL here, so thats gonna be the way your going to receive the data(sounds good, right?).

### What you should develop?
Its simple. The user needs to type an address inside a field and be redirected to a products list page.

We're   using   GraphQL:    https://www.graphql.com/guides/ 

The   API   link   is:    https://803votn6w7.execute-api.us-west-2.amazonaws.com/dev/public/graphql
  - Home
    - To   find   the   latitude   and   longitude   of   an   address,   please   use   a   google   maps   API.
      - Use   the   following   address   to   find   a   POC:    Rua   Américo   Brasiliense,   São   Paulo . 
      - The   Query   needed   to   get   the   right   POC   (Get   the   first   POC):
        - Query:       http://bit.ly/2uSIRPz
        - Arguments:
          - Algorithm:   "NEAREST".
          - Lat:   Use   as   String.
          - Long:   Use   as   String.
          - Now:   Pass   the   current   Date   formatted.
          - Product   List
      - The   Query   needed   to   get   the   products
        - Query:    http://bit.ly/2vSpmqK
          - Arguments:
            - Id:   id   of   the   POC.
            - Search:   if   ""   (empty),   do   not   filters   by   search.
            - CategoryId:   if   0   (Zero)   do   not   filters   by   category.
            - The   Query   needed   to   get   the   category   list
        - Query:    http://bit.ly/2ugVEYE



### 4. Docs and Deploy:

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
