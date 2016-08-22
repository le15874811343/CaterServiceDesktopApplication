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
 * ��̨����
 * @author �ּ���
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

		this.setTitle("��̨����");
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
		this.jButton2 = new JButton("��̨");
		this.jButton3 = new JButton("���");
		this.jButton4 = new JButton("����");
		this.jButton5 = new JButton("ˢ��");
		this.jButton6 = new JButton("����");
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
		tab.add(jScrollPane, "С��");
		tab.add(jScrollPane1, "����");
		tab.add(jScrollPane2, "����");
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
		this.jMenu=new JMenu("��ѯ");
		this.jMenuItem2=new JMenuItem("�����ѯ");
		this.jMenu.add(jMenuItem2);
		this.jMenu.addSeparator();
		JMenuItem jMenuItem3=new JMenuItem("���������ѯ");
		this.jMenu.add(jMenuItem3);
		JMenuItem jMenuItem6=new JMenuItem("�˿ͷ��������ѯ");
		this.jMenu.addSeparator();
		this.jMenu.add(jMenuItem6);
		JMenuItem jMenuItem7=new JMenuItem("Ա��ҵ�������ѯ");
		this.jMenu.addSeparator();
		this.jMenu.add(jMenuItem7);
		JMenuItem jMenuItem8=new JMenuItem("Ա��ҵ��ͳ�Ʋ�ѯ");
		this.jMenu.addSeparator();
		this.jMenu.add(jMenuItem8);
		jMenu2 = new JMenu("�˻�");
		this.jMenuItem = new JMenuItem("Ա������");
		this.jMenu2.add(jMenuItem);
		this.jMenu3=new JMenu("����");
		JMenuItem jMenuItem4=new JMenuItem("��������");
		JMenuItem jMenuItem5=new JMenuItem("��Ʒ����");
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
			if (tableList.get(i).getT_note().equals("С��")) {
				ArrayList<ImageIcon> minIcon = this.getMinTableImage();
				this.jButton = new JButton(minIcon.get(mixcount));
				mixcount++;
				this.jButton.setName(tableList.get(i).getT_deskno());
				jButton.setLayout(null);
				JRadioButton jRadioButton = new JRadioButton(tableList.get(i)
						.getT_deskno() + "����");
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
			if (tableList.get(i).getT_note().equals("����")) {
				ArrayList<ImageIcon> maxIcons = this.getMaxTableImage();
				this.jButton = new JButton(maxIcons.get(maxcount));
				maxcount++;
				this.jButton.setName(tableList.get(i).getT_deskno());
				jButton.setLayout(null);
				JRadioButton jRadioButton = new JRadioButton(tableList.get(i)
						.getT_deskno() + "����");
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
			if (tableList.get(i).getT_note().equals("����")) {
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
	 * ���С����ͼƬ�ķ���
	 * 
	 * @return
	 */
	public ArrayList<ImageIcon> getMinTableImage() {
		ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
		ArrayList<String> tableName=new ArrayList<String>();
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = service.getTable(tableUse);
		for(TableUse t:tableList){
			if(t.getT_note().equals("С��")){
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
	 * ��Ŵ�����ͼƬ
	 * 
	 * @return
	 */
	public ArrayList<ImageIcon> getMaxTableImage() {
		ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
		ArrayList<String> tableName=new ArrayList<String>();
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = service.getTable(tableUse);
		for(TableUse t:tableList){
			if(t.getT_note().equals("����")){
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
	 * ��Ű��ᱳ���ķ���
	 * 
	 * @return
	 */
	public ArrayList<ImageIcon> getBoxTableImage() {
		ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
		ArrayList<String> tableName=new ArrayList<String>();
		TableUse tableUse = new TableUse();
		ArrayList<TableUse> tableList = service.getTable(tableUse);
		for(TableUse t:tableList){
			if(t.getT_note().equals("����")){
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
		if (e.getActionCommand().trim().equals("��̨")) {
			this.buttonGroup.clearSelection();
			if (t_deskno != null) {
				tableUse = new TableUse();
				tableUse.setT_deskno(t_deskno);
				ArrayList<TableUse> tableUseList = service.getTable(tableUse);
				if (tableUseList.get(0).getT_state().equals("����")) {
					JOptionPane.showMessageDialog(this, "��̨�ɹ�" + "����:"
							+ tableUse.getT_deskno());
					tableUse.setT_state("�ò���.....");
					service.updataTable(tableUse);
					this.t_deskno = null;
					this.clearRow();

				} else {
					JOptionPane.showMessageDialog(this, "���������ò���,��ѡ��������");
					this.t_deskno = null;
				}
			} else {
				JOptionPane.showMessageDialog(this, "��ѡ�����ӣ�");
			}
		}
		if (e.getActionCommand().trim().equals("���")) {
			this.buttonGroup.clearSelection();
			if (t_deskno != null) {
				tableUse = new TableUse();
				tableUse.setT_deskno(t_deskno);
				ArrayList<TableUse> tableUseList = service.getTable(tableUse);
				if (tableUseList.get(0).getT_state().equals("�ò���.....")) {
					this.t_deskno = null;
					MenuFream menuFream = new MenuFream(tableUse,this.userInfo);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "������û�п�̨,���ȿ�̨");
					this.t_deskno = null;
				}
			} else {
				JOptionPane.showMessageDialog(this, "��ѡ�����ӣ�");
			}
		}
		if (e.getActionCommand().trim().equals("����")) {
			this.buttonGroup.clearSelection();
			if (t_deskno != null) {
				tableUse = new TableUse();
				tableUse.setT_deskno(t_deskno);
				ArrayList<TableUse> tableUseList = service.getTable(tableUse);
				if (tableUseList.get(0).getT_state().equals("�ò���.....")) {
					this.t_deskno = null;
					CheckOutJFrame checkOutJFrame = new CheckOutJFrame(tableUse,this.userInfo);
			
				} else {
					JOptionPane.showMessageDialog(this, "������û�п�̨,���ȿ�̨");
					this.t_deskno = null;
				}
			} else {
				JOptionPane.showMessageDialog(this, "��ѡ�����ӣ�");
			}
		}
		if (e.getActionCommand().trim().equals("Ա������")) {
			ShowUserView showuserView = new ShowUserView(this.userInfo);
		
		}
		if(e.getActionCommand().equals("�����ѯ")){
			if(this.userInfo.getU_comptce().equals("����Ա")){
			FindIncomeJFrame  findIncomeJFrame=new FindIncomeJFrame();
			}
			else{
				JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
			}
			}
		if(e.getActionCommand().equals("���������ѯ")){
			if(this.userInfo.getU_comptce().equals("����Ա")){
				FindSaleJFrame findSaleJFrame=new FindSaleJFrame();
				}
				else{
					JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
				}
				}
		if(e.getActionCommand().equals("�˿ͷ��������ѯ")){
			if(this.userInfo.getU_comptce().equals("����Ա")){
				FindCommentJFrame findCommentJFrame=new FindCommentJFrame();
				}
				else{
					JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
				}
				}
		if(e.getActionCommand().equals("Ա��ҵ�������ѯ")){
			FindPersonSaleJFrame findPersonSaleJFrame=new FindPersonSaleJFrame(); 
		}
		if(e.getActionCommand().equals("Ա��ҵ��ͳ�Ʋ�ѯ")){
			FindPersonCountJFrame findPersonCountJFrame=new FindPersonCountJFrame();
		}
		if(e.getActionCommand().equals("ˢ��")){
			this.clearRow();
		}
		if(e.getActionCommand().equals("����")){
			CommentJFrame commentJFrame=new CommentJFrame(this.userInfo);
		}
		if(e.getActionCommand().equals("��������")){
			if(this.userInfo.getU_comptce().equals("����Ա")){
			TableManagerJFrame tableManagerJFrame=new TableManagerJFrame();
			}
			else{
				JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
			}
		}
		if(e.getActionCommand().equals("��Ʒ����")){
			if(this.userInfo.getU_comptce().equals("����Ա")){
		MenuManagerJFrame menuManagerJFrame=new MenuManagerJFrame();
			}
			else{
				JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
			}
		}
		}
	}


