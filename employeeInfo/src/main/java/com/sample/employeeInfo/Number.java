package com.sample.employeeInfo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Number {

	private static Queue<Integer> convertedValues = new LinkedList<Integer>();
	
	private static short baseNumber= 0;
	
	public static void main(String[] args) {

		Number number = Number.create("7ABC",(short) 2);
		
	}

	
	
	public static String toString(short numBase) {
		
		Queue<Integer> newconvertedValues = new LinkedList<Integer>();
		
		if(numBase==baseNumber){
			return convertToStringFromBaseN(Number.getConvertedValues(),Number.getBaseNumber());
		}
		else{
			for (Integer integer : convertedValues) {
				int convertedAsciiValue = getConvertedAsciiValue(integer, baseNumber);
				Integer convertToBaseN = convertToBaseN(convertedAsciiValue, numBase, 1);
				newconvertedValues.add(convertToBaseN);
			}
			Number.setBaseNumber(numBase);
			Number.setConvertedValues(newconvertedValues);
			System.out.println(newconvertedValues);
			String convertToStringFromBaseN = convertToStringFromBaseN(newconvertedValues,Number.getBaseNumber());
			return convertToStringFromBaseN;
		}
		
	}

	private static Queue<Integer> convertBaseNToBaseM(Queue<Integer> convertedValues2, short baseNumber2, short numBase) {
		
		for (Integer integer2 : convertedValues2) {
			getConvertedAsciiValue(integer2, baseNumber);
		}
return null;
	}



	private static String convertToStringFromBaseN(
			Queue<Integer> convertedValues2, short baseNumber2) {
		StringBuilder builder = new StringBuilder();
	int convertedAscIIValue = 0;	
		for (Integer integer : convertedValues2) {
			convertedAscIIValue =	getConvertedAsciiValue(integer,baseNumber);
			builder.append((char)convertedAscIIValue);
		}
		System.out.println("the output"+convertedAscIIValue);
		System.out.println("Example"+convertedValues2);
		System.out.println("the out string"+builder);
		return builder.toString();
	}



	private static int getConvertedAsciiValue(Integer integer, short baseNumber2) {
		
	
		List<Integer> convertIntegerToDigits = convertIntegerToDigits(integer);
		System.out.println("converted "+integer+"to"+convertIntegerToDigits(integer));
		Integer asciiValue = 0;
		for (int i = 0; i < convertIntegerToDigits.size(); i++) {
	
			asciiValue += convertIntegerToDigits.get(i)*pow(baseNumber2, convertIntegerToDigits.size()-(i+1));
		}
		
		return asciiValue;
	}

	private static List<Integer> convertIntegerToDigits(Integer number){
		
		if (number<0) number=-number; // maybe you'd like to support negatives
		List<Integer> digits = new LinkedList<Integer>();

		while (number>0) {
		    digits.add(0, number%10);
		    number=number/10;
		}
		return digits;
	}

	public static Number create(String string, short numBase) {
	
		Number.setBaseNumber(numBase);
		try{
		char[] chars = string.toCharArray();
	
		for (char c : chars) {
			int asciiValue = (int)c;
			convertedValues.add(convertToBaseN(asciiValue,numBase,1));
		}
		 
		return new Number();	
		}
		catch(Exception e){
			return null;
		}
		
	}

	
	private static Integer convertToBaseN(int num,int n, int pow)
	{
		 Integer r = num%n;

		    if(num < n){
		        return new Double((Math.pow(10, pow-1))*r.doubleValue()).intValue();
		    }
		    return convertToBaseN(num/n, n,pow+1)+ 
		            new Double(Math.pow(10, pow-1)*r.doubleValue()).intValue();
		
	}
	
	private static int pow(int x, int y)   {
		int z = x;
		if(y==0){
			return 1;
		}
		for( int i = 1; i < y; i++ )
			z *= x;    
		return z;
		}

	
	
	
	public static Queue<Integer> getConvertedValues() {
		return convertedValues;
	}

	public static void setConvertedValues(Queue<Integer> convertedValues) {
		Number.convertedValues = convertedValues;
	}

	public static short getBaseNumber() {
		return baseNumber;
	}

	public static void setBaseNumber(short baseNumber) {
		Number.baseNumber = baseNumber;
	}

	
	
}
