# RESTful APIs with Spring Boot

Experiment 2.1.1 implementation using Java 17+ and Spring Boot. Only GET and POST APIs are provided for the Post resource.

## Structure

- `controller` — HTTP endpoints
- `service` — business logic
- `repository` — database access
- `model` — JPA entity
- `dto` — request, response, and standard API envelope
- `exception` — validation and error handling
- `config` — CORS settings

## Run

`mvn spring-boot:run`

The service starts at `http://localhost:8080` and uses an in-memory H2 database.

## Endpoints

### POST /api/posts

`{ "title": "Spring Boot API", "content": "Created through a validated POST request." }`

Returns `201 Created`.

### GET /api/posts

Returns `200 OK` and all posts.

All responses include `success`, `message`, `data`, and `timestamp`. Invalid requests return field-specific validation errors. CORS permits local React and Vite development servers.
