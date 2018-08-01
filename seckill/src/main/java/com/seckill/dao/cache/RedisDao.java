package com.seckill.dao.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.seckill.entity.SecKill;
import com.seckill.exception.SeckillCloseException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final JedisPool jedisPool;
	
	public RedisDao(String ip, int port) {
		this.jedisPool = new JedisPool(ip, port);
	}
	
	private RuntimeSchema<SecKill> schema = RuntimeSchema.createFrom(SecKill.class);
	
	public SecKill getSeckill(long seckillId) {
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + seckillId;
				
				//自动序列化
				byte[] bytes = jedis.get(key.getBytes());
				//缓存中获取到bytes
				if(bytes != null) {
					//初始化一个空对象
					SecKill secKill = schema.newMessage();
					ProtostuffIOUtil.mergeFrom(bytes, secKill, schema);
					return secKill;
				}
			} finally {
				// TODO: handle finally clause
				jedis.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	
	public String putSeckill(SecKill secKill) {
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + secKill.getSeckillId();
				byte[] bytes = ProtostuffIOUtil.toByteArray(secKill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				//设置超时时间
				int timeout = 60*60;
				String result = jedis.setex(key.getBytes(), timeout, bytes);
				return result;
			} finally {
				// TODO: handle finally clause
				jedis.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(),e);
		}
		return null;
	}
	
}










