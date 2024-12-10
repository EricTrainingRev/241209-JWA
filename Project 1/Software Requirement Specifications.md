# Software Requirements Specification
This document contains the security and software requirements for the Planetarium application

## Security Requirements
- Passwords should never be visible in plain text
- Users should only be able to interact with resources they have added to the Planetarium
- Only logged in Users should be able to access the Planetarium home page

## Software Requirements

### User Objects
- Users should have unique usernames
- Usernames and passwords should be between 5-30 characters
- Usernames and passwords should start with a letter
- Usernames should support lower case, upper case, numeric characters, underscores, and dashes
- Passwords should contain a lower case, upper case, and numeric character
- Passwords should support underscores and dashes
### Planet Objects
- Planet names should be between 1-30 characters
- Planet names should support lower case, upper case, numeric characters, white space, underscores, and dashes
- Planets should have unique names
- Planets should be “owned” by the user that added it to the Planetarium
- Planets should allow adding an associated image, but an image should not be required for the data to be added to the database
    - JPEG & PNG should be supported
### Moon Objects
- Moon names should be between 1-30 characters
- Moon names should support lower case, upper case, numeric characters, white space, underscores, and dashes 
- Moons should have unique names
- Moons should be “owned” by the Planet the User adding the moon associated it with
- Moons should be deleted if their "owner" planet is deleted from the database
- Moons should allow adding an associated image, but an image should not be required for the data to be added to the database
    - JPEG & PNG should be supported