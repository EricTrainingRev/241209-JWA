package com.revature.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        UserDaoPositiveTest.class,
        UserDaoCreateUserNegativeTest.class,
        UserDaoFindUserByUsernameNegativeTest.class
})
public class UserDaoTestSuite {

}
