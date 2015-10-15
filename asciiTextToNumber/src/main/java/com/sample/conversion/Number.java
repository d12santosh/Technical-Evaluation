package com.sample.conversion;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;






import com.sample.util.Util;





public class Number {

	

	private static final int DEFAULT_POWER_OF_VLUE = 1;

	private static Queue<Integer> convertedValues = new LinkedList<Integer>();
	
	private static short baseNumber= 0;
	
	public static void main(String[] args) {

		Number number = Number.create("7ABCDEF",(short) 16);
		System.out.println(Number.getConvertedValues());
		System.out.println(number.toString((short)2));
	}
	
	
	
	/**
	 * This method is used to convert Ascii Text to the digits of given number base 
	 * 
	 *  @author Dhulipala Santosh Kumar
	 * @param asciiText - ascii text to convert into digits
	 * @param numBase -  to which the ascii text to be converted to digits of base number  
	 *        
	 * @return Number object if conversion is success any exception will return null value
	 */

	public static Number create(String asciiText, short numBase) {
		
		Number.setBaseNumber(numBase);
		try{
		char[] chars = asciiText.toCharArray();
	
		for (char c : chars) {
			int asciiValue = (int)c;
			if(asciiValue>=32 && asciiValue <=127){
			getConvertedValues().add(Util.convertToBaseN(asciiValue,numBase,DEFAULT_POWER_OF_VLUE));
			}
			else{
				throw new Exception("Expecte Ascii Values");
			}
		}
		 
		return new Number();	
		}
		catch(Exception e){
			getConvertedValues().clear();
			return null;
		}
		
	}

	/**
	 * This method is used to convert the digits of base N to base M and then ascii text 
	 *   
	 *  @author Dhulipala Santosh Kumar
	 * 
	 * @param numBase - The base number to which the the digits to be converted 
	 *        
	 * @return Ascii Text of the converted digits of base N
	 */

	public String toString(short numBase) {
		
		Queue<Integer> newconvertedValues = new LinkedList<Integer>();
		if(numBase==baseNumber){
			return Util.convertToStringFromBaseN(Number.getConvertedValues(),Number.getBaseNumber());
		}
		else{
			for (Integer integer : convertedValues) {
				int convertedAsciiValue = Util.getConvertedAsciiValue(integer, getBaseNumber());
				Integer convertToBaseN = Util.convertToBaseN(convertedAsciiValue, numBase, 1);
				newconvertedValues.add(convertToBaseN);
			}
			Number.setBaseNumber(numBase);
			Number.setConvertedValues(newconvertedValues);
			String convertToAsciiTextFromBaseN = Util.convertToStringFromBaseN(newconvertedValues,Number.getBaseNumber());
			return convertToAsciiTextFromBaseN;
		}
		
	}

	
	
	public static short getBaseNumber() {
		return baseNumber;
	}

	public static void setBaseNumber(short baseNumber) {
		Number.baseNumber = baseNumber;
	}

	public static Queue<Integer> getConvertedValues() {
		return convertedValues;
	}

	public static void setConvertedValues(Queue<Integer> convertedValues) {
		Number.convertedValues = convertedValues;
	}

}
