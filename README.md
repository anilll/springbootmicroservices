# springbootmicroservices
springbootmicroservicesapis

**Zipkin server details**
The quickest way to get started is to fetch the latest released server as a self-contained executable jar. Note that the Zipkin server requires minimum JRE 8. For example:

curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar

You can also start Zipkin via Docker.(make sure Docker desktop is intalled in local)
docker run -d -p 9411:9411 openzipkin/zipkin

**Required Java 17**

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
