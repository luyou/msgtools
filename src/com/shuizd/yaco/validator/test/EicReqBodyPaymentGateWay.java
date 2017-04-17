package com.shuizd.yaco.validator.test;

import java.util.ArrayList;
import java.util.List;

public class EicReqBodyPaymentGateWay {
	
	private String backNotifyUrl;
	
	private String pageNotifyUrl;
	
	private String amt;
	
	private String accountId;
	
	private String targetId;
	
	private String creditId;
	
	private String paymentProtocolsNo;
	
	private String securedTransactions;
	
	private String customsFlag;
	
	private String bankTag;
	
	private String bankCode;
	
	private String payChannel;
	
	private List<PaymentGateWayOrder> orderDetails = new ArrayList<PaymentGateWayOrder>();

	public String getBackNotifyUrl() {
		return backNotifyUrl;
	}

	public void setBackNotifyUrl(String backNotifyUrl) {
		this.backNotifyUrl = backNotifyUrl;
	}

	public String getPageNotifyUrl() {
		return pageNotifyUrl;
	}

	public void setPageNotifyUrl(String pageNotifyUrl) {
		this.pageNotifyUrl = pageNotifyUrl;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getPaymentProtocolsNo() {
		return paymentProtocolsNo;
	}

	public void setPaymentProtocolsNo(String paymentProtocolsNo) {
		this.paymentProtocolsNo = paymentProtocolsNo;
	}

	public List<PaymentGateWayOrder> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<PaymentGateWayOrder> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public String getCustomsFlag() {
		return customsFlag;
	}

	public void setCustomsFlag(String customsFlag) {
		this.customsFlag = customsFlag;
	}
	
	public String getBankTag() {
		return bankTag;
	}

	public void setBankTag(String bankTag) {
		this.bankTag = bankTag;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public String getSecuredTransactions() {
		return securedTransactions;
	}

	public void setSecuredTransactions(String securedTransactions) {
		this.securedTransactions = securedTransactions;
	}
	
}
