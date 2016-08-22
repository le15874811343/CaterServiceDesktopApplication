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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import entity.*;
import service.*;

import java.io.*;
/**
 * 修改菜品信息面板
 * @author 乐家良
 *
 */
public class UpdataMenuPanel extends JPanel implements ActionListener,
		ItemListener, ChangeListener, KeyListener {
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
	private JTextField jTextField3;
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

	private JTextField _jTextField3;
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
	private JTextField __jTextField3;
	private JRadioButton __jRadioButton1;
	private JRadioButton __jRadioButton2;
	private JRadioButton __jRadioButton3;
	private JRadioButton __jRadioButton4;
	private JLabel ___jLabel;
	private JLabel ___jLabel1;
	private JLabel ___jLabel2;
	private JLabel ___jLabel3;
	private JComboBox ___box;
	private DefaultComboBoxModel ___dcm;
	private JButton ___button;
	private JButton ___button2;
	private JTextField ___jTextField;
	private JTextField ___jTextField3;
	private JRadioButton ___jRadioButton1;
	private JRadioButton ___jRadioButton2;
	private JRadioButton ___jRadioButton3;
	private JRadioButton ___jRadioButton4;
	private ButtonGroup buttonGroup1;
	private ButtonGroup _buttonGroup1;
	private ButtonGroup __buttonGroup1;
	private ButtonGroup ___buttonGroup1;
	private JTabbedPane tab;
	private JPanel jPanel = new JPanel();
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JPanel jPanel3 = new JPanel();
	private JButton button3;
	private JButton _button3;
	private JButton __button3;
	private JButton ___button3;
	private JTextField jTextField2;
	private JTextField _jTextField2;
	private JTextField __jTextField2;
	private JTextField ___jTextField2;
	private MenuService menuService = new MenuService();
	private JFileChooser fileChooser;
	private File file;
	private boolean flag = false;
	private MenuInfo _menuInfo = new MenuInfo();

	public UpdataMenuPanel() {
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
		this.button3 = new JButton("添加图片");
		this.button3.setBounds(70, 350, 100, 40);
		this.jTextField2 = new JTextField();
		this.jTextField2.setBounds(250, 350, 100, 40);
		this.jTextField2.setOpaque(false);
		this.jTextField2.setEditable(false);
		this._button3 = new JButton("添加图片");
		this._button3.setBounds(70, 350, 100, 40);
		this._jTextField2 = new JTextField();
		this._jTextField2.setBounds(250, 350, 100, 40);
		this._jTextField2.setOpaque(false);
		this._jTextField2.setEditable(false);
		this.__button3 = new JButton("添加图片");
		this.__button3.setBounds(70, 350, 100, 40);
		this.__jTextField2 = new JTextField();
		this.__jTextField2.setBounds(250, 350, 100, 40);
		this.__jTextField2.setOpaque(false);
		this.__jTextField2.setEditable(false);
		this.___button3 = new JButton("添加图片");
		this.___button3.setBounds(70, 350, 100, 40);
		this.___jTextField2 = new JTextField();
		this.___jTextField2.setBounds(250, 350, 100, 40);
		this.___jTextField2.setOpaque(false);
		this.___jTextField2.setEditable(false);
		this.filter = new FileNameExtensionFilter("所有图片文件", "png", "gif",
				"ico", "tif", "tiff", "jpg", "jpeg", "jpe", "jfif", "bmp",
				"dib");
		this.jLabel = new JLabel("菜名:");
		this.jLabel.setBounds(50, 50, 40, 40);
		this.jLabel1 = new JLabel("菜名:");
		this.jLabel1.setBounds(50, 120, 40, 40);
		this.jLabel2 = new JLabel("价格:");
		this.jLabel2.setBounds(50, 190, 40, 40);
		this.jLabel3 = new JLabel("类型:");
		this.jLabel3.setBounds(50, 260, 40, 40);
		this.jTextField = new JTextField();
		this.jTextField.setBounds(100, 120, 200, 40);

		this.button = new JButton("修改");
		this.button.setBounds(70, 400, 100, 40);
		this.button2 = new JButton("重置");
		this.button2.setBounds(250, 400, 100, 40);
		this.jTextField3 = new JTextField();
		this.jTextField3.setBounds(100, 190, 200, 40);
		this.jRadioButton1 = new JRadioButton("小炒");
		this.jRadioButton1.setBounds(100, 260, 70, 40);
		this.jRadioButton2 = new JRadioButton("火锅");
		this.jRadioButton2.setBounds(170, 260, 70, 40);
		this.jRadioButton3 = new JRadioButton("汤");
		this.jRadioButton3.setBounds(240, 260, 70, 40);
		this.jRadioButton4 = new JRadioButton("饮品");
		this.jRadioButton4.setBounds(310, 260, 70, 40);
		this.jTextField3.setOpaque(false);
		this.jRadioButton1.setOpaque(false);
		this.jRadioButton2.setOpaque(false);
		this.jRadioButton3.setOpaque(false);
		this.jRadioButton4.setOpaque(false);
		this.box = new JComboBox();
		this.box.setBounds(100, 50, 200, 40);
		this.dcm = new DefaultComboBoxModel();
		this.buttonGroup1 = new ButtonGroup();
		this.box.setModel(dcm);

		this.buttonGroup1.add(jRadioButton1);
		this.buttonGroup1.add(jRadioButton2);
		this.buttonGroup1.add(jRadioButton3);
		this.buttonGroup1.add(jRadioButton4);
		this.tab = new JTabbedPane(JTabbedPane.LEFT);
		this.jPanel.add(jLabel);
		this.jPanel.add(jLabel1);
		this.jPanel.add(jLabel2);
		this.jPanel.add(jLabel3);
		this.jPanel.add(jTextField);
		this.jPanel.add(jTextField3);
		this.jPanel.add(jRadioButton1);
		this.jPanel.add(jRadioButton2);
		this.jPanel.add(jRadioButton3);
		this.jPanel.add(jRadioButton4);
		this.jPanel.add(button);
		this.jPanel.add(button2);
		this.jPanel.add(box);
		this._jLabel = new JLabel("菜名:");
		this._jLabel.setBounds(50, 50, 40, 40);
		this._jLabel1 = new JLabel("菜名:");
		this._jLabel1.setBounds(50, 120, 40, 40);
		this._jLabel2 = new JLabel("价格:");
		this._jLabel2.setBounds(50, 190, 40, 40);
		this._jLabel3 = new JLabel("类型:");
		this._jLabel3.setBounds(50, 260, 40, 40);
		this._jTextField = new JTextField();
		this._jTextField.setBounds(100, 120, 200, 40);

		this._button = new JButton("修改");
		this._button.setBounds(70, 400, 100, 40);
		this._button2 = new JButton("重置");
		this._button2.setBounds(250, 400, 100, 40);
		this._jTextField3 = new JTextField();
		this._jTextField3.setBounds(100, 190, 200, 40);
		this._jRadioButton1 = new JRadioButton("小炒");
		this._jRadioButton1.setBounds(100, 260, 70, 40);
		this._jRadioButton2 = new JRadioButton("火锅");
		this._jRadioButton2.setBounds(170, 260, 70, 40);
		this._jRadioButton3 = new JRadioButton("汤");
		this._jRadioButton3.setBounds(240, 260, 70, 40);
		this._jRadioButton4 = new JRadioButton("饮品");
		this._jRadioButton4.setBounds(310, 260, 70, 40);
		this._jTextField3.setOpaque(false);
		this._jRadioButton1.setOpaque(false);
		this._jRadioButton2.setOpaque(false);
		this._jRadioButton3.setOpaque(false);
		this._jRadioButton4.setOpaque(false);
		this._box = new JComboBox();
		this._box.setBounds(100, 50, 200, 40);
		this._dcm = new DefaultComboBoxModel();

		this._buttonGroup1 = new ButtonGroup();
		this._box.setModel(_dcm);

		this._buttonGroup1.add(_jRadioButton1);
		this._buttonGroup1.add(_jRadioButton2);
		this._buttonGroup1.add(_jRadioButton3);
		this._buttonGroup1.add(_jRadioButton4);
		this.jPanel1.add(_jLabel);
		this.jPanel1.add(_jLabel1);
		this.jPanel1.add(_jLabel2);
		this.jPanel1.add(_jLabel3);
		this.jPanel1.add(_jTextField);
		this.jPanel1.add(_jTextField3);
		this.jPanel1.add(_jRadioButton1);
		this.jPanel1.add(_jRadioButton2);
		this.jPanel1.add(_jRadioButton3);
		this.jPanel1.add(_jRadioButton4);
		this.jPanel1.add(_button);
		this.jPanel1.add(_button2);
		this.jPanel1.add(_box);
		this.__jLabel = new JLabel("菜名:");
		this.__jLabel.setBounds(50, 50, 40, 40);
		this.__jLabel1 = new JLabel("菜名:");
		this.__jLabel1.setBounds(50, 120, 40, 40);
		this.__jLabel2 = new JLabel("价格:");
		this.__jLabel2.setBounds(50, 190, 40, 40);
		this.__jLabel3 = new JLabel("类型:");
		this.__jLabel3.setBounds(50, 260, 40, 40);
		this.__jTextField = new JTextField();
		this.__jTextField.setBounds(100, 120, 200, 40);

		this.__button = new JButton("修改");
		this.__button.setBounds(70, 400, 100, 40);
		this.__button2 = new JButton("重置");
		this.__button2.setBounds(250, 400, 100, 40);
		this.__jTextField3 = new JTextField();
		this.__jTextField3.setBounds(100, 190, 200, 40);
		this.__jRadioButton1 = new JRadioButton("小炒");
		this.__jRadioButton1.setBounds(100, 260, 70, 40);
		this.__jRadioButton2 = new JRadioButton("火锅");
		this.__jRadioButton2.setBounds(170, 260, 70, 40);
		this.__jRadioButton3 = new JRadioButton("汤");
		this.__jRadioButton3.setBounds(240, 260, 70, 40);
		this.__jRadioButton4 = new JRadioButton("饮品");
		this.__jRadioButton4.setBounds(310, 260, 70, 40);
		this.__jTextField3.setOpaque(false);
		this.__jRadioButton1.setOpaque(false);
		this.__jRadioButton2.setOpaque(false);
		this.__jRadioButton3.setOpaque(false);
		this.__jRadioButton4.setOpaque(false);
		this.__box = new JComboBox();
		this.__box.setBounds(100, 50, 200, 40);
		this.__dcm = new DefaultComboBoxModel();

		this.__buttonGroup1 = new ButtonGroup();
		this.__box.setModel(__dcm);
		this.__buttonGroup1.add(__jRadioButton1);
		this.__buttonGroup1.add(__jRadioButton2);
		this.__buttonGroup1.add(__jRadioButton3);
		this.__buttonGroup1.add(__jRadioButton4);
		this.___jLabel = new JLabel("菜名:");
		this.___jLabel.setBounds(50, 50, 40, 40);
		this.___jLabel1 = new JLabel("菜名:");
		this.___jLabel1.setBounds(50, 120, 40, 40);
		this.___jLabel2 = new JLabel("价格:");
		this.___jLabel2.setBounds(50, 190, 40, 40);
		this.___jLabel3 = new JLabel("类型:");
		this.___jLabel3.setBounds(50, 260, 40, 40);
		this.___jTextField = new JTextField();
		this.___jTextField.setBounds(100, 120, 200, 40);

		this.___button = new JButton("修改");
		this.___button.setBounds(70, 400, 100, 40);
		this.___button2 = new JButton("重置");
		this.___button2.setBounds(250, 400, 100, 40);
		this.___jTextField3 = new JTextField();
		this.___jTextField3.setBounds(100, 190, 200, 40);
		this.___jRadioButton1 = new JRadioButton("小炒");
		this.___jRadioButton1.setBounds(100, 260, 70, 40);
		this.___jRadioButton2 = new JRadioButton("火锅");
		this.___jRadioButton2.setBounds(170, 260, 70, 40);
		this.___jRadioButton3 = new JRadioButton("汤");
		this.___jRadioButton3.setBounds(240, 260, 70, 40);
		this.___jRadioButton4 = new JRadioButton("饮品");
		this.___jRadioButton4.setBounds(310, 260, 70, 40);
		this.___jTextField3.setOpaque(false);
		this.___jRadioButton1.setOpaque(false);
		this.___jRadioButton2.setOpaque(false);
		this.___jRadioButton3.setOpaque(false);
		this.___jRadioButton4.setOpaque(false);
		this.___box = new JComboBox();
		this.___box.setBounds(100, 50, 200, 40);
		this.___dcm = new DefaultComboBoxModel();

		this.___buttonGroup1 = new ButtonGroup();
		this.___box.setModel(___dcm);
		this.___buttonGroup1.add(___jRadioButton1);
		this.___buttonGroup1.add(___jRadioButton2);
		this.___buttonGroup1.add(___jRadioButton3);
		this.___buttonGroup1.add(___jRadioButton4);
		this.jTextField.setOpaque(false);
		this._jTextField.setOpaque(false);
		this.__jTextField.setOpaque(false);
		this.___jTextField.setOpaque(false);
		this.button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jTextField3.setFont(new Font("华文行楷", Font.PLAIN, 14));
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
		this.jTextField3.setForeground(new Color(92, 167, 186));
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
		this._jTextField3.setFont(new Font("华文行楷", Font.PLAIN, 14));
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
		this._jTextField3.setForeground(new Color(92, 167, 186));
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
		this.__jTextField3.setFont(new Font("华文行楷", Font.PLAIN, 14));
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
		this.__jTextField3.setForeground(new Color(92, 167, 186));
		this.__jRadioButton1.setForeground(new Color(92, 167, 186));
		this.__jRadioButton2.setForeground(new Color(92, 167, 186));
		this.__jRadioButton3.setForeground(new Color(92, 167, 186));
		this.__jRadioButton4.setForeground(new Color(92, 167, 186));
		this.__jTextField.setForeground(new Color(92, 167, 186));
		this.__jTextField2.setForeground(new Color(92, 167, 186));
		this.___button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___button3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jLabel1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jLabel3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jTextField3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jRadioButton1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jRadioButton2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jRadioButton3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jRadioButton4.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jTextField.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___jTextField2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.___button.setForeground(new Color(92, 167, 186));
		this.___button2.setForeground(new Color(92, 167, 186));
		this.___button3.setForeground(new Color(92, 167, 186));
		this.___jLabel.setForeground(new Color(92, 167, 186));
		this.___jLabel1.setForeground(new Color(92, 167, 186));
		this.___jLabel2.setForeground(new Color(92, 167, 186));
		this.___jLabel3.setForeground(new Color(92, 167, 186));
		this.___jTextField3.setForeground(new Color(92, 167, 186));
		this.___jRadioButton1.setForeground(new Color(92, 167, 186));
		this.___jRadioButton2.setForeground(new Color(92, 167, 186));
		this.___jRadioButton3.setForeground(new Color(92, 167, 186));
		this.___jRadioButton4.setForeground(new Color(92, 167, 186));
		this.___jTextField.setForeground(new Color(92, 167, 186));
		this.___jTextField2.setForeground(new Color(92, 167, 186));
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
		this.jPanel2.add(__jTextField3);
		this.jPanel2.add(__jRadioButton1);
		this.jPanel2.add(__jRadioButton2);
		this.jPanel2.add(__jRadioButton3);
		this.jPanel2.add(__jRadioButton4);
		this.jPanel2.add(__button);
		this.jPanel2.add(__button2);
		this.jPanel2.add(__box);
		this.jPanel3.add(___button3);
		this.jPanel3.add(___jTextField2);
		this.jPanel3.add(___jLabel);
		this.jPanel3.add(___jLabel1);
		this.jPanel3.add(___jLabel2);
		this.jPanel3.add(___jLabel3);
		this.jPanel3.add(___jTextField);
		this.jPanel3.add(___jTextField3);
		this.jPanel3.add(___jRadioButton1);
		this.jPanel3.add(___jRadioButton2);
		this.jPanel3.add(___jRadioButton3);
		this.jPanel3.add(___jRadioButton4);
		this.jPanel3.add(___button);
		this.jPanel3.add(___button2);
		this.jPanel3.add(___box);
		this.tab.add(jPanel, "小炒");
		this.tab.add(jPanel1, "火锅");
		this.tab.add(jPanel2, "汤");
		this.tab.add(jPanel3, "饮品");
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
		this.___button.addActionListener(this);
		this.___button2.addActionListener(this);
		this.___button3.addActionListener(this);
		this.box.addItemListener(this);
		this._box.addItemListener(this);
		this.__box.addItemListener(this);
		this.___box.addItemListener(this);
		this.tab.addChangeListener(this);
		this.jTextField3.addKeyListener(this);
		this._jTextField3.addKeyListener(this);
		this.__jTextField3.addKeyListener(this);
		this.___jTextField3.addKeyListener(this);
	}

	public void bindData() {
		this.dcm.addElement("--请选择--");
		this._dcm.addElement("--请选择--");
		this.__dcm.addElement("--请选择--");
		this.___dcm.addElement("--请选择--");
		this.jTextField.setText("--请选择菜名--");
		this._jTextField.setText("--请选择菜名--");
		this.__jTextField.setText("--请选择菜名--");
		this.___jTextField.setText("--请选择菜名--");
		this.jTextField2.setText("非必须添加项");
		this._jTextField2.setText("非必须添加项");
		this.__jTextField2.setText("非必须添加项");
		this.___jTextField2.setText("非必须添加项");
		MenuInfo menuInfo = new MenuInfo();
		ArrayList<MenuInfo> menuList = (ArrayList<MenuInfo>) menuService
				.getMenInfoList(menuInfo);
		for (MenuInfo m : menuList) {
			if (m.getM_type().equals("小炒")) {
				this.dcm.addElement(m.getM_name());
			}
			if (m.getM_type().equals("火锅")) {
				this._dcm.addElement(m.getM_name());
			}
			if (m.getM_type().equals("汤")) {
				this.__dcm.addElement(m.getM_name());
			}
			if (m.getM_type().equals("饮品")) {
				this.___dcm.addElement(m.getM_name());
			}
		}
	}

	public void clearElement() {
		this.dcm.removeAllElements();
		this._dcm.removeAllElements();
		this.buttonGroup1.clearSelection();
		this._buttonGroup1.clearSelection();
		this.__buttonGroup1.clearSelection();
		this.___buttonGroup1.clearSelection();
		this.__dcm.removeAllElements();
		this.___dcm.removeAllElements();
		this.jTextField.setText("--请选择桌名--");
		this._jTextField.setText("--请选择桌名--");
		this.__jTextField.setText("--请选择桌名--");
		this.___jTextField.setText("--请选择桌名--");
		this.jTextField2.setText("非必须添加项");
		this._jTextField2.setText("非必须添加项");
		this.__jTextField2.setText("非必须添加项");
		this.___jTextField2.setText("非必须添加项");
		this.jTextField3.setText("");
		this._jTextField3.setText("");
		this.__jTextField3.setText("");
		this.___jTextField3.setText("");
		this.file = null;
		this._menuInfo.setM_name(null);
		this.flag = false;
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
			if (file != null) {
				this.jTextField2.setText(this.file.getName());
				this._jTextField2.setText(this.file.getName());
				this.__jTextField2.setText(this.file.getName());
				this.___jTextField2.setText(this.file.getName());
			}
		}
		if (e.getActionCommand().trim().equals("修改")) {
			if (this._menuInfo.getM_name() != null) {
				MenuInfo newMenuInfo = new MenuInfo();
				if (this.jRadioButton1.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton1.getText());
				}
				if (this.jRadioButton2.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton2.getText());
				}
				if (this.jRadioButton3.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton3.getText());
				}
				if (this.jRadioButton4.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton4.getText());
				}
				if (this._jRadioButton1.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton1.getText());
				}
				if (this._jRadioButton2.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton2.getText());
				}
				if (this._jRadioButton3.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton3.getText());
				}
				if (this._jRadioButton4.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton4.getText());
				}
				if (this.__jRadioButton1.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton1.getText());
				}
				if (this.__jRadioButton2.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton2.getText());
				}
				if (this.__jRadioButton3.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton3.getText());
				}
				if (this.__jRadioButton4.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton4.getText());
				}
				if (this.___jRadioButton1.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton1.getText());
				}
				if (this.___jRadioButton2.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton2.getText());
				}
				if (this.___jRadioButton3.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton3.getText());
				}
				if (this.___jRadioButton4.isSelected()) {
					newMenuInfo.setM_type(this.jRadioButton4.getText());
				}
				MenuInfo menuInfo1 = menuService.getMenInfoList(this._menuInfo)
						.get(0);
				if (menuInfo1.getM_type().equals("小炒")) {
					newMenuInfo.setM_name(this.jTextField.getText());
					if (!this.jTextField3.getText().equals("")) {
						newMenuInfo.setM_price(Double
								.parseDouble(this.jTextField3.getText()));
						flag = true;
					} else {
						JOptionPane.showMessageDialog(this, "请输入价格");
						flag = false;
					}
				}
				if (menuInfo1.getM_type().equals("火锅")) {
					newMenuInfo.setM_name(this._jTextField.getText());
					if (!this._jTextField3.getText().equals("")) {
						newMenuInfo.setM_price(Double
								.parseDouble(this._jTextField3.getText()));
						flag = true;
					} else {
						JOptionPane.showMessageDialog(this, "请输入价格");
						flag = false;
					}
				}
				if (menuInfo1.getM_type().equals("汤")) {
					newMenuInfo.setM_name(this.__jTextField.getText());
					if (!this.__jTextField3.getText().equals("")) {
						newMenuInfo.setM_price(Double
								.parseDouble(this.__jTextField3.getText()));
						flag = true;
					} else {
						JOptionPane.showMessageDialog(this, "请输入价格");
						flag = false;
					}
				}
				if (menuInfo1.getM_type().equals("饮品")) {
					newMenuInfo.setM_name(this.___jTextField.getText());
					if (!this.___jTextField3.getText().equals("")) {
						newMenuInfo.setM_price(Double
								.parseDouble(this.___jTextField3.getText()));
						flag = true;
					} else {
						JOptionPane.showMessageDialog(this, "请输入价格");
						flag = false;
					}
				}
				if (!newMenuInfo.getM_name().equals("") && flag == true) {
					MenuInfo findMenuInfo = new MenuInfo();
					findMenuInfo.setM_name(newMenuInfo.getM_name());
					if (menuService.getMenInfoList(findMenuInfo).size() == 0
							|| newMenuInfo.getM_name().equals(
									this._menuInfo.getM_name())) {
						if (file != null) {
							try {
								FileInputStream fileInputStream = new FileInputStream(
										file);
								BufferedInputStream bufferedInputStream = new BufferedInputStream(
										fileInputStream);
								FileOutputStream fileOutputStream = new FileOutputStream(
										"images/" + newMenuInfo.getM_name()
												+ ".jpg", false);
								BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
										fileOutputStream);
								byte[] b = new byte[1024];

								if (menuService.updataMenu(newMenuInfo,
										_menuInfo) > 0) {
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

							if (menuService.updataMenu(newMenuInfo, _menuInfo) > 0) {
								JOptionPane.showMessageDialog(this, "修改成功");
								this.clearElement();
							}
							JOptionPane.showMessageDialog(this, "没有进行配图");
						}

					} else {
						JOptionPane.showMessageDialog(this, "新的菜品名称与其他现有名称冲突了");
					}
				} else if (newMenuInfo.getM_name().equals("")) {
					JOptionPane.showMessageDialog(this, "请输入修改后的菜名");
				}
			} else {
				JOptionPane.showMessageDialog(this, "请选择菜品!");
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
				_menuInfo.setM_name(e.getItem().toString());
				MenuInfo menuInfo1 = menuService.getMenInfoList(this._menuInfo)
						.get(0);
				if (menuInfo1.getM_type().equals("小炒")) {
					this.jTextField.setText(menuInfo1.getM_name());
					this.jTextField3.setText(Double.toString(menuInfo1
							.getM_price()));
					this.jRadioButton1.setSelected(true);
				}
				if (menuInfo1.getM_type().equals("火锅")) {
					this._jTextField.setText(menuInfo1.getM_name());
					this._jTextField3.setText(Double.toString(menuInfo1
							.getM_price()));
					this._jRadioButton2.setSelected(true);
				}
				if (menuInfo1.getM_type().equals("汤")) {
					this.__jTextField.setText(menuInfo1.getM_name());
					this.__jTextField3.setText(Double.toString(menuInfo1
							.getM_price()));
					this.__jRadioButton3.setSelected(true);
				}
				if (menuInfo1.getM_type().equals("饮品")) {
					this.___jTextField.setText(menuInfo1.getM_name());
					this.___jTextField3.setText(Double.toString(menuInfo1
							.getM_price()));
					this.___jRadioButton4.setSelected(true);
				}
			} else {

				this.buttonGroup1.clearSelection();
				this._buttonGroup1.clearSelection();
				this.__buttonGroup1.clearSelection();
				this.___buttonGroup1.clearSelection();
				this.jTextField.setText("--请选择菜品--");
				this._jTextField.setText("--请选择菜品--");
				this.__jTextField.setText("--请选择菜品--");
				this.___jTextField.setText("--请选择菜品--");
				this.jTextField2.setText("非必须添加项");
				this._jTextField2.setText("非必须添加项");
				this.__jTextField2.setText("非必须添加项");
				this.___jTextField2.setText("非必须添加项");
				this.jTextField3.setText("");
				this._jTextField3.setText("");
				this.__jTextField3.setText("");
				this.___jTextField3.setText("");
				this.file = null;
				this._menuInfo.setM_name(null);
				this.flag = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar = e.getKeyChar();
		if (!this.jTextField3.getText().equals("")
				&& this.jTextField3.getText().indexOf(".") < 0) {
			if (keyChar == '.'
					|| (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)) {

			} else {
				e.consume(); // 关键，屏蔽掉非法输入
			}
		} else if (!this._jTextField3.getText().equals("")
				&& this._jTextField3.getText().indexOf(".") < 0) {
			if (keyChar == '.'
					|| (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)) {

			} else {
				e.consume(); // 关键，屏蔽掉非法输入
			}
		} else if (!this.__jTextField3.getText().equals("")
				&& this.__jTextField3.getText().indexOf(".") < 0) {
			if (keyChar == '.'
					|| (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)) {

			} else {
				e.consume(); // 关键，屏蔽掉非法输入
			}
		} else if (!this.___jTextField3.getText().equals("")
				&& this.___jTextField3.getText().indexOf(".") < 0) {
			if (keyChar == '.'
					|| (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)) {

			} else {
				e.consume(); // 关键，屏蔽掉非法输入
			}
		} else {
			if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

			} else {
				e.consume(); // 关键，屏蔽掉非法输入
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
