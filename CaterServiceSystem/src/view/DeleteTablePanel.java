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
 * 餐桌删除面板
 * @author 乐家良
 *
 */
public class DeleteTablePanel extends JPanel implements ItemListener,
		ActionListener, ChangeListener {
	private JComboBox comboBox;
	private DefaultComboBoxModel dcm;
	private JComboBox comboBox1;
	private DefaultComboBoxModel dcm1;
	private JComboBox comboBox2;
	private DefaultComboBoxModel dcm2;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel _jLabel;
	private JLabel _jLabel1;
	private JLabel _jLabel2;
	private JLabel __jLabel;
	private JLabel __jLabel1;
	private JLabel __jLabel2;
	private JTextField jTextField;
	private JTextField jTextField1;
	private JTextField _jTextField;
	private JTextField _jTextField1;
	private JTextField __jTextField;
	private JTextField __jTextField1;
	private JButton button;
	private JButton button2;
	private JButton _button;
	private JButton _button2;
	private JButton __button;
	private JButton __button2;
	private TableService tableService = new TableService();
	private JTabbedPane tab;
	private JPanel jPanel = new JPanel();
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private TableUse _tTableUse = new TableUse();

	public DeleteTablePanel() {
		this.setSize(500, 500);
		this.setLayout(null);
		this.init();
		this.bindData();
	}

	public void init() {
		jPanel.setLayout(null);
		jPanel1.setLayout(null);
		jPanel2.setLayout(null);
		jPanel.setBackground(new Color(201, 186, 131));
		jPanel1.setBackground(new Color(201, 186, 131));
		jPanel2.setBackground(new Color(201, 186, 131));
		jPanel.setSize(480, 480);
		jPanel1.setSize(480, 480);
		jPanel2.setSize(480, 480);
		this.comboBox = new JComboBox();
		this.comboBox.setBounds(150, 100, 200, 40);
		this.comboBox1 = new JComboBox();
		this.comboBox1.setBounds(150, 100, 200, 40);
		this.comboBox2 = new JComboBox();
		this.comboBox2.setBounds(150, 100, 200, 40);
		this.dcm = new DefaultComboBoxModel();
		this.dcm1 = new DefaultComboBoxModel();
		this.dcm2 = new DefaultComboBoxModel();
		this.comboBox.setModel(dcm);
		this.comboBox1.setModel(dcm1);
		this.comboBox2.setModel(dcm2);
		this.jLabel = new JLabel("桌名");
		this.jLabel.setBounds(100, 100, 40, 40);
		this.jLabel1 = new JLabel("状态");
		this.jLabel1.setBounds(100, 200, 40, 40);
		this.jTextField = new JTextField();
		this.jTextField.setBounds(150, 200, 200, 40);
		this.jLabel2 = new JLabel("桌型");
		this.jLabel2.setBounds(100, 300, 40, 40);
		this.jTextField1 = new JTextField();
		this.jTextField1.setBounds(150, 300, 200, 40);
		this.button = new JButton("删除");
		this.button.setBounds(100, 400, 100, 40);
		this.button2 = new JButton("重置");
		this.button2.setBounds(250, 400, 100, 40);
		this._jLabel = new JLabel("桌名");
		this._jLabel.setBounds(100, 100, 40, 40);
		this._jLabel1 = new JLabel("状态");
		this._jLabel1.setBounds(100, 200, 40, 40);
		this._jTextField = new JTextField();
		this._jTextField.setBounds(150, 200, 200, 40);
		this._jLabel2 = new JLabel("桌型");
		this._jLabel2.setBounds(100, 300, 40, 40);
		this._jTextField1 = new JTextField();
		this._jTextField1.setBounds(150, 300, 200, 40);
		this._button = new JButton("删除");
		this._button.setBounds(100, 400, 100, 40);
		this._button2 = new JButton("重置");
		this._button2.setBounds(250, 400, 100, 40);
		this.__jLabel = new JLabel("桌名");
		this.__jLabel.setBounds(100, 100, 40, 40);
		this.__jLabel1 = new JLabel("状态");
		this.__jLabel1.setBounds(100, 200, 40, 40);
		this.__jTextField = new JTextField();
		this.__jTextField.setBounds(150, 200, 200, 40);
		this.__jLabel2 = new JLabel("桌型");
		this.__jLabel2.setBounds(100, 300, 40, 40);
		this.__jTextField1 = new JTextField();
		this.__jTextField1.setBounds(150, 300, 200, 40);
		this.__button = new JButton("删除");
		this.__button.setBounds(100, 400, 100, 40);
		this.__button2 = new JButton("重置");
		this.__button2.setBounds(250, 400, 100, 40);
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
		this.__jTextField.setEditable(false);
		this.__jTextField1.setEditable(false);
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
		
		this.tab = new JTabbedPane(JTabbedPane.LEFT);
		this.jTextField.setText("--请选择桌子--");
		this.jTextField1.setText("--请选择桌子--");
		this._jTextField.setText("--请选择桌子--");
		this._jTextField1.setText("--请选择桌子--");
		this.__jTextField.setText("--请选择桌子--");
		this.__jTextField1.setText("--请选择桌子--");
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
		this.tab.add(jPanel, "小桌");
		this.tab.add(jPanel1, "大桌");
		this.tab.add(jPanel2, "包厢");
		this.tab.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(tab);
		this.comboBox.addItemListener(this);
		this.comboBox1.addItemListener(this);
		this.comboBox2.addItemListener(this);
		this.button.addActionListener(this);
		this.button2.addActionListener(this);
		this._button.addActionListener(this);
		this._button2.addActionListener(this);
		this.__button.addActionListener(this);
		this.__button2.addActionListener(this);
		this.tab.addChangeListener(this);
	}

	public void bindData() {
		dcm.addElement("--请选择--");
		dcm1.addElement("--请选择--");
		dcm2.addElement("--请选择--");
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = tableService.getTable(tableUse);
		for (TableUse t : tableList) {
			if (t.getT_note().equals("小桌")) {
				dcm.addElement(t.getT_deskno());
			}
			if (t.getT_note().equals("大桌")) {
				dcm1.addElement(t.getT_deskno());
			}
			if (t.getT_note().equals("包厢")) {
				dcm2.addElement(t.getT_deskno());
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
				_tTableUse.setT_deskno(e.getItem().toString());
				if (tableService.getTable(_tTableUse).get(0).getT_note()
						.equals("小桌")) {
					this.jTextField.setText(tableService.getTable(_tTableUse)
							.get(0).getT_state());
					this.jTextField1.setText(tableService.getTable(_tTableUse)
							.get(0).getT_note());
				}
				if (tableService.getTable(_tTableUse).get(0).getT_note()
						.equals("大桌")) {
					this._jTextField.setText(tableService.getTable(_tTableUse)
							.get(0).getT_state());
					this._jTextField1.setText(tableService.getTable(_tTableUse)
							.get(0).getT_note());
				}
				if (tableService.getTable(_tTableUse).get(0).getT_note()
						.equals("包厢")) {
					this.__jTextField.setText(tableService.getTable(_tTableUse)
							.get(0).getT_state());
					this.__jTextField1.setText(tableService
							.getTable(_tTableUse).get(0).getT_note());
				}
			}
		}
		else{
			this.jTextField.setText("--请选择桌子--");
			this.jTextField1.setText("--请选择桌子--");
			this._jTextField.setText("--请选择桌子--");
			this._jTextField1.setText("--请选择桌子--");
			this.__jTextField.setText("--请选择桌子--");
			this.__jTextField1.setText("--请选择桌子--");
			this._tTableUse.setT_deskno(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("删除")) {
           if(this._tTableUse.getT_deskno()!=null){
        	   if(tableService.deleteTable(this._tTableUse)>0){
        		   JOptionPane.showMessageDialog(this, "删除成功");
        		   this.clearElements();
        	   }
           }
           else{
        	   JOptionPane.showMessageDialog(this, "请选择餐桌");
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
		this.jTextField.setText("--请选择桌子--");
		this.jTextField1.setText("--请选择桌子--");
		this._jTextField.setText("--请选择桌子--");
		this._jTextField1.setText("--请选择桌子--");
		this.__jTextField.setText("--请选择桌子--");
		this.__jTextField1.setText("--请选择桌子--");
		this._tTableUse.setT_deskno(null);
		this.bindData();
 }
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	this.clearElements();
	}
}
