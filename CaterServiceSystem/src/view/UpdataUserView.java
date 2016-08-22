package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import entity.UserInfo;

import service.UserService;

/**
 * 用户信息修改面板
 * 
 * @author 张丹
 * 
 */
public class UpdataUserView extends JPanel implements ActionListener,
		ItemListener {

	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JComboBox jComboBox;
	private DefaultComboBoxModel dcm;
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
	private int index = 0;

	private UserService userservice = new UserService();
	private UserInfo userinfo = new UserInfo();

	private List<UserInfo> userList = null;

	public UpdataUserView() {
		this.setSize(500, 500);
		this.setLayout(null);
		this.createComponent();
		this.bindData();
	}

	public void createComponent() {
		this.jComboBox = new JComboBox();
		this.jComboBox.setOpaque(false);
		this.dcm = new DefaultComboBoxModel();
		this.jLabel5 = new JLabel("用户名:");// 查询条件
		this.jLabel = new JLabel("用户名:");
		this.jLabel2 = new JLabel("用户密码:");
		this.jLabel3 = new JLabel("性别:");
		this.jLabel4 = new JLabel("用户权限:");
		this.jTextField = new JTextField();
		this.jTextField.setOpaque(false);
		this.jPasswordField = new JPasswordField();
		this.jPasswordField.setOpaque(false);
		this.jRadioButton = new JRadioButton("男");
		this.jRadioButton.setOpaque(false);
		this.jRadioButton2 = new JRadioButton("女");
		this.jRadioButton2.setOpaque(false);
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton);
		this.buttonGroup.add(jRadioButton2);
		this.jRadioButton3 = new JRadioButton("服务员");
		this.jRadioButton3.setOpaque(false);
		this.jRadioButton4 = new JRadioButton("管理员");
		this.jRadioButton4.setOpaque(false);
		this.buttonGroup2 = new ButtonGroup();
		this.buttonGroup2.add(jRadioButton3);
		this.buttonGroup2.add(jRadioButton4);
		this.jButton5 = new JButton("修改");
		this.jButton6 = new JButton("重置");
		this.jLabel5.setBounds(140, 30, 100, 30);
		this.jComboBox.setBounds(240, 30, 100, 30);
		this.jLabel.setBounds(140, 90, 100, 30);
		this.jTextField.setBounds(240, 90, 100, 30);
		this.jLabel2.setBounds(140, 150, 100, 30);
		this.jPasswordField.setBounds(240, 150, 100, 30);
		this.jLabel3.setBounds(140, 210, 100, 30);
		this.jRadioButton.setBounds(240, 210, 100, 30);
		this.jRadioButton2.setBounds(340, 210, 100, 30);
		this.jLabel4.setBounds(140, 270, 100, 30);
		this.jRadioButton3.setBounds(240, 270, 100, 30);
		this.jRadioButton4.setBounds(340, 270, 100, 30);
		this.jButton5.setBounds(140, 360, 100, 30);
		this.jButton6.setBounds(280, 360, 100, 30);
		this.jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel.setForeground(new Color(92, 167, 186));
		this.jLabel5.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel5.setForeground(new Color(92, 167, 186));
		this.jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel2.setForeground(new Color(92, 167, 186));
		this.jLabel3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel3.setForeground(new Color(92, 167, 186));
		this.jLabel4.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel4.setForeground(new Color(92, 167, 186));
		this.jRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton.setForeground(new Color(137, 190, 178));
		this.jRadioButton2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton2.setForeground(new Color(137, 190, 178));
		this.jRadioButton3.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton3.setForeground(new Color(137, 190, 178));
		this.jRadioButton4.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton4.setForeground(new Color(137, 190, 178));
		this.jButton5.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jButton5.setForeground(new Color(92, 167, 186));
		this.jButton6.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jButton6.setForeground(new Color(92, 167, 186));
		// 下拉框链接模型
		this.jComboBox.setModel(dcm);
		this.add(jLabel);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jComboBox);
		this.add(jTextField);
		this.add(jPasswordField);
		this.add(jRadioButton);
		this.add(jRadioButton2);
		this.add(jRadioButton3);
		this.add(jRadioButton4);
		this.add(jButton5);
		this.add(jButton6);
		this.jComboBox.addItemListener(this);
		this.jButton5.addActionListener(this);
		this.jButton6.addActionListener(this);
	}

	public void bindData() {
		dcm.addElement("请选择");
		UserInfo _userInfo=new UserInfo();
		userList = userservice.getUserInfo(_userInfo);
		for (UserInfo u : userList) {
			dcm.addElement(u.getU_name());
		}

	}
  public void clearElement(){
		this.jTextField.setText("");
		this.jPasswordField.setText("");
		this.buttonGroup.clearSelection();
		this.buttonGroup2.clearSelection();
		this.dcm.removeAllElements();
		this.userinfo.setU_name(null);
		this.bindData();
  }
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		index = e.getStateChange();
		if (index == 1) {
			if(!e.getItem().toString().equals("请选择")){
			userinfo.setU_name(e.getItem().toString());
			List<UserInfo> user = userservice.getUserInfo(userinfo);
			this.jTextField.setText(user.get(0).getU_name());
			this.jPasswordField.setText(user.get(0).getU_password());
			if (jRadioButton.getText().equals(user.get(0).getU_sex())) {
				jRadioButton.setSelected(true);
			}
			if (jRadioButton2.getText().equals(user.get(0).getU_sex())) {
				jRadioButton2.setSelected(true);
			}
			if (jRadioButton3.getText().equals(user.get(0).getU_comptce())) {
				jRadioButton3.setSelected(true);
			}
			if (jRadioButton4.getText().equals(user.get(0).getU_comptce())) {
				jRadioButton4.setSelected(true);
			}
		}
			else{
				this.jTextField.setText("");
				this.jPasswordField.setText("");
				this.buttonGroup.clearSelection();
				this.buttonGroup2.clearSelection();
				this.userinfo.setU_name(null);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().trim().equals("修改")) {
			if(this.userinfo.getU_name()!=null){
			UserInfo newUserInfo=new UserInfo();
			newUserInfo.setU_name(jTextField.getText());
			newUserInfo.setU_password(jPasswordField.getText());
			if (jRadioButton.isSelected()) {
				newUserInfo.setU_sex(jRadioButton.getText());
			}
			if (jRadioButton2.isSelected()) {
				newUserInfo.setU_sex(jRadioButton2.getText());
			}
			if (jRadioButton3.isSelected()) {
				newUserInfo.setU_comptce(jRadioButton3.getText());
			}
			if (jRadioButton4.isSelected()) {
				newUserInfo.setU_comptce(jRadioButton4.getText());
			}
			if(!newUserInfo.getU_password().equals("")&&!newUserInfo.getU_name().equals("")){
			UserInfo findUserinfo = new UserInfo();
			findUserinfo.setU_name(newUserInfo.getU_name());
			if (userservice.getUserInfo(findUserinfo).size() == 0||newUserInfo.getU_name().equals(this.userinfo.getU_name())) {
				boolean flag = userservice.updataUserInfo(newUserInfo,
					this.userinfo);
				if (flag) {
					JOptionPane.showMessageDialog(this, "修改成功");
					this.clearElement();
				} else {
					JOptionPane.showMessageDialog(this, "修改未成功");
				}
			} else {
				JOptionPane.showMessageDialog(this, "您修改后的用户名已存在，请重新修改");
			}
			}
			else{
				JOptionPane.showMessageDialog(this, "请补全用户名信息和密码信息");
			}
		}
			else{
				JOptionPane.showMessageDialog(this, "请选择要修改的用户");

			}
		}
		if (e.getActionCommand().trim().equals("重置")) {
this.clearElement();
		}
	}

}
