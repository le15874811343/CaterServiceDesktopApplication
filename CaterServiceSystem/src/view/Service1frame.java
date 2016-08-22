package view;

import javax.swing.JButton;

import java.lang.reflect.Array;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import service.*;
import entity.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
/**
 * 开台窗体
 * @author 乐家良
 *
 */
public class Service1frame extends JFrame implements MouseListener,
		ActionListener {
	private JButton jButton;
	private TablePane tablepane = new TablePane();
	private TablePane1 tablepane1 = new TablePane1();
	private Mypanel mypanel = new Mypanel();
	private JScrollPane jScrollPane;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private TablePane3 tablePane3 = new TablePane3();
	private JTabbedPane tab;
	private TableService service = new TableService();
	private JMenuBar jMenuBar;
	private JMenu jMenu2;
	private JMenuItem jMenuItem;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private String t_deskno;
	private TableUse tableUse = null;
	private UserInfo userInfo;
	private JMenu jMenu;
	private JMenuItem jMenuItem2;
	private JMenu jMenu3;

	public Service1frame(UserInfo userInfo) {

		this.setTitle("开台服务");
		this.setSize(600, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(mypanel);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.init();
		this.userInfo=userInfo;
		this.binData();
		this.setVisible(true);
	}
	public Service1frame() {

	}

	public void init() {
		tab = new JTabbedPane(JTabbedPane.TOP);
		Container container = this.getLayeredPane();
		this.jScrollPane = new JScrollPane(tablepane);
		this.jScrollPane1 = new JScrollPane(tablepane1);
		this.jScrollPane2 = new JScrollPane(tablePane3);
		this.jButton2 = new JButton("开台");
		this.jButton3 = new JButton("点菜");
		this.jButton4 = new JButton("结账");
		this.jButton5 = new JButton("刷新");
		this.jButton6 = new JButton("点评");
		this.jButton2.setBounds(0, 200, 200, 101);
		this.jButton3.setBounds(0, 301, 200, 101);
		this.jButton4.setBounds(0, 402, 200, 101);
		this.jButton5.setBounds(0, 503, 200, 101);
		this.jButton6.setBounds(0, 604, 200, 101);
		tablepane.setPreferredSize(new Dimension(800, 800));
		tablepane.setLayout(new GridLayout(3, 3));
		tablepane1.setPreferredSize(new Dimension(800, 800));
		tablepane1.setLayout(new GridLayout(3, 3));
		tablePane3.setPreferredSize(new Dimension(800, 800));
		tablePane3.setLayout(new GridLayout(2, 5));
		container.setLayout(null);
		container.add(tab);
		tab.add(jScrollPane, "小桌");
		tab.add(jScrollPane1, "大桌");
		tab.add(jScrollPane2, "包厢");
		mypanel.setLayout(null);
		mypanel.add(jButton2);
		mypanel.add(jButton3);
		mypanel.add(jButton4);
		mypanel.add(jButton5);
		mypanel.add(jButton6);
		JPanel menuJPanel = new JPanel();
		menuJPanel.setBounds(0, 0, 140, 30);
		mypanel.add(menuJPanel);
		tab.setBounds(200, 200, this.getWidth() + 565, this.getHeight()-95);
		mypanel.add(tab);
		this.jMenuBar = new JMenuBar();
		this.jMenu=new JMenu("查询");
		this.jMenuItem2=new JMenuItem("收入查询");
		this.jMenu.add(jMenuItem2);
		this.jMenu.addSeparator();
		JMenuItem jMenuItem3=new JMenuItem("销售情况查询");
		this.jMenu.add(jMenuItem3);
		JMenuItem jMenuItem6=new JMenuItem("顾客反馈情况查询");
		this.jMenu.addSeparator();
		this.jMenu.add(jMenuItem6);
		JMenuItem jMenuItem7=new JMenuItem("员工业绩详情查询");
		this.jMenu.addSeparator();
		this.jMenu.add(jMenuItem7);
		JMenuItem jMenuItem8=new JMenuItem("员工业绩统计查询");
		this.jMenu.addSeparator();
		this.jMenu.add(jMenuItem8);
		jMenu2 = new JMenu("账户");
		this.jMenuItem = new JMenuItem("员工管理");
		this.jMenu2.add(jMenuItem);
		this.jMenu3=new JMenu("管理");
		JMenuItem jMenuItem4=new JMenuItem("餐桌管理");
		JMenuItem jMenuItem5=new JMenuItem("菜品管理");
		this.jMenu3.add(jMenuItem4);
		this.jMenu3.addSeparator();
		this.jMenu3.add(jMenuItem5);
		this.jMenuBar.add(jMenu2);
		this.jMenuBar.add(jMenu);
		this.jMenuBar.add(jMenu3);
		this.jMenuBar.setOpaque(false);
		menuJPanel.add(jMenuBar);
		this.setContentPane(mypanel);
		this.jButton2.addActionListener(this);
		this.jButton3.addActionListener(this);
		this.jButton4.addActionListener(this);
		this.jButton5.addActionListener(this);
		this.jButton6.addActionListener(this);
		this.jMenu2.addActionListener(this);
		this.jMenuItem.addActionListener(this);
		this.jMenuItem2.addActionListener(this);
		jMenuItem3.addActionListener(this);
		jMenuItem4.addActionListener(this);
		jMenuItem5.addActionListener(this);
		jMenuItem6.addActionListener(this);
		jMenuItem7.addActionListener(this);
		jMenuItem8.addActionListener(this);
	}

	public void binData() {
		int mixcount = 0;
		int maxcount = 0;
		int boxcount = 0;
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = service.getTable(tableUse);
		for (int i = 0; i < tableList.size(); i++) {
			if (tableList.get(i).getT_note().equals("小桌")) {
				ArrayList<ImageIcon> minIcon = this.getMinTableImage();
				this.jButton = new JButton(minIcon.get(mixcount));
				mixcount++;
				this.jButton.setName(tableList.get(i).getT_deskno());
				jButton.setLayout(null);
				JRadioButton jRadioButton = new JRadioButton(tableList.get(i)
						.getT_deskno() + "号桌");
				jRadioButton.setName(tableList.get(i).getT_deskno());
				JTextField field2 = new JTextField();
				jRadioButton.setBounds(40, 70, 100, 40);
				field2.setText(tableList.get(i).getT_state());
				field2.setBounds(120, 70, 100, 40);
				field2.setOpaque(false);
				jRadioButton.setOpaque(false);
				field2.setEditable(false);
				jButton.add(jRadioButton);
				jButton.add(field2);
				this.buttonGroup.add(jRadioButton);
				this.tablepane.add(jButton);
				jRadioButton.addMouseListener(this);
			}
			if (tableList.get(i).getT_note().equals("大桌")) {
				ArrayList<ImageIcon> maxIcons = this.getMaxTableImage();
				this.jButton = new JButton(maxIcons.get(maxcount));
				maxcount++;
				this.jButton.setName(tableList.get(i).getT_deskno());
				jButton.setLayout(null);
				JRadioButton jRadioButton = new JRadioButton(tableList.get(i)
						.getT_deskno() + "号桌");
				jRadioButton.setName(tableList.get(i).getT_deskno());
				JTextField field2 = new JTextField();
				field2.setText(tableList.get(i).getT_state());
				jRadioButton.setBounds(40, 70, 100, 40);
				field2.setBounds(120, 70, 100, 40);
				jRadioButton.setOpaque(false);
				field2.setOpaque(false);
				field2.setEditable(false);
				jButton.add(jRadioButton);
				jButton.add(field2);
				this.buttonGroup.add(jRadioButton);
				this.tablepane1.add(jButton);
				jRadioButton.addMouseListener(this);
			}
			if (tableList.get(i).getT_note().equals("包厢")) {
				ArrayList<ImageIcon> boxIcons = this.getBoxTableImage();
				this.jButton = new JButton(boxIcons.get(boxcount));
				boxcount++;
				this.jButton.setName(tableList.get(i).getT_deskno());
				jButton.setLayout(null);
				JRadioButton jRadioButton = new JRadioButton(tableList.get(i)
						.getT_deskno());
				JTextField field2 = new JTextField();
				jRadioButton.setName(tableList.get(i).getT_deskno());
				field2.setText(tableList.get(i).getT_state());
				jRadioButton.setBounds(40, 70, 100, 40);
				field2.setBounds(120, 70, 100, 40);
				jRadioButton.setOpaque(false);
				field2.setOpaque(false);
				field2.setEditable(false);
				jButton.add(jRadioButton);
				jButton.add(field2);
				this.buttonGroup.add(jRadioButton);

				this.tablePane3.add(jButton);
				jRadioButton.addMouseListener(this);
			}
		}
	}

	/**
	 * 存放小桌子图片的方法
	 * 
	 * @return
	 */
	public ArrayList<ImageIcon> getMinTableImage() {
		ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
		ArrayList<String> tableName=new ArrayList<String>();
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = service.getTable(tableUse);
		for(TableUse t:tableList){
			if(t.getT_note().equals("小桌")){
			tableName.add("images/"+t.getT_deskno()+".png");
			}
		}
		for(String s:tableName){
			ImageIcon icon = new ImageIcon(s);
			iconList.add(icon);
		}
		return iconList;
	}

	/**
	 * 存放大桌子图片
	 * 
	 * @return
	 */
	public ArrayList<ImageIcon> getMaxTableImage() {
		ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
		ArrayList<String> tableName=new ArrayList<String>();
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = service.getTable(tableUse);
		for(TableUse t:tableList){
			if(t.getT_note().equals("大桌")){
			tableName.add("images/"+t.getT_deskno()+".png");
			}
		}
		for(String s:tableName){
			ImageIcon icon = new ImageIcon(s);
			iconList.add(icon);
		}
		return iconList;
	}

	

	/**
	 * 存放包厢背景的方法
	 * 
	 * @return
	 */
	public ArrayList<ImageIcon> getBoxTableImage() {
		ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
		ArrayList<String> tableName=new ArrayList<String>();
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = service.getTable(tableUse);
		for(TableUse t:tableList){
			if(t.getT_note().equals("包厢")){
			tableName.add("images/"+t.getT_deskno()+".png");
			}
		}
		for(String s:tableName){
			ImageIcon icon = new ImageIcon(s);
			iconList.add(icon);
		}
		return iconList;
	}
public void clearRow(){
	tablepane.removeAll();
	tablepane1.removeAll();
	tablePane3.removeAll();
	this.binData();
	tablepane.setVisible(false);
	tablepane1.setVisible(false);
	tablePane3.setVisible(false);
	tablepane.setVisible(true);
	tablepane1.setVisible(true);
	tablePane3.setVisible(true);
}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() > 0) {
			t_deskno = e.getComponent().getName();

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().trim().equals("开台")) {
			this.buttonGroup.clearSelection();
			if (t_deskno != null) {
				tableUse = new TableUse();
				tableUse.setT_deskno(t_deskno);
				ArrayList<TableUse> tableUseList = service.getTable(tableUse);
				if (tableUseList.get(0).getT_state().equals("空闲")) {
					JOptionPane.showMessageDialog(this, "开台成功" + "桌名:"
							+ tableUse.getT_deskno());
					tableUse.setT_state("用餐中.....");
					service.updataTable(tableUse);
					this.t_deskno = null;
					this.clearRow();

				} else {
					JOptionPane.showMessageDialog(this, "此桌正在用餐中,请选择别的桌子");
					this.t_deskno = null;
				}
			} else {
				JOptionPane.showMessageDialog(this, "请选择桌子！");
			}
		}
		if (e.getActionCommand().trim().equals("点菜")) {
			this.buttonGroup.clearSelection();
			if (t_deskno != null) {
				tableUse = new TableUse();
				tableUse.setT_deskno(t_deskno);
				ArrayList<TableUse> tableUseList = service.getTable(tableUse);
				if (tableUseList.get(0).getT_state().equals("用餐中.....")) {
					this.t_deskno = null;
					MenuFream menuFream = new MenuFream(tableUse,this.userInfo);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "此桌还没有开台,请先开台");
					this.t_deskno = null;
				}
			} else {
				JOptionPane.showMessageDialog(this, "请选择桌子！");
			}
		}
		if (e.getActionCommand().trim().equals("结账")) {
			this.buttonGroup.clearSelection();
			if (t_deskno != null) {
				tableUse = new TableUse();
				tableUse.setT_deskno(t_deskno);
				ArrayList<TableUse> tableUseList = service.getTable(tableUse);
				if (tableUseList.get(0).getT_state().equals("用餐中.....")) {
					this.t_deskno = null;
					CheckOutJFrame checkOutJFrame = new CheckOutJFrame(tableUse,this.userInfo);
			
				} else {
					JOptionPane.showMessageDialog(this, "此桌还没有开台,请先开台");
					this.t_deskno = null;
				}
			} else {
				JOptionPane.showMessageDialog(this, "请选择桌子！");
			}
		}
		if (e.getActionCommand().trim().equals("员工管理")) {
			ShowUserView showuserView = new ShowUserView(this.userInfo);
		
		}
		if(e.getActionCommand().equals("收入查询")){
			if(this.userInfo.getU_comptce().equals("管理员")){
			FindIncomeJFrame  findIncomeJFrame=new FindIncomeJFrame();
			}
			else{
				JOptionPane.showMessageDialog(this, "你没有权限，请联系管理员");
			}
			}
		if(e.getActionCommand().equals("销售情况查询")){
			if(this.userInfo.getU_comptce().equals("管理员")){
				FindSaleJFrame findSaleJFrame=new FindSaleJFrame();
				}
				else{
					JOptionPane.showMessageDialog(this, "你没有权限，请联系管理员");
				}
				}
		if(e.getActionCommand().equals("顾客反馈情况查询")){
			if(this.userInfo.getU_comptce().equals("管理员")){
				FindCommentJFrame findCommentJFrame=new FindCommentJFrame();
				}
				else{
					JOptionPane.showMessageDialog(this, "你没有权限，请联系管理员");
				}
				}
		if(e.getActionCommand().equals("员工业绩详情查询")){
			FindPersonSaleJFrame findPersonSaleJFrame=new FindPersonSaleJFrame(); 
		}
		if(e.getActionCommand().equals("员工业绩统计查询")){
			FindPersonCountJFrame findPersonCountJFrame=new FindPersonCountJFrame();
		}
		if(e.getActionCommand().equals("刷新")){
			this.clearRow();
		}
		if(e.getActionCommand().equals("点评")){
			CommentJFrame commentJFrame=new CommentJFrame(this.userInfo);
		}
		if(e.getActionCommand().equals("餐桌管理")){
			if(this.userInfo.getU_comptce().equals("管理员")){
			TableManagerJFrame tableManagerJFrame=new TableManagerJFrame();
			}
			else{
				JOptionPane.showMessageDialog(this, "你没有权限，请联系管理员");
			}
		}
		if(e.getActionCommand().equals("菜品管理")){
			if(this.userInfo.getU_comptce().equals("管理员")){
		MenuManagerJFrame menuManagerJFrame=new MenuManagerJFrame();
			}
			else{
				JOptionPane.showMessageDialog(this, "你没有权限，请联系管理员");
			}
		}
		}
	}


