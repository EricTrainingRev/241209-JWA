package com.revature.steps.hooks;

import io.cucumber.java.Before;

public class TagHooks {

    @Before("@Search")
    public void searchTagSetup(){
        System.out.println("This hook runs before the search scenarios");
    }

    @Before("@Mobile")
    public void mobileTagSetup(){
        System.out.println("This hook runs before the mobile scenario");
    }

    @Before("@Mobile and @Matrix")
    public void mobileAndMatrixThing(){
        System.out.println("This hook runs before the mobile and matrix scenarios");
    }

}
