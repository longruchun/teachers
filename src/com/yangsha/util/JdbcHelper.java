package com.yangsha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

public class JdbcHelper {

	static String driver="com.mysql.jdbc.Driver";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	static String url="jdbc:mysql://localhost:3306/shop";
	static Connection conn= null;
	static PreparedStatement ps=null;
	static ResultSet rs = null;
	static String user="root";
	static String password="root";
	
	public static Connection getConnection() {
		if(conn!=null) {
			return conn;
		}else {
			try {
				conn=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	}
	public static void closeAll() {
		if(rs!=null) {
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
				ps=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static int executeUpdate(String sql,Object...args) {
		int res=0;
		try {
			ps=getConnection().prepareStatement(sql);
			if(args.length>0) {
				for(int i = 0;i<args.length;i++) {
					ps.setObject((i+1),args[i]);
				}
			}
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		
		return res;
	}
	public static<T> List<T> executeQuery(String sql,Class<T> clazz,Object...args){
		List<T> list = new ArrayList<>();
		try {
			ps=getConnection().prepareStatement(sql);
			if(args.length>0) {
				for(int i = 0;i<args.length;i++) {
					ps.setObject((i+1),args[i]);
				}
			}
			rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCounts = rsmd.getColumnCount();
			while(rs.next()) {
				T t = clazz.newInstance();
				for(int i = 0;i<columnCounts;i++) {
					String columnName = rsmd.getColumnName(i+1);
					Object columnVal = rs.getObject(i+1);
					PropertyUtils.setProperty(t, columnName, columnVal);
				}
				list.add(t);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	//运行聚合函数的查询不能用以上语法，另外写运行聚合函数的语法
	public static int executeQuery(String sql,Object...args) {
		int val=0;
		try {
			ps=getConnection().prepareStatement(sql);
			if(args.length>0) {
				for(int i = 0;i<args.length;i++) {
					ps.setObject((i+1),args[i]);
				}
			}
			rs=ps.executeQuery();
			if(rs.next()) {
				val=(int)rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return val;
	}
	
}

