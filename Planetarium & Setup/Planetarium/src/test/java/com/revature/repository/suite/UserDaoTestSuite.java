package com.revature.repository.suite;

import com.revature.repository.negative.UserDaoCreateUserNegativeTest;
import com.revature.repository.negative.UserDaoFindUserByUsernameNegativeTest;
import com.revature.repository.positive.UserDaoPositiveTest;
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
