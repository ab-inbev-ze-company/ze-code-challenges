# Data Engineering Challenge

## About the Challenge... 

At Zé, we were facing the issue of not knowing where are our couriers, making the current status of deliveries invisible to consumers and to our internal backoffice team. Therefore, we decided to start the development of a new app, to be used by each courier, called Zé Entregador. 

With this app, the couriers (its users) will not only manage data regarding orders that are being delivered but also will allow the retrieval of their geolocation information in real-time.

Thus, while tracking each courier current location, we will be able to proper inform the consumers where their order is, thus, reducing their ansiety and also bringing quality, confidence and value for the entire experience with Zé.

## What we need to define

With the current volume of orders being sold at Zé, we expect to receive around 1M records of coordinates each day - we are considering that every courier will use the new app and this volume will grow each month following Zé's growth.  

The app is almost finished, and the couriers are already able to manage the order's information while associtaing them with the delivery of it, inform that the devivery of the order is starting, and also assign that the order was just delivered - we expect they do this when actually delivering the beverages to the consumer. So, for every action that the courier does regarding each order, we are collecting the location using the device's GPS sensor. Besides these moments, we are also collecting location data while the courier is driving to the consumer's place - this way we expect to send notifications to the consumer that his/her order is arriving or just arrived, for instance.

Regarding the infrastructure on our cloud that will receive all this data, we are really delayed, and it is exactly where we need your help, to help us answering these questions:

* How are we going to receive all the location data from the couriers' app? What protocols, services, components we are going to use to proper receive the data, store it and be available to be used in other products. 
  * Should we create an API for it? 
  * Should we use some specific managed component to receive this information? 
  * Should we use queues, pub-sub mechanisms, serverless components? 
* While receiving this location data associed with order's information, imagine we need to ingest more information to it. 
  * How would we do this? 
  * In which layer that you have proposed in the previous answer?
* We need to create an API to retrieve the last retrieved location from an order. 
  * How do you propose us to do this? 
  * While receiving location data, can you elaborate a solution to store the order's last location information? 
* If we need to notify the users about each order's status, how would you implement this while collecting the data?
* How to store the data and how to make it available to be queried by our Data Analytics team? 

### Technical Requirements

We need you to propose the infrastructure with AWS in your mind - at Zé's, our entire platform runs on AWS.

### Writing it down (IaC) is a plus

After drawing the proposed infrastrucure, we would like you to write it down using some tool like CloudFormation, Terraform or any other that you feel confortable in using it (at Zé, we have our infrastructure codified using both tools).

### How to deliver it

Please, create a repo in Github to host the resource presenting the infrastructure and also the code to implement it. For the drawing, feel free to use any kind of tool to generate it - it can be a PDF, a presentation, or anything else - we are just interested in the content.

Don't forget to add @ze-engineering-code-challenge as a collaborator for it. This Github account (@ze-engineering-code-challenge) is solely used by Zé's engineers to download your code and review it. 

**Once you have finished the challenge, please follow the instructions in:**
- https://github.com/ZXVentures/ze-code-challenges#how-to-deliver