package com.zyd.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDO {
	
	private Long productId;
	private String productCode;//产品编号 
	private String productName;//产品名称 
	private String productType;//产品类型
	private String processTemplateId;//模板id
	private String status;//A (available)上架  P (pause)暂停  T(Terminated)下架
	private int cityId;//城市id
	private int provinceId;//省id
	private Long maxLoanAmt; //
	private Long minLoanAmt; //
	private String isChannelProxy;//是否有代理 
	private Long channelId; //渠道号  每屏秀秀
	private BigDecimal interestRate;
	private int minLoanPeriod; //最短贷款期限
	private int maxLoanPeriod; //最长贷款期限
	private Long managerFeeAmt;//管理费金额
	private BigDecimal managerFeeRate;//管理费费率
	private String productLoaneeDesc;//产品适用人群描述 
	private String productUsageDesc;//产品用途描述
	private String productDesc;//产品描述
	private Date publishTime;//发布时间
	private Date closeTime;//下架时间
	
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
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public Long getMaxLoanAmt() {
		return maxLoanAmt;
	}
	public void setMaxLoanAmt(Long maxLoanAmt) {
		this.maxLoanAmt = maxLoanAmt;
	}
	public Long getMinLoanAmt() {
		return minLoanAmt;
	}
	public void setMinLoanAmt(Long minLoanAmt) {
		this.minLoanAmt = minLoanAmt;
	}
	public String getIsChannelProxy() {
		return isChannelProxy;
	}
	public void setIsChannelProxy(String isChannelProxy) {
		this.isChannelProxy = isChannelProxy;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	public int getMinLoanPeriod() {
		return minLoanPeriod;
	}
	public void setMinLoanPeriod(int minLoanPeriod) {
		this.minLoanPeriod = minLoanPeriod;
	}
	public int getMaxLoanPeriod() {
		return maxLoanPeriod;
	}
	public void setMaxLoanPeriod(int maxLoanPeriod) {
		this.maxLoanPeriod = maxLoanPeriod;
	}
	public Long getManagerFeeAmt() {
		return managerFeeAmt;
	}
	public void setManagerFeeAmt(Long managerFeeAmt) {
		this.managerFeeAmt = managerFeeAmt;
	}
	public BigDecimal getManagerFeeRate() {
		return managerFeeRate;
	}
	public void setManagerFeeRate(BigDecimal managerFeeRate) {
		this.managerFeeRate = managerFeeRate;
	}
	public String getProductLoaneeDesc() {
		return productLoaneeDesc;
	}
	public void setProductLoaneeDesc(String productLoaneeDesc) {
		this.productLoaneeDesc = productLoaneeDesc;
	}
	public String getProductUsageDesc() {
		return productUsageDesc;
	}
	public void setProductUsageDesc(String productUsageDesc) {
		this.productUsageDesc = productUsageDesc;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
}
