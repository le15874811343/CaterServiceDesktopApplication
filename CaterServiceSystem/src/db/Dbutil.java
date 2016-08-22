package db;
import java.sql.*;
import java.util.*;
/**
 * 数据库操作类
 * @author Administrator
 *
 */
public class Dbutil {
   private static Connection connection;
   private static PreparedStatement preparedStatement;
   private static ResultSet resultSet;
public Dbutil() {
	super();
	// TODO Auto-generated constructor stub
}
public Dbutil(Connection connection, PreparedStatement preparedStatement,
		ResultSet resultSet) {
	super();
	this.connection = connection;
	this.preparedStatement = preparedStatement;
	this.resultSet = resultSet;
}
public Connection getConnection() {
	return connection;
}
public void setConnection(Connection connection) {
	this.connection = connection;
}
public PreparedStatement getPreparedStatement() {
	return preparedStatement;
}
public void setPreparedStatement(PreparedStatement preparedStatement) {
	this.preparedStatement = preparedStatement;
}
public ResultSet getResultSet() {
	return resultSet;
}
public void setResultSet(ResultSet resultSet) {
	this.resultSet = resultSet;
}
/**
 * 获取连接对象
 */
public static void getCon(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
	connection	=DriverManager.getConnection("jdbc:mysql:///mysrc?characterEncoding=utf-8", "root",
				"le353480");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * 获取预命令对象
 * @param sql
 */
public static void getPstmt(String sql){
	 Dbutil.getCon();
	 try {
		preparedStatement=connection.prepareStatement(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * 获取结果集对象
 * @param sql
 */
public static void getRes(String sql){
	Dbutil.getPstmt(sql);
	try {
	 resultSet=preparedStatement.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 public static int executeUpdata(String sql,List<Object> parmars){
	 int count=0;
	 try{
	 Dbutil.getPstmt(sql);
	 if(parmars!=null){
		 for(int i=0;i<parmars.size();i++){
			
				preparedStatement.setObject(i+1, parmars.get(i));
			} 
		 }
	
	 count=preparedStatement.executeUpdate();

	 }
 catch (Exception e) {
	 e.printStackTrace();
	// TODO: handle exception
}
	 return count;
 }
 public static ResultSet executeQuery(String sql,List<Object> parmars){
	 ResultSet res=null;
	 try{
	 Dbutil.getPstmt(sql);
	 if(parmars!=null){
		 for(int i=0;i<parmars.size();i++){
		 preparedStatement.setObject(i+1, parmars.get(i));
		 }
	 }
	    res=preparedStatement.executeQuery();
	 }
	 catch (Exception e) {
		 e.printStackTrace();
		// TODO: handle exception
	}
	 return res;
 }
 public static void claseAll(){
	 try{
		 if(connection!=null){
			 connection.close();
		 }
		 if(preparedStatement!=null){
			 preparedStatement.close();
		 }
	 }
	 catch (Exception e) {
		 e.printStackTrace();
		// TODO: handle exception
	}
 }
}
