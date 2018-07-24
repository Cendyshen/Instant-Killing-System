package com.seckill.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.entity.SuccessKilled;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKillDao;
	
	@Test
	public void testInsertSuccessKilled () throws Exception{
		long id = 1000L;
		long phone = 13223413213L;
		int insertCount = successKillDao.insertSuccessKilled(id ,phone);
		System.out.println("insertCount:"+insertCount);
	}

	@Test
	public void testQueryByIdWithSeckill() throws Exception{
		long id = 1000L;
		long phone = 13223413213L;
		SuccessKilled successKilled = successKillDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckilled());
	}

}
