package entity;

/**
 * 用户信息类
 * @author Admin
 *
 */
public class UserInfo {
	private int u_id;
private String u_name;
private String u_password;
private String u_sex;
private String u_comptce;
public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public String getU_password() {
	return u_password;
}
public void setU_password(String u_password) {
	this.u_password = u_password;
}
public String getU_sex() {
	return u_sex;
}
public void setU_sex(String u_sex) {
	this.u_sex = u_sex;
}
public String getU_comptce() {
	return u_comptce;
}
public void setU_comptce(String u_comptce) {
	this.u_comptce = u_comptce;
}
public UserInfo(String u_name, String u_password, String u_sex, String u_comptce) {
	super();
	this.u_name = u_name;
	this.u_password = u_password;
	this.u_sex = u_sex;
	this.u_comptce = u_comptce;
}
public UserInfo() {
	super();
	// TODO Auto-generated constructor stub
}

}
