@US3 @SR2 @SR3
Feature: View User Planets and Moons
    As a user I want to see my planets and moons added to the Planetarium so I can track my findings

    @PR4 @MR4
    Scenario: Login should allow for viewing owned resources
        Given   the user is logged in on the home page
        Then    they should see their planets and moons

    Scenario: Users not logged in should not be able to view the home page and its resources
        Given   the user is not logged in
        When    the user tries to directly access the home page
        Then    the user should be denied access

