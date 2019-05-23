# Model View Controller

## Agenda
* REST
* Servlets
* MVC

## Setup
Download and install postman(app or chrome extension) https://www.getpostman.com/downloads/

## Workshop - Game of Thrones
We want to create a GOT API.  
Our one and only entity is __Character__ - a character from GOT (ex: Tyrion Lannister).  
Build an application with three layers(DAO, Service, RestController) based on Spring Boot. We provide DAOs and Services but not the Controllers.  
### Task1
Create a rest controller with the following CRUD methods:
* save(Character) - save your own character
* getById(Long id) - return to client the character with specified id
* getAll() - return to client all characters
* update(Character) - update a character
* delete(Long id) - delete the character with given id  
All endpoints will produce text output(plain text).  
  
Save/update request body:   
```
      {
        "id":"271",
            "url":"",
            "name":"Ion Zapada",
            "gender":"male",
            "culture":"Valyrian",
            "born":"28.12.1996 in Pasu Tihuta",
            "died":"not today",
            "titles": ["Regele Omatului"],
        "aliases":[""],
        "playedBy":[""]
       }
```

### Task2
#### Task2.1
Intercept all request and check if those are authorized. If a request is not authorized then it should be rejected(no controller should process is).  
A request is authorized if has an __Authorization__ header with a value defind by you. Any other request is invalid.  

#### Task2.2
Extend precedent task with __basic access authentication__. So authorization header should have a __basic auth__ token as value(generate it with postman).  
On server side(in interceptor) decode __basic auth__ header and check if user and password are same with those defined by you.
