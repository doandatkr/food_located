package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoiDao {
	public Connection cn;
	public void KetNoi() throws Exception{
		//B1: xac dinh hqtcsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.print("Da xac dinh duoc heqtcsdl");
		String url="jdbc:sqlserver://LAPTOP:1433;databaseName=FoodLocated;user=sa;password=123";
		cn=DriverManager.getConnection(url);
		System.out.print("-Da ket noi");
	}
}
