package entity;

public class MenuInfo {
 private int m_id;
 private String m_name;
 private double m_price;
 private String m_type;
public String getM_type() {
	return m_type;
}
public void setM_type(String m_type) {
	this.m_type = m_type;
}
public int getM_id() {
	return m_id;
}
public void setM_id(int m_id) {
	this.m_id = m_id;
}
public String getM_name() {
	return m_name;
}
public void setM_name(String m_name) {
	this.m_name = m_name;
}
public double getM_price() {
	return m_price;
}
public void setM_price(double m_price) {
	this.m_price = m_price;
}
public MenuInfo(int m_id, String m_name, double m_price) {
	super();
	this.m_id = m_id;
	this.m_name = m_name;
	this.m_price = m_price;
}
public MenuInfo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "²Ë±àºÅ:"+this.getM_id()+"²ËÃû:"+this.getM_name()+"¼Û¸ñ:"+this.getM_price();
}
 
}
