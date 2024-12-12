# Test Data Organizer

## User Story 1
- Happy Path Testing
    - need username & password that meets all requirements

|id|valid username|
|--|--------------|
|VU1|Super_man-2001|

|id|valid password|
|-|-|
|VP1|Krypton-was_2000|

- Sad Path Testing
    - need usernames & passwords that fail one or more requirements

|id|invalid username|requirement broken|
|-|----------------|------------------|
|IU1|Batman          |UR1               |
|IU2|Bane            |UR2               |
|IU3|wonder_woman_for_the_DC_theming|UR2|
|IU4|2face           |UR3|
|IU5|joker!!!!!!?)|UR4|

|id|invalid password|requirement broken|
|-|-|-|
|IP1|b0Ts|UR2|
|IP2|AlfredIsTheBestButlerToExist111|UR2|
|IP3|3atman|UR3|
|IP4|A1fredIsTheBestButlerToExist!!|UR5, UR6|
|IP5|batman1|UR5|
|IP6|BATMAN1|UR5|
|IP7|Robin|UR5|

Once you have your positive and negative test data you need to organize what your expected outputs are when the data is used in your acceptance criteria: a Decision Table is a useful way of organizing the data with the expected results they should produce

|Username|Password|Expected Result|
|-|-|-|
|VU1|VP1|Account create successfully alert|
|IU1|VP1|Invalid username alert|
|IU2|VP1|Invalid username alert|
|IU3|VP1|Invalid username alert|
|IU4|VP1|Invalid username alert|
|IU5|VP1|Invalid username alert|
|VU1|IP1|Invalid password alert|
|VU1|IP2|Invalid password alert|
|VU1|IP3|Invalid password alert|
|VU1|IP4|Invalid password alert|
|VU1|IP5|Invalid password alert|
|VU1|IP6|Invalid password alert|
|VU1|IP7|Invalid password alert|

## User Story 2
- Happy Path Testing

|Id|valid username|
|-|-|
|VU1|Batman|

|Id|valid password|
|-|-|
|VP1|Iamthenight1939|

- Sad Path Testing

|Id|invalid username|
|-|-|
|IU1|Robin|

|Id|invalid password|
|-|-|
|IP1|Iamtheintern1939|

Decision table for login

|Username|Password|Expected Result|
|-|-|-|
|VU1|VP1|login success|
|VU1|IP1|Invalid Credentials alert|
|IU1|VP1|Invalid Credentials alert|
|IU1|IP1|Invalid Credentials alert|

Decision table for accessing home page

|user state|expected result|
|-|-|
|logged in| can access home page directly|
|logged out| can not access home page directly|