# Security Microservice
So far it has crud operations on an entity, it uses spring web, jpa, postgres. The postgres runs in a docker container.
Next step is to make it a full fledged auth service.
## CURL Commands
### get
`curl localhost:8083/events
`
### post on mac
`curl -X POST -H "Content-Type: application/json" -d '{"name": "Another Event"}' http://localhost:8083/events
`

### post on windows cmd
`curl -Method POST -Uri http://localhost:8083/events -Headers @{ "Content-Type" = "application/json" } -Body '{"name": "Another Event"}'
`
### for windows the format might be defferent.

## Enter the postgres running in the docker container
## 0. Run using the SecurityApplication file in the IDE
This only works in the dev envioronment.
## 1. How to build and run using maven in mac terminal?

### Build the Application Using Maven:
Compile the application and package it into a JAR file using the Maven wrapper. This step will create the executable JAR file in the target directory.

`./mvnw package`

### Run the Application Locally:
Execute the JAR file to start the Spring Boot application. It will listen on the port specified in your application.properties (8081 in this case).

`java -jar target/security-0.0.1-SNAPSHOT.jar`


## enter the postgres running in the docker container
### command format
`docker exec -it <container_name> psql -U <username> -d <database_name>
`
### command 
`docker exec -it security-postgres-1 psql -U myuser -d mydatabase`


### once in the postgres list them all

`\l`
### connect to your db
`\c mydatabase`

### test with a simple query
`select * from event;`