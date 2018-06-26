package com.zyd.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JsonResultDO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code = "";
	private String message = "";
	private Object data;

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean optSuccess() {
		return "000000".equals(this.code);
	}

	public void setErr(Exception e) {
		setCode("999999");
		setMessage(e.getMessage());
		setData(null);
	}

	public void setSuccessData(Object data) {
		setData(data);
		setMessage("操作成功");
		setCode("000000");
	}

	public <T> T parseData(Class<T> clz) {
		if (!optSuccess()) {
			return null;
		}
		if (this.data == null) {
			return null;
		}
		String jsonStr = "";
		if ((this.data instanceof JSONObject)) {
			JSONObject json = (JSONObject) this.data;
			jsonStr = json.toJSONString();
		} else {
			jsonStr = JSON.toJSONString(this.data);
		}
		return JSON.parseObject(jsonStr, clz);
	}

	public <T> List<T> parseDataList(Class<T> clz) {
		if (!optSuccess()) {
			return null;
		}
		if (this.data == null) {
			return new ArrayList<T>();
		}
		String jsonStr = "";
		if ((this.data instanceof JSONObject)) {
			JSONObject json = (JSONObject) this.data;
			jsonStr = json.toJSONString();
		} else {
			jsonStr = JSON.toJSONString(this.data);
		}
		return JSON.parseArray(jsonStr, clz);
	}

	public String toString() {
		return "JsonResultDO [code=" + this.code + ", message=" + this.message + ", data=" + this.data + "]";
	}
}
