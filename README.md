# Quiz Application

## Overview

This is a Quiz Application developed using Spring Boot and PostgreSQL. The application allows users to take quizzes, view their scores, and manage quiz content. It uses RESTful APIs to handle CRUD operations for quizzes and questions.

## Features

- User registration and authentication
- Create, read, update, and delete quizzes
- Add, update, and delete questions
- Take quizzes and get scores
- View quiz history and scores

## Technologies Used

- **Backend:**

  - Spring Boot
  - Spring Security
  - Spring Data JPA
  - PostgreSQL
  - REST API

- **Tools:**
  - Spring Tool Suite (STS)
  - Postman

## Prerequisites

- Java 8 or higher
- Maven
- PostgreSQL

## Setup Instructions

### Backend Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/akash-codelink/quiz-application.git
   cd quiz-application
   ```

2. **Configure PostgreSQL:**

   - Create a database named `questionDB`.
   - Update the `application.properties` file located in `src/main/resources/` with your PostgreSQL database details:

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/quizdb
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

     ```

3. **Open the project in Spring Tool Suite (STS):**

   - Open STS and import the project using `File -> Import -> Existing Maven Projects`.
   - Navigate to the project's root directory and finish the import.

4. **Build and run the application:**
   - Use the STS interface to build the project by right-clicking on the project and selecting `Run As -> Maven install`.
   - Run the project by selecting `Run As -> Spring Boot App`.

## Testing with Postman

1. **Install Postman:** Download and install Postman from [https://www.postman.com/](https://www.postman.com/).

2. **Import API collection:**

   - Create a new Postman collection and add requests for the following API endpoints.

3. **API Endpoints:**

- **User Endpoints:**

  - `POST /api/register` - Register a new user
  - `POST /api/login` - User login

- **Quiz Endpoints:**

  - `POST /api/quiz/create` - Create a new quiz
  - `GET /api/quiz/getQuiz/{id}` - Get quiz by ID
  - `PUT /api/quiz/submit/{id}` - submit quiz

- **Question Endpoints:**
  - `GET /api/Question/allQuestions/` - Get all questions from DB
  - `GET /api/Question/category/{type}` - Get questions based on category type
  - `POST /api/Question/addQuestion` - Add questions into DB
  - `PUT /api/Question//updateById/{question}` - Update a question
  - `DELETE /api/Question//deleteQuestion/{id}` - Delete a question

## Usage

1. **Register a new user or login with existing credentials.**
2. **Create a new quiz:**
   - Use the REST API or frontend interface to create a new quiz.
   - Add questions to the quiz.
3. **Take a quiz:**
   - Select a quiz to take.
   - Answer the questions and submit the quiz.
4. **View scores:**
   - After submitting the quiz, view your score.
   - Check quiz history and past scores.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure your code follows the project's coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the Spring Boot and PostgreSQL communities for their fantastic tools and documentation.
- Special thanks to all contributors and testers.

---
