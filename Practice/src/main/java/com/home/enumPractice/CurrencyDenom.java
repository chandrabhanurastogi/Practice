package com.home.enumPractice;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class CurrencyDenom {


	static {
		System.out.println(CurrencyDenom.class.getName());
		for(BICalculationClassEnum coin: BICalculationClassEnum.values()){
	        System.out.println("coin: " + coin);
	        System.out.println(coin.getCode());
	}
	}
public static void main(String...s){/*
	
	BICalculationClassEnum c = BICalculationClassEnum.NICKLE;
	switch(c){
	case NICKLE:
	System.out.println("NICKLE");
	break;
	case DIME:
		System.out.println("DIME");
		break;
	}
*/}
	
}
enum BICalculationClassEnum {
	
	CLASSNAME_MEDICLAIM_PLAN("mediclaim plan"), 
	CLASSNAME_MAHAJEEVAN_PLAN("mahajeevan plan"), 
	CLASSNAME_ANYTIME_PLAN("anytime plan"), 
	CLASSNAME_SIMPLE_BENIFIT_PLAN("simple benefit");
	
	private String code;
	
	private BICalculationClassEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	private static final Map<String, BICalculationClassEnum> keys = new HashMap<String, BICalculationClassEnum>();
	static {
		for (BICalculationClassEnum bICalculationClassEnum : BICalculationClassEnum.values()) {
			keys.put(bICalculationClassEnum.getCode(), bICalculationClassEnum);
		}
	}
	
	public static BICalculationClassEnum keyOf(String key) {
		BICalculationClassEnum biCalculationClassEnum = null;
		if (StringUtils.isNotBlank(key)) {
			biCalculationClassEnum = keys.get(key);
		}
		return biCalculationClassEnum;
	}
}
enum Currency{
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
	
	private int value;
	
	private Currency(int value){
		this.value=value;
	}
	
	public int getValue(){
		return value;
	}
}