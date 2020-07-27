package hhsim.businesscardocr;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import hhsim.businesscardocr.BusinessCardParser;
import hhsim.businesscardocr.ContactInfo;

/**
 * Unit tests for Business Card OCR
 */
public class BusinessCardParserTest {

	@Test
	public void testExample1() throws Exception {
		System.out.println("\n\nExample 1:\n");
		ContactInfo contactInfo = new ContactInfo("Mike Smith", "4105551234", "msmith@asymmetrik.com");
		assertEquals(contactInfo.toString(), testGetContactInfo("example1.txt"));
	}

	@Test
	public void testExample2() throws Exception {
		System.out.println("\n\nExample 2:\n");
		ContactInfo contactInfo = new ContactInfo("Lisa Haung", "4105551234", "lisa.haung@foobartech.com");
		assertEquals(contactInfo.toString(), testGetContactInfo("example2.txt"));
	}

	@Test
	public void testExample3() throws Exception {
		System.out.println("\n\nExample 3:\n");
		ContactInfo contactInfo = new ContactInfo("Arthur Wilson", "17035551259", "awilson@abctech.com");
		assertEquals(contactInfo.toString(), testGetContactInfo("example3.txt"));
	}

	private String testGetContactInfo(String resource) throws IOException {
		return BusinessCardParser.getContactInfo(Resources.toString(Resources.getResource(resource), Charsets.UTF_8))
				.toString();
	}
}