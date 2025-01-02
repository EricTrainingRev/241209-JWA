package com.revature.repository;

import com.revature.exceptions.DuplicateUserException;

import java.util.ArrayList;
import java.util.List;

public class UsernameStorageRepoImp implements UsernameStorageRepo{

    // this is used to represent a "real" database
    public List<String> usernameStorage;

    // when an object is made it "initializes" our database
    public UsernameStorageRepoImp(){
        usernameStorage = new ArrayList<>();
        usernameStorage.add("Batman"); // adding this for our Sad Path testing
        /*
            In a real life situation, instead of using the constructor like this you would have some
            setup script that could be used to reset or setup your database for testing
         */
    }

    /*
        This class represents us interacting with a database: so we are actually going to make
        some business logic checks here when normally you would not. This is because databases will
        oftentimes be set up in such a way that they enforce the business rules of the application
        they store data for. Having redundant checks for your business requirements and any other
        requirements that need to be accommodated in multiple layers of your application is known
        as "Defense in Depth". This is a practice of putting redundant checks in your application in
        order to make the service more fault-tolerant: even if one layer of your application fails
        to enforce requirements (think your service failing to validate a business rule) the other layers
        of your application are making the same checks,and should reduce the chance that the failure in
        the service leads to a defect being discovered by the end user
     */
    @Override
    public String storeUsername(String username) {
        for(String u : usernameStorage){
            if(u.equals(username)){
                throw new DuplicateUserException("Username taken: please choose another");
            }
        }
        /*
            In a real database you would most likely see the data being added to the database
            returned with an initialized id. We are somewhat simulating that here
         */
        usernameStorage.add(username);
        return username;
    }
}
