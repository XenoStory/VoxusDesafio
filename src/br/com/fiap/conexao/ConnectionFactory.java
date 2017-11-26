package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private Connection con = null;
	
	
	public Connection conectar(){
		
		String db_url   = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		String db_drive = "oracle.jdbc.driver.OracleDriver";
		String db_user  = "rm77702";
		String db_pass  = "210299";
		
		
		try {
			Class.forName(db_drive);
			this.con = DriverManager.getConnection(db_url,db_user,db_pass);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
