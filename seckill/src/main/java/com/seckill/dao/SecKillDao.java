package com.seckill.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.seckill.entity.SecKill;
//import org.apache.ibatis.annotations.Param;

public interface SecKillDao {
	/**
	 * 减库存
	 * @param seckillid
	 * @param killTime
	 * @return
	 */
	int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
	
	/**
	 * 根据ID查秒杀对象
	 * @param seckillId
	 * @return
	 */
	SecKill queryById(long seckillId);
	
	/**
	 * 根据偏移量查商品秒杀列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<SecKill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	
	
	
}
