# ⚽ NextXI Backend

NextXI is a football intelligence platform that helps users make smarter football decisions using data, analytics, and AI.

This repository contains the backend service built with **Kotlin**, **Spring Boot**, and **PostgreSQL**.

---

## 🚀 Tech Stack

- Kotlin
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Flyway
- Docker & Docker Compose
- Gradle

---

## 📋 Prerequisites

Before you begin, make sure you have:

- Java 21
- Docker Desktop
- IntelliJ IDEA
- Git

---

## 📥 Clone the Repository

### SSH (Recommended)

```bash
git clone git@github.com:<your-github-username>/nextxi-backend.git
cd nextxi-backend
```

### HTTPS

```bash
git clone https://github.com/<your-github-username>/nextxi-backend.git
cd nextxi-backend
```

---

## ⚙️ Environment Configuration

Create a local environment file.

```bash
cp .env.example .env
```

Example:

```env
POSTGRES_DB=nextxi
POSTGRES_USER=nextxi
POSTGRES_PASSWORD=nextxi
```

---

## 🐳 Start PostgreSQL

```bash
docker compose up -d
```

Verify:

```bash
docker ps
```

Stop the database:

```bash
docker compose down
```

Stop and remove the database volume:

```bash
docker compose down -v
```

---

## ▶️ Run the Application

Open the project in IntelliJ IDEA.

Run:

```
NextxiBackendApplication.kt
```

By default the application starts on:

```
http://localhost:8080
```

---

## 🗄 Database

Current database:

- PostgreSQL 16

Database connection:

| Property | Value |
|----------|-------|
| Host | localhost |
| Port | 5432 |
| Database | nextxi |

---

## 📁 Project Structure

```
nextxi-backend
├── docker
├── src
│   ├── main
│   │   ├── kotlin
│   │   └── resources
│   └── test
├── docker-compose.yml
├── .env.example
├── README.md
├── build.gradle.kts
└── settings.gradle.kts
```

---

## ✅ Current Development Status

- ✔ Spring Boot project initialized
- ✔ Kotlin configured
- ✔ Docker environment configured
- ✔ PostgreSQL running in Docker
- ✔ IntelliJ database integration
- ✔ Spring Data JPA
- ✔ Flyway integrated
- 🔄 Database schema design in progress
- 🔄 REST API development in progress

---

## 🛣 Roadmap

### Phase 1
- Authentication
- Player Management
- Club Management
- Competition Management

### Phase 2
- Scouting Engine
- Transfer Recommendation Engine
- Search & Filtering

### Phase 3
- AI-powered Football Decision Engine
- Analytics Dashboard
- Performance Insights

---

## 🤝 Contributing

Contributions, ideas and suggestions are welcome.

Please create a feature branch and submit a Pull Request.

---

## 📄 License

This project is currently under active development.