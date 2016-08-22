package dao;
/**
 * 用户dao类
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.*;
import entity.UserInfo;

public class UserDao {
	/**
	 * 用户登陆的方法
	 * @param userinfo
	 * @return
	 */
 public UserInfo login(UserInfo userinfo)
 {UserInfo _userinfo=null;
	StringBuffer sql=new StringBuffer("select * from user where 1=1");
	ArrayList<Object> parmars=new ArrayList<Object>();
	if(userinfo.getU_name()!=null){
		sql.append(" and u_name=?");
		parmars.add(userinfo.getU_name());
	}
	if(userinfo.getU_password()!=null){
		sql.append(" and u_password=?");
		parmars.add(userinfo.getU_password());
	}
	if(userinfo.getU_comptce()!=null){
		sql.append(" and u_comptce=?");
		parmars.add(userinfo.getU_comptce());
	}
	ResultSet resultSet=  Dbutil.executeQuery(sql.toString(), parmars);
	try {
		while(resultSet.next()){
			_userinfo=new UserInfo();
			_userinfo.setU_id(resultSet.getInt("u_id"));
			_userinfo.setU_name(resultSet.getString("u_name"));
			_userinfo.setU_password(resultSet.getString("u_password"));
			_userinfo.setU_sex(resultSet.getString("u_sex"));
			_userinfo.setU_comptce(resultSet.getString("u_comptce"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return _userinfo;
 }
 /**
	 * 获取所有用户信息的方法
	 * @param userinfo
	 * @return
	 */
	public List<UserInfo> getUserInfo(UserInfo userinfo){
		StringBuffer sql=new StringBuffer("select * from user where 1=1 ");
		List<Object> params=new ArrayList<Object>();
		List<UserInfo> userlist=new ArrayList<UserInfo>();
		if(userinfo.getU_id()!=0){
			sql.append(" and u_id=?");
			params.add(userinfo.getU_id());
		}
		if(userinfo.getU_name()!=null){
			sql.append(" and u_name=?");
			params.add(userinfo.getU_name());
		}
		if(userinfo.getU_password()!=null){
			sql.append(" and u_password=?");
			params.add(userinfo.getU_password());
		}
		if(userinfo.getU_sex()!=null){
			sql.append(" and u_sex=?");
			params.add(userinfo.getU_sex());
		}
		if(userinfo.getU_comptce()!=null){
			sql.append(" and u_comptce=?");
			params.add(userinfo.getU_comptce());
		}
		ResultSet res=Dbutil.executeQuery(sql.toString(), params);
		try {
			while(res.next()){
				UserInfo userinfo1=new UserInfo();
				userinfo1.setU_id(res.getInt("u_id"));
				userinfo1.setU_name(res.getString("u_name"));
				userinfo1.setU_password(res.getString("u_password"));
				userinfo1.setU_sex(res.getString("u_sex"));
				userinfo1.setU_comptce(res.getString("u_comptce"));
				userlist.add(userinfo1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
		
	}
	/**
	 * 添加用户的方法
	 * @param userinfo
	 * @return
	 */
	public int addUserInfo(UserInfo userinfo){
		String sql="insert into user (u_name,u_password,u_sex,u_comptce) VALUES(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(userinfo.getU_name());
		params.add(userinfo.getU_password());
		params.add(userinfo.getU_sex());
		params.add(userinfo.getU_comptce());
		return Dbutil.executeUpdata(sql, params);
		
	}
	/**
	 * 删除用户的方法
	 * @param userinfo
	 * @return
	 */
	public int deleteUserInfo(UserInfo userinfo){
		StringBuffer sql=new StringBuffer("delete from user where 1=1");
		List<Object> params=new ArrayList<Object>();
		if(userinfo.getU_name()!=null){
			sql.append(" and u_name=?");
			params.add(userinfo.getU_name());
		}
		if(userinfo.getU_password()!=null){
			sql.append(" and u_password=?");
			params.add(userinfo.getU_password());
		}
		if(userinfo.getU_sex()!=null){
			sql.append(" and u_sex=?");
			params.add(userinfo.getU_sex());
		}
		if(userinfo.getU_comptce()!=null){
			sql.append(" and u_comptce=?");
			params.add(userinfo.getU_comptce());
		}
		
		return Dbutil.executeUpdata(sql.toString(), params);
		
	}
	/**
	 * 修改用户的方法
	 * @param userinfo
	 * @return
	 */
	public int updataUserInfo(UserInfo newuserinfo,UserInfo olduserinfo){
		int count=0;
		StringBuffer sql=new StringBuffer("update user set u_name=?,u_password=?,u_sex=?,u_comptce=? where 1=1");
		List<Object> params=new ArrayList<Object>();
		params.add(newuserinfo.getU_name());
		params.add(newuserinfo.getU_password());
		params.add(newuserinfo.getU_sex());
		params.add(newuserinfo.getU_comptce());
		if(olduserinfo.getU_name()!=null){
			sql.append(" and u_name=?");
			params.add(olduserinfo.getU_name());
		}
		if(olduserinfo.getU_password()!=null){
			sql.append(" and u_password=?");
			params.add(olduserinfo.getU_password());
		}
		if(olduserinfo.getU_sex()!=null){
			sql.append(" and u_sex=?");
			params.add(olduserinfo.getU_sex());
		}
		if(olduserinfo.getU_comptce()!=null){
			sql.append(" and u_comptce=?");
			params.add(olduserinfo.getU_comptce());
		}
		count=Dbutil.executeUpdata(sql.toString(), params);
		return count;
		
	}
	
}
