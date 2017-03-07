package dataProcess.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataProcess.pojo.M1605;
import util.Adapters;

public class M1605DaoImp {
	private  final String tableName = "month1605";
	private Connection conn=null;
	Logger logger = LogManager.getFormatterLogger(M1605DaoImp.class);

	public M1605DaoImp(){
		conn = DBManager.getConnection();
	}

	/**
	 * Inserting the record.
	 * @param r record, the instace of <code>dataProcess.pojo.M1605<code>
	 * @param onlyWithLocation whether insert the record with location only.
	 * @return return <code>true<code> while succeed in inserting the record.
	 */
	public boolean insert(M1605 r,boolean onlyWithLocation){
		String sql="INSERT INTO month1605 (id,crawler_time,crawler_time_stamp,device,is_retweet,locate,nick_name,pic_content,ping,r_device,"
				+ "r_location,r_nick_name,r_ping,r_time,r_time_stamp,r_url,r_user_id,r_user_type,r_weibo_content,r_weibo_id,"
				+ "r_zhan,r_zhuan,time,time_stamp,tou_xiang,url,user_id,user_type,weibo_content,weibo_id,"
				+ "zhan,zhuan)  "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		if(r == null){
			return false;
		}
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, r.getId());
			ps.setTimestamp(2, r.getCrawler_time());
			ps.setLong(3, r.getCrawler_time_stamp());
			ps.setString(4, r.getDevice());
			ps.setInt(5, r.getIs_retweet());
			ps.setString(6, r.getLocate());
			ps.setString(7, r.getNick_name());
			ps.setString(8, r.getPic_content());			
			ps.setLong(9, r.getPing());
			ps.setString(10, r.getR_device());

			ps.setString(11, r.getR_location());
			ps.setString(12, r.getR_nick_name());
			ps.setLong(13, r.getR_ping());
			ps.setDate(14, Adapters.utilDate2sqlDate(r.getR_time()));
			ps.setLong(15, r.getR_time_stamp());
			ps.setString(16, r.getR_url());			
			ps.setString(17, r.getR_user_id());
			ps.setString(18, r.getR_user_type());
			ps.setString(19, r.getR_weibo_content());
			ps.setString(20, r.getR_weibo_id());


			ps.setLong(21, r.getR_zhan());
			ps.setLong(22, r.getR_zhuan());
			ps.setTimestamp(23, r.getTime());
			ps.setLong(24, r.getTime_stamp());			
			ps.setString(25, r.getTou_xiang());
			ps.setString(26, r.getUrl());
			ps.setString(27, r.getUser_id());
			ps.setString(28, r.getUser_type());
			ps.setString(29, r.getWeibo_content());
			ps.setString(30, r.getWeibo_id());

			ps.setLong(31, r.getZhan());
			ps.setLong(32, r.getZhuan());

			if(onlyWithLocation){
				// the records whose location or r_location are null will be discarded.
				if((r.getLocate() == null && r.getR_location() == null)){
					return false;
				}else if( (r.getLocate() != null && !r.getLocate().trim().equals("")) || (r.getR_location() !=null && !r.getR_location().trim().equals(""))){

					ps.execute();
					return true;
				}
			}else{
				ps.execute();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("erros when inserting the record"+e);
			logger.error("record :"+ r);
		}finally{
			try{
				if(ps != null)
					ps.close();
			}catch(SQLException e){
				e.printStackTrace();
				logger.error("erros when inserting the record"+e);
			}
		}
		return false;
	}
	
	
	public boolean isExist(long id){
		String sql = "select * from " + tableName+ "  where id = ?" ;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Encounters error while check whether the record already exists."+e.getMessage());
		}finally{
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.error("Encounters error while check whether the record already exists."+e.getMessage());
				}
		}
		return false;
	}
	
	
	public void close(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("Encounters error while close the connection. " +e.getMessage());
			}
		}
	}
}
