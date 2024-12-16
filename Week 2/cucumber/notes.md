# General notes
Recommended Plugins:
- Cucumber for Java
- Gherkin

These plugins will make it easier to create and execute your Cucumber tests

# Cucumber Configuration key configs
- Main Class 
  - what class will be the entry point for the Cucumber test?
- Glue 
  - where methods with code to execute when the mapped step is reached in the test?
- Feature or Folder Path 
  - where are the feature files located?

For Glue and Feature or Folder Path, if no configuration details are provided the app will search the entire classpath for data to use