**important:** this is a new version of our code challenge and is only meant to be used by people who are starting the challenge right now. If you already began the challenge, you can still read the old instructions [here](https://github.com/ZXVentures/ze-code-challenges/blob/e8937d04b2dcda1c06db39f7b085dbe7e27cc440/frontend-mobile.md)

# Frontend/Mobile Challenge

Você pode ler esse desafio em Português aqui: https://github.com/ZXVentures/ze-code-challenges/blob/master/frontend-mobile_pt.md 

## About the Challenge 

We're using GraphQL here (take a look at https://www.graphql.com/guides/), so that's gonna be the way you're going to receive the data (sounds good, right?).

### What you should develop?
It's simple. The user needs to type an address inside a field and be redirected to a products list page. So your job as a front-end engineer will be to create 2 simple screens consuming and sending data to our API.

You can check out an example of this flow at: https://ze.delivery/ (our production env)

### Visual
We want you to feel free to develop the markup the way you want, we have no wireframes or something like that for this task. You will create 2 screens:
  - Home page:
    - Needs to have a header, a footer and a input for the user to fill up with the address.
  - Products page:
    - We want to see the products as cards, with the product title, price and buttons to add/remove the product.

### About the API
The API link that you will use: https://frontend-code-challenge-api.ze.delivery/graphql
(If you open it in the browser it will appear "Missing Authentication Token", you need use it in code)
  - Home page:
    - To find the latitude and longitude of an address, you can use Google Maps API or use any other Geocoder API that you feel comfortable with.
    - Use the following address to find a distributor (PoC):  Rua Américo Brasiliense, São Paulo . 
    - The Query needed to get the right distributor (get the first distributor):
        - [Query](https://studio.apollographql.com/sandbox/explorer?endpoint=https%3A%2F%2Ffrontend-code-challenge-api.ze.delivery%2Fgraphql&explorerURLState=N4IgJg9gxgrgtgUwHYBcQC4QEcYIE4CeABAArQDKCAhnlABYAUAJAA4XW10AyESA5uiLkUeAJb8AhABoirdjXpcqKQcLGSAlEWAAdJESJsolBYwA2vAbKMnOPfjLPLBc4x0XKtu-QaKiwer5EAM4oyjDBgb5IVIhRAL56iUggUiAAbjSiVABGZgjBGCDeBjogNu7clmWCZQC0ACwAbAB0TQCc7Q0ArADMZVJRZRWmSig1RPUATL1tvVPtAIztA3pJIPFAA)
        - Arguments:
          - pocSearchLat: Use as String.
          - pocSearchLong: Use as String.
  - Products page:
      - The Query needed to get the products
        - [Query](https://studio.apollographql.com/sandbox/explorer?endpoint=https%3A%2F%2Ffrontend-code-challenge-api.ze.delivery%2Fgraphql&explorerURLState=N4IgJg9gxgrgtgUwHYBcQC4QEcYIE4CeABAArQAUAJAA7QCSY6RAyingJZIDmAhADREaeCGBhQUAZ2YIAhnigALJqw7cBQkWMkBhGSgRcIhBsracuASiLAAOkiJFaUcu0aCnDK7fsOiru75EEih6MBIBvkgyiBEO1MKi4hLkErLySu4JWlJpigJQegZGBCaZmkm6%2BobGYF6xvv4%2BgSjsKAA2CPUO7HAyXJ1NvvHsUAOBDgVVxdZdDWCzDi3tY%2BMAvvXrPpurIHwgAG5y7DIARh0SGCDeDjYgHvMYRLcArADMAEy3fBG38eWS0jkiluTCQMDabW%2BPl%2BWQqhWqJQeoPBbTsO1WQA)
        - Arguments:
          - pocId: id of the distributor retrieved from the previous query (PocSearch).
          - productsSearch: if "" (empty), does not filter by search.
          - productsCategoryId: if null, does not filter by category.
      - The Query needed to get the category list
        - [Query](https://studio.apollographql.com/sandbox/explorer?endpoint=https%3A%2F%2Ffrontend-code-challenge-api.ze.delivery%2Fgraphql&explorerURLState=N4IgJg9gxgrgtgUwHYBcQC4QEcYIE4CeABAMICGKCA5hHgJYIDORwAOkkUVBdbQ82w6cidMO2FEUdFABsE4ogF92ikABoQANzL0yAIzmMMIEIqA)


### Tech Requirements (for both positions):
- You need to create a repo on GitHub to host your code
  - Github users:
      - @ze-engineering-code-challenge
- Avoid using scaffolds (Create React App etc.), we want to see how you make your project structure
- Keep it simple, no need for fancy stuff :)
- TESTS 💛 We really love testing our code and features here!

#### If you are running for a front-end position:
- You're not allowed to use any CSS Frameworks (Bootstrap, Tailwind, Bulma, PureCSS etc.)
- React will be a plus, but you can use whatever you want =)
- I want to be able to run your project locally by using `npm start`

#### If you are running for a mobile position:
- You should use React Native to develop your application
- I want to be able to run your project with one single command
- Hosting it its a BIG plus (Expo should do the job for you)

## Evaluation Method

Your code will be under review of the Zé Engineering team. What we will look for:
- **Good Practices and patterns**
- **Code and Folder Structure**
- **Componentization and data flow**
- **Easy to understand code (again, no need for fancy stuff)**
- **TESTS**

Feel free to implement it the way you feel more confortable :)

## How to deliver it

Please, use Github to host your code and add @ze-engineering-code-challenge as a collaborator for it. This Github account (@ze-engineering-code-challenge) is solely used by Zé's engineers to download your code and review it

**Once you have finished the challenge, please follow these [instructions](https://github.com/ZXVentures/ze-code-challenges#how-to-deliver).**
