package entity;

public class Sale {
   private int m_id;
   private int s_count;
   private String s_date;
public String getS_date() {
	return s_date;
}
public void setS_date(String s_date) {
	this.s_date = s_date;
}
public Sale() {
	super();
	// TODO Auto-generated constructor stub
}
public Sale(int m_id, int s_count) {
	super();
	this.m_id = m_id;
	this.s_count = s_count;
}
public int getM_id() {
	return m_id;
}
public void setM_id(int m_id) {
	this.m_id = m_id;
}
public int getS_count() {
	return s_count;
}
public void setS_count(int s_count) {
	this.s_count = s_count;
}
}
