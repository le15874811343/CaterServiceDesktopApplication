package dao;
import entity.*;
import java.sql.*;
import db.*;
import java.util.*;
public class IncomeDao {
    public int addIncom(Income income){
    	String sql="insert into income(u_id,i_money,i_date) values(?,?,?)";
    	List<Object> parmars=new ArrayList<Object>();
    	parmars.add(income.getU_id());
    	parmars.add(income.getI_money());
    	parmars.add(income.getI_data());
    	return Dbutil.executeUpdata(sql, parmars);
    }
    public List<Income> getIncome(Income income){
    	StringBuffer sql=new StringBuffer("select * from income where 1=1");
    	List<Income> incomeList=new ArrayList<Income>();
    	List<Object> params=new ArrayList<Object>();
    	if(income.getU_id()!=0){
    		sql.append(" and u_id=?");
    		params.add(income.getU_id());
    	}
    	if(income.getI_money()!=0.0){
    		sql.append(" and i_money=?");
    		params.add(income.getI_money());
    	}
    	if(income.getI_data()!=null){
    		sql.append(" and i_date like ?");
    		params.add(income.getI_data());
    	}
    	ResultSet res=Dbutil.executeQuery(sql.toString(), params);
    	try {
			while(res.next()){
				
				Income income1=new Income();
				income1.setI_id(res.getInt("i_id"));
				income1.setU_id(res.getInt("u_id"));
				income1.setI_money(res.getDouble("i_money"));
				income1.setI_data(res.getString("i_date"));
				incomeList.add(income1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incomeList;
    }
    public List<Income> getI_MoneyByYear(Income income){
    	StringBuffer sql=new StringBuffer("select u_id, SUM(i_money)as 'i_money',i_date from income GROUP BY DATE_FORMAT(i_date,'%Y') ");
    	List<Income> incomeList=new ArrayList<Income>();
    	List<Object> params=new ArrayList<Object>();
    	ResultSet res=Dbutil.executeQuery(sql.toString(), params);
    	try {
			while(res.next()){
				
				Income income1=new Income();
				income1.setU_id(res.getInt("u_id"));
				income1.setI_money(res.getDouble("i_money"));
				income1.setI_data(res.getString("i_date"));
				incomeList.add(income1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incomeList;
    }
    public List<Income> getI_MoneyByMonth(Income income){
    	StringBuffer sql=new StringBuffer("select u_id, SUM(i_money)as 'i_money',i_date from income where i_date like ? GROUP BY DATE_FORMAT(i_date,'%m') ");
    	List<Income> incomeList=new ArrayList<Income>();
    	List<Object> params=new ArrayList<Object>();
    		params.add(income.getI_data());
    	ResultSet res=Dbutil.executeQuery(sql.toString(), params);
    	try {
			while(res.next()){
				
				Income income1=new Income();
				income1.setU_id(res.getInt("u_id"));
				income1.setI_money(res.getDouble("i_money"));
				income1.setI_data(res.getString("i_date"));
				incomeList.add(income1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incomeList;
    }
    public List<Income> getI_MoneyByDay(Income income){
    	StringBuffer sql=new StringBuffer("select u_id, SUM(i_money)as 'i_money',i_date from income where i_date like ? GROUP BY DATE_FORMAT(i_date,'%Y'), DATE_FORMAT(i_date,'%d')");
    	List<Income> incomeList=new ArrayList<Income>();
    	List<Object> params=new ArrayList<Object>();
    		params.add(income.getI_data());
    	ResultSet res=Dbutil.executeQuery(sql.toString(), params);
    	try {
			while(res.next()){
				
				Income income1=new Income();
				income1.setU_id(res.getInt("u_id"));
				income1.setI_money(res.getDouble("i_money"));
				income1.setI_data(res.getString("i_date"));
				incomeList.add(income1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incomeList;
    }
    public List<Income> getCountByYear(Income income){
    	StringBuffer sql=new StringBuffer("SELECT COUNT(*) as 'i_id' ,SUM(i_money) as 'i_money',u_id,i_date from income where u_id=? GROUP BY DATE_FORMAT(i_date,'%Y')");
    	List<Income> incomeList=new ArrayList<Income>();
    	List<Object> params=new ArrayList<Object>();
    	params.add(income.getU_id());
    	ResultSet res=Dbutil.executeQuery(sql.toString(), params);
    	try {
			while(res.next()){
				
				Income income1=new Income();
				income1.setI_id(res.getInt("i_id"));
				income1.setI_money(res.getDouble("i_money"));
				income1.setU_id(res.getInt("u_id"));
				income1.setI_data(res.getString("i_date"));
				incomeList.add(income1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incomeList;
    }
    public List<Income> getCountByMonth(Income income){
    	StringBuffer sql=new StringBuffer("SELECT COUNT(*) as 'i_id' ,SUM(i_money) as 'i_money',u_id,i_date from income where u_id=? and i_date like ?  GROUP BY DATE_FORMAT(i_date,'%m')");
    	List<Income> incomeList=new ArrayList<Income>();
    	List<Object> params=new ArrayList<Object>();
    	params.add(income.getU_id());
    		params.add(income.getI_data());
    	ResultSet res=Dbutil.executeQuery(sql.toString(), params);
    	try {
			while(res.next()){
				
				Income income1=new Income();
				income1.setI_id(res.getInt("i_id"));
				income1.setI_money(res.getDouble("i_money"));
				income1.setU_id(res.getInt("u_id"));
				income1.setI_data(res.getString("i_date"));
				incomeList.add(income1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incomeList;
    }
    public List<Income> getCountByDay(Income income){
    	StringBuffer sql=new StringBuffer("SELECT COUNT(*) as 'i_id' ,SUM(i_money) as 'i_money',u_id,i_date from income where u_id=? and i_date like ?  GROUP BY DATE_FORMAT(i_date,'%Y'), DATE_FORMAT(i_date,'%d')");
    	List<Income> incomeList=new ArrayList<Income>();
    	List<Object> params=new ArrayList<Object>();
    	params.add(income.getU_id());
    		params.add(income.getI_data());
    	ResultSet res=Dbutil.executeQuery(sql.toString(), params);
    	try {
			while(res.next()){
				
				Income income1=new Income();
				income1.setI_id(res.getInt("i_id"));
				income1.setI_money(res.getDouble("i_money"));
				income1.setU_id(res.getInt("u_id"));
				income1.setI_data(res.getString("i_date"));
				incomeList.add(income1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incomeList;
    }
}
