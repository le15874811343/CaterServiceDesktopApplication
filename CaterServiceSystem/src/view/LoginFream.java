package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.UserService;

import dao.UserDao;

import entity.UserInfo;

/**
 * 用户登录窗体
 * 
 * @author 乐家良
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
		this.setTitle("登录");// 设置标题
		this.setSize(400, 400);// 设置界面大小
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(freamPanel);
		this.setLocationRelativeTo(null);// 设置当前窗体所在位置
		this.setLayout(null);// 设置当前窗体空布局
		this.init();// 存放窗体显示代码

		this.setUndecorated(true);
		this.setVisible(true);// 是否显示可见
	}

	public void init() {
		this.button = new JButton("登录");
		ImageIcon icon = new ImageIcon("images/登录.png");
		this.button.setIcon(icon);

		ImageIcon icon1 = new ImageIcon("images/取消.png");
		this.button2 = new JButton("取消");
		this.button2.setIcon(icon1);
		this.jLabel = new JLabel("账号：");
		this.jLabel2 = new JLabel("密码：");
		this.jTextField = new JTextField();
		this.jPasswordField = new JPasswordField();
		this.jRadioButton = new JRadioButton("管理员");
		this.jRadioButton2 = new JRadioButton("服务员");
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
		if (e.getActionCommand().trim().equals("取消")) {
			this.dispose();
		}
		if (e.getActionCommand().trim().equals("登录")) {
			UserInfo userinfo=new UserInfo();
			userinfo.setU_name(jTextField.getText());
			userinfo.setU_password(jPasswordField.getText());
			  if(jRadioButton.isSelected())
		         {
		        	userinfo.setU_comptce("管理员");
		         }
		         if(jRadioButton2.isSelected())
		         {
		        	userinfo.setU_comptce("服务员");
		         }
          if( jTextField.getText().equals("")||jPasswordField.getText().equals("")||jRadioButton.isSelected()==false&jRadioButton2.isSelected()==false)
          {
        	  JOptionPane.showMessageDialog(this, "用户信息不全，请补充");
      }
          else{
        	  if(service.login(userinfo)!=null){
        			Service1frame serviceFream = new Service1frame(service.login(userinfo));
        			this.dispose();
        	  }
        	  else{
        		  userinfo.setU_comptce(null);
        		  if(service.login(userinfo)!=null){
        			  JOptionPane.showMessageDialog(this, "您选择的身份信息有误");
        		  }
        		  else if(service.login(userinfo)==null){
        			  JOptionPane.showMessageDialog(this, "您输入的用户密码信息错误");
        		  }
        	  }
          }
		}
	}
}
