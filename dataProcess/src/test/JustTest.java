package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class JustTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testTimestamp();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void  testScanner(){
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		if(name.equals("yes")){
			System.out.println("yes");
		}
	}
	
	
	
	private static void testTimestamp() throws ParseException{
		String time = "2016-05-02 23:34:24";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = sdf.parse(time);
		System.out.println(d);
	}

}
