# Planetarium Sprint 2
The Planetarium is a web application designed by Revature Space Initiative for astronomers to track celestial bodies they discover in the night sky. Development work on the application is progressing, and the company wants to capitalize on the work of the testers brought on to the project: your job this Sprint is to explore the source code of the planetarium and create Integration and Unit tests for the application

## Project Technology Focus
- Java
- Selenium
- Cucumber
- Junit
- Mockito
- Jira
- Test Case Creation
- Test Reporting
- Acceptance Testing
- System Testing
- Integration Testing
- Unit Testing

## Setup Requirements

### Database Setup
- an environment variable called "DATABASE_URL" needs to be set with the JDBC url for the planetarium database
    - SQLite3 is used by the application
- a database needs to be created and set up for the planetarium to work properly. Use the ```setup-reset.sql``` file to create the database at the same location as your "DATABASE_URL" environment variable

### Webserver Setup
- an environment variable called "PLANETARIUM_URL" needs to be set with the url for the webserver
    - if running the app locally set it to "localhost:8080"
    - if running in the cloud set it to "{public ip or dns}:8080"

### Application start
-  start the application with the command ```java -jar path/to/Planetarium-1.0.jar```

### Team Github Repo
- a team Github repository should be created for Sprint 2
    - all team members should be added as contributors
    - a team branching strategy should be determined and enforced
    - a robust .gitignore file should be created
