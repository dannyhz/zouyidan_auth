package cn.evun.sweet.common.datastructure.generic.convert;

import java.util.Map;

import cn.evun.sweet.common.datastructure.generic.GenericObject;
import cn.evun.sweet.common.datastructure.generic.SingleGenericObject;

/**
 * Map数据类型转换器。
 * 
 * @author yangw
 * @since V1.0.0
 */
public class MapConverter implements GenericObjectConverter {

	@Override
	public boolean isSupportsType(Object source) {
		if (Map.class.isAssignableFrom(source.getClass())) {
			return true;
		}
		return false;
	}

	@Override
	public GenericObject convertObject(Object object) {
		if(Map.class.isAssignableFrom(object.getClass())){
			GenericObject obj = new SingleGenericObject();
        	Map<?,?> objMap = (Map<?,?>)object;
        	for(Map.Entry<?, ?> entry : objMap.entrySet()){
        		obj.setProperty(entry.getKey().toString(), 
        				GenericObjectConverterSupport.convert(entry.getValue()));
        	}
		}
		return null;
	}

}
