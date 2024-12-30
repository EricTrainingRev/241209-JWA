# API Review
When an end user tries to perform some interaction on a web page, there are many different resources/tools that need to work together to allow for that interaction to have a chance of working:
- the web page needs to be designed to interact with the back end
    - Planetarium example: web pages making HTTP requests
- the back end needs to be designed to receive interactions from the front end
    - Planetarium example: Javalin web app designed to listen for HTTP requests
- there needs to be some way for the front and back end to communicate
    - Planetarium example: HTTP requests from the front end and responses from the back end