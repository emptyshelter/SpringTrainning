package com.mybatis3.dao;

public class AddressDaoMain {

	public static void main(String[] args) {
		/*******************AddressDao.findAddressById()**************/
		AddressDao addreDao = new AddressDao();
		System.out.println("####"+addreDao.findAddressById(1));
		System.out.println("---->"+addreDao.findAddressById(1));
	}

}
