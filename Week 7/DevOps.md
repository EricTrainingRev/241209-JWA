# DevOps
- Development
    - writing code
    - testing your service
    - managing documentation
    - interacting with stakeholders
- Operations
    - requisition cloud resources
    - manage cloud resources
    - deploying the service/application
    - monitor the deployment
- Devops
    - a practice of combining the work of development and operations, typically through the use of automation

## General Steps of DevOps
keep in mind, Devops values automation at every step
1. Source Code Control  
    - storing code in a central cloud version controlled repository
2. Building & Testing Automation
    - triggering your tests when changes are made to your cloud repository
    - part of Sprint 3 MVP requirements
3. Deployment to staging
    - take whatever objects were built in the previous step and deploy it/them to an environment where further testing can be performed
        - think building the Planetarium jar file and sending it somewhere for E2E testing
4. Acceptance Testing
    - any final testing for the application is done in this step
        - acceptance testing
        - system testing can happen here as well
    - testing/deployment documentation should be finalized in this step
5. Deployment
    - final product is sent to the production environment and made available to end users

## CICD
Reality is not every company can afford or needs to fully automate a devops pipeline. In the world of Agile there are terms commonly used to describe the level of automation performed in the devops process:
- Continuous Integration
    - practice of regularly merging code into a central repository
    - this is where most of the manual work happens, but it can be automated
- Continuous Delivery
    - this is the practice of automating some of the devops process, but not all of it
    - this is where most of your Sprint 3 work will happen: implementing some form of automation in your CICD pipeline
- Continuous Deployment
    - the practice of automating your entire CICD pipeline. This can include automating the process of sending local source code to the central repository, but manually triggering this process is an acceptable form of manual interaction with the CICD pipeline

## Static Code Analysis
In many CICD pipelines static code analysis plays some role in the automation process: the tools provided by Sonar often perform the static analysis for you:
- SonarCloud
    - a cloud based static code analyzer, SonarCloud can be connected to your cloud repo and configured to scan your repo anytime a change is made (think merging a commit to main). 
        - SonarCloud looks for "code smells", which are things like redundant code, imports that are not used, poorly document coded, poorly written code (think hard coded infinite loop), dependency vulnerabilities, etc.
- SonarQube
    - a tool that can be configured and integrated into your devops pipeline. Because it is integrated directly it is typically considered to be a more powerful solution due to your being able to configure the tool to fit your needs
        - Note these tools are all under SonarQube online
- SonarLint
    - a plugin that can be integrated in your IDE of choice, it provides extra intellisense feedback that is designed to provide static code analysis while working on your source code