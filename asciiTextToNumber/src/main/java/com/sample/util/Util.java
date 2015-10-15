package com.sample.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class Util {
	
	private static final char [] DIGITS =  {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	/**
	 * This method is used to convert the ascii value to the digits of base N 
	 * and is recursive with break condition where ascii value is less then the number base
	 * 
	 * @author Dhulipala Santosh Kumar
	 * @param asciiValue of the Ascii Text <b>example  </b>ASCII Text <strong> A</strong> ASCII value is <strong>65</strong> 
	 * @param numberBase - used to convert the ascii value to the give number base 
	 * power - always value is 1 the conversion to base numbers       
	 * @return digits of ascii number of base 10 to given number base
	 */
	
	public static String convertToBaseN(int asciiValue,int numberBase)
	{
		 
		 Stack<Integer> stack = new Stack<Integer>();
			while(asciiValue>0){
				int remainder = asciiValue%numberBase;
				stack.push(remainder);
				asciiValue = asciiValue/numberBase;
			}
			System.out.println(stack);
			String newString = "";
			while (!stack.isEmpty()) {
				newString = newString+ DIGITS[stack.pop()];
			}
		
			return newString;
	}

	/**
	 * This method is used to calculate the mathematical power of base number
	 *   
	 * @author Dhulipala Santosh Kumar
	 * @param baseNumber
	 * @param exponent 
	 * @return the number of times the base number is multiplied
	 */
	
	
	public static int pow(int baseNumber, int exponent)   {
		int tempValue = baseNumber;
		if(exponent==0){
			return 1;
		}
		for( int i = 1; i < exponent; i++ )
			tempValue *= baseNumber;    
		return tempValue;
		}

	/**
	 * This method is used to convert the digits of base N to base 10 
	 * and is used when to convert the Digits from Base N to base M  
	 *  @author Dhulipala Santosh Kumar
	 * @param digitsList - List of digits which are conveted to base N for the Ascii values
	 * @param baseNumber - The base number of the digits in digit List 
	 *        
	 * @return Ascii Text of the given digits of base N
	 */
	
	public static String convertToStringFromBaseN(Queue<String> digitsList, short baseNumber) {
		StringBuilder builder = new StringBuilder();
	int convertedAscIIValue = 0;	
		for (String digits : digitsList) {
			convertedAscIIValue =	getConvertedAsciiValue(digits,baseNumber);
			builder.append((char)convertedAscIIValue);
		}
		
		return builder.toString();
	}

	
	/**
	 * This method is used to convert the digits of base N to base 10 
	 * and is used when to convert the Digits from Base N to base M  
	 *  @author Dhulipala Santosh Kumar
	 * @param digitsList - List of digits which are conveted to base N for the Ascii values
	 * @param baseNumber - The base number of the digits in digit List 
	 *        
	 * @return Ascii Text of the given digits of base N
	 */
	
	public static int getConvertedAsciiValue(String digits, short baseNumber) {
		
		
		List<Integer> convertIntegerToDigits = splitIntegerToSingleDigits(digits);
		Integer asciiValue = 0;
		for (int i = 0; i < convertIntegerToDigits.size(); i++) {
	
			asciiValue += convertIntegerToDigits.get(i)*pow(baseNumber, convertIntegerToDigits.size()-(i+1));
		}
		
		return asciiValue;
	}
	
	
	/**
	 * This method is used to Split the digits of base N  
	 *  
	 *  @author Dhulipala Santosh Kumar
	 * @param number - digits which need to split 
	 *  
	 *        
	 * @return List of integers 
	 */
		
	public static List<Integer> splitIntegerToSingleDigits(String number){
		
		List<Integer> numberList = new ArrayList<Integer>();
		char[] charArray = number.toCharArray();
		for (char c : charArray) {
			numberList.add(Character.getNumericValue(c));
		}
		return numberList;
				 
	}
}
