package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;


import javax.swing.*;


import entity.Income;

import service.*;
/**
 * ���������ѯ����
 * @author �ּ���,���˱�
 *
 */
public class FindSaleJFrame extends JFrame implements ActionListener,ItemListener {
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
	// private JTable jTable;
	private DefaultComboBoxModel dcm = new DefaultComboBoxModel();
	private DefaultComboBoxModel dcm1 = new DefaultComboBoxModel();
	private DefaultComboBoxModel dcm2 = new DefaultComboBoxModel();
	private DefaultComboBoxModel dcm3 = new DefaultComboBoxModel();
	private FindIncomeJpanel findIncomeJpanel = new FindIncomeJpanel();
	public FindSaleJFrame() {

		this.setTitle("������ѯ����");
		// ָ��icno
		// this.setIconImage(new
		// ImageIcon("resources\\icon\\Eclipse.png").getImage());
		// �رմ�����˳�����
		// �Զ��������пؼ���С
		this.setSize(600, 600);
		// frame.pack();
		// ���ô���λ������Ļ����
//		this.setModal(true);
		this.setLayout(null);// ���õ�ǰ����ղ���
		this.setLocationRelativeTo(null);
		// this.setUndecorated(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(findIncomeJpanel);
		this.setResizable(false);
		this.init();
		this.bindData();

		// ��ʾ����
		this.setVisible(true);
	}

	public void init() {
       this.jLabel=new JLabel("��");
       Font font = new Font("�����п�", Font.BOLD, 20);
       jLabel.setFont(font);
		jLabel.setForeground(Color.red);
		this.jLabel1 = new JLabel("��");
		jLabel1.setFont(font);
		jLabel1.setForeground(Color.red);
		this.jLabel2=new JLabel("չʾ��ʽ");
		this.jComboBox3=new JComboBox();
		this.jComboBox3.setModel(dcm3);
		this.jLabel5 = new JLabel("���Ŵ�Ƶ�");

		jLabel5.setFont(font);
	
		jLabel5.setFont(font);
		this.jLabel4= new JLabel("��");
		jLabel4.setForeground(Color.red);
		jLabel4.setFont(font);
		this.jComboBox = new JComboBox();
		jComboBox.setOpaque(false);
		this.jComboBox1 = new JComboBox();
		this.jComboBox2 = new JComboBox();
		jComboBox1.setOpaque(false);
		this.jButton = new JButton("��ѯ");
		jButton.setFont(font);
		this.jLabel5.setBounds(120, 40, 200, 40);
		this.jLabel.setBounds(170, 70, 120, 40);
		this.jLabel1.setBounds(170, 140, 120, 40);
		this.jLabel4.setBounds(170, 210, 120, 40);
		this.jLabel2.setBounds(170, 300, 200, 40);
		this.jLabel2.setFont(font);
		jLabel2.setForeground(Color.red);
		this.jComboBox.setBounds(280, 50, 160, 40);
		this.jComboBox1.setBounds(280, 140, 160, 40);
		this.jComboBox2.setBounds(280, 210, 160, 40);
		this.jComboBox3.setBounds(280, 300, 160, 40);
		this.jButton.setBounds(280, 370, 100, 40);
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
		this.jComboBox.setModel(dcm);
		this.jComboBox1.setModel(dcm1);
		this.jComboBox2.setModel(dcm2);
		this.jButton.addActionListener(this);
		this.jComboBox1.addItemListener(this);
	}

	public void bindData() {
		dcm.addElement("--��ѡ�����--");
		dcm1.addElement("--��ѡ���·�--");
		dcm3.addElement("--��ѡ��չʾ��ʽ--");
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
		dcm3.addElement("���ʽ");
		dcm3.addElement("��״ͼ");
		dcm3.addElement("��״ͼ");
	}
	public void bindDayData(){
		dcm2.removeAllElements();
		dcm2.addElement("--��ѡ������--");
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

		if (e.getActionCommand().equals("��ѯ")) {
			StringBuffer where=new StringBuffer();
			int index = 0;
			int index1 = 0;
			int index2 = 0;
			int index3 = 0;
			// TODO Auto-generated method stub
			index = this.jComboBox.getSelectedIndex();
			index1 = this.jComboBox1.getSelectedIndex();
			index2 = this.jComboBox2.getSelectedIndex();
			index3 = this.jComboBox3.getSelectedIndex();
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
				JOptionPane.showMessageDialog(this, "��ѡ��չʾͼ�Σ�");
			}
			if (index3 > 0&&where!=null ) {
	            if(jComboBox3.getSelectedItem().equals("��״ͼ")){
	            SalePieChart3DView chart3dView=new SalePieChart3DView(where.toString());
	            }
	            if(jComboBox3.getSelectedItem().equals("��״ͼ")){
	            	SaleCreateColumnChartView chartView=new SaleCreateColumnChartView(where.toString());
	            }
	            if(jComboBox3.getSelectedItem().equals("���ʽ")){
	            	FindSaleJtable findIncome=new FindSaleJtable(where.toString());
	            }
		}

	}
}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

		 if(e.getStateChange()==1&&!e.getItem().toString().equals("--��ѡ���·�--")){
		 this.bindDayData();
		}
		else if(e.getStateChange()==1&&e.getItem().toString().equals("--��ѡ���·�--")){
			this.dcm2.removeAllElements();
			this.dcm2.addElement("--��ѡ���·�--");
		}
	}
	
}
