package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import entity.UserInfo;

import service.UserService;

/**
 * 个人信息面板
 * 
 * @author 张丹
 * 
 */
public class UserInfoView extends JPanel implements ActionListener {

	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField jTextField;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField4;
	private JButton jButton;
	private UserService userservice = new UserService();
	private UserInfo userinfo;

	public UserInfoView(UserInfo userInfo) {
		this.setSize(500, 500);
		this.setLayout(null);
		this.userinfo = userInfo;
		this.createComponent();
		this.bindData();
	}

	public UserInfoView() {
		this.setSize(500, 500);
		this.setLayout(null);

		this.createComponent();
	}

	public void createComponent() {
		this.jButton = new JButton("修改");
		this.jTextField2 = new JTextField(10);
		this.jTextField2.setOpaque(false);
		this.jTextField3 = new JTextField(10);
		this.jTextField3.setOpaque(false);
		this.jLabel = new JLabel("用户名:");
		this.jLabel2 = new JLabel("用户密码:");
		this.jLabel3 = new JLabel("性别:");
		this.jLabel4 = new JLabel("用户权限:");
		this.jTextField = new JTextField(10);
		this.jTextField.setOpaque(false);
		this.jTextField4 = new JTextField();
		this.jTextField4.setOpaque(false);
		this.jTextField.setEditable(false);
		this.jTextField2.setEditable(false);
		this.jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel.setForeground(new Color(92, 167, 186));
		this.jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel2.setForeground(new Color(92, 167, 186));
		this.jLabel3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel3.setForeground(new Color(92, 167, 186));
		this.jLabel4.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel4.setForeground(new Color(92, 167, 186));
		this.jButton.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jButton.setForeground(new Color(92, 167, 186));
		this.jLabel.setBounds(140, 90, 100, 30);
		this.jTextField.setBounds(240, 90, 100, 30);
		this.jLabel2.setBounds(140, 150, 100, 30);
		this.jTextField4.setBounds(240, 150, 100, 30);
		this.jLabel3.setBounds(140, 210, 100, 30);
		this.jTextField2.setBounds(240, 210, 100, 30);
		this.jLabel4.setBounds(140, 270, 100, 30);
		this.jTextField3.setBounds(240, 270, 100, 30);
		this.jButton.setBounds(200, 350, 100, 40);
		this.jTextField3.setEditable(false);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jTextField);
		this.add(jTextField4);
		this.add(jTextField2);
		this.add(jTextField3);
		this.add(jButton);
		this.jButton.addActionListener(this);

	}

	public void bindData() {
		UserInfo findUserInfo = new UserInfo();
		findUserInfo.setU_id(this.userinfo.getU_id());
		List<UserInfo> user = userservice.getUserInfo(findUserInfo);
		this.jTextField.setText(user.get(0).getU_name());
		this.jTextField4.setText(user.get(0).getU_password());
		this.jTextField2.setText(user.get(0).getU_sex());
		this.jTextField3.setText(user.get(0).getU_comptce());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("修改")) {
			UserInfo newuserinfo = new UserInfo();
			newuserinfo.setU_name(this.userinfo.getU_name());
			newuserinfo.setU_password(this.jTextField4.getText());
			newuserinfo.setU_sex(this.userinfo.getU_sex());
			newuserinfo.setU_comptce(this.userinfo.getU_comptce());
			UserInfo olduserinfo = new UserInfo();
			olduserinfo.setU_name(this.userinfo.getU_name());
			if (userservice.updataUserInfo(newuserinfo, olduserinfo)) {
				JOptionPane.showMessageDialog(this, "修改成功");
				this.bindData();
			}
		}
	}

}
