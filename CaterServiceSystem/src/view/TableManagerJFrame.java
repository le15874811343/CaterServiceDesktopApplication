package view;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import entity.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.*;
/**
 * ���ӹ�����
 * @author �ּ���
 *
 */
public class TableManagerJFrame extends JDialog implements TreeSelectionListener ,ActionListener{
	private TableManagerPanel managerPanel = new TableManagerPanel();
	private JButton jButton;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
    private JTree jTree;
    private DefaultMutableTreeNode rootNode;
    private TableJTable tableJTable=new TableJTable();
    private AddTablePanel addTablePanel=new AddTablePanel();
    private DeleteTablePanel deleteTablePanel=new DeleteTablePanel();
    private UpdataTablePanel updataTablePanel=new UpdataTablePanel();
	public TableManagerJFrame() {
		this.setContentPane(managerPanel);
		// ���ñ������
		this.setFont(new Font("system", Font.PLAIN, 12));
		Font f = this.getFont();
		this.toFront();

		FontMetrics fm = this.getFontMetrics(f);
		int x = fm.stringWidth("��������ϵͳ������ӭ�û�ʹ��");
		int y = fm.stringWidth(" ");
		int z = this.getWidth() / 2 - (x / 2);
		int w = z / y;
		String pad = String.format("%" + w + "s", " ");
		this.setTitle(pad + "��������ϵͳ������ӭ�û�ʹ��");
		this.setSize(700, 700);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.init();
		this.bindData();
		this.setFocusable(true);
		this.setVisible(true);
	}

	public void init() {
		tableJTable.setBackground(new Color(201, 186, 131));
		addTablePanel.setBackground(new Color(201, 186, 131));
		deleteTablePanel.setBackground(new Color(201, 186, 131));
		updataTablePanel.setBackground(new Color(201, 186, 131));
		this.rootNode=new DefaultMutableTreeNode("��������");
		this.jButton = new JButton("ϵͳ��ҳ");
		this.jButton.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jButton.setForeground(new Color(137,190,178));
		this.jButton2 = new JButton("ˢ��");
		this.jButton2.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jButton2.setForeground(new Color(137,190,178));
		this.jButton3 = new JButton("ǰһ��");
		this.jButton3.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jButton3.setForeground(new Color(137,190,178));
		this.jButton4 = new JButton("��һ��");
		this.jButton4.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jButton4.setForeground(new Color(137,190,178));
		this.jButton5 = new JButton("��ȫ�˳�");
		this.jButton5.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jButton5.setForeground(new Color(137,190,178));
		this.jButton.setBounds(180, 40, 100, 30);
		this.jButton2.setBounds(300, 40, 80, 30);
		this.jButton3.setBounds(400, 40, 80, 30);
		this.jButton4.setBounds(500, 40, 80, 30);
		this.jButton5.setBounds(600, 40, 100, 30);
     this.jTree=new JTree(rootNode);
     DefaultMutableTreeNode rootNode1=new DefaultMutableTreeNode("������Ϣ");
     DefaultMutableTreeNode rootNode2=new DefaultMutableTreeNode("�������");
     DefaultMutableTreeNode rootNode3=new DefaultMutableTreeNode("����ɾ��");
     DefaultMutableTreeNode rootNode4=new DefaultMutableTreeNode("�����޸�");
     this.rootNode.add(rootNode1);
     this.rootNode.add(rootNode2);
     this.rootNode.add(rootNode3);
     this.rootNode.add(rootNode4);
     this.jTree.setBounds(0, 120, 150, 400);
     this.jTree.setFont(new Font("�����п�", Font.PLAIN, 14));
 	DefaultTreeCellRenderer cellRenderer =(DefaultTreeCellRenderer)this.jTree.getCellRenderer();
	//cellRenderer.setBackgroundNonSelectionColor(Color.red);
	cellRenderer.setBackgroundSelectionColor(new Color(92, 167, 186));
	//cellRenderer.setBorderSelectionColor(Color.red);
	cellRenderer.setTextNonSelectionColor(new Color(137,190,178));
     this.jTree.setOpaque(false);
     this.add(jTree);
     this.add(jButton);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jButton4);
		this.add(jButton5);
     this.jTree.addTreeSelectionListener(this);
     this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.jButton3.addActionListener(this);
		this.jButton4.addActionListener(this);
		this.jButton5.addActionListener(this);
	}

	public void bindData() {
	
	}
	/**
	 * ��ʾ���
	 * 
	 * @param jPanel
	 */
	public void showJPane(JPanel jPanel) {
		this.add(jPanel);
		jPanel.setBounds(180, 100, 500, 500);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		String rootname = e.getPath().getLastPathComponent().toString();
		if(rootname.trim().equals("��������")){
			this.updataTablePanel.setVisible(false);
			this.addTablePanel.setVisible(false);
			this.deleteTablePanel.setVisible(false);
			this.tableJTable.setVisible(false);
		}
		if(rootname.trim().equals("������Ϣ")){
			this.updataTablePanel.setVisible(false);
			this.addTablePanel.setVisible(false);
			this.deleteTablePanel.setVisible(false);
			this.tableJTable.clearRow();
			this.tableJTable.setVisible(true);
			
			this.showJPane(tableJTable);
		}
		if(rootname.trim().equals("�������")){
			this.updataTablePanel.setVisible(false);
			this.tableJTable.setVisible(false);
			this.deleteTablePanel.setVisible(false);
			this.addTablePanel.setVisible(true);
			this.showJPane(addTablePanel);
		}
		if(rootname.trim().equals("����ɾ��")){
			this.updataTablePanel.setVisible(false);
			this.tableJTable.setVisible(false);
			this.addTablePanel.setVisible(false);
            this.deleteTablePanel.clearElements();
			this.deleteTablePanel.setVisible(true);
			this.showJPane(deleteTablePanel);
		}
		if(rootname.trim().equals("�����޸�")){
			this.tableJTable.setVisible(false);
			this.addTablePanel.setVisible(false);
			this.deleteTablePanel.setVisible(false);
			this.updataTablePanel.clearElement();
			this.updataTablePanel.setVisible(true);
			this.showJPane(updataTablePanel);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().trim().equals("��ȫ�˳�")) {

			this.dispose();
		}

		if (e.getActionCommand().trim().equals("ϵͳ��ҳ")) {
			this.updataTablePanel.setVisible(false);
			this.addTablePanel.setVisible(false);
			this.deleteTablePanel.setVisible(false);
			this.tableJTable.setVisible(false);

		}
		if (e.getActionCommand().trim().equals("ˢ��")) {
		updataTablePanel.clearElement();
		deleteTablePanel.clearElements();
		tableJTable.clearRow();

		}
	}
}
