package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import service.*;
import entity.*;

/**
 * 员工列表面板
 * 
 * @author 张丹
 * 
 */
public class JTableView extends JPanel {

	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;// 滚动面板
	private UserService userservice = new UserService();
	private UserInfo userinfo = new UserInfo();
	private List<UserInfo> userList = new ArrayList<UserInfo>();

	public JTableView() {

		this.setSize(500, 500);
		this.setLayout(new GridLayout());
		this.createComponent();
		this.bindData();
	}

	public void createComponent() {
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] columnNames = new String[] {"用户编号", "用户名", "性别", "用户权限" };
		this.dtm = new DefaultTableModel(new Object[][] {}, columnNames);
		this.jTable.setModel(dtm);
		this.jScrollPane = new JScrollPane();
		this.jScrollPane.getViewport().add(jTable);
		this.add(jScrollPane);
		this.jScrollPane.setBounds(0, 0, 480, 480);

	}
public void clearRow(){
	  int n= this.dtm.getRowCount();
		while(n-->0){
			dtm.removeRow(0);
		}
		this.bindData();
}

	public void bindData() {
		userList = userservice.getUserInfo(userinfo);
		for (UserInfo u : userList) {
		
				dtm.addRow(new Object[] {u.getU_id(), u.getU_name(),
						u.getU_sex(), u.getU_comptce() });
			
			}
	}
}
