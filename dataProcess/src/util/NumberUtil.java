package util;

public class NumberUtil {
	
	/**
	 * Transform a number which is between 0 and 99  to String. 
	 * If the number is less than 10, one zero will be added at its left side.
	 * @param num
	 * @return
	 */
	public static String intToStr2(int num){
		if(num < 0 || num > 99)
			return null;
		
		if( num < 10){
			return "0"+num;
		}else{
			return Integer.toString(num);
		}
	}
}
