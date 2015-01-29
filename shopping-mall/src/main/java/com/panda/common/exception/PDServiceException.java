package com.panda.common.exception;

import com.panda.common.vo.ResponseCode;

/**
 * 
 * service层异常处理类
 * 
 */
public class PDServiceException extends Exception {

	/**
	 * 序列化标识
	 */
	private static final long serialVersionUID = 23625480652400721L;

	/**
	 * 错误描述信息
	 */
	private String errorMsg;

	/**
	 * 错误代码
	 */
	private int errorKey = ResponseCode.FAIL;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(int errorKey) {
		this.errorKey = errorKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorMsg == null) ? 0 : errorMsg.hashCode());
		result = prime * result + errorKey;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PDServiceException other = (PDServiceException) obj;
		if (errorMsg == null) {
			if (other.errorMsg != null)
				return false;
		} else if (!errorMsg.equals(other.errorMsg))
			return false;
		if (errorKey != other.errorKey)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PDServiceException [errorMsg=" + errorMsg + ", errorKey="
				+ errorKey + "]";
	}

	public PDServiceException() {
	}

	public PDServiceException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.errorKey = ResponseCode.SERVICE;
	}

	public PDServiceException(String errorMsg, int errorKey) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.errorKey = errorKey;

	}

	public PDServiceException(Exception exception) {
		super();
		this.errorMsg = exception.getLocalizedMessage();
		this.errorKey = ResponseCode.SERVICE;
	}

	public PDServiceException(int errorKey, Throwable cause) {
		super(cause);
		this.errorMsg = cause.getLocalizedMessage();
		this.errorKey = errorKey;
	}

}
