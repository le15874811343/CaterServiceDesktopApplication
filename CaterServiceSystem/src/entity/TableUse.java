package entity;

public class TableUse {
  private String  t_deskno;
  private String t_state;
  private String t_note;
public TableUse() {
	super();
	// TODO Auto-generated constructor stub
}
public TableUse(String t_deskno, String t_state, String t_note) {
	super();
	this.t_deskno = t_deskno;
	this.t_state = t_state;
	this.t_note = t_note;
}
public String getT_deskno() {
	return t_deskno;
}
public void setT_deskno(String t_deskno) {
	this.t_deskno = t_deskno;
}
public String getT_state() {
	return t_state;
}
public void setT_state(String t_state) {
	this.t_state = t_state;
}
public String getT_note() {
	return t_note;
}
public void setT_note(String t_note) {
	this.t_note = t_note;
}
}
