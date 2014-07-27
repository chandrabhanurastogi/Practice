package com.home.reflection;

import java.lang.reflect.Field;

public class SetterTest {
	public static void main(String ...s) throws Exception{
		Emp e = new Emp();
		
		e.setName("bhanu");
		int count = 0;
		System.out.println(e.getClass().getDeclaredFields().length);
		
		for (Field field : Emp.class.getDeclaredFields()) {
			field.setAccessible(true);
			Object value = field.get(e);
			if(value!=null){
				count+=1;
			}
		}
		System.out.println(count);
		//System.out.println(Emp.class.getDeclaredMethods().length);
	}
	
	/*public void test(){

		Object value = null;
		try {
			value = field.get(model);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		if (value != null) {
			if (hasMultipleCondition) {
				clause.append(" " + andOr + " ");
			} else {
				clause.append(" WHERE ");
			}
			clause.append(field.getName() + "=");
			if (value instanceof String) {
				clause.append("'" + value + "'");
			} else {
				clause.append(String.valueOf(value));
			}
			hasMultipleCondition = true;
		}
	
	}*/

}

