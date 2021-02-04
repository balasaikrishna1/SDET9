package com.crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQueryTest {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
		      Driver mysqlDriverR = new Driver();
		      DriverManager.registerDriver(mysqlDriverR);
		  
		        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpSAI","root","root");
		      
		       Statement stat = con.createStatement();
		       
		       
		      ResultSet result=  stat.executeQuery("select * from Emp");
		            
		              while (result.next()) {
					        System.out.println(result.getInt(1) + "\t" + result.getString(2)+ "\t" + result.getString(3));
					}
		      
		}catch (Exception e) {
				System.err.println("query is invalid");
		}finally {
			 con.close();
			 System.out.println("close");
		}
    
}
	}


