# Behavior Driven Development
The basic idea behind Behavior Driven Development (BDD) is letting the perspective of the end user drive the development process:
- What kind of UI would a prospective end user want to use?
    - Web App?
    - Terminal based app?
    - API?
- What kind of actions do the end users want to take with our application?
    - login?
    - store data?
        - pictures?
        - text?
        - music?
    - transform data?
        - draw out metrics
        - Rag app
    - communicate with others?
        - video?
        - text?
        - voice?
- etc.

Ultimately, BDD involves getting in the mind space of the end user and thinking about the application you are developing from that perspective. Keep in mind this can lead to conflict in vision between the end user and stakeholders when doing agile work, so in these scenarios constant communication and clarification with the stakeholders should be done

## Common BDD Documentation
- RTM
    - User Stories
    - Acceptance Criteria

## Crafting User Stories
Fundamentally, User Stories require three core components:
- actor
- action
- intent

A typical User Story pattern:
- As a ...
    - user
    - system
    - admin
    - load balancer
- I want ...
    - to log in
    - to convert images from png to jpeg
    - to see employee information
    - to send requests to the proper location in the backend
- So that ...
    - I can view my profile
    - the image file will have the appropriate type for further transformations in the app
    - so I can validate the distribution of labor is fair
    - the applications receiving requests are not overloaded 

couple of notes when creating user stories:
- User stories should be understood by anyone working on the project
- User stories should address a specific feature/requirement of an application