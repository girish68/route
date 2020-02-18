# route
This is mvc demo project which gives yes/no response if a route connectivity (input.txt) exists between two cities. The end point is as
folows http://localhost:8080/connected?origin=xxxx&destination=yyyy where xxxx is the origin city and yyyy is the destination city

The above url responds with yes/no. The yes response confirms the route between the cities.

The project can be built using maven compiler using teh command "clean compile package"

A few unit tests also exists for postive tests and negative tests

Also the program generates the swagger definition for the end point and it can be accessed at http://localhost:8080/swagger-ui.html


