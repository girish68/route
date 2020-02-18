# route demo project

This is mvc demo project which gives yes/no response if a route connectivity (input.txt) exists between two cities. The end point is as

folows http://localhost:8080/connected?origin=xxxx&destination=yyyy where 'xxxx' is the origin city and 'yyyy' is the destination city

example : http://localhost:8080/connected?origin=Boston&destination=New York

The above url responds with yes/no. The "yes" response confirms the route between the cities and "no" confirms no connectivity. The coverage can be expanded by editing the "input.txt" under resources by adding the connetivity between more cities.

The program reads the input.txt file and parses it to establish the route database. For every GET request, the programs extracts the request parameters "origin" and "destination" using "RequestParam" annotation and does the lookup on the route database and responds back "yes" if the route exists between them otherwise responds with "no".

The project can be built using maven compiler using the command "clean compile package" or simply importing into any IDE (like IntelliJ) Once the project is successfully compiled the same can be run.The web server is hosted out of local host port 8080.

A few unit tests also exists using mockmvc for postive tests and negative tests

Finally the program generates the swagger definition for the end point and it can be accessed at http://localhost:8080/swagger-ui.html

The route-controller link will display the GET end point and parameter types. The end point can be tested in swagger page also.


