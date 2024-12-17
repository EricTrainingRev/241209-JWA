package com.revature.steps.hooks;

import io.cucumber.java.*;

public class CucumberHooks {

    /*
        Often you will need to perform one or more actions between the execution of your scenarios, and
        even sometimes in between the individual steps of a scenario. Cucumber provides "hooks" in order
        to accomplish this

        Some common uses for hooks are to reset databases before test execution and taking screenshots
        after a failed scenario
     */

    @Before
    public void resetDatabase(){
        System.out.println("This hook method runs before each scenario");
    }

    @BeforeStep
    public void doSomethingBeforeEachStep(){
        System.out.println("This hook method runs before each step in a scenario");
    }

    @AfterStep
    public void doSomethingAfterEachStep(){
        System.out.println("This hook method runs after each step in a scenario");
    }

    @After
    public void takeScreenshotOfFailedScenario(Scenario scenario){
        /*
            If you need to generate any extra resources, such as screenshots, you can use the code
            snippet below to check if the scenario failed, and if so, to perform the necessary actions
            to generate the resources you need
         */
        if(scenario.isFailed()){
            System.out.println("perform some action for failed scenario");
        } else {
            System.out.println("perform some action for successful scenario");
        }
    }

}
