package view;
import entity.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import service.*;
/**
 * 菜单窗体
 * @author 唐华
 *
 */
public class MenuFream extends JFrame implements ActionListener ,MouseListener{
private JButton jButton;
private JButton jButton2;
private JButton jButton3;
private JButton jButton4;
private JButton menuButton;
private ButtonGroup buttonGroup;
private JRadioButton jrb;
private JTable jTable;
private DefaultTableModel dtm;
private JPanel jPanel2;
private JPanel jPanel3;
private JPanel jPanel4;
private JScrollPane jScrollPane;
private JScrollPane jScrollPane3;
private JScrollPane jScrollPane4;
private JScrollPane jScrollPane5;
private JScrollPane jScrollPane2;
private JTextField jTextField;
private JPanel jPanel=new JPanel();
private  List<MenuInfo> menuList=null; 
private  MenuService service=new MenuService();
private MenuPanel menuPanel=new MenuPanel();
private String menuName=null;
private JTabbedPane tab;
private TableUse tableUse;
private UserInfo userInfo;
private PayBillService payBillService=new PayBillService();
public MenuFream(TableUse tableUse,UserInfo userInfo){
	    this.setTitle("菜单");
	    this.setSize(600, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(menuPanel);
		this.init();
		this.userInfo=userInfo;
		this.tableUse=tableUse;
		this.bindData();
		this.bindJtableData();
		this.setVisible(true);
}
public void init(){
	tab = new JTabbedPane(JTabbedPane.LEFT);
	Container container = this.getLayeredPane();
	container.setLayout(null);
	container.add(tab);
	jPanel2=new JPanel();
	jPanel3=new JPanel();
	jPanel4=new JPanel();
	jPanel2.setLayout(new GridLayout(4,3));
	jPanel2.setPreferredSize(new Dimension(1200,800));
	jPanel3.setLayout(new GridLayout(2,3));
	jPanel3.setPreferredSize(new Dimension(900,700));
	jPanel4.setLayout(new GridLayout(2,3));
	jPanel4.setPreferredSize(new Dimension(800,800));
	this.jScrollPane3=new JScrollPane(jPanel2);
	this.jScrollPane4=new JScrollPane(jPanel3);
	this.jScrollPane5=new JScrollPane(jPanel4);
	this.jButton=new JButton("+");
	this.jButton2=new JButton("-");
	this.jButton3=new JButton("完成");
	this.jButton4=new JButton("上一步");
	 this.jTable=new JTable(){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	String [] columnNames=new String[]{"菜名","单价","数量"};
	this.dtm=new DefaultTableModel(new Object[][]{}, columnNames);
	this.jTable.setModel(dtm);
	this.jScrollPane2=new JScrollPane();
	this.jScrollPane2.getViewport().add(jTable);
	this.jrb=new JRadioButton();
	jPanel.setLayout(new GridLayout(3,4));
	jPanel.setPreferredSize(new Dimension(1200,900));
	this.jScrollPane = new JScrollPane(jPanel);// this.jScrollPane.setLayout(null);//设置面板布局 null
	
	this.add(jScrollPane);// 添加控件到当前窗体
	tab.add(jScrollPane3,"小炒");
	tab.add(jScrollPane, "火锅");
	tab.add(jScrollPane4, "汤");
	tab.add(jScrollPane5,"饮品");
	tab.setBounds(600, 300,this.getWidth()+165,this.getHeight()-195);
	this.jButton.setBounds(450, 350, 80, 40);
	this.jButton2.setBounds(450,430, 80, 40);
	this.jButton3.setBounds(450, 510, 80, 40);
	this.jButton4.setBounds(450, 590, 80, 40);
	this.jScrollPane.setBounds(600, 300,this.getWidth()+200,this.getHeight()-60);
	this.jScrollPane2.setBounds(0, 300, 300, this.getHeight()-195);
	this.add(jButton);
	this.add(jButton2);
	this.add(jButton3);
	this.add(jButton4);
	this.add(jScrollPane2);
	this.jButton.addActionListener(this);
	this.jButton2.addActionListener(this);
	this.jButton3.addActionListener(this);
	this.jButton4.addActionListener(this);
	this.add(tab);
}
public void bindData(){
	ArrayList<ImageIcon> menuIconList=null;
	int chafingCount=0;
	int stirIcon=0; 
	int soupCount=0;
	int drinkCount=0;
	buttonGroup =new ButtonGroup();
	 MenuInfo menuinfo=new MenuInfo();
	 menuList= service.getMenInfoList(menuinfo);
	 for(MenuInfo m:menuList){
		 if(m.getM_type().equals("小炒")){
			 menuIconList=this.getStirIcon();
			 jTextField =new JTextField();
			 jTextField.setText(Double.toString(m.getM_price()));
			 jTextField.setBounds(30, 180, 100, 30);
			 jTextField.setOpaque(false);
			 jTextField.setEditable(false);
			menuButton=new JButton(menuIconList.get(stirIcon));
			stirIcon++;
			menuButton.setLayout(null);
			jrb=new JRadioButton(m.getM_name());
			jrb.setName(m.getM_name());
			this.jrb.setOpaque(false);
			buttonGroup.add(jrb);
			menuButton.add(jTextField);
			this.jrb.setBounds(30,40,100, 50);
			menuButton.add(jrb);
			
			jPanel2.add(menuButton);
			this.jrb.addMouseListener(this);
		 }
		 if(m.getM_type().equals("火锅")){
			 menuIconList=this.getChafingIcon();
			 jTextField =new JTextField();
			 jTextField.setText(Double.toString(m.getM_price()));
			 jTextField.setBounds(30, 180, 100, 30);
			 jTextField.setOpaque(false);
			 jTextField.setEditable(false);
			menuButton=new JButton(menuIconList.get(chafingCount));
			 chafingCount++;
			menuButton.setLayout(null);
			jrb=new JRadioButton(m.getM_name());
			jrb.setName(m.getM_name());
			this.jrb.setOpaque(false);
			buttonGroup.add(jrb);
			menuButton.add(jTextField);
			this.jrb.setBounds(30,40,100, 50);
			menuButton.add(jrb);
			
			jPanel.add(menuButton);
			this.jrb.addMouseListener(this);
		 }
		 if(m.getM_type().equals("汤")){
			 menuIconList=this.getSoupIcon();
			 jTextField =new JTextField();
			 jTextField.setText(Double.toString(m.getM_price()));
			 jTextField.setBounds(30, 180, 100, 30);
			 jTextField.setOpaque(false);
			 jTextField.setEditable(false);
			menuButton=new JButton(menuIconList.get(soupCount));
			soupCount++;
			menuButton.setLayout(null);
			jrb=new JRadioButton(m.getM_name());
			jrb.setName(m.getM_name());
			this.jrb.setOpaque(false);
			buttonGroup.add(jrb);
			menuButton.add(jTextField);
			this.jrb.setBounds(30,40,100, 50);
			menuButton.add(jrb);
			
			jPanel3.add(menuButton);
			this.jrb.addMouseListener(this);
		 }
		 if(m.getM_type().equals("饮品")){
			 menuIconList=this.getDrinkIcon();
			 jTextField =new JTextField();
			 jTextField.setText(Double.toString(m.getM_price()));
			 jTextField.setBounds(30, 180, 100, 30);
			 jTextField.setOpaque(false);
			 jTextField.setEditable(false);
			menuButton=new JButton(menuIconList.get(drinkCount));
			drinkCount++;
			menuButton.setLayout(null);
			jrb=new JRadioButton(m.getM_name());
			jrb.setName(m.getM_name());
			this.jrb.setOpaque(false);
			buttonGroup.add(jrb);
			menuButton.add(jTextField);
			this.jrb.setBounds(30,40,100, 50);
			menuButton.add(jrb);
			jPanel4.add(menuButton);
			this.jrb.addMouseListener(this);
		 }
	
		}
	
}
/**
 * 存放小炒类图片的方法
 * @return
 */
public ArrayList<ImageIcon> getStirIcon(){
	ArrayList<ImageIcon> arrayList=new ArrayList<ImageIcon>();
	ArrayList<String> menuName=new ArrayList<String>();
	MenuInfo menuinfo=new MenuInfo();
	menuList=service.getMenInfoList(menuinfo);
	for(MenuInfo m:menuList){
		if(m.getM_type().equals("小炒")){
			menuName.add("images/"+m.getM_name()+".jpg");
		}
		
	}

	for(String s:menuName){
		 ImageIcon icon=new ImageIcon(s);
		 arrayList.add(icon);
		 icon=null;
	}
	
	
	
	return arrayList;
}
/**
 * 存放火锅类图片的方法
 * @return
 */
public ArrayList<ImageIcon> getChafingIcon(){
	ArrayList<ImageIcon> arrayList=new ArrayList<ImageIcon>();
	ArrayList<String> menuName=new ArrayList<String>();
	MenuInfo menuinfo=new MenuInfo();
	menuList=service.getMenInfoList(menuinfo);
	for(MenuInfo m:menuList){
		if(m.getM_type().equals("火锅")){
			menuName.add("images/"+m.getM_name()+".jpg");
		}
		
	}

	for(String s:menuName){
		 ImageIcon icon=new ImageIcon(s);
		 arrayList.add(icon);
		 icon=null;
	}
	
	
	
	return arrayList;
}
/**
 * 存放汤类图片的方法
 * @return
 */
public ArrayList<ImageIcon> getSoupIcon(){
	ArrayList<ImageIcon> arrayList=new ArrayList<ImageIcon>();
	ArrayList<String> menuName=new ArrayList<String>();
	MenuInfo menuinfo=new MenuInfo();
	menuList=service.getMenInfoList(menuinfo);
	for(MenuInfo m:menuList){
		if(m.getM_type().equals("汤")){
			menuName.add("images/"+m.getM_name()+".jpg");
		}
		
	}

	for(String s:menuName){
		 ImageIcon icon=new ImageIcon(s);
		 arrayList.add(icon);
		 icon=null;
	}
	
	
	
	return arrayList;
}
/**
 * 存放饮品背景
 * @return
 */
public ArrayList<ImageIcon> getDrinkIcon(){
	ArrayList<ImageIcon> arrayList=new ArrayList<ImageIcon>();
	ArrayList<String> menuName=new ArrayList<String>();
	MenuInfo menuinfo=new MenuInfo();
	menuList=service.getMenInfoList(menuinfo);
	for(MenuInfo m:menuList){
		if(m.getM_type().equals("饮品")){
			menuName.add("images/"+m.getM_name()+".jpg");
		}
		
	}

	for(String s:menuName){
		 ImageIcon icon=new ImageIcon(s);
		 arrayList.add(icon);
		 icon=null;
	}
	
	
	
	return arrayList;
}
 public void bindJtableData(){
	 PayBill payBill=new PayBill();
	 payBill.setT_deskno(this.tableUse.getT_deskno());
	 ArrayList<PayBill> payBillList=payBillService.getPayBill(payBill);
	 for(PayBill p:payBillList){
		 dtm.addRow(new Object[]{p.getV_name(),p.getV_price(),p.getV_count()});
	 }
 }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equals("+")){
	if(menuName!=null){
		MenuInfo menuinfo=new MenuInfo();
		menuinfo.setM_name(menuName);
	 menuList=	service.getMenInfoList(menuinfo);
	 int count=0;
	 boolean flag=false;
	 if(jTable.getRowCount()==0){
		 dtm.addRow(new Object[]{menuList.get(0).getM_name(),menuList.get(0).getM_price(),1});
	 
	 }
	 else{
   for(int i=0;i<jTable.getRowCount();i++){
	   count++;
	   if(jTable.getValueAt(i, 0).equals(menuList.get(0).getM_name())){
		   dtm.setValueAt(Integer.parseInt(dtm.getValueAt(i, 2).toString())+1, i, 2);
		   flag=true;
		
	   }
	   else if(count==jTable.getRowCount()&&flag==false){
		   dtm.addRow(new Object[]{menuList.get(0).getM_name(),menuList.get(0).getM_price(),0});
		  
	   }
   }

	 }
  
	}
	}
	if(e.getActionCommand().equals("-")){
     int index= jTable.getSelectedRow();
     if(index>=0){
        if(Integer.parseInt(dtm.getValueAt(index,2).toString())>1){
        	  dtm.setValueAt(Integer.parseInt(dtm.getValueAt(index, 2).toString())-1, index, 2);
        }
        else{
        	dtm.removeRow(index);
        }
	}
	}
	if(e.getActionCommand().equals("完成")){
		PayBill payBill=new PayBill();
		payBill.setT_deskno(this.tableUse.getT_deskno());
		payBillService.deletePayBill(payBill);
		int count=1;
		for(int i=0;i<jTable.getRowCount();i++){
			payBill.setV_name(dtm.getValueAt(i, 0).toString());
			payBill.setV_count(dtm.getValueAt(i, 2).toString());
			payBill.setV_price(Double.parseDouble(dtm.getValueAt(i, 1).toString()));
			if(payBillService.addPayBill(payBill)==0){
				count=0;
				JOptionPane.showMessageDialog(this,"发生了一个错误,请联系管理员");
			}
		}
		if(count==1){
			JOptionPane.showMessageDialog(this,"点菜成功，请耐心等候，我们正在精心烹饪中");
			Service1frame service1frame=new Service1frame(this.userInfo);
			this.dispose();
		}
	}
	if(e.getActionCommand().trim().equals("上一步")){
		Service1frame service1frame=new Service1frame(this.userInfo);
		this.dispose();
	}
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getClickCount()>0){
	menuName=e.getComponent().getName();
	}
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
