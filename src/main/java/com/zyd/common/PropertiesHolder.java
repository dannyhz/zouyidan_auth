package com.zyd.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

public class PropertiesHolder extends PropertyPlaceholderConfigurer {
	private Logger logger = LoggerFactory.getLogger(PropertiesHolder.class);

	private static Map<String, String> props = new HashMap();
	private Map<String, Resource> envs = new HashMap();
	private Resource[] locals;
	private String osName;
	private String WINDOWS = "windows";
	private String LINUX = "linux";

	public PropertiesHolder() {
	}

	public void initPropertiesHolder() {
		Resource resource = null;
		this.logger.info("the system's name is " + this.osName);
		if (StringUtils.isBlank(this.osName)) {
			return;
		}
		if (this.osName.toLowerCase().contains(this.WINDOWS)) {
			resource = (Resource) this.envs.get(this.WINDOWS);
		} else if (this.osName.toLowerCase().contains(this.LINUX)) {
			resource = (Resource) this.envs.get(this.LINUX);
		}
		this.logger.info("the resource fileName is " + resource.getFilename());
		if ((this.locals == null) || (this.locals.length <= 0)) {
			this.locals = new Resource[] { resource };
			setLocations(this.locals);
		} else {
			List<Resource> newLocals = new ArrayList();
			newLocals.add(resource);
			for (int i = 0; i < this.locals.length; i++) {
				newLocals.add(this.locals[i]);
			}
			setLocations((Resource[]) newLocals.toArray(new Resource[newLocals.size()]));
		}
	}

	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties properties)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, properties);
		for (Object obj : properties.keySet()) {
			String key = String.valueOf(obj);
			props.put(key, String.valueOf(properties.getProperty(key)));
		}
	}

	public static void putKV(String key, String value) {
		props.put(key, value);
	}

	public static String getValue(String key) {
		return (String) props.get(key);
	}

	public Map<String, Resource> getEnvs() {
		return this.envs;
	}

	public void setEnvs(Map<String, Resource> envs) {
		this.envs = envs;
	}

	public Resource[] getLocals() {
		return this.locals;
	}

	public void setLocals(Resource[] locals) {
		this.locals = locals;
	}

	public String getOsName() {
		return this.osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}
}
