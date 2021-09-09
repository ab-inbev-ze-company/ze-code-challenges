# Desafio de QA

You can read this challenge in English here: https://github.com/ZXVentures/ze-code-challenges/blob/master/qa.md 

## Sobre o Desafio


Não queremos que os nossos clientes tenham problemas e bugs ao utilizar a nossa plataforma Zé Delivery. Principalmente nesse momento super importante, que é quando ele escolhe uma cerveja gelada para degustar na hora.
 
Bem, tendo isso em mente, devemos implementar alguns testes para minimizar esse risco:


### 1. Identifique os fluxos críticos

Você notará que nossas plataformas web e mobile são um pouco diferentes, portanto, para esta primeira parte do desafio do código, você pode escolher um dos 3 aplicativos que temos: Android, iOS, Web.
 
i. Identifique no mínimo, 3 fluxos importantes que mantêm o aplicativo funcionando corretamente. Por exemplo: Login (Login é um fluxo importante porque o usuário precisa estar logado para concluir uma compra). Como foi dado como exemplo, agora não vale usar o login no teste heinn :p
 
ii. Forneça uma explicação detalhada de por que esses fluxos são importantes para que o usuário possa comprar seus produtos.


### 2. Teste de Automação UI

i. Nesta etapa, você terá que criar uma suite de testes de automação. Uma automação de teste da web ou uma automação de teste de aplicativo (caso queira entregar os dois será um plus, mas não é obrigatório):
##### Teste Automatizado de WEB
Em nossa [Aplicação da Web](https://www.ze.delivery/), crie uma suite de testes de automação para um cenário da parte 1 do desafio de código (escolha um dos 3 fluxos que você criou em `1. Identifique os fluxos críticos`).

##### Teste Automatizado de MOBILE
Em nosso aplicativo Mobile, escolha um dos aplicativos Android ou iOS [Android](https://play.google.com/store/apps/details?id=com.cerveceriamodelo.modelonow&hl=pt_BR) ou [iOS](https://apps.apple.com/br/app/z%C3%A9-delivery/id1070070438):
i.Crie um conjunto de testes de automação para um cenário da parte 1 do desafio de código (escolha um dos 3 fluxos criados em `1. Identifique os fluxos críticos`).
 
ii. Forneça um resumo com as diretrizes das decisões que você tomou (por exemplo, explique por que você escolheu essa linguagem de programação, estrutura, etc.).


### 3. API automation test

Queremos que você automatize uma suite de testes de API com abordagem **ATDD**

Crie testes automatizados para obter o clima usando a API Open Weather: 
[http://openweathermap.org/current](http://openweathermap.org/current)

Dica:
**Cobrir mais cenários e ser flexível para diferentes tipos de respostas.** 

## Método de Avaliação das Automações UI e API

Seu código estará sob análise do time de Engenharia do Zé. O que vamos procurar:
- Boas práticas e padrões
- Código e estrutura de pastas
- [Boas práticas de commits](https://chris.beams.io/posts/git-commit/)
- Código fácil de entender (novamente, não precisa de coisas extravagantes)
- Testes legíveis, manuteníveis e confiáveis 
- Um arquivo read.me detalhado com instruções claras sobre como configurar o ambiente e executar os testes em nossas máquinas locais!
 
Para criar os testes acima, você pode escolher qualquer linguagem de programação, framework etc que você se sinta mais confortável :)


## How to deliver it

Por favor, utilize o Github para hospedar seu código e adicione @ze-engineering-code-challenge como um colaborador do repositório. Essa conta do Github (@ze-engineering-code-challenge) é usado exclusivamente pelo time de Engenharia do Zé para baixar o seu código e revisá-lo

**Depois de terminar o desafio, siga estas [instruções](https://github.com/ZXVentures/ze-code-challenges#how-to-deliver).**