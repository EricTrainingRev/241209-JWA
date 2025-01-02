package com.revature.service;

import com.revature.exceptions.DuplicateUserException;
import com.revature.repository.UsernameStorageRepo;

public class UsernameStorageServiceImp implements UsernameStorageService{

    private UsernameStorageRepo usernameStorageRepo;

    public UsernameStorageServiceImp(UsernameStorageRepo usernameStorageRepo){
        this.usernameStorageRepo = usernameStorageRepo;
    }

    @Override
    public String storeUsername(String username) {
        for(String u : usernameStorageRepo.getUsernames()){
            if(u.equals(username)){
                throw new DuplicateUserException("Username taken: please choose another");
            }
        }
        /*
            If your application was more robust you might have more checks put here: for instance,
            what if the username is valid but something goes wrong in the database and the username
            is not stored correctly? In that situation you might get a database specific error
            that triggers some exception in your code base. There are many more steps that COULD be
            taken to test the application, but when you are in the midst of a sprint you want to focus
            first and foremost on whatever your MVP requirements are
         */
        usernameStorageRepo.storeUsername(username);
        return username + " added to database successfully";
    }
}
