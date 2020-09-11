# unbox-challenge

This a challenge of Unbox Culture. This project did use Java, Spring Boot, MongoCluster

For access the cluster, use MongoDB Compass and use this uri:

  mongodb+srv://admin:nimda@cluster0.4lvhw.gcp.mongodb.net/test
  
For create a user, started the project and use Postman.

  Endpoint for create user:
  
    http://localhost:8080/user/add
    
  Method POST
  
  Body example:
  
    {
      "name":"Admin",
      "email":"admin123@gmail.com",
      "doc":"003.803.050-03"
    }
   
  Is necessary a valid CPF and email valid
