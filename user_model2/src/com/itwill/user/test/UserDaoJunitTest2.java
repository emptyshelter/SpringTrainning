package com.itwill.user.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.itwill.user.User;
import com.itwill.user.UserDao;

public class UserDaoJunitTest2 {
	public UserDaoJunitTest2() {
		//System.out.println("UserDaoJunitTest()기본생성자:"+this);
	}
	/*
	@Test(timeout=5000)  : 시간단위 : 밀리초
	@Test(expected=RuntimeException.class) : RuntimeException이 발생해야 성공
	@Ignore(value="test")
	@Before @Test로 지정된 단위 테스트 메소드가 실행되기 전 해당 테스트 클래스의 객체를 초기화하는 작업
	@After  @Test로 지정된 단위 테스트 메소드가 실행되기 전과 후에해당 테스트  실행 수 실행
	@BeforeClass
	 - 테스트 클래스 수행 시 단위 테스트 메소드 보다 먼저 딱 한 번 수행되어야 할 경우 지정
	@AfterClass
	 - 단위테스트 함수들이 다 수행되고 맨 마지막에 수행되어야 할 경우 지정
	 */
	
	UserDao userDao;
	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDao=new UserDao(JavaSeDataSource.getDataSource());
	}
	*/
	@Before
	public void setUpBefore() throws Exception {
		userDao=new UserDao(JavaSeDataSource.getDataSource());
	}
	@Test(timeout = 100000)
	public void existedUser() throws Exception{
		/*
		    assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인
			assertEquals(a,b) : 객체 a와b의 값이 같은지 확인
			assertSame(a,b) : 객체 a와b가 같은 객체임을 확인
			assertTrue(a) : a가 참인지 확인
			assertNotNull(a) : a객체가 null이 아님을 확인
			이외에도 다양한 단정문이 존재합니다. 
 			http://junit.sourceforge.net/javadoc/org/junit/Assert.html
		*/
		assertTrue(userDao.existedUser("a"));
	}
	@Test
	public void read() throws Exception{
		assertNotNull(userDao.findUser("a"));
	}
	@Test
	public void create() throws Exception{
		assertEquals(1,userDao.create(new User("dsaas","x", "엑스맨", "x@naver.com")));
	}
}
