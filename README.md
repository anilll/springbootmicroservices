# springbootmicroservices
springbootmicroservicesapis

Required Java 17

**Note: for API-GATEWAY service**

api-gateway.yaml

server:
  port: 8060
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
management:
  tracing:
    sampling:
      probability: 1.0

spring:
  application:
    name: api-gateway
  config:
    import: "optional:configserver:http://localhost:8088"
  cloud:
    gateway:
      routes:
        - id: employee-service
          uri: http://localhost:8082
          predicates:
            - Path=/employees/**
        - id: department-service
          uri: http://localhost:8081
          predicates:
            - Path=/departments/**


**OR**

server:
  port: 8060
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
management:
  tracing:
    sampling:
      probability: 1.0

spring:
  application:
    name: api-gateway
  config:
    import: "optional:configserver:http://localhost:8088"
  cloud:
    gateway:
      routes:
        - id: employee-service
          uri: lb://employee-service
          predicates:
            - Path=/employees/**
        - id: department-service
          uri: lb://department-service
          predicates:
            - Path=/departments/**
