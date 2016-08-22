package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import entity.UserInfo;

/**
 * Ա��������Ϣ����
 * 
 * @author �ŵ�
 * 
 */
public class ShowUserView extends JDialog  implements ActionListener,
		TreeSelectionListener {

	private JTree jTree;// ���ؼ�
	private DefaultMutableTreeNode rootnode;// ģ�ͽڵ�

	private JLabel jLabel;//
	private JTextField jTextField;
	private JButton jButton;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;

	// private FirstPage firstPage=new FirstPage();

	private ColorJPone colorJPone = new ColorJPone();
	private JTableView jTableView = new JTableView();
	private AddUserInfoView userview = new AddUserInfoView();
	private UpdataUserView updataview=new UpdataUserView();
	private DeleteUserView deleteview=new DeleteUserView();
	private UserInfoView userinfoview=new UserInfoView();
 private UserInfo userInfo;
	public ShowUserView(UserInfo userInfo) {

		this.setContentPane(colorJPone);
		// ���ñ������
		this.setFont(new Font("system", Font.PLAIN, 12));
		Font f = this.getFont();
		this.toFront();

		FontMetrics fm = this.getFontMetrics(f);
		int x = fm.stringWidth("�û�����ϵͳ������ӭ�û�ʹ��");
		int y = fm.stringWidth(" ");
		int z = this.getWidth() / 2 - (x / 2);
		int w = z / y;
		String pad = String.format("%" + w + "s", " ");
		this.setTitle(pad + "�û�����ϵͳ������ӭ�û�ʹ��");
		this.setSize(700, 700);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
this.setModal(true);
		this.init();
		this.userInfo=userInfo;
		this.bindData();
		this.setFocusable(true);
		this.setVisible(true);

	}

	public void init() {
        //magenta �ۺ� 
		userview.setBackground(new Color(201, 186, 131));
		jTableView.setBackground(new Color(201, 186, 131));
		updataview.setBackground(new Color(201, 186, 131));
		deleteview.setBackground(new Color(201, 186, 131));
		userinfoview.setBackground(new Color(201, 186, 131));
		this.jLabel = new JLabel("��ǰ�û���");
		// this.jLabel.setBackground(Color.blue);
		//���������ֱ��ʾ�� ���壬��ʽ�����壬б��ȣ����ֺ�
		this.jLabel.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jLabel.setForeground(new Color(92, 167, 186));
		this.jTextField = new JTextField(10);
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

		this.jLabel.setBounds(400, 0, 100, 30);
		this.jTextField.setBounds(500, 0, 100, 30);
		this.jTextField.setEditable(false);
		this.jButton.setBounds(180, 40, 100, 30);
		this.jButton2.setBounds(300, 40, 80, 30);
		this.jButton3.setBounds(400, 40, 80, 30);
		this.jButton4.setBounds(500, 40, 80, 30);
		this.jButton5.setBounds(600, 40, 100, 30);
		this.jTextField.setOpaque(false);
		this.rootnode = new DefaultMutableTreeNode("Ա������");
		this.jTree = new JTree(rootnode);
		DefaultMutableTreeNode rootnode2 = new DefaultMutableTreeNode("Ա���б�");
		DefaultMutableTreeNode rootnode3 = new DefaultMutableTreeNode("���Ա��");
		DefaultMutableTreeNode rootnode4 = new DefaultMutableTreeNode("�޸�Ա����Ϣ");
		DefaultMutableTreeNode rootnode5 = new DefaultMutableTreeNode("ɾ��Ա��");
		DefaultMutableTreeNode rootnode6 = new DefaultMutableTreeNode("������Ϣ");
		this.jTree.setOpaque(false);
		// this.jTree.setBackground(Color.);
		this.jTree.setFont(new Font("�����п�", Font.PLAIN, 14));
		DefaultTreeCellRenderer cellRenderer =(DefaultTreeCellRenderer)this.jTree.getCellRenderer();
		
		//cellRenderer.setBackgroundNonSelectionColor(Color.red);
		cellRenderer.setBackgroundSelectionColor(new Color(92, 167, 186));
		//cellRenderer.setBorderSelectionColor(Color.red);
		cellRenderer.setTextNonSelectionColor(new Color(137,190,178));
				
		this.jTree.repaint();
		this.rootnode.add(rootnode2);
		this.rootnode.add(rootnode3);
		this.rootnode.add(rootnode4);
		this.rootnode.add(rootnode5);
		this.rootnode.add(rootnode6);
		this.add(jLabel);
		this.add(jTextField);
		this.add(jButton);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jButton4);
		this.add(jButton5);
		this.add(jTree);
		this.jTree.setBounds(0, 120, 150, 400);
		this.jTree.addTreeSelectionListener(this);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);
		this.jButton3.addActionListener(this);
		this.jButton4.addActionListener(this);
		this.jButton5.addActionListener(this);

	}

	public void bindData() {
  this.jTextField.setText(this.userInfo.getU_name());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().trim().equals("ϵͳ��ҳ")) {
			jTableView.setVisible(false);
			userview.setVisible(false);
			updataview.setVisible(false);
			deleteview.setVisible(false);
			userinfoview.setVisible(false);

		}
		if (e.getActionCommand().trim().equals("ˢ��")) {
			jTableView.clearRow();
			userview.clearData();
			updataview.clearElement();
			deleteview.clearElement();
			userinfoview.bindData();
		}
		if (e.getActionCommand().trim().equals("ǰһ��")) {

			
		}
		if (e.getActionCommand().trim().equals("��һ��")) {

		}
		if (e.getActionCommand().trim().equals("��ȫ�˳�")) {

			this.dispose();
		}

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

		if (rootname.trim().equals("Ա������")) {

			jTableView.setVisible(false);
			userview.setVisible(false);
			updataview.setVisible(false);
			deleteview.setVisible(false);
			userinfoview.setVisible(false);

			// firstPage.setVisible(true);
			// showJPane(firstPage);

		}
		if (rootname.trim().equals("Ա���б�")) {
			// firstPage.setVisible(false);
			if(this.userInfo.getU_comptce().equals("����Ա")){
			userview.setVisible(false);
			updataview.setVisible(false);
			deleteview.setVisible(false);
			userinfoview.setVisible(false);
			jTableView.clearRow();
			jTableView.setVisible(true);
			showJPane(jTableView);
			}
			else{
				JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
			}

		}
		if (rootname.trim().equals("���Ա��")) {
			// firstPage.setVisible(false);
			if(this.userInfo.getU_comptce().equals("����Ա")){
			jTableView.setVisible(false);
			updataview.setVisible(false);
			deleteview.setVisible(false);
			userinfoview.setVisible(false);
			userview.clearData();
			userview.setVisible(true);
			showJPane(userview);
			}
			else{
				JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
			}
		}
		if (rootname.trim().equals("�޸�Ա����Ϣ")) {
			if(this.userInfo.getU_comptce().equals("����Ա")){
			jTableView.setVisible(false);
			userview.setVisible(false);
			deleteview.setVisible(false);
			userinfoview.setVisible(false);
			updataview.clearElement();
			updataview.setVisible(true);
			showJPane(updataview);
			}
			else{
				JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
			}
		}
		if (rootname.trim().equals("ɾ��Ա��")) {
if(this.userInfo.getU_comptce().equals("����Ա")){
			jTableView.setVisible(false);
			userview.setVisible(false);
			updataview.setVisible(false);
			userinfoview.setVisible(false);
			deleteview.clearElement();
			deleteview.setVisible(true);
			showJPane(deleteview);
}
else{
	JOptionPane.showMessageDialog(this, "��û��Ȩ�ޣ�����ϵ����Ա");
}
		}
		if (rootname.trim().equals("������Ϣ")) {
			userinfoview=new UserInfoView(this.userInfo);
			userinfoview.setBackground(new Color(201, 186, 131));
			jTableView.setVisible(false);
			userview.setVisible(false);
			updataview.setVisible(false);
			deleteview.setVisible(false);
			userinfoview.bindData();
			userinfoview.setVisible(true);
			showJPane(userinfoview);
		}
		

	}

}
