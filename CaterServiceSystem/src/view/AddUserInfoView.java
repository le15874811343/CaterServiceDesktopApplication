package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.UserService;

import entity.UserInfo;
/**
 * �û���Ϣ������
 * @author �ŵ�
 *
 */
public class AddUserInfoView extends JPanel implements ActionListener {

	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JTextField jTextField;
	private JPasswordField jPasswordField;
	private ButtonGroup buttonGroup;
	private ButtonGroup buttonGroup2;
	private JRadioButton jRadioButton;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	private JButton jButton5;
	private JButton jButton6;

	private UserService userservice = new UserService();

	public AddUserInfoView() {

		this.setSize(500, 500);
		this.setLayout(null);
		this.createComponent();
	}

	public void createComponent() {

		this.jLabel = new JLabel("�û���");
		this.jLabel2 = new JLabel("�û�����");
		this.jLabel3 = new JLabel("�Ա�");
		this.jLabel4 = new JLabel("�û�Ȩ��");
		this.jLabel5 = new JLabel("ȷ��");
		this.jLabel6 = new JLabel("����");
		this.jButton5 = new JButton("ȷ��");
		this.jButton6 = new JButton("����");

		this.jTextField = new JTextField(10);
		this.jTextField.setOpaque(false);
		this.jPasswordField = new JPasswordField(10);
		this.jPasswordField.setOpaque(false);
		this.jRadioButton = new JRadioButton("��");
		this.jRadioButton.setOpaque(false);
		this.jRadioButton2 = new JRadioButton("Ů");
		this.jRadioButton2.setOpaque(false);
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton);
		this.buttonGroup.add(jRadioButton2);
		this.jRadioButton3 = new JRadioButton("����Ա");
		this.jRadioButton3.setOpaque(false);
		this.jRadioButton4 = new JRadioButton("����Ա");
		this.jRadioButton4.setOpaque(false);
		this.buttonGroup2 = new ButtonGroup();
		this.buttonGroup2.add(jRadioButton3);
		this.buttonGroup2.add(jRadioButton4);
		jButton5.setLayout(null);
		jLabel5.setBounds(30, 0, 40, 40);
		this.jButton5.add(jLabel5);
		// �ڰ�ť�����ͼƬ
		ImageIcon icon = new ImageIcon("images/4.jpg");
		this.jButton5.setIcon(icon);
		jButton6.setLayout(null);
		jLabel6.setBounds(30, 0, 40, 40);
		jButton6.setIcon(icon);
		this.jButton6.add(jLabel6);

		this.jLabel.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jLabel.setForeground(new Color(92, 167, 186));
		this.jLabel2.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jLabel2.setForeground(new Color(92, 167, 186));
		this.jLabel3.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jLabel3.setForeground(new Color(92, 167, 186));
		this.jLabel4.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jLabel4.setForeground(new Color(92, 167, 186));
		this.jRadioButton.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jRadioButton.setForeground(new Color(137, 190, 178));
		this.jRadioButton2.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jRadioButton2.setForeground(new Color(137, 190, 178));
		this.jRadioButton3.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jRadioButton3.setForeground(new Color(137, 190, 178));
		this.jRadioButton4.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jRadioButton4.setForeground(new Color(137, 190, 178));
		this.jLabel.setBounds(140, 40, 100, 40);
		this.jTextField.setBounds(240, 40, 100, 40);
		this.jLabel2.setBounds(140, 100, 100, 40);
		this.jPasswordField.setBounds(240, 100, 100, 40);
		this.jLabel3.setBounds(140, 160, 100, 40);
		this.jRadioButton.setBounds(240, 160, 100, 40);
		this.jRadioButton2.setBounds(340, 160, 100, 40);
		this.jLabel4.setBounds(140, 220, 100, 40);
		this.jRadioButton3.setBounds(240, 220, 100, 40);
		this.jRadioButton4.setBounds(340, 220, 100, 40);
		this.jButton5.setBounds(140, 320, 100, 40);
		this.jButton6.setBounds(280, 320, 100, 40);
		// ImageIcon icon=new ImageIcon("image/01");
		// jButton5.setIcon(icon);

		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jTextField);
		this.add(jPasswordField);
		this.add(jRadioButton);
		this.add(jRadioButton2);
		this.add(jRadioButton3);
		this.add(jRadioButton4);
		this.add(jButton5);
		this.add(jButton6);
		this.jButton5.addActionListener(this);
		this.jButton6.addActionListener(this);

	}

	public void clearData() {
       this.jTextField.setText("");
       this.jPasswordField.setText("");
       this.buttonGroup.clearSelection();
       this.buttonGroup2.clearSelection();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().trim().equals("ȷ��")) {
			UserInfo newuserinfo = new UserInfo();
			newuserinfo.setU_name(jTextField.getText());
			newuserinfo.setU_password(jPasswordField.getText());
			if (jRadioButton.isSelected()) {
				newuserinfo.setU_sex(jRadioButton.getText());
				if (jRadioButton3.isSelected()) {
					newuserinfo.setU_comptce(jRadioButton3.getText());
				}
				if (jRadioButton4.isSelected()) {
					newuserinfo.setU_comptce(jRadioButton4.getText());
				}
			}
			if (jRadioButton2.isSelected()) {
				newuserinfo.setU_sex(jRadioButton2.getText());
				if (jRadioButton3.isSelected()) {
					newuserinfo.setU_comptce(jRadioButton3.getText());
				}
				if (jRadioButton4.isSelected()) {
					newuserinfo.setU_comptce(jRadioButton4.getText());
				}
			}if(!newuserinfo.getU_name().equals("")&&!newuserinfo.getU_password().equals("")&&newuserinfo.getU_sex()!=null&&newuserinfo.getU_comptce()!=null){
			UserInfo findUserinfo = new UserInfo();
			findUserinfo.setU_name(jTextField.getText());
			if (userservice.getUserInfo(findUserinfo).size() == 0) {
				boolean flag = userservice.addUserInfo(newuserinfo);
				// System.out.println(flag);
				if (flag) {
					JOptionPane.showMessageDialog(this, "��ӳɹ�");
					this.clearData();
				} else {
					JOptionPane.showMessageDialog(this, "���δ�ɹ�");
				}
			} else {
				JOptionPane.showMessageDialog(this, "����ӵ�Ա���Ѵ��ڣ����������");
			}

		}
			else{
				JOptionPane.showMessageDialog(this, "��д����Ϣ��ȫ,�벹��");
			}
		}
		if (e.getActionCommand().trim().equals("����")) {

			this.clearData();
		}

	}
}
