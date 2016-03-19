package util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Mike Creel
 *
 */
public class FormatDateTest {

	/**
	 * Test method for {@link util.FormatDate#FormatMyDate(java.lang.String)}.
	 */
	
	@Test
	public void testbadFormatMyDate() {

		String baddate = "00/01/2014";
		FormatDate myformatdate = new FormatDate();
		assertEquals("",myformatdate.FormatMyDate(baddate));
	}

	@Test
	public void testgoodFormatMyDate() {
		String gooddate = "3/1/2014";
		FormatDate myformatdate = new FormatDate();
		assertEquals("03/01/2014",myformatdate.FormatMyDate(gooddate));
	}

}
