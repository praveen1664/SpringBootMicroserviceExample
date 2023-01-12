# SpringBootMicroserviceExample

## What is this?
The repository contains a complete Microservices example with 3 main services USER-SERVICE, HOTEL-SERVICE and RATING-SERVICE.  In it we have used [OKTA AUTH](https://developer.okta.com/docs/concepts/how-okta-works/), [Spring Security](https://spring.io/projects/spring-security), [Resilence4j](https://resilience4j.readme.io/docs), [Feign Client](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html), [Spring Cloud api gatway](https://spring.io/projects/spring-cloud-gateway), [Configuration server](https://spring.io/projects/spring-cloud-config),[Eureka server](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html), [OenApi3 Specifications](https://swagger.io/specification/) for individual services documents  and a consolidated swagger docs server which provides the consilidated view of all swagger docs. This Microservices examples uses Postgres , SQL & Mongo databases running inside docker containers for which we are also providing a docker compose file.

## Salient features
Apart from about cloud capabilities we have also shown the improved [resilence](https://resilience4j.readme.io/docs), [Feign Client](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html), [Circuit Breaker pattern](https://martinfowler.com/bliki/CircuitBreaker.html), [fallback](https://martinfowler.com/bliki/CircuitBreaker.html), [BlukHead](https://reflectoring.io/bulkhead-with-resilience4j/) , [Ratelimiters](https://resilience4j.readme.io/docs/ratelimiter) & [Retry mechanism ](https://resilience4j.readme.io/docs/retry) along with microservices architecture.

## What are the component services & salient features
We are are using following services to deliver this Demo

### HOTEL-SERVICE
Written in spring boot it is using Postgres as backend. It is enabled with Eureka client, Configuration server, Openapi3 swagger URL & it is also seeding consolidated documents to Common dcument server. It is being used by Rating-SERVER  & USER-SERVICE. Its end poiunts are /hotels & /hotels/{hotelId}

### RATING-SERVICE
Written in spring boot it is using MongoDB as backend. It is enabled with Eureka client, Configuration server, Openapi3 swagger URL & it is also seeding consolidated documents to Common dcument server. It is being used by USER-SERVICE. Its end poiunts are /ratings & /ratings/{ratingId}

### USER-SERVICE
Written in spring boot it is using POSTGRESS as backend. It is enabled with Eureka client, Configuration server, Openapi3 swagger URL & it is also seeding consolidated documents to Common dcument server. Apart from about cloud capabilities we have also shown the improved resilence, Circuit Breaker pattern & Ratelimiters along with microservices architecture. Its end poiunts are /users & /users/{userId}. We have shown the demo of resilnece patterns and [Feign client](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html) with this service.

## API-GATEWAY
It is using Spring-Cloud-Gateway, enabled with Eureka client & Configuration server. This services could be tested by appending end points of each of HOTEL-SERVICE, RATING-SERVICE and USER-SERVICE.

## ServiceRegistry
It is implemented with Eureka Service Registry with Spring Cloud. We are using Eureka client for Service discovery as well.

## CONFIG-SERVER
It is implemented with Spring Cloud Configuration server. The configuration is served from our another GithUb repository.

## Document-Server
It is implemented with Spring Fox lib of Spring Boot which consolidate the individual swagger docs of each of Microservice & present them on a single swagger dcument. Please select the spec for any service from the dropdown provided for the same.

## docker-compose.yml
This service will start 2 Postgres conatiners, One mongo DB along with PGafmin & Mongo-express configuration to test it fully.