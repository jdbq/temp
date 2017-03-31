package gasoline.store.utility;

import javax.sql.*;
import java.sql.*;
import javax.naming.*;

public class DBConnectUtil {
	public static Connection getConnection(){
		Connection connection = null;
		
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/ICS114db");
			connection = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return connection;
	}
}
