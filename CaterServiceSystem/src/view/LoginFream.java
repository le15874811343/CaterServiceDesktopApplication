package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.UserService;

import dao.UserDao;

import entity.UserInfo;

/**
 * �û���¼����
 * 
 * @author �ּ���
 * 
 */
public class LoginFream extends JFrame implements ActionListener {
	private JButton button;
	private JButton button2;
	private JLabel jLabel;
	private JLabel jLabel2;
	private JTextField jTextField;
	private JPasswordField jPasswordField;
	private JRadioButton jRadioButton;
	private JRadioButton jRadioButton2;
	private ButtonGroup buttonGroup;
	private LoginFreamPanel freamPanel = new LoginFreamPanel();
 private UserService service=new UserService();
	public LoginFream() {
		this.setTitle("��¼");// ���ñ���
		this.setSize(400, 400);// ���ý����С
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(freamPanel);
		this.setLocationRelativeTo(null);// ���õ�ǰ��������λ��
		this.setLayout(null);// ���õ�ǰ����ղ���
		this.init();// ��Ŵ�����ʾ����

		this.setUndecorated(true);
		this.setVisible(true);// �Ƿ���ʾ�ɼ�
	}

	public void init() {
		this.button = new JButton("��¼");
		ImageIcon icon = new ImageIcon("images/��¼.png");
		this.button.setIcon(icon);

		ImageIcon icon1 = new ImageIcon("images/ȡ��.png");
		this.button2 = new JButton("ȡ��");
		this.button2.setIcon(icon1);
		this.jLabel = new JLabel("�˺ţ�");
		this.jLabel2 = new JLabel("���룺");
		this.jTextField = new JTextField();
		this.jPasswordField = new JPasswordField();
		this.jRadioButton = new JRadioButton("����Ա");
		this.jRadioButton2 = new JRadioButton("����Ա");
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton);
		this.buttonGroup.add(jRadioButton2);
		this.jLabel.setBounds(100, 100, 100, 40);
		this.jTextField.setBounds(150, 105, 150, 30);
		this.jLabel2.setBounds(100, 160, 100, 40);
		this.jPasswordField.setBounds(150, 165, 150, 30);
		this.button.setBounds(100, 250, 80, 30);
		this.button2.setBounds(220, 250, 80, 30);
		this.jRadioButton.setBounds(100, 200, 80, 30);
		this.jRadioButton2.setBounds(240, 200, 80, 30);
		this.jRadioButton.setOpaque(false);
		this.jRadioButton2.setOpaque(false);
		this.jTextField.setOpaque(false);
		this.jPasswordField.setOpaque(false);
		this.add(jRadioButton);
		this.add(jRadioButton2);
		this.add(jLabel);
		this.add(jTextField);
		this.add(jLabel2);
		this.add(jPasswordField);
		this.add(button);
		this.add(button2);
		this.button2.addActionListener(this);
		this.button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().trim().equals("ȡ��")) {
			this.dispose();
		}
		if (e.getActionCommand().trim().equals("��¼")) {
			UserInfo userinfo=new UserInfo();
			userinfo.setU_name(jTextField.getText());
			userinfo.setU_password(jPasswordField.getText());
			  if(jRadioButton.isSelected())
		         {
		        	userinfo.setU_comptce("����Ա");
		         }
		         if(jRadioButton2.isSelected())
		         {
		        	userinfo.setU_comptce("����Ա");
		         }
          if( jTextField.getText().equals("")||jPasswordField.getText().equals("")||jRadioButton.isSelected()==false&jRadioButton2.isSelected()==false)
          {
        	  JOptionPane.showMessageDialog(this, "�û���Ϣ��ȫ���벹��");
      }
          else{
        	  if(service.login(userinfo)!=null){
        			Service1frame serviceFream = new Service1frame(service.login(userinfo));
        			this.dispose();
        	  }
        	  else{
        		  userinfo.setU_comptce(null);
        		  if(service.login(userinfo)!=null){
        			  JOptionPane.showMessageDialog(this, "��ѡ��������Ϣ����");
        		  }
        		  else if(service.login(userinfo)==null){
        			  JOptionPane.showMessageDialog(this, "��������û�������Ϣ����");
        		  }
        	  }
          }
		}
	}
}
