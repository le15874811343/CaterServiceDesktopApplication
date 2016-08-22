package view;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import entity.*;
import service.*;
/**
 * 删除菜品面板
 * @author 乐家良
 *
 */
public class DeleteMenuPanel extends JPanel implements ItemListener, ActionListener, ChangeListener{
	private JComboBox comboBox;
	private DefaultComboBoxModel dcm;
	private JComboBox comboBox1;
	private DefaultComboBoxModel dcm1;
	private JComboBox comboBox2;
	private DefaultComboBoxModel dcm2;
	private JComboBox comboBox3;
	private DefaultComboBoxModel dcm3;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel _jLabel;
	private JLabel _jLabel1;
	private JLabel _jLabel2;
	private JLabel __jLabel;
	private JLabel __jLabel1;
	private JLabel __jLabel2;
	private JLabel ___jLabel;
	private JLabel ___jLabel1;
	private JLabel ___jLabel2;
	private JTextField jTextField;
	private JTextField jTextField1;
	private JTextField _jTextField;
	private JTextField _jTextField1;
	private JTextField __jTextField;
	private JTextField __jTextField1;
	private JTextField ___jTextField;
	private JTextField ___jTextField1;
	private JButton button;
	private JButton button2;
	private JButton _button;
	private JButton _button2;
	private JButton __button;
	private JButton __button2;
	private JButton ___button;
	private JButton ___button2;
	private MenuService menuService=new MenuService();
	private JTabbedPane tab;
	private JPanel jPanel = new JPanel();
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JPanel jPanel3=new JPanel();
	private MenuInfo _MenuInfo = new MenuInfo();

	public DeleteMenuPanel() {
		this.setSize(500, 500);
		this.setLayout(null);
		this.init();
		this.bindData();
	}

	public void init() {
		jPanel.setLayout(null);
		jPanel1.setLayout(null);
		jPanel2.setLayout(null);
		jPanel3.setLayout(null);
		jPanel.setBackground(new Color(201, 186, 131));
		jPanel1.setBackground(new Color(201, 186, 131));
		jPanel2.setBackground(new Color(201, 186, 131));
		jPanel3.setBackground(new Color(201, 186, 131));
		jPanel.setSize(480, 480);
		jPanel1.setSize(480, 480);
		jPanel2.setSize(480, 480);
		jPanel3.setSize(480, 480);
		this.comboBox = new JComboBox();
		this.comboBox.setBounds(150, 100, 200, 40);
		this.comboBox1 = new JComboBox();
		this.comboBox1.setBounds(150, 100, 200, 40);
		this.comboBox2 = new JComboBox();
		this.comboBox2.setBounds(150, 100, 200, 40);
		this.comboBox3 = new JComboBox();
		this.comboBox3.setBounds(150, 100, 200, 40);
		this.dcm = new DefaultComboBoxModel();
		this.dcm1 = new DefaultComboBoxModel();
		this.dcm2 = new DefaultComboBoxModel();
		this.dcm3 = new DefaultComboBoxModel();
		this.comboBox.setModel(dcm);
		this.comboBox1.setModel(dcm1);
		this.comboBox2.setModel(dcm2);
		this.comboBox3.setModel(dcm3);
		this.jLabel = new JLabel("菜名");
		this.jLabel.setBounds(100, 100, 40, 40);
		this.jLabel1 = new JLabel("价格");
		this.jLabel1.setBounds(100, 200, 40, 40);
		this.jTextField = new JTextField();
		this.jTextField.setBounds(150, 200, 200, 40);
		this.jLabel2 = new JLabel("类型");
		this.jLabel2.setBounds(100, 300, 40, 40);
		this.jTextField1 = new JTextField();
		this.jTextField1.setBounds(150, 300, 200, 40);
		this.button = new JButton("删除");
		this.button.setBounds(100, 400, 100, 40);
		this.button2 = new JButton("重置");
		this.button2.setBounds(250, 400, 100, 40);
		this._jLabel = new JLabel("菜名");
		this._jLabel.setBounds(100, 100, 40, 40);
		this._jLabel1 = new JLabel("价格");
		this._jLabel1.setBounds(100, 200, 40, 40);
		this._jTextField = new JTextField();
		this._jTextField.setBounds(150, 200, 200, 40);
		this._jLabel2 = new JLabel("类型");
		this._jLabel2.setBounds(100, 300, 40, 40);
		this._jTextField1 = new JTextField();
		this._jTextField1.setBounds(150, 300, 200, 40);
		this._button = new JButton("删除");
		this._button.setBounds(100, 400, 100, 40);
		this._button2 = new JButton("重置");
		this._button2.setBounds(250, 400, 100, 40);
		this.__jLabel = new JLabel("菜名");
		this.__jLabel.setBounds(100, 100, 40, 40);
		this.__jLabel1 = new JLabel("价格");
		this.__jLabel1.setBounds(100, 200, 40, 40);
		this.__jTextField = new JTextField();
		this.__jTextField.setBounds(150, 200, 200, 40);
		this.__jLabel2 = new JLabel("类型");
		this.__jLabel2.setBounds(100, 300, 40, 40);
		this.__jTextField1 = new JTextField();
		this.__jTextField1.setBounds(150, 300, 200, 40);
		this.__button = new JButton("删除");
		this.__button.setBounds(100, 400, 100, 40);
		this.__button2 = new JButton("重置");
		this.__button2.setBounds(250, 400, 100, 40);
		this.___jLabel = new JLabel("菜名");
		this.___jLabel.setBounds(100, 100, 40, 40);
		this.___jLabel1 = new JLabel("价格");
		this.___jLabel1.setBounds(100, 200, 40, 40);
		this.___jTextField = new JTextField();
		this.___jTextField.setBounds(150, 200, 200, 40);
		this.___jLabel2 = new JLabel("类型");
		this.___jLabel2.setBounds(100, 300, 40, 40);
		this.___jTextField1 = new JTextField();
		this.___jTextField1.setBounds(150, 300, 200, 40);
		this.___button = new JButton("删除");
		this.___button.setBounds(100, 400, 100, 40);
		this.___button2 = new JButton("重置");
		this.___button2.setBounds(250, 400, 100, 40);
		this.jTextField.setOpaque(false);
		this.jTextField1.setOpaque(false);
		this.jTextField.setEditable(false);
		this.jTextField1.setEditable(false);
		this._jTextField.setOpaque(false);
		this._jTextField1.setOpaque(false);
		this._jTextField.setEditable(false);
		this._jTextField1.setEditable(false);
		this.__jTextField.setOpaque(false);
		this.__jTextField1.setOpaque(false);
		this.___jTextField.setOpaque(false);
		this.___jTextField1.setOpaque(false);
		this.__jTextField.setEditable(false);
		this.__jTextField1.setEditable(false);
		this.___jTextField.setEditable(false);
		this.___jTextField1.setEditable(false);
		this.jTextField.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jTextField1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jTextField.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jTextField1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jTextField.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jTextField1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jTextField.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jTextField1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jTextField.setForeground(new Color(92, 167, 186));
		this.jTextField1.setForeground(new Color(92, 167, 186));
		this.jLabel.setForeground(new Color(92, 167, 186));
		this.jLabel1.setForeground(new Color(92, 167, 186));
		this.jLabel2.setForeground(new Color(92, 167, 186));
		this.button.setForeground(new Color(92, 167, 186));
		this.button2.setForeground(new Color(92, 167, 186));
		this._jTextField.setForeground(new Color(92, 167, 186));
		this._jTextField1.setForeground(new Color(92, 167, 186));
		this._jLabel.setForeground(new Color(92, 167, 186));
		this._jLabel1.setForeground(new Color(92, 167, 186));
		this._jLabel2.setForeground(new Color(92, 167, 186));
		this._button.setForeground(new Color(92, 167, 186));
		this._button2.setForeground(new Color(92, 167, 186));
		this.__jTextField.setForeground(new Color(92, 167, 186));
		this.__jTextField1.setForeground(new Color(92, 167, 186));
		this.__jLabel.setForeground(new Color(92, 167, 186));
		this.__jLabel1.setForeground(new Color(92, 167, 186));
		this.__jLabel2.setForeground(new Color(92, 167, 186));
		this.__button.setForeground(new Color(92, 167, 186));
		this.__button2.setForeground(new Color(92, 167, 186));
		this.___jTextField.setForeground(new Color(92, 167, 186));
		this.___jTextField1.setForeground(new Color(92, 167, 186));
		this.___jLabel.setForeground(new Color(92, 167, 186));
		this.___jLabel1.setForeground(new Color(92, 167, 186));
		this.___jLabel2.setForeground(new Color(92, 167, 186));
		this.___button.setForeground(new Color(92, 167, 186));
		this.___button2.setForeground(new Color(92, 167, 186));
		
		this.tab = new JTabbedPane(JTabbedPane.LEFT);
		this.jTextField.setText("--请选择桌子--");
		this.jTextField1.setText("--请选择桌子--");
		this._jTextField.setText("--请选择桌子--");
		this._jTextField1.setText("--请选择桌子--");
		this.__jTextField.setText("--请选择桌子--");
		this.__jTextField1.setText("--请选择桌子--");
		this.___jTextField.setText("--请选择桌子--");
		this.___jTextField1.setText("--请选择桌子--");
		this.jPanel.add(comboBox);
		this.jPanel.add(jLabel);
		this.jPanel.add(jLabel1);
		this.jPanel.add(jLabel2);
		this.jPanel.add(jTextField1);
		this.jPanel.add(jTextField);
		this.jPanel.add(button);
		this.jPanel.add(button2);
		this.jPanel1.add(comboBox1);
		this.jPanel1.add(_jLabel);
		this.jPanel1.add(_jLabel1);
		this.jPanel1.add(_jLabel2);
		this.jPanel1.add(_jTextField1);
		this.jPanel1.add(_jTextField);
		this.jPanel1.add(_button);
		this.jPanel1.add(_button2);
		this.jPanel2.add(comboBox2);
		this.jPanel2.add(__jLabel);
		this.jPanel2.add(__jLabel1);
		this.jPanel2.add(__jLabel2);
		this.jPanel2.add(__jTextField1);
		this.jPanel2.add(__jTextField);
		this.jPanel2.add(__button);
		this.jPanel2.add(__button2);
		this.jPanel3.add(comboBox3);
		this.jPanel3.add(___jLabel);
		this.jPanel3.add(___jLabel1);
		this.jPanel3.add(___jLabel2);
		this.jPanel3.add(___jTextField1);
		this.jPanel3.add(___jTextField);
		this.jPanel3.add(___button);
		this.jPanel3.add(___button2);
		this.tab.add(jPanel, "小炒");
		this.tab.add(jPanel1, "火锅");
		this.tab.add(jPanel2, "汤");
		this.tab.add(jPanel3, "饮品");
		this.tab.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(tab);
		this.comboBox.addItemListener(this);
		this.comboBox1.addItemListener(this);
		this.comboBox2.addItemListener(this);
		this.comboBox3.addItemListener(this);
		this.button.addActionListener(this);
		this.button2.addActionListener(this);
		this._button.addActionListener(this);
		this._button2.addActionListener(this);
		this.__button.addActionListener(this);
		this.__button2.addActionListener(this);
		this.___button.addActionListener(this);
		this.___button2.addActionListener(this);
		this.tab.addChangeListener(this);
	}

	public void bindData() {
		dcm.addElement("--请选择--");
		dcm1.addElement("--请选择--");
		dcm2.addElement("--请选择--");
		dcm3.addElement("--请选择--");
		MenuInfo menuinfo=new MenuInfo();
		ArrayList<MenuInfo> menuList = (ArrayList<MenuInfo>) menuService.getMenInfoList(menuinfo);
		for (MenuInfo m :menuList) {
			if (m.getM_type().equals("小炒")) {
				dcm.addElement(m.getM_name());
			}
			if (m.getM_type().equals("火锅")) {
				dcm1.addElement(m.getM_name());
			}
			if (m.getM_type().equals("汤")) {
				dcm2.addElement(m.getM_name());
			}
			if (m.getM_type().equals("饮品")) {
				dcm3.addElement(m.getM_name());
			}

		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int index = 0;
		index = e.getStateChange();
		if (index == 1) {
			if (!e.getItem().toString().equals("--请选择--")) {
				_MenuInfo.setM_name(e.getItem().toString());
				if (menuService.getMenInfoList(_MenuInfo).get(0).getM_type()
						.equals("小炒")) {
					this.jTextField.setText(Double.toString(menuService.getMenInfoList(_MenuInfo).get(0).getM_price())
							);
					this.jTextField1.setText(menuService.getMenInfoList(_MenuInfo)
							.get(0).getM_type());
				}
				if (menuService.getMenInfoList(_MenuInfo).get(0).getM_type()
						.equals("火锅")) {
					this._jTextField.setText(Double.toString(menuService.getMenInfoList(_MenuInfo).get(0).getM_price())
							);
					this._jTextField1.setText(menuService.getMenInfoList(_MenuInfo)
							.get(0).getM_type());
				}
				if (menuService.getMenInfoList(_MenuInfo).get(0).getM_type()
						.equals("汤")) {
					this.__jTextField.setText(Double.toString(menuService.getMenInfoList(_MenuInfo).get(0).getM_price())
							);
					this.__jTextField1.setText(menuService.getMenInfoList(_MenuInfo)
							.get(0).getM_type());
				}
				if (menuService.getMenInfoList(_MenuInfo).get(0).getM_type()
						.equals("饮品")) {
					this.___jTextField.setText(Double.toString(menuService.getMenInfoList(_MenuInfo).get(0).getM_price())
							);
					this.___jTextField1.setText(menuService.getMenInfoList(_MenuInfo)
							.get(0).getM_type());
				}
			}
			else{
				this.jTextField.setText("--请选择菜品--");
				this.jTextField1.setText("--请选择菜品--");
				this._jTextField.setText("--请选择菜品--");
				this._jTextField1.setText("--请选择菜品--");
				this.__jTextField.setText("--请选择菜品--");
				this.__jTextField1.setText("--请选择菜品--");
				this.___jTextField.setText("--请选择菜品--");
				this.___jTextField1.setText("--请选择菜品--");
				this._MenuInfo.setM_name(null);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("删除")) {
           if(this._MenuInfo.getM_name()!=null){
        	   if(menuService.deleteMenu(_MenuInfo)>0){
        		   JOptionPane.showMessageDialog(this, "删除成功");
        		   this.clearElements();
        	   }
           }
           else{
        	   JOptionPane.showMessageDialog(this, "请选择菜品");
           }
		}
		if(e.getActionCommand().equals("重置")){
			this.clearElements();
		}
	}
 public void clearElements(){
		this.dcm.removeAllElements();
		this.dcm1.removeAllElements();
		this.dcm2.removeAllElements();
		this.dcm3.removeAllElements();
		this.jTextField.setText("--请选择菜品--");
		this.jTextField1.setText("--请选择菜品--");
		this._jTextField.setText("--请选择菜品--");
		this._jTextField1.setText("--请选择菜品--");
		this.__jTextField.setText("--请选择菜品--");
		this.__jTextField1.setText("--请选择菜品--");
		this.___jTextField.setText("--请选择菜品--");
		this.___jTextField1.setText("--请选择菜品--");
		this._MenuInfo.setM_name(null);
		this.bindData();
 }
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	this.clearElements();
	}
}
