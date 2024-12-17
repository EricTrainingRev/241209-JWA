package com.revature.steps.search;

import io.cucumber.java.en.Given;

public class SearchSteps {
    @Given("website open in phone")
    public void website_open_in_phone() {
        System.out.println("opening site in phone");
    }

    @Given("website open in desktop browser")
    public void website_open_in_desktop_browser() {
        System.out.println("opening site on desktop");
    }
}
