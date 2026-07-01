# Alsostore

A simple read-only product catalog backend built with Spring Boot 4 (Java 21) + PostgreSQL. Serves a list of categories and products, and seeds the database with demo data on first run.

## Stack

- Java 21, Spring Boot 4.0.0
- Spring Web MVC, Spring Data JPA
- PostgreSQL
- Lombok

## Getting Started

### 1. Requirements
- JDK 21
- PostgreSQL

### 2. Environment setup

Create a `.env` file in the project root (picked up via `spring.config.import`):

```env
DATABASE_URL=jdbc:postgresql://localhost:5432/alsostore
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=postgres
```

The DB schema is created/updated automatically (`ddl-auto: update`); there are no separate migrations in the project.

### 3. Build and run

```bash
./mvnw spring-boot:run
```

or

```bash
./mvnw clean package
java -jar target/alsostore-0.0.1-SNAPSHOT.jar
```

The app starts on `http://localhost:8080`.

### 4. Demo data

On startup, `DataSeeder` checks whether categories already exist in the database — if the table is empty, it creates 3 categories (`Electronics`, `Clothing`, `Home and Kitchen`) and 4 products. On subsequent runs, seeding is skipped if data is already present.

There's no authentication or authorization in the project — all endpoints are open.

## REST API

Base prefix: `/api`

| Method | Path | Description |
|---|---|---|
| `GET` | `/categories` | List all categories |
| `GET` | `/products` | List all products |
| `GET` | `/products/category/{categoryId}` | List products by category ID |

All endpoints are read-only — there's no create, update, or delete via the API.

## Database schema

```
Category
├── id (PK, identity)
└── name

Product
├── id (PK, identity)
├── name
├── description
├── image_url
├── price
└── category_id (FK → Category.id, NOT NULL)
```

Relationship: `Category 1—N Product`. When serialized to JSON, `Product.category` is hidden (`@JsonIgnore`), and `Category.products` is lazily loaded and effectively unused in the current API responses.
