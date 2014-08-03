/**
 * 
 */
package com.nagihome.reflect.util;

import java.lang.reflect.Method;

/**
 * @author Nagi
 *
 */
public class ReflexUtils {
	
	public static Method[] getDeclaredMethods(Object obj){
		return obj.getClass().getDeclaredMethods();		
	}
	
	public static Method[] getMethods(Object obj){
		return obj.getClass().getMethods();
	}
	
	public static void printAllMethods(Object obj){
		
	}
}
