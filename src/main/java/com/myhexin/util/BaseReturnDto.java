package com.myhexin.util;

import java.util.HashMap;
import java.util.Map;

public class BaseReturnDto {
	private String retCode ="";//0成功，1失败
	private String retMsg = "";
	private Map<String,Object> ext_msg = new HashMap<String,Object>();

	
	public BaseReturnDto() {
		super();
	}

	public BaseReturnDto(String retCode, String retMsg) {
		super();
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public Map<String, Object> getExt_msg() {
		return ext_msg;
	}

	public void setExt_msg(Map<String, Object> ext_msg) {
		this.ext_msg = ext_msg;
	}
	
}
