<div>
    <h1 style="text-align: center;">
        To do list
    </h1>
</div>

<hr>

REST API for managing tasks (CRUD) which is part of the Simplify challenge for developers
junior backend, who apply for the position.

## Technologies used

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Practices adopted

- SOLID, DRY, YAGNI, KISS
- API REST
- Queries with Spring Data JPA
- Dependency Injection
- Handling error responses
- Automatic Swagger generation with OpenAPI 3

## How to run

- Clone git repository
- Build the project:

```
$ ./mvnw clean package
```

- Run the application:

```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

The API can be accessed at [localhost:8080](http://localhost:8080).
Swagger can be viewed at [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

To make the HTTP requests below, the tool was used [httpie](https://httpie.io):

- Create Task

```
$ http POST :8080/todos name="New Todo" description="Description of the new task" priority=1

[
  {
    "description": "Description of the new task",
    "id": 1,
    "name": "New Todo",
    "priority": 2,
    "realized": false
  }
]
```

- List Tasks

```
$ http GET :8080/todos

[
  {
    "description": "Description of the new task",
    "id": 1,
    "name": "New Todo",
    "priority": 2,
    "realized": false
  }
]
```

- Update Task

```
$ http PUT :8080/todos/1 name="New todo updated" description="Description of the new todo updated" priority=2 realized=true

[
  {
    "description": "Description of the new todo updated",
    "id": 1,
    "name": "New todo updated",
    "priority": 2,
    "realizado": true
  }
]
```

- Remove Task

```
http DELETE :8080/todos/1

void
```