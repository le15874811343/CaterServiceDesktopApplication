package dao;
import java.util.*;
import java.sql.*;

import db.*;
import entity.*;
public class MenuDao {
 public List<MenuInfo> getMenInfoList(MenuInfo menuinfo){
	 List<MenuInfo> menuList=new ArrayList<MenuInfo>();
	 StringBuffer sql=new StringBuffer("select * from menu where 1=1");
	 List<Object> params=new ArrayList<Object>();
	 if(menuinfo.getM_id()!=0){
		 sql.append(" and m_id=?");
		 params.add(menuinfo.getM_id());
	 }
	 if(menuinfo.getM_name()!=null){
		 sql.append(" and m_name=?");
		 params.add(menuinfo.getM_name());
	 }
	 if(menuinfo.getM_price()!=0){
		 sql.append(" and m_price=?");
		 params.add(menuinfo.getM_price());
	 }
	 if(menuinfo.getM_type()!=null){
		 sql.append(" and m_type=?");
		 params.add(menuinfo.getM_type());
	 }
	 ResultSet rs=Dbutil.executeQuery(sql.toString(), params);
	 try {
		while(rs.next()){
			 MenuInfo menuInfo2=new MenuInfo();
			 menuInfo2.setM_id(rs.getInt("m_id"));
			 menuInfo2.setM_name(rs.getString("m_name"));
			 menuInfo2.setM_price(rs.getDouble("m_price"));
			 menuInfo2.setM_type(rs.getString("m_type"));
			 menuList.add(menuInfo2);
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return menuList;
 }
 public int addMenu(MenuInfo menuInfo){
	 String sql="insert into menu(m_name,m_price,m_type) values(?,?,?)";
	 List<Object> params=new ArrayList<Object>();
	 params.add(menuInfo.getM_name());
	 params.add(menuInfo.getM_price());
	 params.add(menuInfo.getM_type());
	 return Dbutil.executeUpdata(sql, params);
 }
 public int deleteMenu(MenuInfo menuInfo){
	 String sql="delete from menu  where m_name=?";
	 List<Object> params=new ArrayList<Object>();
	 params.add(menuInfo.getM_name());
	 return Dbutil.executeUpdata(sql, params);
 }
 public int updataMenu(MenuInfo newMenuInfo,MenuInfo oldMenuInfo){
	 String sql="update menu set m_name=?,m_price=?,m_type=? where m_name=?";
	 List<Object> params=new ArrayList<Object>();
	 params.add(newMenuInfo.getM_name());
	 params.add(newMenuInfo.getM_price());
	 params.add(newMenuInfo.getM_type());
	 params.add(oldMenuInfo.getM_name());
	 return Dbutil.executeUpdata(sql, params);
 }
} 
