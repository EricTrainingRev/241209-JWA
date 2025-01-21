# Jenkins
Jenkins is a popular ope source devops tool: it allows you to create a devops pipeline that can interact with your github repo, perform build and test actions on your source code, and facilitate the generation of documentation, along with many other actions

## Jenkins Terminology
- Main Controller: this is the software that controls your Jenkins **jobs**
- Agents: this is the software used to perform the actions within a Jenkins job
    - agents are meant to contain the bare-bones software needed to perform one or more actions within a Jenkins job
- job: the collection of actions Jenkins is intended to perform for us
    - the level of automation within the job determines whether we are doing Continuous Delivery or Continuous Deployment
- build: a build singular is the output of a Jenkins job: you can have multiple build resources, but the general term for the results of a Jenkins job is simply the build
- Freestyle job: a Jenkins job that is configured via Jenkins directly
    - this type of job is useful when the job has few actions or involves a smaller application
- Pipeline job: the initial job creation happens in the Jenkins UI, but the actions and resources used in the job are controlled by a file within your remote repository called a "Jenkinsfile"
    - Jenkinsfile is written in Groovy Syntax, which can make it easier to determine what agent performs specific actions, and it makes it easier to interact wit build objects within the job
    - Using a Jenkinsfile allows your team to practice "Configuration as Code": this is a practice of using one or more configuration files saved with the rest of your source code to control/configure your Jenkins job. The benefit of this is easy tracking of changes to the job, easy access to the configuration for all team members (less permission management/credential management) and easier linking between resources in your source code and your Jenkins job