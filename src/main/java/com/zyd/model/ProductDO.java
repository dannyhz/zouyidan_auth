package com.zyd.model;

public class ProductDO {
	
	Long productId;
	String productCode;//产品编号 
	String productName;//产品名称 
	String productType;//产品类型
	String processTemplateId;//模板id
	String status;//
	int cityId;//城市id
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProcessTemplateId() {
		return processTemplateId;
	}
	public void setProcessTemplateId(String processTemplateId) {
		this.processTemplateId = processTemplateId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
