package main;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataProcess.DataInsertJDBC;
import tool.EmailTool;
import util.NumberUtil;

public class BatchExtractWithLocation {

	static Logger logger = LogManager.getLogger(BatchExtractWithLocation.class);
	public static void main(String[] args) {
		
		String path = "C:/Users/qtian/datas/weibo/201605/weibo_freshdata.2016-05-";
		long totalStart=System.currentTimeMillis();
		for( int i=1;i<32;i++){
			File f = new File(path+NumberUtil.intToStr2(i));
			if(!f.exists()){
				System.out.println("File "+path+NumberUtil.intToStr2(i)+" do NOT exist!!!");
				continue;
			}
			long start = System.currentTimeMillis();
			DataInsertJDBC dj = new DataInsertJDBC();
			dj.extract1605Info(path+NumberUtil.intToStr2(i));
			
			long end = System.currentTimeMillis();
			System.out.println(path+NumberUtil.intToStr2(i) +"elapsed time: " + (end-start)/60000+" minutes");
			logger.error(path+NumberUtil.intToStr2(i)+ "elapsted time : "+(end-start)/60000+" minutes");
		}
		long totalEnd = System.currentTimeMillis();
		System.out.println("over!!!!!!!!!!!!!!!!"+" , it takes "+(totalStart-totalEnd)/60000+" minutes.");
		EmailTool.sendEmail("Program completed successfully", 
				"The program has completed successfully! it takes "+(totalStart-totalEnd)/60000 +" minutes.");
	}
	
	

}
