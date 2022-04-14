package Conectar;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;


public class Conentar_class {	
	private static BasicDataSource dataSource=null;	
	private static DataSource getDataSource() {
		if(dataSource==null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jc.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("1914");
			dataSource.setUrl("jdbc:mysql://localhost:3306/productosPractica4");
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxIdle(5000);	
		}				
		return dataSource ;		
	} 
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
	
}

