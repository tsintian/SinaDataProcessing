package dataProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataProcess.daoImp.M1605DaoImp;
import dataProcess.daoImp.UserIdDaoImp;
import dataProcess.pojo.M1605;
import util.Adapters;

public class DataInsertJDBC {

	static Logger logger = LogManager.getLogger(DataInsertJDBC.class);


	public DataInsertJDBC(){

	}


	//For test.
	/**
	 * Insert the record and the user_id into database. ONLY the record WITH LOCATION INFORMATION!!!!
	 * 
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private void readFile(){
		String path = "C:/Users/qtian/datas/weibo/201605/weibo_freshdata.2016-05-01";
		BufferedReader br=null;
		M1605DaoImp m1605 = new M1605DaoImp();
		long i=0;
		try {
			br = new BufferedReader(new FileReader(path));
			for(String line; (line=br.readLine()) != null;){
				String[] strArra = line.split("\t");
				M1605 m = Adapters.record2M1605(strArra);

				boolean r = m1605.insert(m,true);
				if(r)
					System.out.println(++i+" : "+line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("erros when reading files"+e.getMessage());

		}finally{
			try{
				if(br != null)
					br.close();
				m1605.close();
			}catch(IOException e){
				e.printStackTrace();
				logger.error("erros when reading files"+e.getMessage());
			}
		}
	}



	/**
	 * Extact information for May,2016. 
	 * @param filePath  
	 * @param extractUserId  whether extract user id into table.
	 * @param onlyRecordWithLocation  whether only extract the records with location information. 
	 */
	public void extract1605Info(String filePath,boolean extractUserId,boolean onlyRecordWithLocation){
		BufferedReader br=null;
		UserIdDaoImp userImp = new UserIdDaoImp();
		M1605DaoImp m1605 = new M1605DaoImp();
		long i=0;
		try {
			br = new BufferedReader(new FileReader(filePath));
			for(String line; (line=br.readLine()) != null;){
				String[] strArra = line.split("\t");
				M1605 m = Adapters.record2M1605(strArra);

				if(extractUserId){
					//Extracting the user id then push it into the database.
					userImp.insertUserID(m.getUser_id());
				}

				//Check whether the record was already in the database.
				boolean isExist = m1605.isExist(m.getId());
				if(isExist)
					return ;

				boolean r = m1605.insert(m,onlyRecordWithLocation);
				if(r){
					System.out.println(++i+" : "+line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("erros when reading files",e);

		}finally{
			try{
				if(br != null)
					br.close();
				m1605.close();
				userImp.close();
			}catch(IOException e){
				e.printStackTrace();
				logger.error("Encounters error while closing. "+e.getMessage());
			}
		}
	}




	/**
	 * Extract the records with location as well as inserts the user id into User Id table.
	 * @param path
	 */
	public void extract1605Info(String path){
		this.extract1605Info(path, true, true);
	}


}
