package view;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import service.TableService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ��Ʒ������
 * @author �ּ���
 *
 */
public class MenuManagerJFrame extends JDialog implements ActionListener,TreeSelectionListener{
	private MenuManagerPanel managerPanel = new MenuManagerPanel();
	private JButton jButton;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
    private JTree jTree;
    private DefaultMutableTreeNode rootNode;
    private MenuJTable menuJTable=new MenuJTable();
 
    private AddMenuPanel addMenuPanel=new AddMenuPanel();
    private DeleteMenuPanel deleteMenuPanel=new DeleteMenuPanel();
    private UpdataMenuPanel updataMenuPanel=new UpdataMenuPanel();
	public MenuManagerJFrame() {
		this.setContentPane(managerPanel);
		// ���ñ������
		this.setFont(new Font("system", Font.PLAIN, 12));
		Font f = this.getFont();
		this.toFront();

		FontMetrics fm = this.getFontMetrics(f);
		int x = fm.stringWidth("��Ʒ����ϵͳ������ӭ�û�ʹ��");
		int y = fm.stringWidth(" ");
		int z = this.getWidth() / 2 - (x / 2);
		int w = z / y;
		String pad = String.format("%" + w + "s", " ");
		this.setTitle(pad + "��Ʒ����ϵͳ������ӭ�û�ʹ��");
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
		menuJTable.setBackground(new Color(201, 186, 131));
		addMenuPanel.setBackground(new Color(201, 186, 131));
		deleteMenuPanel.setBackground(new Color(201, 186, 131));
		updataMenuPanel.setBackground(new Color(201, 186, 131));
		this.rootNode=new DefaultMutableTreeNode("��Ʒ����");
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
     DefaultMutableTreeNode rootNode1=new DefaultMutableTreeNode("��Ʒ��Ϣ");
     DefaultMutableTreeNode rootNode2=new DefaultMutableTreeNode("��Ʒ���");
     DefaultMutableTreeNode rootNode3=new DefaultMutableTreeNode("��Ʒɾ��");
     DefaultMutableTreeNode rootNode4=new DefaultMutableTreeNode("��Ʒ�޸�");
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
		if(rootname.trim().equals("��Ʒ����")){
			this.updataMenuPanel.setVisible(false);
			this.addMenuPanel.setVisible(false);
			this.deleteMenuPanel.setVisible(false);
			this.menuJTable.setVisible(false);
		}
		if(rootname.trim().equals("��Ʒ��Ϣ")){
			this.updataMenuPanel.setVisible(false);
			this.addMenuPanel.setVisible(false);
			this.deleteMenuPanel.setVisible(false);
			this.menuJTable.clearRow();
			this.menuJTable.setVisible(true);
			
			this.showJPane(menuJTable);
		}
		if(rootname.trim().equals("��Ʒ���")){
			this.updataMenuPanel.setVisible(false);
			this.menuJTable.setVisible(false);
			this.deleteMenuPanel.setVisible(false);
			this.addMenuPanel.setVisible(true);
			this.showJPane(addMenuPanel);
		}
		if(rootname.trim().equals("��Ʒɾ��")){
			this.updataMenuPanel.setVisible(false);
			this.menuJTable.setVisible(false);
			this.addMenuPanel.setVisible(false);
            this.deleteMenuPanel.clearElements();
			this.deleteMenuPanel.setVisible(true);
			this.showJPane(deleteMenuPanel);
		}
		if(rootname.trim().equals("��Ʒ�޸�")){
			this.menuJTable.setVisible(false);
			this.addMenuPanel.setVisible(false);
			this.deleteMenuPanel.setVisible(false);
			this.updataMenuPanel.clearElement();
			this.updataMenuPanel.setVisible(true);
			this.showJPane(updataMenuPanel);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().trim().equals("��ȫ�˳�")) {

			this.dispose();
		}

		if (e.getActionCommand().trim().equals("ϵͳ��ҳ")) {
			this.updataMenuPanel.setVisible(false);
			this.addMenuPanel.setVisible(false);
			this.deleteMenuPanel.setVisible(false);
			this.menuJTable.setVisible(false);

		}
		if (e.getActionCommand().trim().equals("ˢ��")) {
		updataMenuPanel.clearElement();
		deleteMenuPanel.clearElements();
		menuJTable.clearRow();

		}
	}
}

