package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import service.UserService;

import entity.UserInfo;
/**
 * 删除用户信息面板
 * @author 张丹
 *
 */
public class DeleteUserView extends JPanel implements ActionListener,
		ItemListener {

	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JComboBox jComboBox;
	private DefaultComboBoxModel dcm;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JPasswordField jPasswordField;
	private JButton jButton5;
	private JButton jButton6;

	private UserService userservice = new UserService();
	private List<UserInfo> userList = new ArrayList<UserInfo>();
	private UserInfo userinfo = new UserInfo();

	public DeleteUserView() {
		this.setSize(500, 500);
		this.setLayout(null);
		this.createComponent();
		this.bindData();
	}

	public void createComponent() {
		this.jTextField2 = new JTextField(10);
		this.jTextField2.setOpaque(false);
		this.jTextField3 = new JTextField(10);
		this.jTextField3.setOpaque(false);
		this.jComboBox = new JComboBox();
		this.jComboBox.setOpaque(false);
		this.dcm = new DefaultComboBoxModel();
		this.jLabel5 = new JLabel("用户名:");// 查询条件

		this.jLabel2 = new JLabel("用户密码:");
		this.jLabel3 = new JLabel("性别:");
		this.jLabel4 = new JLabel("用户权限:");
		this.jPasswordField = new JPasswordField(10);
		this.jPasswordField.setOpaque(false);

		this.jButton5 = new JButton("删除");
		this.jButton6 = new JButton("重置");
		this.jLabel3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel3.setForeground(new Color(92, 167, 186));
		this.jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel2.setForeground(new Color(92, 167, 186));
		this.jLabel4.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel4.setForeground(new Color(92, 167, 186));
		this.jLabel5.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel5.setForeground(new Color(92, 167, 186));
		this.jButton5.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jButton5.setForeground(new Color(92, 167, 186));
		this.jButton6.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jButton6.setForeground(new Color(92, 167, 186));
		this.jLabel5.setBounds(140, 30, 100, 30);
		this.jComboBox.setBounds(240, 30, 100, 30);
		this.jLabel2.setBounds(140, 90, 100, 30);
		this.jPasswordField.setBounds(240, 90, 100, 30);
		this.jLabel3.setBounds(140, 150, 100, 30);
		this.jTextField2.setBounds(240, 150, 100, 30);
		this.jLabel4.setBounds(140, 210, 100, 30);
		this.jTextField3.setBounds(240, 210, 100, 30);
		this.jButton5.setBounds(140, 300, 100, 30);
		this.jButton6.setBounds(280, 300, 100, 30);
		// 下拉框链接模型
		this.jComboBox.setModel(dcm);
		this.jPasswordField.setEditable(false);
		this.jTextField2.setEditable(false);
		this.jTextField3.setEditable(false);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jComboBox);
		this.add(jPasswordField);
		this.add(jTextField2);
		this.add(jTextField3);
		this.add(jButton5);
		this.add(jButton6);
		this.jComboBox.addItemListener(this);
		this.jButton5.addActionListener(this);
		this.jButton6.addActionListener(this);
	}

	public void bindData() {
		dcm.addElement("请选择");
		UserInfo _UserInfo=new UserInfo();
		userList = userservice.getUserInfo(_UserInfo);
		for (UserInfo u : userList) {
			dcm.addElement(u.getU_name());
		}

	}
 public void clearElement(){
	 this.dcm.removeAllElements();
	 this.jPasswordField.setText("");
	 this.jTextField2.setText("");
	 this.jTextField3.setText("");
	 this.userinfo.setU_name(null);
	 this.bindData();
 }
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int index = 0;
		index = e.getStateChange();
		if (index == 1) {
			if(!e.getItem().equals("请选择")){
			userinfo.setU_name(e.getItem().toString());
			List<UserInfo> user = userservice.getUserInfo(userinfo);
			this.jPasswordField.setText(user.get(0).getU_password());
			this.jTextField2.setText(user.get(0).getU_sex());
			this.jTextField3.setText(user.get(0).getU_comptce());
		}
			else{
				this.jPasswordField.setText("");
				 this.jTextField2.setText("");
				 this.jTextField3.setText("");
				 this.userinfo.setU_name(null);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("删除")) {
			if (this.userinfo.getU_name()!= null) {
				boolean flag = userservice.deleteUserInfo(this.userinfo);
				if (flag) {
					JOptionPane.showMessageDialog(this, "删除成功");
					this.clearElement();
				} else {

					JOptionPane.showMessageDialog(this, "修改未成功");
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "请选择您要删除的员工");
			}
		}
		if (e.getActionCommand().equals("重置")) {
			this.clearElement();
		}
	}

}
