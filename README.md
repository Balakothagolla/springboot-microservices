# springboot-microservices
This is spring boot micro services application with 4 services. 
we are using Eureka service registry where all the client services will be registred with Eureka server.

Browser will talk to cloud gateway and gateway is responsible for redirecting the requests to subsequent services.

Below are list of services 
product-service
order-service
cloud-gateway
service-registry

#How to start the servcies
run the application Spring boot main class as spring boot application.

First start with service registry -> cloud-gateway and next other two services.
