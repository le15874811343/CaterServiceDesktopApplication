package dao;
import entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import db.*;
public class SaleDao {
   public int addSale(Sale sale ){
	   String sql="insert into sale(m_id,s_count,s_date) values(?,?,?)";
	   List<Object> parmars=new ArrayList<Object>();
	   parmars.add(sale.getM_id());
	   parmars.add(sale.getS_count());
	   parmars.add(sale.getS_date());
	   return   Dbutil.executeUpdata(sql, parmars);
   }
   public ArrayList<Sale> findSaleByYear(Sale sale){
	   Sale _Sale=null;
	   ArrayList<Sale> saleList=new ArrayList<Sale>();
	   String sql="SELECT m_id,SUM(s_count) as 's_count',s_date FROM sale  GROUP BY DATE_FORMAT(s_date,'%Y'),m_id";
	   List<Object> parmars=new ArrayList<Object>();
	  ResultSet resultSet= Dbutil.executeQuery(sql, parmars);
	  try {
		while(resultSet.next()){
			  _Sale=new Sale();
			  _Sale.setM_id(resultSet.getInt("m_id"));
			  _Sale.setS_count(resultSet.getInt("s_count"));
			  _Sale.setS_date(resultSet.getString("s_date"));
			  saleList.add(_Sale);
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return saleList;
   }
   public ArrayList<Sale> findSaleByMonth(Sale sale){
	   Sale _Sale=null;
	   ArrayList<Sale> saleList=new ArrayList<Sale>();
	   String sql="SELECT m_id,SUM(s_count) as 's_count',s_date FROM sale where s_date like ? GROUP BY DATE_FORMAT(s_date,'%m'),m_id";
	   List<Object> parmars=new ArrayList<Object>();
	   parmars.add(sale.getS_date());
	  ResultSet resultSet= Dbutil.executeQuery(sql, parmars);
	  try {
		while(resultSet.next()){
			  _Sale=new Sale();
			  _Sale.setM_id(resultSet.getInt("m_id"));
			  _Sale.setS_count(resultSet.getInt("s_count"));
			  _Sale.setS_date(resultSet.getString("s_date"));
			  saleList.add(_Sale);
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return saleList;
   }
   public ArrayList<Sale> findSaleByDay(Sale sale){
	   Sale _Sale=null;
	   ArrayList<Sale> saleList=new ArrayList<Sale>();
	   String sql="SELECT m_id,SUM(s_count) as 's_count',s_date FROM sale where s_date like ? GROUP BY DATE_FORMAT(s_date,'%Y'),DATE_FORMAT(s_date,'%d'),m_id";
	   List<Object> parmars=new ArrayList<Object>();
	   parmars.add(sale.getS_date());
	  ResultSet resultSet= Dbutil.executeQuery(sql, parmars);
	  try {
		while(resultSet.next()){
			  _Sale=new Sale();
			  _Sale.setM_id(resultSet.getInt("m_id"));
			  _Sale.setS_count(resultSet.getInt("s_count"));
			  _Sale.setS_date(resultSet.getString("s_date"));
			  saleList.add(_Sale);
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return saleList;
   }
   public ArrayList<Sale> findSale(Sale sale){
	   Sale _Sale=null;
	   ArrayList<Sale> saleList=new ArrayList<Sale>();
	   String sql="SELECT * FROM sale where s_date like ? ";
	   List<Object> parmars=new ArrayList<Object>();
	   parmars.add(sale.getS_date());
	  ResultSet resultSet= Dbutil.executeQuery(sql, parmars);
	  try {
		while(resultSet.next()){
			  _Sale=new Sale();
			  _Sale.setM_id(resultSet.getInt("m_id"));
			  _Sale.setS_count(resultSet.getInt("s_count"));
			  _Sale.setS_date(resultSet.getString("s_date"));
			  saleList.add(_Sale);
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return saleList;
   }
}
