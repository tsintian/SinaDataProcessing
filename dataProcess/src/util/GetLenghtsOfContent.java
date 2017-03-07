package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataProcess.DataInsertJDBC;
import dataProcess.pojo.M1605;

public class GetLenghtsOfContent {

	// TODO Auto-generated method stub
	private Connection conn;
	static Logger logger = LogManager.getLogger(GetLenghtsOfContent.class);
	private int contentLength = 0;
	private int r_contentLength = 0;
	private int pic_contentLength = 0;
	private int r_locationLength=0; //the location of the reposted.
	private int r_urlLength = 0; // Url of the reposted
	private int locationLength = 0; // Location of the post.
	private int urlLength = 0; //Url of the post.
	private int nick_nameLen = 0;  //screen_name
	private int r_nick_nameLen = 0; 
	private int touxiangLen = 0; 
	private int deviceLen = 0;
	private int r_deviceLen = 0;
	
	
	private int userIdLen = 0;
	
	private int r_userIdLen=0;
	private int weiboIDlen=0;
	private int r_weiboIDLen=0;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis();
		
		GetLenghtsOfContent dj = new GetLenghtsOfContent();
		dj.init();
		dj.readFile();
		logger.error("content length: "+ dj.contentLength);
		logger.error("r_content length: "+dj.r_contentLength);
		logger.error("pic_content length: "+dj.pic_contentLength);
		logger.error("r_location length: "+ dj.r_locationLength);
		logger.error("r URL length: "+dj.r_urlLength);
		logger.error("location length: "+ dj.locationLength);
		logger.error("URL length: "+ dj.urlLength);
		logger.error("nick name length: "+ dj.nick_nameLen);
		logger.error("r nick_name length: "+dj.r_nick_nameLen);
		logger.error("touxiang length: "+dj.touxiangLen);
		logger.error("device length: "+dj.deviceLen);
		logger.error("r_device length: "+dj.r_deviceLen);
		
		
		logger.error("userId length: "+dj.userIdLen);
		
		logger.error("r userID length: "+dj.r_userIdLen);
		logger.error("weiboID length: "+dj.weiboIDlen);
		
		logger.error("r weiboID length: "+dj.r_weiboIDLen);
		
		
		
		
		System.out.println("content length: "+dj.contentLength);
		System.out.println("r_content length: "+dj.r_contentLength);
		System.out.println("pic_content length: "+dj.pic_contentLength);
		System.out.println("r_location length: "+dj.r_locationLength);
		System.out.println("r URL length: "+ dj.r_urlLength);
		System.out.println("location length: "+dj.locationLength);
		System.out.println("URL length: "+ dj.urlLength);
		System.out.println("nick name length: "+dj.nick_nameLen);
		System.out.println("r nick_name length: "+dj.r_nick_nameLen);
		System.out.println("touxiang length: "+dj.touxiangLen);
		System.out.println("device length: "+dj.deviceLen);
		System.out.println("r device length: "+dj.r_deviceLen);
		
		System.out.println("userId length: "+dj.userIdLen);
		
		System.out.println("R userID length: "+dj.r_userIdLen);
		System.out.println("weiboID length: "+dj.weiboIDlen);
		
		System.out.println("r weiboID length: "+dj.r_weiboIDLen);
		
		System.out.println("over!!!!!!!!!!!!!!!!");
		long end = System.currentTimeMillis();
		System.out.println("elapsed time: " + (end-start)/60000+" minutes");
	}
	

	// Init the connection.
	private void init() {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/weibodb";
			conn = DriverManager.getConnection(url, "weibo", "weibo");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("exceptions when connect the database", e);
		}

	}

	private void readFile() {
		String path = "C:/Users/qtian/datas/weibo/201605/weibo_freshdata.2016-05-07";
		BufferedReader br = null;
		long i = 0;
		try {
			br = new BufferedReader(new FileReader(path));
			for (String line; (line = br.readLine()) != null;) {
				String[] strArra = line.split("\t");
				M1605 m = record2M1605(strArra);
				
				
				// Content, r_weibo_content
				contentLength = m.getWeibo_content().length() > contentLength ? m.getWeibo_content().length(): contentLength;
				r_contentLength = m.getR_weibo_content().length() > r_contentLength ? m.getR_weibo_content().length() : r_contentLength;
				
				pic_contentLength = m.getPic_content().length() > pic_contentLength ? m.getPic_content().length():pic_contentLength;
				r_locationLength = m.getR_location().length() > r_locationLength ? m.getR_location().length() : r_locationLength;
				r_urlLength = m.getR_url().length() > r_urlLength? m.getR_url().length():r_urlLength;
				locationLength = m.getLocate().length() > locationLength ? m.getLocate().length() : locationLength;
				urlLength = m.getUrl().length() > urlLength ? m.getUrl().length():urlLength;
				nick_nameLen = m.getNick_name().length() > nick_nameLen ? m.getNick_name().length() : nick_nameLen;
				r_nick_nameLen = m.getR_nick_name().length() > r_nick_nameLen ? m.getR_nick_name().length() : r_nick_nameLen;
				touxiangLen = m.getTou_xiang().length() > touxiangLen?m.getTou_xiang().length():touxiangLen;
				if(m.getDevice() != null){
					deviceLen = m.getDevice().length() > deviceLen?m.getDevice().length():deviceLen;
				}
				if(m.getR_device() != null){
					r_deviceLen = m.getR_device().length() > r_deviceLen?m.getR_device().length():r_deviceLen;
				}
				
				
				
				
				userIdLen = m.getUser_id().length() > userIdLen?m.getUser_id().length():userIdLen;
				if(m.getR_user_id() != null){
					r_userIdLen = m.getR_user_id().length() > r_userIdLen? m.getR_user_id().length():r_userIdLen;
				}
				
				weiboIDlen = m.getWeibo_id().length() > weiboIDlen ? m.getWeibo_id().length():weiboIDlen;
				if(m.getR_weibo_id() != null){
					r_weiboIDLen = m.getR_weibo_id().length()>r_weiboIDLen?m.getR_weibo_id().length():r_weiboIDLen;
				}
				
				
				
				
			
				
				System.out.println(++i + " : " + line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("erros when reading files", e);

		} finally {
			try {
				if (br != null)
					br.close();
				if (conn != null)
					conn.close();
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	 //Convert a strnig array to M1605 object.
	 private M1605 record2M1605(String[] r){
	    	if(r.length == 32 || r.length == 33){
	    		M1605 m = new M1605();
	    		
	    		long id = Long.parseLong(r[0]);
	    		m.setId(id);
	    		
	    		//TODO: format pattern.
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    		Timestamp crawler_time;
				try {
					Date tempScrawlerDate = sdf.parse(r[1]);
					crawler_time = new Timestamp(tempScrawlerDate.getTime());
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
	    		logger.error("Less than 32 fields which we expect: ",r.toString());
	    		return null;
	    	}
	    }

}

