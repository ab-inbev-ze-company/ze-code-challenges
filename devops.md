# DevOps / Platform Challenge

## About the Challenge

We want to evaluate your knowledge and skills regarding cloud computing services, specially Amazon Web Services, as our platform runs on it. The challenge is divided in three different parts, as following:

1 - Develop an AWS S3 storage analysis tool (based on https://github.com/coveo/devops-coding-challenge)

2 - Provides scripts for the provision and monitoring of a server at AWS (based on https://github.com/adazzle/devops-coding-challenge)

3 - Propose a high level architecture for a service like Zé

### Prerequisites

You will need an AWS account. Create one if you don't own one already. You can use free-tier resources for this test.

### 1. AWS S3 storage analysis tool

The tool is a shell command line utility that returns information over all S3 buckets in an Amazon account.

- Your tool must work on Linux, OSX and Windows.
- It must be easy to install and use.
- Ideally, your tool won't require installation of any other tools / libraries / frameworks to work.
- Time is money, we cannot afford running a tool that takes hours to complete, your solution should return results within seconds (or minutes if you are willing to test our patience :-).
- Time allowed

The tool must return the following information for each bucket:

- Name
- Creation date
- Number of files
- Total size of files (in kB)
- Last modified date of the most recent file
- And the most important of all, how much does it cost

#### Rules

- Your are free to use the programming language and the SDK of your choice, but remember that installation must not require us to install external tools in order to test the result of your work.
- We will test your work in our environment (which contains several millions of files). The overall performance of your tool will be evaluated. Most of the projects we receive take weeks to run in our environment, can you do better?
- Your code must be made available on GitHub or any other public version control software. Your project must be a standalone project (i.e. do not fork it from our challenge or any other project).

#### Advices
- Try to design and implement your solution as you would do for real production code. Show us how you create clean, maintainable code that does awesome stuff.Build something that we'd be happy to contribute to. This is not a programming contest where dirty hacks win the game.
- Feel free to add more features to the tool! Really, we're curious about what you can think of. We'd expect the same if you worked with us.
- Don't forget about documentation (README) and maintainability 
- Don't forget to write unit tests.

### 2. Scripts for the provision and monitoring of a server at AWS

The goal is to develop a script for the creation of a web server, and a script to check if the server is up.

You are required to set up a new server in AWS, and it must:

- Be publicly accessible.
- Run Nginx or IIS - something to serve up content
- Deploy the content. This can be as simple as a some static text representing a version number, for example: 3.0.1 or as complex as a full website. You choose. We will not provide the content.

Mandatory Work
Fork this repository.

Provide instructions on how to create the server
Provide Instructions on deploying the content
Provide a script that can be run periodically (and externally) to check if the server is up and serving the expected content (version number or returning a 200 status code). Use your scripting language of choice.
Alter the README to contain the steps required to:
Create the server.
Deploy the content.
Run the checker script.
Provide us IAM credentials to login to the AWS account. If you have other resources in it make sure we can only access what is related to this test.
Automate as much as possible.
Document each step.
Make it easy to install
Give us access to your fork, and send us an email when you’re done. Feel free to ask questions if anything is unclear, confusing, or just plain missing.

Extra Credit
We know time is precious, we won't mark you down for not doing the extra credits, but if you want to give them a go...

Automate the server setup using a CloudFormation template. Document what is happening in the template
Use a configuration management tool (such as Puppet, Chef or Ansible) to bootstrap the server. Document what is happening in your definition files
Put the server behind a load balancer. Automate this if possible using any tools you are familiar with and document what is going on
Make the checker script SSH into the instance, check if Nginx is running and start it if it isn't.
Run Nginx inside a Docker container
Make it Cloud provider agnostic - i.e. can we repeat this in Azure or Google Cloud Platform



Olá,

Você acaba de ser contratado pela Z-Tech para cuidar de um projeto de migração de uma plataforma Web. O projeto consiste em migrar todos os recursos (banco de dados, servidor de aplicação, sistemas de cache, conteúdos estáticos, DNS e outros) de um infra-estrutura terceira para a AWS. O principal motivo dessa migração se deve a nova quantidade de acesso esperados. A Z-Tech vem escalado fortemente suas operações nos últimos meses e por conta disso, é esperado uma aumento de tráfego de até 30x. Essa quantidade de acesso é infrequente, possuindo momentos de pico fortes e momentos onde o tráfego é menor.

Essa plataforma Web possui uma arquitetura muito simples. Um servidor de web, (Nginx) em conjunto com um interpretador de código (PHP) que é responsável por servir o conteúdo estático e dinâmico. Para armazenamento é utilizado um banco de dados relacional MySQL. Um dos problemas de performance que existe atualmente nessa solução é que todas as sessões são armazenadas em disco. Em momentos de pico, o disco fica muito utilizado degradando a performance do site. Além disso, essa infraestrutura não é escalável horizontalmente. Outro problema recorrente é quanto ao tempo de carregamento das imagens. A plataforma costuma servir imagens de até 1MB e como seus servidores ficam armazenados na Virginia, perde-se muito tempo com a latência/tempo de download dessas imagens.

A nova conta AWS, em que os recursos serão alocados está totalmente vazia, sem nenhum recurso, ou seja, não existe infraestrutura básica (VPC, Subnets, NAT Gateways, SSH Bastion) para subir a aplicação. Lembre-se de requisitos básico  de segurança (ex: não deixar o banco de dados acessível via internet) ao modelar essa nova infraestrutura. 

Essa infraestrutura da plataforma deve ser elástica e escalável horizontalmente. Nessa aplicação uma das pastas (pasta com imagens de tamanho superior a 1MB) que é servida possui 30Gb.  Devido ao seu tamanho, essa pasta não pode ser copiada para as novas instâncias/pods quando a infraestrutura escalar. Além disso, lembre-se do problema que ocorria com as sessões armazenadas em disco.

Sua missão é propor uma arquitetura utilizando componentes da AWS que atendam os requisitos acima citados. Recomendamos usar: https://cloudcraft.co/ mas você pode utilizar qualquer outra ferramenta. Você tem liberdade de usar os componentes da AWS que quiser e as aplicações que achar necessárias.  Você deverá usar alguma ferramenta para implementar IaC ( infrastructure as a code) como Terraform ou Cloudformation. (Temos preferência por CloudFormation).



