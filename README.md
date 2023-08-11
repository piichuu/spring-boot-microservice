# spring-boot-microservice
Simple microservice to query API

Write an API microservice using Spring Boot to simulate user registration. Write and push your code to Github so the interviewer can see the development process.

- Expose REST API to accept a payload of username, password, and IP address.
- All parameters must not be blank (!= empty and null). Return error messages if not valid
- Password need to be greater than 8 characters, containing at least 1 number, 1 Capitalized letter, 1 special character in this set “_ # $ % .” Return error messages if not valid
- Call this end point to get geolocation for the provided IP: IP-API.com - Geolocation API - Documentation - JSON. If the IP is not in Canada, return error message that user is not eligible to register
- When all validation is passed, return a random uuid and a welcome message with his username and his City Name (resolved using ip-geolocation api)
- The API need to have OpenAPI specification, no matter what your approach is code first or design first.
- Project must use Maven or Gradle to build. Generate a spring boot project here: Spring Initializr 
- Need to have JUnit Tests

Resources used to complete this task:

- https://spring.io/guides/gs/spring-boot/
- https://spring.io/guides/tutorials/rest/
- https://github.com/seancfoley/IPAddress 
- https://stackoverflow.com/questions/1795402/check-if-a-string-contains-a-special-character
- https://www.baeldung.com/java-validate-ipv4-address
- https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
- https://www.javainuse.com/spring/boot_swagger3
- https://www.springboottutorial.com/unit-testing-for-spring-boot-rest-services
