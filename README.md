# Enviro365: Waste Management System

A Spring Boot application for managing waste disposal guidelines, recycling tips, and waste categories.

## Project Overview

This application provides a comprehensive waste management system with features for:
- Waste categorization
- Disposal guidelines management
- Recycling tips and best practices

## Project Structure Details

The application follows a layered architecture:
- **Controllers**: Handle HTTP requests and responses
- **Services**: Implement business logic
- **Repositories**: Manage data persistence
- **Models**: Define data structures

## Features

1. Waste Categories
   - Management of different waste types
   - Category-specific descriptions

2. Disposal Guidelines
   - Detailed instructions for waste disposal
   - Category-specific disposal methods

3. Recycling Tips
   - Best practices when recycling
   - Category-specific disposal methods

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Your preferred IDE (Eclipse, IntelliJ IDEA, etc.)

### Installation

1. Clone the repository:
   ```bash
   git clone git@github.com:Sandile88/waste_management.git
   ```

2. Navigate to the project directory:
   ```bash
   cd waste_management
   ```

3. Build the project:
   ```bash
   ./mvnw clean install
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

### Running Tests

The project includes comprehensive test coverage:

```bash
./mvnw test
```

Test categories include:
- Controller Tests
- Model Tests
- Service Implementation Tests

## H2 Console Access Instructions
You can access the H2 console by navigating to the following URL in your web browser:

#### [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### H2 Database Connection Details
To connect to the H2 database console, use the following credentials:


**JDBC URL:** `jdbc:h2:mem:waste_mgmt_db`

**Username:** `sa`

**Password:** `password`


## API Endpoints

### Waste Categories
- `GET /api/categories` - List all waste categories
- `POST /api/categories` - Create a new category
- Additional endpoints documented in `WasteCategoryController`

### Disposal Guidelines
- `GET /api/guidelines` - List all disposal guidelines
- `POST /api/guidelines` - Create new guidelines
- Additional endpoints documented in `DisposalGuidelineController`

### Recycling Tips
- `GET /api/recycling-tips` - List all recycling tips
- `POST /api/recycling-tips` - Create new recycling tips
- Additional endpoints documented in `RecyclingTipController`

