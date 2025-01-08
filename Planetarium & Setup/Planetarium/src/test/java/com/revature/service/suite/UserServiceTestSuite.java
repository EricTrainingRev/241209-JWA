package com.revature.service.suite;

import com.revature.service.negative.UserServiceAuthenticateNegativeTest;
import com.revature.service.negative.UserServiceCreateUserNegativeTest;
import com.revature.service.positive.UserServicePositiveTest;
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
