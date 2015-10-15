/**
 * 
 */
package com.sample.Util;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import org.junit.Test;

import com.sample.util.Util;

/**
 * @author Dhulipala Santosh Kumar
 *
 */
public class TestUtil {

	/**
	 * Test method for {@link com.sample.util.Util#convertToBaseN(int, int, int)}.
	 */
	@Test
	public void testConvertToBaseN() {
		
		char asciiText ='A';
		int expectedValue =41;// 41 is base 16 value for ascii text 'A'
		Integer actualValue = Util.convertToBaseN((int)asciiText, 16, 1);
		assertTrue("The conversion of ascii vlaue to  base number is ",expectedValue==actualValue);
		
	}

	/**
	 * Test method for {@link com.sample.util.Util#pow(int, int)}.
	 */
	@Test
	public void testPow() {
	
		int expectedValue = 4;
		int actualValue = Util.pow(2, 2);
		assertTrue("The power of base number is ",expectedValue==actualValue);
		
	}

	/**
	 * Test method for {@link com.sample.util.Util#convertToStringFromBaseN(java.util.Queue, short)}.
	 */
	@Test
	public void testConvertToStringFromBaseN() {
		
		String expectedText ="A";
		Queue<Integer> digitsList = new LinkedList<Integer>();
		digitsList.add(41); // 41 is base 16 value for ascii text 'A'
		short numbase = 16;
		String actualValue = Util.convertToStringFromBaseN(digitsList , numbase);
		
		assertTrue("The conversion text for the digits of base is ",expectedText.equals(actualValue));
		
	}

	/**
	 * Test method for {@link com.sample.util.Util#getConvertedAsciiValue(java.lang.Integer, short)}.
	 */
	@Test
	public void testGetConvertedAsciiValue() {
		int expectedValue = 65;
		short numbase = 16;
		int actualValue = Util.getConvertedAsciiValue(41, numbase);
		assertTrue("The convrsion of digits of base N to number of base 10 ",expectedValue==actualValue);
		
	}

	/**
	 * Test method for {@link com.sample.util.Util#splitIntegerToSingleDigits(java.lang.Integer)}.
	 */
	@Test
	public void testSplitIntegerToSingleDigits() {
	
		int expectedValue=2;
		List<Integer> splitIntegerToSingleDigits = Util.splitIntegerToSingleDigits(12);
		assertTrue("The size of digits splitted",expectedValue==splitIntegerToSingleDigits.size());
		
		
	}

}
