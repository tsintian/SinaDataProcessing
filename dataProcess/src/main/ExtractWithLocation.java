package main;

import dataProcess.DataInsertJDBC;

public class ExtractWithLocation {
	
	public static void main(String[] args){
		
		String fileName="C:\\Users\\qtian\\datas\\weibo\\201605\\weibo_freshdata.2016-05-07";
		long start = System.currentTimeMillis();
		DataInsertJDBC dj = new DataInsertJDBC();
		dj.extract1605Info(fileName);
		System.out.println("over!!!!!!!!!!!!!!!!");
		long end = System.currentTimeMillis();
		System.out.println("elapsed time: " + (end-start)/60000+" minutes");
	}
}
