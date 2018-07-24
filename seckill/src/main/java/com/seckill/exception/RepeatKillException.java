package com.seckill.exception;

/**
 * 重复秒杀异常（runtime 异常）
 * @author dan
 *
 */
public class RepeatKillException extends RuntimeException{

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RepeatKillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
