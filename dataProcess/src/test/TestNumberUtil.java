package test;

import org.junit.Test;

import util.NumberUtil;

public class TestNumberUtil {

	@Test
	public void testIntToStr2() {
		for( int i = 1; i<32; i++){
			System.out.println(NumberUtil.intToStr2(i));
		}
	}

}
