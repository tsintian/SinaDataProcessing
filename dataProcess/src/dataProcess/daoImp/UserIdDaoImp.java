package dataProcess.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserIdDaoImp {
	private  final String tableName = "userid";
	private Connection conn=null;
	Logger logger = LogManager.getFormatterLogger(UserIdDaoImp.class);

	public UserIdDaoImp(){
		this.conn = DBManager.getConnection();
	}

	//Inserting user id.
	public boolean insertUserID(String uid){
		
		if( uid == null){
			return false;
		}
		
		// If the user id already exists, then return.
        if(isUserIdExist(uid)){
        	return false;
        }
        
		String sql="INSERT INTO "+tableName + " (USER_ID) VALUES (?)";			
        
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("erros when inserting the uid"+e.getMessage());
			logger.error("record :"+ uid);
		}finally{
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("erros when inserting the uid"+e.getMessage());
				
			}
		}
		return false;
	}
	
	
	/**
	 * Detect whether the user id already exists in the databse.
	 * @param uid User ID
	 * @return return true if the provided user id exists in the database; otherwise, return false;
	 */
	private boolean isUserIdExist(String uid){
		String sql = "select * from " + tableName+ "  where USER_ID = ?" ;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error appears while detecting whether the user exists.");
		}
		return false;
	}
	
	
	/**
	 * Close the connection if it is not null.
	 */
	public void close(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("Error appears while close the connection."+e.getMessage());
			}
		}
	}
	
	

}
