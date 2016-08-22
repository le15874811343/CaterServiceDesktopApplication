package entity;


public class Income {
	private int i_id;
	private int u_id;
   private double i_money;
   private String i_data;
public Income() {
	super();
	// TODO Auto-generated constructor stub
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
public Income(double i_money, String i_data) {
	super();
	this.i_money = i_money;
	this.i_data = i_data;
}
public double getI_money() {
	return i_money;
}
public void setI_money(double i_money) {
	this.i_money = i_money;
}
public String getI_data() {
	return i_data;
}
public void setI_data(String i_data) {
	this.i_data = i_data;
}
}
