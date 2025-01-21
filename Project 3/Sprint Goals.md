# Sprint 3 Goals
This document outlines the primary MVP requirements of the Sprint and secondary stretch goal requirements

## MVP Requirements
The requirements listed below are the MVP requirements of the sprint: you should focus on completing these tasks before moving on to Stretch Goals

### Defect fixing
- defects discovered by your testing should be fixed
    - Retesting should be done to validate your fixes are effective

### DevOps & Jenkins
- Jenkins should be set up on an EC2 instance
- a Jenkins job should be configured for executing Junit unit and integration testing
    - manual testing is acceptable for validating the Jenkins job is functioning properly

### Cloud
- the Planetarium should switch from using SQlite locally to a cloud hosted Postgres database
    - Sanity and Regression testing should be performed to validate the switch has been completed successfully

### Stretch Goal Work
- work should be started on a minimum of two stretch goals listed below

## Stretch Goal Requirements

### Celestial resource updating
- planets and moons should support the ability to be updated
    - name change
    - image change
    - owner change
    - etc.

### Celestial resource data addition
- planets and moons should support including more data
    - descriptions
    - galaxy the resource is located in
    - orbit period
    - rotation period
    - flora and/or fauna
    - habitability
    - etc

### Feature Addition
- add functionality to the Planetarium not listed above

### UI revamp
- the Planetarium web UI should be overhauled
    - more pleasing to look at
    - more useful prompts/feedback from the page
    - new functionality added to web pages
    - etc

### DevOps
- Jenkins job should be further automated
    - implement automated testing when the github repo is updated
    - automate test result uploading to third party resources
    - deploy build objects to their intended locations
    - facilitate an entirely automated CICD pipeline
    - etc.