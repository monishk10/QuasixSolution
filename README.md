# QuasixProblem

How to start the QuasixProblem application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/quasixproblem-1.0-SNAPSHOT.jar server config.yml`
3. To run the application enter url `http://localhost:8080`
	-(GET) All data of DB  -> http://localhost:8080/person/all
	-(GET) Particular data -> http://localhost:8080/person/get/(id) Eg. http://localhost:8080/person/get/2
	-(REMOVE) Particular data -> http://localhost:8080/person/remove/(id) Eg. http://localhost:8080/person/remove/3
	-(PUT) -> Open POSTMAN or similar app -> In URL http://localhost:8080/person/save type: POST -> In Headers header = Content-Type     value = application/json]
										  -> In Body, raw format enter {"id":5,"firstName":"Sam","lastName":"Sable","email":"sam@email.com"}
										  -> And POST it

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
