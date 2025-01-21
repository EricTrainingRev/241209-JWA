# Planetarium Sprint 2
The Planetarium is a web application designed by Revature Space Initiative for astronomers to track celestial bodies they discover in the night sky. Testing work on the application is progressing, and the company wants to capitalize on the automation work completed so far: your job this Sprint is to begin developing a CICD pipeline for the Planetarium to further automate the building/testing of the application. Also, there are multiple stretch goals for this sprint: your team has a secondary goal of beginning work on those stretch goals and reporting on your progress at the end of the sprint

## Project Technology Focus
- Java
- Selenium
- Cucumber
- Junit
- Mockito
- Jira
- Test Case Creation
- Test Reporting
- System Testing
- Integration Testing
- Unit Testing
- DevOps
- Jenkins
- AWS

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
- the same github repo for Sprint 2 should be utilized
    - all team members should be added as contributors
    - a team branching strategy should be determined and enforced
    - a robust .gitignore file should be created
