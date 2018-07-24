package com.seckill.service;

import java.util.List;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.SecKill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;

/**
 * 业务接口：站在"使用者"角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
public interface SeckillService {
	
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<SecKill> getSeckillList();
	
	/**
	 * 查询单个秒杀记录
	 * @param seckillId
	 * @return
	 */
	SecKill getById(long seckillId);
		
	/**
	 * 秒杀开启时暴露秒杀地址，
	 * 否则暴露系统时间和秒杀开启时间
	 * @param secKillId
	 */
	Exposer exportSeckillUrl(long seckillId);	
	
	/**
	 * 用户执行秒杀操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException,SeckillCloseException;
	
	
    /**
     * 执行秒杀操作-存储过程
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
//    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
		
}
