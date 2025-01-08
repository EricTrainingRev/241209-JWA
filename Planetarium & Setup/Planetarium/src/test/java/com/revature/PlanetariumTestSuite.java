package com.revature;

import com.revature.repository.suite.UserDaoTestSuite;
import com.revature.service.suite.UserServiceTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserDaoTestSuite.class,
        UserServiceTestSuite.class
})
public class PlanetariumTestSuite {
}
