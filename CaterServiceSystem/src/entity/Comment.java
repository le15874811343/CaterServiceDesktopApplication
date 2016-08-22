package entity;
/**
 * 评论实体类
 * @author Administrator
 *
 */
public class Comment {
	private int c_id;
	private  int i_id;
	private  int u_id;
  
	
private String service;
  private String taste;
  private String note;
  private String date;
  public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getI_id() {
		return i_id;
	}
	public void setI_id(int i_id) {
		this.i_id = i_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getService() {
	return service;
}
public void setService(String service) {
	this.service = service;
}
public String getTaste() {
	return taste;
}
public void setTaste(String taste) {
	this.taste = taste;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public Comment() {
	super();
	// TODO Auto-generated constructor stub
}
public Comment(String service, String taste, String note, String date) {
	super();
	this.service = service;
	this.taste = taste;
	this.note = note;
	this.date = date;
}
}
