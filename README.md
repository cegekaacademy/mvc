# Model View Controller

## Agenda
* REST
* Servlets
* MVC

## Setup
Download postman(app or chrome extension) https://www.getpostman.com/downloads/

## Workshop - Game of Thrones
We want to create a GOT API.  
Our one and only entity is __Character__ - a character from GOT (ex: Tyrion Lannister).  
Build an application with three layers(DAO, Service, RestController) based on Spring Boot. We provide DAOs and Services but not the Controllers.  
### Task1
Create a rest controller with the following CRUD methods:
* getById(Long id) - return to client the character with specified id
* getAll() - return to client all characters
* save(Character) - save your own character
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
