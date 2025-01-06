package com.revature.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        UserDaoPositiveTest.class,
        UserDaoNegativeTest.class
})
public class UserDaoTestSuite {

}
