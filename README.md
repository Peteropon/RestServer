# RestServer

This is a very simple spring server which delivers REST responses of a small animal database. The server is up and running on aws Elastic Beanstalk 
here: http://petros.us-east-2.elasticbeanstalk.com/
It supports GET, POST, PUT and DELETE requests.
Endpoints:
  - /animals : For a list of all available animals (GET) or for inserting a new animal (POST) combined with a json body
  - /animals/{id} : For inquiring a specific animal (GET), for updating (PUT) or deleting (DELETE) an animal
  - /randomanimal : Returns a random animal from the database
  
Some additional info about the server is also available through Spring Boot Actuator by entering
- /actuator/ + health or mapping or httptrace
