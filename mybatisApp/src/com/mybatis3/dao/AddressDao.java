package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Address;

public class AddressDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.mybatis3.mapper.AddressMapper.";

	public AddressDao() {
		InputStream mybatisConfigInputStream = null;
		try {
			mybatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Address findAddressById(Integer addrId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Address address = sqlSession.selectOne(NAMESPACE+"findAddressById",addrId);
		sqlSession.close();
		return address;
	}
	
	public ArrayList<Address> findAddressAll(){
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<Address> addressList = null;
		addressList = sqlSession.selectList(NAMESPACE+"findAddressAll");
		return (ArrayList<Address>) addressList;
	}
	
}
