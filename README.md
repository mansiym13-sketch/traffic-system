# 🚦 Smart Traffic System

A robust backend application built with **Spring Boot** designed to monitor, manage, and process traffic-related data. This system provides a structured approach to handling traffic violations, complete with database integration and a web-based user interface.

## 🚀 Features

* **Violation Management:** Track and store traffic violations using dedicated entities and repositories.
* **Web Interface:** Includes frontend templates (`index.html`) served via Spring MVC for user interaction and data visualization.
* **RESTful & MVC Controllers:** Handles API requests and serves web views through `TrafficController` and `TrafficViewController`.
* **Containerization Ready:** Includes a `Dockerfile` for seamless deployment and scalable containerized environments.
* **Robust Architecture:** Built on the reliable Spring Boot framework with Maven for dependency management.

## 🛠️ Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **Data Access:** Spring Data JPA / Hibernate (via `ViolationRepository`)
* **Build Tool:** Maven (`pom.xml`, `mvnw`)
* **Frontend:** HTML5 (Spring Boot Templates)
* **Deployment:** Docker

## 📂 Project Structure

```text
traffic-system/
│
├── src/main/java/com/traffic/system/
│   ├── controller/               # Request handlers
│   │   ├── TrafficController.java
│   │   └── TrafficViewController.java
│   ├── entity/                   # Database models
│   │   └── Violation.java
│   ├── repository/               # Database access layers
│   │   └── ViolationRepository.java
│   └── TrafficSystemApplication.java # Main entry point
│
├── src/main/resources/
│   ├── templates/                # Web UI views
│   │   └── index.html
│   └── application.properties    # Application configuration
│
├── Dockerfile                    # Docker configuration
├── pom.xml                       # Maven dependencies
└── mvnw / mvnw.cmd               # Maven wrapper scripts
⚙️ Getting Started
Follow these steps to set up the project locally.

Prerequisites
Java Development Kit (JDK): Version 11 or higher (typically 17 for modern Spring Boot).

Maven: (Optional, as the project includes the Maven Wrapper mvnw).

Docker: (Optional, for containerized deployment).

Local Installation & Execution
1. Clone the repository:

Bash
git clone [https://github.com/mansiym13-sketch/traffic-system.git](https://github.com/mansiym13-sketch/traffic-system.git)
cd traffic-system
2. Build the project:
Using the included Maven wrapper, compile the project and download dependencies:

Bash
# On Linux/macOS
./mvnw clean install

# On Windows
mvnw.cmd clean install
3. Run the application:
Start the Spring Boot server:

Bash
# On Linux/macOS
./mvnw spring-boot:run

# On Windows
mvnw.cmd spring-boot:run
The application will typically start on http://localhost:8080.

🐳 Running with Docker
If you prefer to run the application in an isolated container:

1. Build the Docker image:

Bash
docker build -t traffic-system .
2. Run the container:

Bash
docker run -p 8080:8080 traffic-system
