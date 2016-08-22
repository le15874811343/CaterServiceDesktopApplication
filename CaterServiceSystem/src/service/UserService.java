package service;

import java.util.List;

import dao.UserDao;

import entity.UserInfo;

public class UserService {
 private UserDao userdao1=new UserDao();
 public UserInfo login(UserInfo userinfo){
	 return   userdao1.login(userinfo);
 }
 public List<UserInfo> getUserInfo(UserInfo userinfo){
		return userdao1.getUserInfo(userinfo);
	}
	
	public boolean addUserInfo(UserInfo userinfo){
		boolean flag=false;
		int count=userdao1.addUserInfo(userinfo);
		if(count>0){
			flag=true;
		}
		return flag;
		
	}
	
	public boolean deleteUserInfo(UserInfo userinfo){
		boolean flag=false;
		int count=userdao1.deleteUserInfo(userinfo);
		if(count>0){
			flag=true;
		}
		return flag;
		
	}
	
	public boolean updataUserInfo(UserInfo newuserinfo,UserInfo olduserinfo){
		boolean flag=false;
		int count=userdao1.updataUserInfo(newuserinfo, olduserinfo);
		if(count>0){
			flag=true;
		}
		return flag;
		
	}
}
