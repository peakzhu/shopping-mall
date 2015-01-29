package com.panda.common.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ReturnData<E> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 801303944859566772L;

	/**
	 * 操作结果的状态码，具体定义参见ResponseCode类的定义
	 */
	protected int code;
	
	/**
	 * 操作结果的描述信息，可作为页面提示信息使用
	 */
	protected String msg;
	
	/**
	 * 操作类型，具体定义参见OperationType类的定义
	 */
	protected int opttype;
	
	/**
	 * 返回的业务数据
	 */
	protected E data;

	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	/**
	 * 有参构造方法
	 * @param opttype
	 */
	public ReturnData(int opttype) {
		this.opttype = opttype;
	}

	/**
	 * 业务层执行成功时，根据业务层返回的数据，填充ReturnData对象
	 * @param desc 成功描述信息，即ReturnData对象中的msg
	 * @param e 业务数据
	 * @return ReturnData对象
	 */
	public ReturnData<E> getSuccessResponse(String desc, E e){
		setCode(ResponseCode.OK);
		setMsg(desc);
		data = e;
		return this;
	}
	
	/**
	 * 业务层执行成功时，根据业务层返回的数据，填充ReturnData对象
	 * @param e 业务数据
	 * @return ReturnData对象
	 */
	public ReturnData<E> getSuccessResponse(E e){
		setCode(ResponseCode.OK);
		setMsg("调用后台方法成功");
		data = e;
		return this;
	}
	
	
	/**
	 * 根据业务层的逻辑异常，填充ReturnData对象
	 * @param errorKey 错误代码，即ReturnData对象中的code，如果为1(1为正常的code)所以设为0
	 * @param desc 错误描述信息，即ReturnData对象中的msg
	 * @return SMTResponse对象
	 */
	public ReturnData<E> getFailResponse(int errorKey, String desc){
		setCode(1==errorKey?0:errorKey);
		setMsg(desc);
		return this;
	}
	
	/**
	 * 根据业务层的逻辑异常，填充ReturnData对象
	 * @param desc 错误描述信息，即ReturnData对象中的msg
	 * @return SMTResponse对象
	 */
	public ReturnData<E> getFailResponse(String desc){
		setCode(0);
		setMsg(desc);
		return this;
	}
	
	/**
	 * 根据业务层的逻辑异常，填充ReturnData对象
	 * @param errorKey 错误代码，即ReturnData对象中的code，如果为1(1为正常的code)所以设为0
	 * @return SMTResponse对象
	 */
	public ReturnData<E> getFailResponse(int errorKey){
		setCode(1==errorKey?0:errorKey);
		setMsg("调用后台逻辑错误");
		return this;
	}
	public Map<String,Object> toMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",this.getCode());
		map.put("meg",this.getMsg());
		map.put("data",this.getData());
		return map;
	}
	public int getOpttype() {
		return opttype;
	}

	public void setOpttype(int opttype) {
		this.opttype = opttype;
	}
	
}
