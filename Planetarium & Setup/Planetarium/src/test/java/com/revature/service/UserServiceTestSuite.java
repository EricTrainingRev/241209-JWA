package com.revature.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServicePositiveTest.class,
        UserServiceCreateUserNegativeTest.class,
        UserServiceAuthenticateNegativeTest.class
})
public class UserServiceTestSuite {
}
