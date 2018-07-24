package com.seckill.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.entity.SecKill;
import javax.annotation.Resource;

/**
 * 配置Spring和Junit整合，Junit启动时加载SpringIOC容器
 * spring-test,junit
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SecKillDaoTest {
 
	@Resource
    private SecKillDao secKillDao;
//   
	@Test
	public void testReduceNumber() throws Exception{
        long id = 1000;
        SecKill secKill = secKillDao.queryById(id);
        System.out.println(secKill.getName());
        System.out.println(secKill);
	}

	@Test
	public void testQueryById() throws Exception{
        Date killTime = new Date();
        int updateCount = secKillDao.reduceNumber(1000L,killTime);
        System.out.println("updateCount=" + updateCount);
	}

	@Test
	public void testQueryAll() throws Exception{
		List<SecKill> seckills = secKillDao.queryAll(0, 100);
		for(SecKill secKill:seckills) {
			System.out.println(secKill);
		}
	}

}
