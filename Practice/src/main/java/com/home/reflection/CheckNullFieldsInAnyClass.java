package com.home.reflection;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

public class CheckNullFieldsInAnyClass {
	public static void main(String ...s){
		Emp emp = new Emp();
		
		try {
			//Assign empty string to all null String values of emp class
//			emp = (Emp) setNullsToDefault(String.class, "test", emp, null);
			//Assign null to all empty String values of emp class
			emp.setName("");
			emp = (Emp) setNullsToDefault(String.class, null, emp, StringUtils.EMPTY);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
     * Utility class to assign default values to all null fields of a specific
     * type in an object. Uses reflection so may result in performance overhead.
     * use with discretion.
     * 
     * @author Karan Kumar
     * @param typeCheckClass
     * @param defaultValue
     * @param object
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object setNullsToDefault(Class typeCheckClass, Object defaultValue, Object object, Object checkFor) throws IllegalArgumentException,
	    IllegalAccessException {
	Class<?> clazz = object.getClass();
	Field[] fields = clazz.getDeclaredFields();
	for (Field field : fields) {
	    if (typeCheckClass.equals(field.getType())) {
		field.setAccessible(true);
		if (field.get(object) == checkFor) {
			System.out.println(field.getName());	//Print the name of field
		    field.set(object, defaultValue);
		    System.out.println(field.get(object)); //Print the value of field
		}
	    }
	}
	return (object.getClass().cast(object));
    }

}
