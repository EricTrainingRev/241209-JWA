package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

public class UsernameStorageRepoImp implements UsernameStorageRepo{

    public List<String> usernameStorage;

    public UsernameStorageRepoImp(){
        usernameStorage = new ArrayList<>();
    }

    @Override
    public String storeUsername(String username) {
        return "";
    }
}
