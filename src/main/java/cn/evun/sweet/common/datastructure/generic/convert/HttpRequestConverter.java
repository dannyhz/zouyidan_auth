package cn.evun.sweet.common.datastructure.generic.convert;

import javax.servlet.http.HttpServletRequest;

import cn.evun.sweet.common.datastructure.generic.GenericObject;

/**
 * HttpRequest数据类型转换器。
 * 
 * @author yangw
 * @since V1.0.0
 */
@Deprecated
public class HttpRequestConverter implements GenericObjectConverter {

	/** 对请求中的特殊字符（html，js）进行转义 */
	boolean specialCharacterVonvert = true;
	
	@Override
	public boolean isSupportsType(Object source) {
		if (HttpServletRequest.class.isAssignableFrom(source.getClass())) {
			return true;
		}
		return false;
	}

	@Override
	public GenericObject convertObject(Object object) {
		if(HttpServletRequest.class.isAssignableFrom(object.getClass())){
			//TODO
		}
		return null;
	}

}
