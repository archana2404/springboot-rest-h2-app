# springboot-rest-h2-app

This applicaiton has 2 modules.
  1. netflix-eureka-server
  2. exercise-animal-rest-api
  
  
  netflix-eureka-server
  
      This module create a Eureka Service registry Server on default port 8761.
      
      
 exercise-animal-rest-api
 
      This REST application supports creating an animal, geting information by animal Id and seaching an animal by type and family. Unit tests are written as well.
      
      To create an Animal object, following Json should be passed in Post request. Application will assign an family ie. MAMMAL, AMPHIBIAN based on type of the animal.
      
      {
       "name": "Rocky",
       "type": "Dog"
      }
      
      API also supports seaching animmal by type as well as family.  /animal/search endpoint should be called with parameter type or family.
      
      Currently system support following Animal TYpes.
      1. Dog
      2. Cat
      3. Snake
      4. Frog
      5. Shark
      
      
      
   How to run this application.
   
  1. Download the code to local.
  2. Run mvn install at base folder.
  3. Run mvn spring-boot:run at each  module.
  
  Note: This application is developed using Java 8. Java 8 and higher will be necessary to run this application.
   
   
