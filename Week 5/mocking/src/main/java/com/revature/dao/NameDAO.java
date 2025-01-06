package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

/*
    We can use Mockito to test the Service class that utilizes this DAO class even though the DAO
    is not yet complete: for the purposes of unit testing, it should not matter whether the dependency
    class is fully implemented or not: the goal is not to test the dependency, but the service that
    uses it
 */
public class NameDAO {

    private List<String> names;

    public NameDAO(){
        names = new ArrayList<>();
    }

    /*
        In order to stub our mock object methods the methods
        need to be available in the mocked class, hence the
        unimplemented methods below

        Keep in mind if you don't provide Mockito with a stub result for a method then Mockito
        will return whatever the default of the return type is when the method is called
     */

    //TODO: implement method
    public boolean addName(String name){
        return false;
    }

    //TODO: implement method
    public List<String> returnNames(){
        return null;
    }

}
