package dataProcess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataProcess.daoImp.DataManager;
import dataProcess.pojo.M1605;



public class DataRead {

	 public static void main(String[] args){
	        String path = "C:/Users/qtian/datas/weibo/201605/weibo_freshdata.2016-05-01";
	        DataRead dr = new DataRead();
	        dr.fileRead(path);
	    }

	    private void fileRead(String path){
	         BufferedReader br=null;
	         DataManager dm = new DataManager();
	         dm.txBegin();
	        try {
	            br= new BufferedReader(new FileReader(path));
	            for(String line;(line = br.readLine()) != null;){
	                String[] strArra = line.split("\t");
	                System.out.println(strArra.toString());
	                M1605 m = record2M1605(strArra);
	                dm.pushM1605(m);
	            }
	            dm.txCommit();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }catch (IOException e){
	            e.printStackTrace();
	        }finally {
	        	
	            try {
	                br.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
	            dm.close();
	        }
	    }
	    
	    private M1605 record2M1605(String[] r){
	    	if(r.length == 32){
	    		M1605 m = new M1605();
	    		
	    		long id = Long.parseLong(r[0]);
	    		m.setId(id);
	    		
	    		//TODO: format pattern.
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    		Timestamp crawler_time;
				try {
					Date tempCrawlerDate =  sdf.parse(r[1]);
					crawler_time = new Timestamp(tempCrawlerDate.getTime());
				} catch (ParseException e) {
					e.printStackTrace();
					return null;
				}
	    		m.setCrawler_time(crawler_time);
	    		
	    		long crawler_time_stamp=Long.parseLong(r[2]);
	    		m.setCrawler_time_stamp(crawler_time_stamp);
	    		
	    		byte is_retweet=Byte.parseByte(r[3]);
	    		m.setIs_retweet(is_retweet);
	    		
	    		m.setUser_id(r[4]);
	    		m.setNick_name(r[5]);
	    		m.setTou_xiang(r[6]);
	    		m.setUser_type(r[7]);
	    		m.setWeibo_id(r[8]);
	    		m.setWeibo_content(r[9]);
	    		long zhuan = Long.parseLong(r[10]);
	    		m.setZhuan(zhuan);
	    		
	    		long ping = Long.parseLong(r[11]);
	    		m.setPing(ping);
	    		
	    		long zhan = Long.parseLong(r[12]);
	    		m.setZhan(zhan);
	    		
	    		m.setUrl(r[13]);
	    		
	    		m.setDevice(r[14]);
	    		m.setLocate(r[15]);
	    		
	    		Timestamp time;
				try {
					Date tempTimeDate = sdf.parse(r[16]);
					time = new Timestamp(tempTimeDate.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	    		m.setTime(time);
	    		
	    		long time_stamp = Long.parseLong(r[17]);
	    		m.setTime_stamp(time_stamp);
	    		
	    		m.setR_user_id(r[18]);
	    		
	    		m.setR_nick_name(r[19]);
	    		
	    		m.setR_user_type(r[20]);
	    		
	    		m.setR_weibo_id(r[21]);
	    		
	    		m.setR_weibo_content(r[22]);
	    		
	    		long r_zhuan = Long.parseLong(r[23]);
	    		m.setR_zhuan(r_zhuan);
	    		
	    		long r_ping = Long.parseLong(r[24]);
	    		m.setR_ping(r_ping);
	    		
	    		long r_zhan = Long.parseLong(r[25]);
	    		m.setR_zhan(r_zhan);
	    		
	    		m.setR_url(r[26]);
	    		
	    		m.setR_device(r[27]);
	    		
	    		m.setR_location(r[28]);
	    		
	    		Date r_time = null;
	    		if(!r[29].trim().equals("")){
				try {
					r_time = sdf.parse(r[29]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	    		}
	    		m.setR_time(r_time);
	    		
	    		if(!r[30].trim().equals("")){
	    			long r_time_stamp = Long.parseLong(r[30]);
	    			m.setR_time_stamp(r_time_stamp);
	    		}else{
	    			m.setR_time_stamp(0);
	    		}
	    		
	    		
	    		m.setPic_content(r[31]);
	    		return m;
	    		
	    	}else{
	    		System.out.println("no 32 fields: " + r.toString());
	    		return null;
	    	}
	    }

}
