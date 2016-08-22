package dao;
import entity.*;
import db.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class PayBillDao {
	/**
	 * 添加订单信息的方法
	 * @param payBill
	 * @return
	 */
          public int addPayBill(PayBill payBill){
        	  String sql="insert into paybill(t_deskno,v_name,v_count,v_price) values(?,?,?,?)";
        	  List<Object> parmars=new ArrayList<Object>();
        	  parmars.add(payBill.getT_deskno());
        	  parmars.add(payBill.getV_name());
        	  parmars.add(payBill.getV_count());
        	  parmars.add(payBill.getV_price());
        	  
        	  
        	  return Dbutil.executeUpdata(sql, parmars);
          }
          /**
           * 获取订单信息的方法
           * @param payBill
           * @return
           */
          public ArrayList<PayBill> getPayBill(PayBill payBill){
        	  StringBuffer sql=new StringBuffer("select * from paybill where 1=1");
        	  ArrayList<PayBill> payBillList=new ArrayList<PayBill>();
        	  List<Object> parmars=new ArrayList<Object>();
        	  if(payBill.getT_deskno()!=null){
        		  sql.append(" and t_deskno=?");
        		  parmars.add(payBill.getT_deskno());
        	  }
        	  if(payBill.getV_name()!=null){
        		  sql.append(" and v_name=?");
        		  parmars.add(payBill.getV_name());
        	  }
        	  if(payBill.getV_count()!=null){
        		  sql.append(" and v_count=?");
        		  parmars.add(payBill.getV_count());
        	  }
        	  if(payBill.getV_price()!=0){
        		  sql.append(" and v_price=?");
        		  parmars.add(payBill.getV_price());
        	  }
        	 ResultSet resultSet= Dbutil.executeQuery(sql.toString(), parmars);
        	 try {
				while(resultSet.next()){
					 PayBill _pPayBill=new PayBill();
					 _pPayBill.setT_deskno(resultSet.getString("t_deskno"));
					 _pPayBill.setV_name(resultSet.getString("v_name"));
					 _pPayBill.setV_count(resultSet.getString("v_count"));
					 _pPayBill.setV_price(resultSet.getDouble("v_price"));
					 payBillList.add(_pPayBill);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	  return payBillList;
          }
          public int deletePayBill(PayBill payBill){
        	  StringBuffer sql=new StringBuffer("delete from paybill where 1=1");
        	  List<Object> parmars=new ArrayList<Object>();
        	  if(payBill.getT_deskno()!=null){
        		  sql.append(" and t_deskno=?");
        		  parmars.add(payBill.getT_deskno());
        	  }
        	  if(payBill.getV_name()!=null){
        		  sql.append(" and v_name=?");
        		  parmars.add(payBill.getV_name());
        	  }
        	  if(payBill.getV_count()!=null){
        		  sql.append(" and v_count=?");
        		  parmars.add(payBill.getV_count());
        	  }
        	  if(payBill.getV_price()!=0){
        		  sql.append(" and v_price=?");
        		  parmars.add(payBill.getV_price());
        	  }
        	  return Dbutil.executeUpdata(sql.toString(), parmars);
          }
}
