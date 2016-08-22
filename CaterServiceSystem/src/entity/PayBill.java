package entity;

public class PayBill {
 private String t_deskno;
 private String v_name;
 private String v_count;
 private double v_price;
public PayBill() {
	super();
	// TODO Auto-generated constructor stub
}
public PayBill(String t_deskno, String v_name, String v_count, double v_price) {
	super();
	this.t_deskno = t_deskno;
	this.v_name = v_name;
	this.v_count = v_count;
	this.v_price = v_price;
}
public String getT_deskno() {
	return t_deskno;
}
public void setT_deskno(String t_deskno) {
	this.t_deskno = t_deskno;
}
public String getV_name() {
	return v_name;
}
public void setV_name(String v_name) {
	this.v_name = v_name;
}
public String getV_count() {
	return v_count;
}
public void setV_count(String v_count) {
	this.v_count = v_count;
}
public double getV_price() {
	return v_price;
}
public void setV_price(double v_price) {
	this.v_price = v_price;
}
}
