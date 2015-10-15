package com.sample.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Util {
	
	
	
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
	
	public static Integer convertToBaseN(int asciiValue,int numberBase, int power)
	{
		 Integer remainder = asciiValue%numberBase;

		    if(asciiValue < numberBase){
		        return new Double((Util.pow(10, power-1))*remainder.doubleValue()).intValue();
		    }
		    return convertToBaseN(asciiValue/numberBase, numberBase,power+1)+ 
		            new Double(Util.pow(10, power-1)*remainder.doubleValue()).intValue();
		
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
	
	public static String convertToStringFromBaseN(Queue<Integer> digitsList, short baseNumber) {
		StringBuilder builder = new StringBuilder();
	int convertedAscIIValue = 0;	
		for (Integer digits : digitsList) {
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
	
	public static int getConvertedAsciiValue(Integer digits, short baseNumber) {
		
		
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
		
	public static List<Integer> splitIntegerToSingleDigits(Integer number){
		
		if (number<0) number=-number; 
		List<Integer> digits = new LinkedList<Integer>();

		while (number>0) {
		    digits.add(0, number%10);
		    number=number/10;
		}
		return digits;
	}
}
