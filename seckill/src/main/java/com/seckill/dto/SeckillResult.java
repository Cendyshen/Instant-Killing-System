package com.seckill.dto;

public class SeckillResult<T> {
	
	private boolean success;
	
	private T data;
	
	private String error;

	public SeckillResult(boolean success, T data) {
		this.setSuccess(success);
		this.setData(data);
	}

	public SeckillResult(boolean success, String error) {
		this.setSuccess(success);
		this.setError(error);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}
