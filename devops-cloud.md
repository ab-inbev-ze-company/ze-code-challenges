# DevOps / Cloud Challenge

## About the Challenge... 

We have two challenges and you can choose the one you prefer to do it: one, is all about scripting and the goal is to create a tool to retrieve information from AWS S3 buckets. The other challenge, is about defining an architecture for Zé at AWS, considering several requirements that are necessary to consider.

It is entirely up to you to choose the challenge, feel free to ask any question - we really want you to succeed and then, join us to help evolve our platform.

## The First Challenge - An AWS S3 storage analysis tool

This first one is entirely based on [Coveo DevOps Challenge](https://github.com/coveo/devops-coding-challenge), we just removed some requirements and made some things simpler in the end.

What you need to build, if you choose to take this challenge, is to develop an AWS S3 storage analysis tool. To test your tool, you might create a free [Amazon](http://aws.amazon.com/en/free/) account (if you don't already have one).

### Specifications

The tool is a shell command line utility that returns information over all [S3](https://aws.amazon.com/documentation/s3/) buckets in an Amazon account.

- Your tool must work on Linux, OSX and Windows.
- It must be easy to install and use.
- Ideally, your tool won't require installation of any other tools / libraries / frameworks to work.
- Time is money, we cannot afford running a tool that takes hours to complete, your solution should return results within seconds (or minutes if you are willing to test our patience :-).

#### The tool must return the following information

For each bucket:
- Name
- Creation date
- Number of files
- Total size of files in KB
- Last modified date of the most recent file
- And the most important of all, **how much does it cost**
  
#### The following options should be supported

- Filter buckets: support prefixes, glob and/or regexes in the bucket filter (e.g.: s3://mybucket/Folder/SubFolder/log*).
- Get additional buckets information (life cycle, cross-region replication, etc.) via explicit option

Some statistics to check the percentage of space used by a bucket, or any other good ideas you could have, are more than welcome.

### Rules

- Your are free to use the programming language and the [SDK](https://aws.amazon.com/tools/) of your choice, but remember that installation must not require us to install external tools in order to test the result of your work.
- We will test your work in our environment (which contains **several millions of files**). The overall performance of your tool will be evaluated. Most of the projects we receive take weeks to run in our environment, can you do better?

### Advice

- **Try to design and implement your solution as you would do for real production code**. Show us how you create clean, maintainable code that does awesome stuff. Build something that we'd be happy to contribute to. This is not a programming contest where dirty hacks win the game.
- Feel free to add more features! Really, we're curious about what you can think of. We'd expect the same if you worked with us.
- Documentation and maintainability is a plus.
- Remember writing unit tests. 

### How to deliver it

Please, use Github to host your code and add @ze-engineering-code-challenge as a collaborator for it. This Github account (@ze-engineering-code-challenge) is solely used by Zé's engineers to download your code and review it

**Once you have finished the challenge, please submit your information on this amazing form:**
  https://docs.google.com/forms/d/e/1FAIpQLSePVCWxsHZHoRqJY9-XFJHuL7iOjO00sfhZksLBmDbR0KuoLg/viewform

## The Second Challenge - Proposing an architecture to Zé

This second challenge is more like a case than a code challenge itself.

### The Story

Imagine that we are starting Zé Delivery at this moment and we are recruiting the team and finally starting the development of Zé's products, which are: 

- Zé Delivery Consumer App: the one available at the app stores and where an user has an account and submit the orders 
- Zé Delivery Consumer Web: practically equal to the app in functionalities, and used directly in browsers
- Zé Entregador App: used by couriers that will receive information from the orders that they have to deliver
- Zé Partner: web app used by our distributors to manage orders and define their portfolio

### Building the Platform

In a fresh AWS cloud account, how would you draw Zé's infrastructure, considering all the services we want to develop? Think about security, network, communication, databases, etc. While drawing, we also need you to think about requirements like high-availability, performance and even how to give access to our development team to the production database.: 

We expect a high-level infrastrutucture drawing and explanations about each part of it - you can be as pragmatic as possible, the objective here is to quickly understand what you are proposing.

### Technical Requirements

We need you to propose the infrastructure with AWS in your mind - at Zé's, our entire platform runs on AWS.

### Writing it down (IaC)

After drawing the proposed infrastrucure, we would like you to write it down using some tool like CloudFormation, Terraform or any other that you feel confortable in using it (at Zé, we have our infrastructure codified using both tools).

### How to deliver it

Please, create a repo in Github to host the resource presenting the infrastructure and also the code to implement it. For the drawing, feel free to use any kind of tool to generate it - it can be a PDF, a presentation, or anything else - we are just interested in the content.

Don't forget to add @ze-engineering-code-challenge as a collaborator for it. This Github account (@ze-engineering-code-challenge) is solely used by Zé's engineers to download your code and review it. 

**Once you have finished the challenge, please follow the [instructions](https://github.com/ZXVentures/ze-code-challenges#how-to-deliver)**