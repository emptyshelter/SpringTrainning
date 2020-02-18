package com.itwill.guest;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class GuestDaoImplMybatis  implements GuestDao{
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.itwill.guest.mapper.GuestMapper.";
	public GuestDaoImplMybatis() {
		InputStream mybatisConfigInputStream=null;
		try {
			mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory =
					new SqlSessionFactoryBuilder()
					.build(mybatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<Guest> selectAll = new ArrayList<Guest>();
		selectAll = sqlSession.selectList(NAMESPACE+"findAllGuest");
		sqlSession.close();
		return (ArrayList<Guest>) selectAll;
	}

	@Override
	public boolean insertGuest(Guest guest) throws Exception {
		boolean isSuccess = false;
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount = sqlSession.insert(NAMESPACE+"insertGuest",guest);
		if(insertRowCount==1){
			isSuccess=true;
		}else {
			isSuccess=false;
		}
		return isSuccess;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Guest guest = sqlSession.selectOne(NAMESPACE+"findGuestByNo", no);
		sqlSession.close();
		return guest;
	}

	@Override
	public boolean deleteGuest(int no) {
		boolean isSuccess =false;
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE+"deleteGuestByNo",no);
		sqlSession.close();
		if (deleteRowCount == 1) {
			isSuccess= true;
		}else {
			isSuccess= false;
		}
		return isSuccess;
	}

	@Override
	public boolean updateGuest(Guest guest) {
		boolean isSuccess =false;
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int updateRowCount = sqlSession.update(NAMESPACE+"updateGuset",guest);
		sqlSession.close();
		if (updateRowCount == 1) {
			isSuccess= true;
		}else {
			isSuccess= false;
		}
		return isSuccess;
	}
}










