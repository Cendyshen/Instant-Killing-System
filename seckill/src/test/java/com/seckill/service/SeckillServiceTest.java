package com.seckill.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.SecKill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
//	@Test
//	public void testGetSeckillList() throws Exception{
//		List<SecKill> list = seckillService.getSeckillList();
//		logger.info("list={}", list);
//	}
//
//	@Test
//	public void testGetById() {
//		long id = 1000;
//		SecKill seckill = seckillService.getById(id);
//		logger.info("seckill={}", seckill);
//	}
//
//	@Test
//	public void testExportSeckillUrl() {
//		long id = 1004;
//		Exposer exposer = seckillService.exportSeckillUrl(id);
//		logger.info("exposer={}",exposer);
//	}
//
//	@Test
//	public void testExecuteSeckill() {
//		long id = 1004;
//		long phone = 123142422L;
//		String md5 = "aa0298ce3929c804326b111fff374817";
//		SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
//		logger.info("result={}",execution); 
//	}

	  //集成测试代码完整逻辑，注意可重复执行
    @Test
    public void seckillLogic() throws Exception{
        long id = 1004;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone = 15986684542L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id,phone,md5);
                logger.info("result={}",execution);
            }catch (RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }
        }else{
            //秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }

}
