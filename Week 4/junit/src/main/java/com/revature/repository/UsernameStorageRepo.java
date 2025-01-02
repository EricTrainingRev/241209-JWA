package com.revature.repository;

import java.util.List;

public interface UsernameStorageRepo {

    String storeUsername(String username);

    List<String> getUsernames();

}
