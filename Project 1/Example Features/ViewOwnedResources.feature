Feature: View User Planets and Moons
    As a user I want to see my planets and moons added to the Planetarium so I can track my findings

    Scenario: Login should allow for viewing owned resources
        Given   the user is on the login page
        When    the user logs in
        Then    they should see their planets and moons

    Scenario: Users not logged in should not be able to view the home page and its resources
        Given   the user is not logged in
        When    the user tries to directly access the home page
        Then    the user should be denied access
