package com.sjl.health.entity;

public class Result<T> {
	
	private final static String Test_CODE = "STATIC_KEY_TEST";
	
	private String Err_Code;//返回值编号，0000代表成功，其它代表失败

    private T data; //返回的实体对象 
    
    private String Err_Msg;

    public Result() {
    }
    
    public Result<T> success(T data) {
    	Result<T> result = new Result<T>();
    	this.Err_Code = "0000";
    	this.Err_Msg = "success";
		return result;
    }
    
    public Result<T> fail(String message) {
    	Result<T> result = new Result<T>();
    	this.Err_Code = "0001";
    	this.Err_Msg = message;
		return result;
    	
    }

	public String getErr_Code() {
		return Err_Code;
	}

	public void setErr_Code(String err_Code) {
		Err_Code = err_Code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErr_Msg() {
		return Err_Msg;
	}

	public void setErr_Msg(String err_Msg) {
		Err_Msg = err_Msg;
	}
}

