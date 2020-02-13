package com.itwill.user.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserDaoJunitTest.class, UserDaoJunitTest2.class, UserDaoJunitTest3.class })
public class AllTests {

}
