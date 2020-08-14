package com.oscar.demo.common.constant;

public class ConstSysParamValue {
	
	//微信API根地址
	public static String WX_API="https://api.mch.weixin.qq.com";
	//微信统一下单API地址
	public static String WX_PREPAY_URL=WX_API+"/pay/unifiedorder";
	//微信关闭订单API地址
	public static String WX_CLOSE_ORDER_URL=WX_API+"/pay/closeorder";
	//支付宝统一网关地址
	public static String ALIPAY_URL="https://openapi.alipay.com/gateway.do";
	//微信公众账号ID
	public static String WX_APPID="";
	//支付宝应用ID
	public static String ALIPAY_APPID="";
	//微信商户号
	public static String WX_MCHID="";
	//微信支付结果通知地址
	public static String WX_NOTIFY_URL="";
	//私钥
	public static String WX_KEY="";
	//支付宝私钥
	public static String ALIPAY_PRIVATE_KEY="";
	//支付宝公钥
	public static String ALIPAY_PUBLIC_KEY="";
	//微信查询地址
	public static String WX_QUERY=WX_API+"/pay/orderquery";
	//微信申请退款地址
	public static String WX_APPLY_REFUND=WX_API+"/secapi/pay/refund";
	
}
