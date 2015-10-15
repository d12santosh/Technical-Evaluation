package com.sample.conversion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.sample.util.Util;


public class Number {

	private static final int DEFAULT_POWER_OF_VLUE = 1;

	private static Queue<String> convertedValues = new LinkedList<String>();

	private static short baseNumber= 0;

	public static void main(String[] args) {


		Scanner consoleScanner = new Scanner(System.in);
		boolean toRun = true;
		while(toRun){
			System.out.print("Please enter Ascii Text -");
			String asciiText = consoleScanner.next();
			System.out.print("Please enter num Base -");
			short numBase =consoleScanner.nextShort();
			Number number = Number.create(asciiText,numBase);
			System.out.println("The Converted Values of Base "+numBase+" are"+Number.getConvertedValues());
			System.out.println("Please Enter 'Y' if you wish to convert Number to Ascii Text or 'N' to exit");
			if(consoleScanner.next().equalsIgnoreCase("y")){
			System.out.println("Plese Enter new Number base");
			short newNumBase = consoleScanner.nextShort();
			System.out.println("The Convrted Ascii Text from Base "+baseNumber+ "  is "+number.toString(newNumBase));
			System.out.println("The Converted Values of new Base "+newNumBase+" are"+Number.getConvertedValues());
			}
			System.out.println("Please Enter 'Y' if you wish to restart the process or 'N' to exit");
			if(!consoleScanner.next().equalsIgnoreCase("y"))
			{				
				toRun = false;	 
				consoleScanner.close();
			}
		}
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
			getConvertedValues().clear();
			for (char c : chars) {
				int asciiValue = (int)c;
				if(asciiValue>=32 && asciiValue <=127){
					getConvertedValues().add(Util.convertToBaseN(asciiValue,numBase));
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

		Queue<String> newconvertedValues = new LinkedList<String>();
		if(numBase==baseNumber){
			return Util.convertToStringFromBaseN(Number.getConvertedValues(),Number.getBaseNumber());
		}
		else{
			for (String integer : convertedValues) {
				int convertedAsciiValue = Util.getConvertedAsciiValue(integer, getBaseNumber());
				String convertToBaseN = Util.convertToBaseN(convertedAsciiValue, numBase);
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

	public static Queue<String> getConvertedValues() {
		return convertedValues;
	}

	public static void setConvertedValues(Queue<String> convertedValues) {
		Number.convertedValues = convertedValues;
	}

}
