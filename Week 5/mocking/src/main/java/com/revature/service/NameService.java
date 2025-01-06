package com.revature.service;

import com.revature.dao.NameDAO;
import com.revature.exception.BillyDetectedException;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.NameAdditionException;

public class NameService {
    /*
        Business Rules:
        - "billy" is not allowed in the database
        - names should be unique
     */

    private NameDAO nameDAO;

    public NameService(NameDAO nameDAO){
        this.nameDAO = nameDAO;
    }

    public String addNameExceptForBilly(String name){
        if("billy".equals(name)){
            throw new BillyDetectedException("Billy is not allowed!");
        }
        // Stub 1: we need to tell our mock nameDAO what to return when returnNames() is called
        for(String n : nameDAO.returnNames()){
            if(n.equals(name)){
                throw new DuplicateUsernameException("Name must be unique");
            }
        }
        if(nameDAO.addName(name)){
            return "Name added successfully";
        }
        throw new NameAdditionException("There was an issue adding the name to the database");
    }

}
