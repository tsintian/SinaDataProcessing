package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataProcess.pojo.M1605;


public class Adapters {
	static Logger logger = LogManager.getLogger(Adapters.class);

	/**
	 * Converts java.util.Date to java.sql.Date.
	 * @param d
	 * @return
	 */
	public static java.sql.Date utilDate2sqlDate(Date d){
		if(d != null)
			return new java.sql.Date(d.getTime());
		return null;
	}

	/**
	 * Convert a string array to <code>M1605<code> object.
	 * @param r
	 * @return
	 */
	public static M1605 record2M1605(String[] r){
		if(r.length == 32 || r.length == 33){
			M1605 m = new M1605();

			long id = Long.parseLong(r[0]);
			m.setId(id);

			//TODO: format pattern.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Timestamp crawler_time;
			try {
				Date tempCrawlerDate = sdf.parse(r[1]);
				crawler_time = new Timestamp(tempCrawlerDate.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
				logger.error("Exceptions when pasing crawler time: "+r[1],e);
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
				logger.error("Exceptions when pasing time: "+r[16],e);
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
					logger.error("Exceptions when pasing r_time: "+r[29],e);
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
			logger.error("Less than 32 fields which we expect: "+r.toString());
			return null;
		}
	}

}
