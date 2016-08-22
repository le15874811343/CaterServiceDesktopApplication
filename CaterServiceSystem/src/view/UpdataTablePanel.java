package view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import entity.*;
import service.*;
import java.io.*;
/**
 * 修改餐桌信息面板
 * @author 乐家良
 *
 */
public class UpdataTablePanel extends JPanel implements ActionListener,
		ItemListener, ChangeListener {
	private JLabel jLabel;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JComboBox box;
	private DefaultComboBoxModel dcm;
	private JButton button;
	private JButton button2;
	private JTextField jTextField;
	private FileNameExtensionFilter filter;
	private JRadioButton jRadioButton;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	private JLabel _jLabel;
	private JLabel _jLabel1;
	private JLabel _jLabel2;
	private JLabel _jLabel3;
	private JComboBox _box;
	private DefaultComboBoxModel _dcm;
	private JButton _button;
	private JButton _button2;
	private JTextField _jTextField;

	private JRadioButton _jRadioButton;
	private JRadioButton _jRadioButton1;
	private JRadioButton _jRadioButton2;
	private JRadioButton _jRadioButton3;
	private JRadioButton _jRadioButton4;
	private JLabel __jLabel;
	private JLabel __jLabel1;
	private JLabel __jLabel2;
	private JLabel __jLabel3;
	private JComboBox __box;
	private DefaultComboBoxModel __dcm;
	private JButton __button;
	private JButton __button2;
	private JTextField __jTextField;
	private JRadioButton __jRadioButton;
	private JRadioButton __jRadioButton1;
	private JRadioButton __jRadioButton2;
	private JRadioButton __jRadioButton3;
	private JRadioButton __jRadioButton4;
	private ButtonGroup buttonGroup;
	private ButtonGroup _buttonGroup;
	private ButtonGroup __buttonGroup;
	private ButtonGroup buttonGroup1;
	private ButtonGroup _buttonGroup1;
	private ButtonGroup __buttonGroup1;
	private JTabbedPane tab;
	private JPanel jPanel = new JPanel();
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JButton button3;
	private JButton _button3;
	private JButton __button3;
	private JTextField jTextField2;
	private JTextField _jTextField2;
	private JTextField __jTextField2;
	private TableService tableService = new TableService();
	private JFileChooser fileChooser;
	private File file;
	private TableUse _tTableUse = new TableUse();

	public UpdataTablePanel() {
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
		this.button3 = new JButton("添加图片");
		this.button3.setBounds(100, 350, 100, 40);
		this.jTextField2 = new JTextField();
		this.jTextField2.setBounds(250, 350, 100, 40);
		this.jTextField2.setOpaque(false);
		this.jTextField2.setEditable(false);
		this._button3 = new JButton("添加图片");
		this._button3.setBounds(100, 350, 100, 40);
		this._jTextField2 = new JTextField();
		this._jTextField2.setBounds(250, 350, 100, 40);
		this._jTextField2.setOpaque(false);
		this._jTextField2.setEditable(false);
		this.__button3 = new JButton("添加图片");
		this.__button3.setBounds(100, 350, 100, 40);
		this.__jTextField2 = new JTextField();
		this.__jTextField2.setBounds(250, 350, 100, 40);
		this.__jTextField2.setOpaque(false);
		this.__jTextField2.setEditable(false);
		this.filter = new FileNameExtensionFilter("所有图片文件", "png", "gif",
				"ico", "tif", "tiff", "jpg", "jpeg", "jpe", "jfif", "bmp",
				"dib");
		this.jLabel = new JLabel("桌名:");
		this.jLabel.setBounds(100, 50, 40, 40);
		this.jLabel1 = new JLabel("桌名:");
		this.jLabel1.setBounds(100, 120, 40, 40);
		this.jLabel2 = new JLabel("状态:");
		this.jLabel2.setBounds(100, 190, 40, 40);
		this.jLabel3 = new JLabel("卓型:");
		this.jLabel3.setBounds(100, 260, 40, 40);
		this.jTextField = new JTextField();
		this.jTextField.setBounds(150, 120, 200, 40);

		this.button = new JButton("修改");
		this.button.setBounds(100, 400, 100, 40);
		this.button2 = new JButton("重置");
		this.button2.setBounds(250, 400, 100, 40);
		this.jRadioButton = new JRadioButton("空闲");
		this.jRadioButton.setBounds(150, 190, 100, 40);
		this.jRadioButton1 = new JRadioButton("用餐中.....");
		this.jRadioButton1.setBounds(250, 190, 100, 40);
		this.jRadioButton2 = new JRadioButton("小桌");
		this.jRadioButton2.setBounds(150, 260, 70, 40);
		this.jRadioButton3 = new JRadioButton("大桌");
		this.jRadioButton3.setBounds(220, 260, 70, 40);
		this.jRadioButton4 = new JRadioButton("包厢");
		this.jRadioButton4.setBounds(290, 260, 70, 40);
		this.jRadioButton.setOpaque(false);
		this.jRadioButton1.setOpaque(false);
		this.jRadioButton2.setOpaque(false);
		this.jRadioButton3.setOpaque(false);
		this.jRadioButton4.setOpaque(false);
		this.box = new JComboBox();
		this.box.setBounds(150, 50, 200, 40);
		this.dcm = new DefaultComboBoxModel();
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup1 = new ButtonGroup();
		this.box.setModel(dcm);
		this.buttonGroup.add(jRadioButton);
		this.buttonGroup.add(jRadioButton1);
		this.buttonGroup1.add(jRadioButton2);
		this.buttonGroup1.add(jRadioButton3);
		this.buttonGroup1.add(jRadioButton4);
		this.tab = new JTabbedPane(JTabbedPane.LEFT);
		this.jPanel.add(jLabel);
		this.jPanel.add(jLabel1);
		this.jPanel.add(jLabel2);
		this.jPanel.add(jLabel3);
		this.jPanel.add(jTextField);
		this.jPanel.add(jRadioButton);
		this.jPanel.add(jRadioButton1);
		this.jPanel.add(jRadioButton2);
		this.jPanel.add(jRadioButton3);
		this.jPanel.add(jRadioButton4);
		this.jPanel.add(button);
		this.jPanel.add(button2);
		this.jPanel.add(box);
		this._jLabel = new JLabel("桌名:");
		this._jLabel.setBounds(100, 50, 40, 40);
		this._jLabel1 = new JLabel("桌名:");
		this._jLabel1.setBounds(100, 120, 40, 40);
		this._jLabel2 = new JLabel("状态:");
		this._jLabel2.setBounds(100, 190, 40, 40);
		this._jLabel3 = new JLabel("卓型:");
		this._jLabel3.setBounds(100, 260, 40, 40);
		this._jTextField = new JTextField();
		this._jTextField.setBounds(150, 120, 200, 40);

		this._button = new JButton("修改");
		this._button.setBounds(100, 400, 100, 40);
		this._button2 = new JButton("重置");
		this._button2.setBounds(250, 400, 100, 40);
		this._jRadioButton = new JRadioButton("空闲");
		this._jRadioButton.setBounds(150, 190, 100, 40);
		this._jRadioButton1 = new JRadioButton("用餐中.....");
		this._jRadioButton1.setBounds(250, 190, 100, 40);
		this._jRadioButton2 = new JRadioButton("小桌");
		this._jRadioButton2.setBounds(150, 260, 70, 40);
		this._jRadioButton3 = new JRadioButton("大桌");
		this._jRadioButton3.setBounds(220, 260, 70, 40);
		this._jRadioButton4 = new JRadioButton("包厢");
		this._jRadioButton4.setBounds(290, 260, 70, 40);
		this._jRadioButton.setOpaque(false);
		this._jRadioButton1.setOpaque(false);
		this._jRadioButton2.setOpaque(false);
		this._jRadioButton3.setOpaque(false);
		this._jRadioButton4.setOpaque(false);
		this._box = new JComboBox();
		this._box.setBounds(150, 50, 200, 40);
		this._dcm = new DefaultComboBoxModel();
		this._buttonGroup = new ButtonGroup();
		this._buttonGroup1 = new ButtonGroup();
		this._box.setModel(_dcm);
		this._buttonGroup.add(_jRadioButton);
		this._buttonGroup.add(_jRadioButton1);
		this._buttonGroup1.add(_jRadioButton2);
		this._buttonGroup1.add(_jRadioButton3);
		this._buttonGroup1.add(_jRadioButton4);
		this.jPanel1.add(_jLabel);
		this.jPanel1.add(_jLabel1);
		this.jPanel1.add(_jLabel2);
		this.jPanel1.add(_jLabel3);
		this.jPanel1.add(_jTextField);
		this.jPanel1.add(_jRadioButton);
		this.jPanel1.add(_jRadioButton1);
		this.jPanel1.add(_jRadioButton2);
		this.jPanel1.add(_jRadioButton3);
		this.jPanel1.add(_jRadioButton4);
		this.jPanel1.add(_button);
		this.jPanel1.add(_button2);
		this.jPanel1.add(_box);
		this.__jLabel = new JLabel("桌名:");
		this.__jLabel.setBounds(100, 50, 40, 40);
		this.__jLabel1 = new JLabel("桌名:");
		this.__jLabel1.setBounds(100, 120, 40, 40);
		this.__jLabel2 = new JLabel("状态:");
		this.__jLabel2.setBounds(100, 190, 40, 40);
		this.__jLabel3 = new JLabel("卓型:");
		this.__jLabel3.setBounds(100, 260, 40, 40);
		this.__jTextField = new JTextField();
		this.__jTextField.setBounds(150, 120, 200, 40);

		this.__button = new JButton("修改");
		this.__button.setBounds(100, 400, 100, 40);
		this.__button2 = new JButton("重置");
		this.__button2.setBounds(250, 400, 100, 40);
		this.__jRadioButton = new JRadioButton("空闲");
		this.__jRadioButton.setBounds(150, 190, 100, 40);
		this.__jRadioButton1 = new JRadioButton("用餐中.....");
		this.__jRadioButton1.setBounds(250, 190, 100, 40);
		this.__jRadioButton2 = new JRadioButton("小桌");
		this.__jRadioButton2.setBounds(150, 260, 70, 40);
		this.__jRadioButton3 = new JRadioButton("大桌");
		this.__jRadioButton3.setBounds(220, 260, 70, 40);
		this.__jRadioButton4 = new JRadioButton("包厢");
		this.__jRadioButton4.setBounds(290, 260, 70, 40);
		this.__jRadioButton.setOpaque(false);
		this.__jRadioButton1.setOpaque(false);
		this.__jRadioButton2.setOpaque(false);
		this.__jRadioButton3.setOpaque(false);
		this.__jRadioButton4.setOpaque(false);
		this.__box = new JComboBox();
		this.__box.setBounds(150, 50, 200, 40);
		this.__dcm = new DefaultComboBoxModel();
		this.__buttonGroup = new ButtonGroup();
		this.__buttonGroup1 = new ButtonGroup();
		this.__box.setModel(__dcm);
		this.__buttonGroup.add(__jRadioButton);
		this.__buttonGroup.add(__jRadioButton1);
		this.__buttonGroup1.add(__jRadioButton2);
		this.__buttonGroup1.add(__jRadioButton3);
		this.__buttonGroup1.add(__jRadioButton4);
		this.jTextField.setOpaque(false);
		this._jTextField.setOpaque(false);
		this.__jTextField.setOpaque(false);
		this.button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton4.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jTextField.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jTextField2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button.setForeground(new Color(92, 167, 186));
		this.button2.setForeground(new Color(92, 167, 186));
		this.button3.setForeground(new Color(92, 167, 186));
		this.jLabel.setForeground(new Color(92, 167, 186));
		this.jLabel1.setForeground(new Color(92, 167, 186));
		this.jLabel2.setForeground(new Color(92, 167, 186));
		this.jLabel3.setForeground(new Color(92, 167, 186));
		this.jRadioButton.setForeground(new Color(92, 167, 186));
		this.jRadioButton1.setForeground(new Color(92, 167, 186));
		this.jRadioButton2.setForeground(new Color(92, 167, 186));
		this.jRadioButton3.setForeground(new Color(92, 167, 186));
		this.jRadioButton4.setForeground(new Color(92, 167, 186));
		this.jTextField.setForeground(new Color(92, 167, 186));
		this.jTextField2.setForeground(new Color(92, 167, 186));
		this._button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._button3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jLabel3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jRadioButton1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jRadioButton2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jRadioButton3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jRadioButton4.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jTextField.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._jTextField2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this._button.setForeground(new Color(92, 167, 186));
		this._button2.setForeground(new Color(92, 167, 186));
		this._button3.setForeground(new Color(92, 167, 186));
		this._jLabel.setForeground(new Color(92, 167, 186));
		this._jLabel1.setForeground(new Color(92, 167, 186));
		this._jLabel2.setForeground(new Color(92, 167, 186));
		this._jLabel3.setForeground(new Color(92, 167, 186));
		this._jRadioButton.setForeground(new Color(92, 167, 186));
		this._jRadioButton1.setForeground(new Color(92, 167, 186));
		this._jRadioButton2.setForeground(new Color(92, 167, 186));
		this._jRadioButton3.setForeground(new Color(92, 167, 186));
		this._jRadioButton4.setForeground(new Color(92, 167, 186));
		this._jTextField.setForeground(new Color(92, 167, 186));
		this._jTextField2.setForeground(new Color(92, 167, 186));
		this.__button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__button3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jLabel3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jRadioButton1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jRadioButton2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jRadioButton3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jRadioButton4.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jTextField.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__jTextField2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.__button.setForeground(new Color(92, 167, 186));
		this.__button2.setForeground(new Color(92, 167, 186));
		this.__button3.setForeground(new Color(92, 167, 186));
		this.__jLabel.setForeground(new Color(92, 167, 186));
		this.__jLabel1.setForeground(new Color(92, 167, 186));
		this.__jLabel2.setForeground(new Color(92, 167, 186));
		this.__jLabel3.setForeground(new Color(92, 167, 186));
		this.__jRadioButton.setForeground(new Color(92, 167, 186));
		this.__jRadioButton1.setForeground(new Color(92, 167, 186));
		this.__jRadioButton2.setForeground(new Color(92, 167, 186));
		this.__jRadioButton3.setForeground(new Color(92, 167, 186));
		this.__jRadioButton4.setForeground(new Color(92, 167, 186));
		this.__jTextField.setForeground(new Color(92, 167, 186));
		this.__jTextField2.setForeground(new Color(92, 167, 186));
		this.jPanel.add(button3);
		this.jPanel.add(jTextField2);
		this.jPanel1.add(_button3);
		this.jPanel1.add(_jTextField2);
		this.jPanel2.add(__button3);
		this.jPanel2.add(__jTextField2);
		this.jPanel2.add(__jLabel);
		this.jPanel2.add(__jLabel1);
		this.jPanel2.add(__jLabel2);
		this.jPanel2.add(__jLabel3);
		this.jPanel2.add(__jTextField);
		this.jPanel2.add(__jRadioButton);
		this.jPanel2.add(__jRadioButton1);
		this.jPanel2.add(__jRadioButton2);
		this.jPanel2.add(__jRadioButton3);
		this.jPanel2.add(__jRadioButton4);
		this.jPanel2.add(__button);
		this.jPanel2.add(__button2);
		this.jPanel2.add(__box);
		this.tab.add(jPanel, "小桌");
		this.tab.add(jPanel1, "大桌");
		this.tab.add(jPanel2, "包厢");
		this.tab.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(tab);
		this.button.addActionListener(this);
		this.button2.addActionListener(this);
		this.button3.addActionListener(this);
		this._button.addActionListener(this);
		this._button2.addActionListener(this);
		this._button3.addActionListener(this);
		this.__button.addActionListener(this);
		this.__button2.addActionListener(this);
		this.__button3.addActionListener(this);
		this.box.addItemListener(this);
		this._box.addItemListener(this);
		this.__box.addItemListener(this);
		this.tab.addChangeListener(this);
	}

	public void bindData() {
		this.dcm.addElement("--请选择--");
		this._dcm.addElement("--请选择--");
		this.__dcm.addElement("--请选择--");
		this.jTextField.setText("--请选择桌名--");
		this._jTextField.setText("--请选择桌名--");
		this.__jTextField.setText("--请选择桌名--");
		this.jTextField2.setText("非必须添加项");
		this._jTextField2.setText("非必须添加项");
		this.__jTextField2.setText("非必须添加项");
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = tableService.getTable(tableUse);
		for (TableUse t : tableList) {
			if (t.getT_note().equals("小桌")) {
				this.dcm.addElement(t.getT_deskno());
			}
			if (t.getT_note().equals("大桌")) {
				this._dcm.addElement(t.getT_deskno());
			}
			if (t.getT_note().equals("包厢")) {
				this.__dcm.addElement(t.getT_deskno());
			}
		}
	}

	public void clearElement() {
		this.dcm.removeAllElements();
		this.buttonGroup.clearSelection();
		this._dcm.removeAllElements();
		this._buttonGroup.clearSelection();
		this.buttonGroup1.clearSelection();
		this._buttonGroup1.clearSelection();
		this.__buttonGroup1.clearSelection();
		this.__dcm.removeAllElements();
		this.__buttonGroup.clearSelection();
		this.jTextField.setText("--请选择桌名--");
		this._jTextField.setText("--请选择桌名--");
		this.__jTextField.setText("--请选择桌名--");
		this.jTextField2.setText("非必须添加项");
		this._jTextField2.setText("非必须添加项");
		this.__jTextField2.setText("非必须添加项");
		this.file = null;
		this._tTableUse.setT_deskno(null);
		this.bindData();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("添加图片")) {
			this.fileChooser = new JFileChooser();
			this.fileChooser.setAcceptAllFileFilterUsed(false);
			this.fileChooser.setFileFilter(filter);
			this.fileChooser.showOpenDialog(null);
			this.file = this.fileChooser.getSelectedFile();
			if(file!=null){
			this.jTextField2.setText(this.file.getName());
			this._jTextField2.setText(this.file.getName());
			this.__jTextField2.setText(this.file.getName());
			}

		}
		if (e.getActionCommand().trim().equals("修改")) {
			if (this._tTableUse.getT_deskno() != null) {
				TableUse newTableUse = new TableUse();
				if (this.jRadioButton.isSelected()) {
					newTableUse.setT_state(this.jRadioButton.getText());
				}
				if (this.jRadioButton1.isSelected()) {
					newTableUse.setT_state(this.jRadioButton1.getText());
				}
				if (this._jRadioButton.isSelected()) {
					newTableUse.setT_state(this._jRadioButton.getText());
				}
				if (this._jRadioButton1.isSelected()) {
					newTableUse.setT_state(this._jRadioButton1.getText());
				}
				if (this.__jRadioButton.isSelected()) {
					newTableUse.setT_state(this.__jRadioButton.getText());
				}
				if (this.__jRadioButton1.isSelected()) {
					newTableUse.setT_state(this.__jRadioButton1.getText());
				}
				if (this.jRadioButton2.isSelected()) {
					newTableUse.setT_note(this.jRadioButton2.getText());
				}
				if (this.jRadioButton3.isSelected()) {
					newTableUse.setT_note(this.jRadioButton3.getText());
				}
				if (this.jRadioButton4.isSelected()) {
					newTableUse.setT_note(this.jRadioButton4.getText());
				}
				if (this._jRadioButton2.isSelected()) {
					newTableUse.setT_note(this._jRadioButton2.getText());
				}
				if (this._jRadioButton3.isSelected()) {
					newTableUse.setT_note(this._jRadioButton3.getText());
				}
				if (this._jRadioButton4.isSelected()) {
					newTableUse.setT_note(this._jRadioButton4.getText());
				}
				if (this.__jRadioButton2.isSelected()) {
					newTableUse.setT_note(this.__jRadioButton2.getText());
				}
				if (this.__jRadioButton3.isSelected()) {
					newTableUse.setT_note(this.__jRadioButton3.getText());
				}
				if (this.__jRadioButton4.isSelected()) {
					newTableUse.setT_note(this.__jRadioButton4.getText());
				}
				if (tableService.getTable(this._tTableUse).get(0).getT_note()
						.equals("小桌")) {
					newTableUse.setT_deskno(this.jTextField.getText());
				}
				if (tableService.getTable(this._tTableUse).get(0).getT_note()
						.equals("大桌")) {
					newTableUse.setT_deskno(this._jTextField.getText());
				}
				if (tableService.getTable(this._tTableUse).get(0).getT_note()
						.equals("包厢")) {
					newTableUse.setT_deskno(this.__jTextField.getText());
				}
			
				if (!newTableUse.getT_deskno().equals("")) {
					TableUse findTableUse = new TableUse();
					findTableUse.setT_deskno(newTableUse.getT_deskno());
					if (tableService.getTable(findTableUse).size() == 0
							|| newTableUse.getT_deskno().equals(
									this._tTableUse.getT_deskno())) {
						if (file != null) {
							try {
								FileInputStream fileInputStream = new FileInputStream(
										file);
								BufferedInputStream bufferedInputStream = new BufferedInputStream(
										fileInputStream);
								FileOutputStream fileOutputStream = new FileOutputStream(
										"images/" + newTableUse.getT_deskno()
												+ ".png", false);
								BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
										fileOutputStream);
								byte[] b = new byte[1024];

								if (tableService.updataTable(newTableUse,
										_tTableUse) > 0) {
									JOptionPane.showMessageDialog(this, "修改成功");
									try {
										int count = bufferedInputStream.read(b,
												0, 1024);
										while (count > 0) {
											bufferedOutputStream.write(b, 0,
													count);
											count = bufferedInputStream.read(b,
													0, 1024);
										}
										bufferedOutputStream.close();
										this.clearElement();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									JOptionPane.showMessageDialog(this, "配图成功");
								} else {
									JOptionPane.showMessageDialog(this,
											"发生了一个未知错误,请联系开发者");
								}
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else {

							if (tableService.updataTable(newTableUse,
									_tTableUse) > 0) {
								JOptionPane.showMessageDialog(this, "修改成功");
								this.clearElement();
							}
							JOptionPane.showMessageDialog(this, "没有进行配图");
						}

					} else {
						JOptionPane.showMessageDialog(this, "新的餐桌名称与其他现有名称冲突了");
					}
				} else {
					JOptionPane.showMessageDialog(this, "请输入新桌名!");
				}

			} else {
				JOptionPane.showMessageDialog(this, "请选择餐桌!");
			}
		}
		if (e.getActionCommand().trim().equals("重置")) {
			this.clearElement();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		this.clearElement();
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
							.get(0).getT_deskno());
					this.jRadioButton2.setSelected(true);
					if (tableService.getTable(_tTableUse).get(0).getT_state()
							.equals("空闲")) {
						this.jRadioButton.setSelected(true);
					} else {
						this.jRadioButton1.setSelected(true);
					}
				}
				if (tableService.getTable(_tTableUse).get(0).getT_note()
						.equals("大桌")) {
					this._jTextField.setText(tableService.getTable(_tTableUse)
							.get(0).getT_deskno());
					this._jRadioButton3.setSelected(true);
					if (tableService.getTable(_tTableUse).get(0).getT_state()
							.equals("空闲")) {
						this._jRadioButton.setSelected(true);
					} else {
						this._jRadioButton1.setSelected(true);
					}
				}
				if (tableService.getTable(_tTableUse).get(0).getT_note()
						.equals("包厢")) {
					this.__jTextField.setText(tableService.getTable(_tTableUse)
							.get(0).getT_deskno());
					this.__jRadioButton4.setSelected(true);
					if (tableService.getTable(_tTableUse).get(0).getT_state()
							.equals("空闲")) {
						this.__jRadioButton.setSelected(true);
					} else {
						this.__jRadioButton1.setSelected(true);
					}
				}
			}
			else{
				this.jTextField.setText("--请选择桌名--");
				this._jTextField.setText("--请选择桌名--");
				this.__jTextField.setText("--请选择桌名--");
				this.jTextField2.setText("非必须添加项");
				this._jTextField2.setText("非必须添加项");
				this.__jTextField2.setText("非必须添加项");
				this.buttonGroup.clearSelection();
				this._buttonGroup.clearSelection();
			
				this.buttonGroup1.clearSelection();
				this._buttonGroup1.clearSelection();
				this.__buttonGroup.clearSelection();
				this.__buttonGroup1.clearSelection();
				this.file = null;
				this._tTableUse.setT_deskno(null);
			}
		}
	}
}
