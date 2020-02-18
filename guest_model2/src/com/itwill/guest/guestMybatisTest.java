package com.itwill.guest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class guestMybatisTest {

	public static void main(String[] args) throws Exception {
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		String today = sdFormat.format(nowDate);
		GuestService guestService = new GuestService();
//		System.out.println("---->"+guestService.selectAll());
//		System.out.println("--->" + guestService.selectByNo(13));
//		System.out.println("---insert" + guestService
//				.insertGuest(new Guest(0, "마바마바",today, "mybatis@naver.com", "없음", "youbatis", "적당히좀쓰자...")));
//		System.out.println("--->"+guestService.deleteGuest(13));
		Guest updateGuest = new Guest(2, "마이바티스", today, "change@gmail.com", "없음", "테스트하는중", "테테스트?");
		System.out.println("--->"+guestService.updateGuest(updateGuest));

	}

}
