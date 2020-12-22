package com.bitacademy.emaillist.dao.test;

import java.util.List;

import com.bitacademy.emaillist.dao.EmaillistDao;
import com.bitacademy.emaillist.vo.EmaillistVo;

public class TestEmaillistDao {

	public static void main(String[] args) {
//		EmaillistVo vo = new EmaillistVo();
//		vo.setFirstName("마");
//		vo.setLastName("이콜");
//		vo.setEmail("michol@gmail.com");
//		testInsert(vo);
		testFindAll();
	}
	
	public static boolean testInsert(EmaillistVo vo) {
		return new EmaillistDao().insert(vo);
	}
	
	public static void testFindAll() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		for(EmaillistVo vo : list) {
			System.out.println(vo);
		}
	}
}
