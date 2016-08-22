package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import db.Dbutil;
import entity.*;

/**
 * 关于桌子的方法
 * 
 * @author Admin
 * 
 */
public class TableDao {
	/**
	 * 获取桌子信息的方法
	 * 
	 * @param tableUse
	 * @return
	 */
	public ArrayList<TableUse> getAllTable(TableUse tableUse) {
		StringBuffer sql = new StringBuffer("select * from tableuse where 1=1");
		ArrayList<Object> parmars = new ArrayList<Object>();
		ArrayList<TableUse> tableUseList = new ArrayList<TableUse>();
		if (tableUse.getT_deskno() != null) {
			sql.append(" and t_deskno=?");
			parmars.add(tableUse.getT_deskno());
		}
		if (tableUse.getT_state() != null) {
			sql.append(" and t_state=?");
			parmars.add(tableUse.getT_state());
		}
		if (tableUse.getT_note() != null) {
			sql.append(" and t_note=?");
			parmars.add(tableUse.getT_note());
		}
		ResultSet resultSet = Dbutil.executeQuery(sql.toString(), parmars);
		try {
			while (resultSet.next()) {

				TableUse _TableUse = new TableUse();
				_TableUse.setT_deskno(resultSet.getString("t_deskno"));
				_TableUse.setT_state(resultSet.getString("t_state"));
				_TableUse.setT_note(resultSet.getString("t_note"));
				tableUseList.add(_TableUse);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableUseList;
	}

	/**
	 * 修改餐桌状态的方法
	 * 
	 * @param oldTableUse
	 * @return
	 */
	public int updataTable(TableUse oldTableUse) {
		StringBuffer sql = new StringBuffer(
				"update tableuse set t_state=? where 1=1 ");
		ArrayList<Object> parmars = new ArrayList<Object>();
		parmars.add(oldTableUse.getT_state());
		if (oldTableUse.getT_deskno() != null) {
			sql.append("and t_deskno=?");
			parmars.add(oldTableUse.getT_deskno());
		}
		if (oldTableUse.getT_note() != null) {
			sql.append("and t_note=?");
			parmars.add(oldTableUse.getT_note());
		}
		return Dbutil.executeUpdata(sql.toString(), parmars);
	}

	/**
	 * 添加餐桌的方法
	 * 
	 * @param tableUse
	 * @return
	 */
	public int addTable(TableUse tableUse) {
		String sql = "insert into tableuse(t_deskno,t_note) values(?,?)";
		ArrayList<Object> parmars = new ArrayList<Object>();
		parmars.add(tableUse.getT_deskno());
		parmars.add(tableUse.getT_note());
		return Dbutil.executeUpdata(sql, parmars);
	}

	/**
	 * 删除餐桌的方法
	 * 
	 * @param tableUse
	 * @return
	 */
	public int deleteTable(TableUse tableUse) {
		String sql = "delete from tableuse where t_deskno=?";
		ArrayList<Object> parmars = new ArrayList<Object>();
		parmars.add(tableUse.getT_deskno());
		return Dbutil.executeUpdata(sql, parmars);

	}
	/**
	 * 修改餐桌信息的方法
	 * @param tableUse
	 * @param oldTableUse
	 * @return
	 */
   public int updataTable(TableUse tableUse,TableUse oldTableUse){
	   String sql="update tableuse set t_deskno=?,t_state=?,t_note=? where t_deskno=?";
	   ArrayList<Object> parmars = new ArrayList<Object>();
	   parmars.add(tableUse.getT_deskno());
	   parmars.add(tableUse.getT_state());
	   parmars.add(tableUse.getT_note());
	   parmars.add(oldTableUse.getT_deskno());
	   return Dbutil.executeUpdata(sql, parmars);
   }
}
