package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {
	public static Connection mycon(){
		Connection con  = null;
		String url="jdbc:sqlserver://DESKTOP-2SR1L34\\SQLEXPRESS;databaseName=AnunturiImobiliare;integratedSecurity=true;encrypt=false;";
		try{
			con = DriverManager.getConnection(url,"sa","asd123");
		}catch(Exception e){
			System.out.print(e);
		}
		
		return con;
		
	}

}
