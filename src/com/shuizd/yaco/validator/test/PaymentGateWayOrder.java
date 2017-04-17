package com.shuizd.yaco.validator.test;


public class PaymentGateWayOrder{

	private PaymentGateWayTrade paymentGateWayTrade;
	private PaymentDetailsCustoms paymentDetailsCustoms;
	private PaymentDetailsUserInf paymentDetailsUserInf;
	
	public PaymentGateWayTrade getPaymentGateWayTrade() {
		return paymentGateWayTrade;
	}
	public void setPaymentGateWayTrade(PaymentGateWayTrade paymentGateWayTrade) {
		this.paymentGateWayTrade = paymentGateWayTrade;
	}
	public PaymentDetailsCustoms getPaymentDetailsCustoms() {
		return paymentDetailsCustoms;
	}
	public void setPaymentDetailsCustoms(PaymentDetailsCustoms paymentDetailsCustoms) {
		this.paymentDetailsCustoms = paymentDetailsCustoms;
	}
	public PaymentDetailsUserInf getPaymentDetailsUserInf() {
		return paymentDetailsUserInf;
	}
	public void setPaymentDetailsUserInf(PaymentDetailsUserInf paymentDetailsUserInf) {
		this.paymentDetailsUserInf = paymentDetailsUserInf;
	}
	
	
}
