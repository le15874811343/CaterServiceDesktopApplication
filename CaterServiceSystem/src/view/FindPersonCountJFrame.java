package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import javax.swing.*;


import org.omg.CORBA.UserException;

import entity.*;

import service.*;
/**
 * 查询员工业绩统计情况窗体
 * @author 乐家良
 *
 */
public class FindPersonCountJFrame extends JFrame implements ActionListener,ItemListener{
	private JLabel jLabel;
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JComboBox jComboBox;
	private JComboBox jComboBox1;
	private JComboBox jComboBox2;
	private JButton jButton;
	private JComboBox jComboBox3;
	
	private JLabel jLabel2;
	private JLabel jLabel6;
	private JComboBox jComboBox4;
	// private JTable jTable;
	private DefaultComboBoxModel dcm = new DefaultComboBoxModel();
	private DefaultComboBoxModel dcm1 = new DefaultComboBoxModel();
	private DefaultComboBoxModel dcm2 = new DefaultComboBoxModel();
	private DefaultComboBoxModel dcm3 = new DefaultComboBoxModel();
	private DefaultComboBoxModel dcm4=new DefaultComboBoxModel();
	private FindIncomeJpanel findIncomeJpanel = new FindIncomeJpanel();
 private UserService userService=new UserService();
	
	public FindPersonCountJFrame()  {
		this.setTitle("收入查询服务");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 自动适配所有控件大小
		this.setSize(600, 600);
		// 设置窗体位置在屏幕中央
		this.setLayout(null);// 设置当前窗体空布局
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// this.setUndecorated(true);
		this.setContentPane(findIncomeJpanel);
		this.init();
		this.bindData();
		// 显示窗体
		this.setVisible(true);
	}
	public void init() {
       this.jLabel=new JLabel("年");
       Font font = new Font("华文行楷", Font.BOLD, 20);
       jLabel.setFont(font);
		jLabel.setForeground(Color.red);
		this.jLabel6=new JLabel("展示形式");
		jLabel6.setFont(font);
		jLabel6.setForeground(Color.red);
		this.jLabel1 = new JLabel("月");
		jLabel1.setFont(font);
		jLabel1.setForeground(Color.red);
		this.jLabel2=new JLabel("员工");
		this.jComboBox3=new JComboBox();
		this.jComboBox3.setModel(dcm3);
		this.jLabel5 = new JLabel("豪门大酒店");
		jLabel5.setFont(font);
		jLabel5.setFont(font);
		this.jLabel4= new JLabel("日");
		jLabel4.setForeground(Color.red);
		jLabel4.setFont(font);
		this.jComboBox = new JComboBox();
		jComboBox.setOpaque(false);
		this.jComboBox1 = new JComboBox();
		this.jComboBox2 = new JComboBox();
		this.jComboBox4= new JComboBox();
		jComboBox1.setOpaque(false);
		this.jButton = new JButton("查询");
		jButton.setFont(font);
		this.jLabel5.setBounds(120, 40, 200, 40);
		this.jLabel.setBounds(170, 70, 120, 40);
		this.jLabel1.setBounds(170, 140, 120, 40);
		this.jLabel4.setBounds(170, 210, 120, 40);
		this.jLabel2.setBounds(170, 300, 200, 40);
		this.jLabel2.setFont(font);
		jLabel2.setForeground(Color.red);
		this.jComboBox.setBounds(280, 70, 160, 40);
		this.jComboBox1.setBounds(280, 140, 160, 40);
		this.jComboBox2.setBounds(280, 210, 160, 40);
		this.jComboBox3.setBounds(280, 300, 160, 40);
		this.jButton.setBounds(280, 450, 100, 40);
		this.jLabel6.setBounds(170, 370, 120, 40);
		this.jComboBox4.setBounds(280, 370, 160, 40);
		this.add(jLabel4);
		this.add(jLabel);
		this.add(jLabel1);
		this.add(jLabel5);
		this.add(jComboBox);
		this.add(jComboBox1);
		this.add(jButton);
		this.add(jComboBox2);
		this.add(jLabel2);
		this.add(jComboBox3);
		this.add(jLabel6);
		this.add(jComboBox4);
		this.jComboBox.setModel(dcm);
		this.jComboBox1.setModel(dcm1);
		this.jComboBox2.setModel(dcm2);
		this.jComboBox4.setModel(dcm4);
		this.jButton.addActionListener(this);
		this.jComboBox1.addItemListener(this);
	}

	public void bindData() {
		dcm.addElement("--请选择年份--");
		dcm1.addElement("--请选择月份--");
		dcm3.addElement("--请选择员工--");
		for (int i = 0; i < 21; i++) {
			dcm.addElement(2010+i);
		}
		for (int i = 1; i < 13; i++) {
			if(i<10){
			dcm1.addElement("0"+i);
			}
			else{
				dcm1.addElement(i);
			}
		}
		UserInfo userInfo=new UserInfo();
		for(UserInfo u:userService.getUserInfo(userInfo)){
			dcm3.addElement(u.getU_name());
		}
	dcm4.addElement("--请选择展示形式--");
	dcm4.addElement("表格式");
	dcm4.addElement("柱状图");
	dcm4.addElement("折线图");
	}
public void bindDayData(){
	dcm2.removeAllElements();
	dcm2.addElement("--请选择日期--");
	for (int i = 1; i < 32; i++) {
		if(i<10){
			dcm2.addElement("0"+i);
			}
			else{
				dcm2.addElement(i);
			}
	}
}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("查询")) {
			StringBuffer where=new StringBuffer();
			int	index = this.jComboBox.getSelectedIndex();
			int	index1 = this.jComboBox1.getSelectedIndex();
			int	index2 = this.jComboBox2.getSelectedIndex();
			int	index3 = this.jComboBox3.getSelectedIndex();
			int	index4= this.jComboBox4.getSelectedIndex();
				if (index > 0 ) {
		       where.append(this.jComboBox.getSelectedItem().toString());
				}
				if (index1> 0 ) {
					   where.append("-"+this.jComboBox1.getSelectedItem().toString()+"-");
				} 
				if (index2> 0 ) {
					   where.append(this.jComboBox2.getSelectedItem());
				}
			if(index<=0&&index1<=0&&index2<=0){
				where=new StringBuffer("");
			}
			if(index3<=0){
				JOptionPane.showMessageDialog(this, "请选择员工！");
			}
			if(index4<=0){
				JOptionPane.showMessageDialog(this, "请选择展示形式！");
			}
			if (index3 > 0) {
	            if(jComboBox4.getSelectedItem().equals("表格式")&&!jComboBox3.getSelectedItem().equals("--请选择员工--")){
	            	String name=jComboBox3.getSelectedItem().toString();
	           PersonCountJtable chart3dView=new PersonCountJtable(where.toString(),name);
	            }
	            if(jComboBox4.getSelectedItem().equals("柱状图")&&!jComboBox3.getSelectedItem().equals("--请选择员工--")){
	            	String name=jComboBox3.getSelectedItem().toString();
	          PersonCountColumn personCountColumn=new PersonCountColumn(where.toString(), name);
	            }
	            if(jComboBox4.getSelectedItem().equals("折线图")&&!jComboBox3.getSelectedItem().equals("--请选择员工--")){
	            	String name=jComboBox3.getSelectedItem().toString();
	             PersonCountLineChart personCountLineChart=new PersonCountLineChart(where.toString(),name);
	            }
	           
		}

	}
}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

		 if(e.getStateChange()==1&&!e.getItem().toString().equals("--请选择月份--")){
		 this.bindDayData();
		}
		else if(e.getStateChange()==1&&e.getItem().toString().equals("--请选择月份--")){
			this.dcm2.removeAllElements();
			this.dcm2.addElement("--请选择月份--");
		}
	}

}
