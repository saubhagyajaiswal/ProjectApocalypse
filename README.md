# ProjectApocalypse
Register to Survive

Pre-Step:
Have a Postgres dataBase as below:
  url=jdbc:postgresql://localhost:5432/apocalypse
  databaseName: apocalypse
  username=postgres
  password=1234
  
 
 Run the main SurviveApplication.main() over your IDE 
            **OR**
 Open cmd prompt in source directory run _mvn clean install_  and run the _survive-0.0.1-SNAPSHOT.jar_ in target folder
 
 Once the application is up, you can use the swagger url to verify the APIs : http://localhost:8090/swagger-ui.html#/
 Or you can you Postman for API testin.
 
 **SurvivorCotroller**
     
    * Get Details of All Survivors:           GET REQUEST  http://localhost:8090/survivor
    * Infection Update :                      PUT REQUEST  http://localhost:8090/survivor/infectionUpdate?userId=11
          Request Parameter  userId: 11
    * Location Update for survivor:           PUT REQUEST  http://localhost:8090/survivor/locationUpdate?userId=11
          Request Body {
                          "latitude": "23",
                          "longitude": "33"
                        }
          Request Parameter userId : 11
    * CreateSurvivor :  Need to provide below details   POST REQUEST 
          Request Body{
              "age": 0,
              "gender": "string",
              "location": {
                   "latitude": "string",
                   "longitude": "string"
               },
              "name": "string"
              }
          Request Parameter [WATER, FOOD, MEDICATION, AMMUNITION]   // any
   
   **ReportsController**
   
        * Get Percentage Of Infected Survivors:       GET REQUEST http://localhost:8090/reports/infectedPercentage
        * Get Percentage Of Non Infected Survivors:   GET REQUEST http://localhost:8090/reports/nonInfectedPercentage
        * Get List Of Infected Survivors:             GET REQUEST http://localhost:8090/reports/infectedSurvivors
        * Get List Of Non Infected Survivors:         GET REQUEST http://localhost:8090/reports/nonInfectedSurvivors
        * Get details of all Robot (Land/Flying):     GET REQUEST http://localhost:8090/reports/robots

 
 
