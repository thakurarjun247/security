# Security Microservice
So far it has crud operations on an entity, it uses spring web, jpa, postgres. The postgres runs in a docker container.
Next step is to make it a full fledged auth service.
## CURL Commands
### get
`curl localhost:8083/events
`
### post
`curl -X POST -H "Content-Type: application/json" -d '{"name": "Another Event"}' http://localhost:8083/events
`


## Enter the postgres running in the docker container
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

