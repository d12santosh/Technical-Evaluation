/**
 * 
 */
package com.sample.conversion;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author skdhulip
 *
 */
public class TestNumber {

	/**
	 * Test method for {@link com.sample.conversion.Number#create(java.lang.String, short)}.
	 */
	@Test
	public void testCreate() {
		
		String asciiText = "ABC";
		short numBase = 16;
		String expectedValueforAofBase16 = "41";
		String expectedValueforBofBase16 = "42";
		String expectedValueforCofBase16 = "43";
		Number create = Number.create(asciiText, numBase);
		assertTrue("The converted Values of the ascii text A to Numbase",create.getConvertedValues().contains(expectedValueforAofBase16));
		assertTrue("The converted Values of the ascii text B to Numbase",create.getConvertedValues().contains(expectedValueforBofBase16));
		assertTrue("The converted Values of the ascii text C to Numbase",create.getConvertedValues().contains(expectedValueforCofBase16));
		assertTrue("The Numbase of the conveterd values is", create.getBaseNumber()==numBase);
				
	}

	@Test
	public void testCreateForNonAsciiText() {
		char nonAscii =  '\u2665';
		String asciiText = "ABC :"+nonAscii;
		short numBase = 16;
		Number create = Number.create(asciiText, numBase);
		Assert.assertNull(create);
	}

	/**
	 * Test method for {@link com.sample.conversion.Number#toString(short)}.
	 */
	@Test
	public void testToStringShort() {
		
		String asciiText = "ABC";
		Queue<String> valuesOfAciiTextToBase16 = new LinkedList<String>();
		valuesOfAciiTextToBase16.add("41");//base 16 value of ascii text A
		valuesOfAciiTextToBase16.add("42");//base 16 value of ascii text B
		valuesOfAciiTextToBase16.add("43");//base 16 value of ascii text C
		Number.setConvertedValues(valuesOfAciiTextToBase16);
		short numBase = 16;
		Number.setBaseNumber(numBase);
		
		Number number = new Number();
		assertTrue("The converted Ascii Text",number.toString(numBase).equals(asciiText));
		
		short numBase1 = 8;
		
		String expectedValueforAofBase8 = "101";
		String expectedValueforBofBase8 = "102";
		String expectedValueforCofBase8 = "103";
		assertTrue("",number.toString(numBase1).equals(asciiText));
		valuesOfAciiTextToBase16.clear();
		valuesOfAciiTextToBase16.add(expectedValueforAofBase8);//base 8 value of ascii text A
		valuesOfAciiTextToBase16.add(expectedValueforBofBase8);//base 8 value of ascii text B
		valuesOfAciiTextToBase16.add(expectedValueforCofBase8);//base 8 value of ascii text C
		assertTrue("The converted Values of the ascii text A to Numbase",number.getConvertedValues().contains(expectedValueforAofBase8));
		assertTrue("The converted Values of the ascii text B to Numbase",number.getConvertedValues().contains(expectedValueforBofBase8));
		assertTrue("The converted Values of the ascii text C to Numbase",number.getConvertedValues().contains(expectedValueforCofBase8));
		System.out.println(Number.getConvertedValues());
		
		
	}

}
