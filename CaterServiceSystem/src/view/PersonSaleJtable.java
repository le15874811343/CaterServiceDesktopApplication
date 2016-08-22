package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

import service.*;

import entity.Comment;
import entity.Income;
import entity.UserInfo;
/**
 * 员工业绩详细信息表
 * @author 乐家良
 *
 */
public class PersonSaleJtable extends JFrame {
	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	private IncomService incomeService = new IncomService();
	private IncomeTableJpanel incomeTableJpanel = new IncomeTableJpanel();
	private String where;
	private UserService userService = new UserService();
	private String name;

	public PersonSaleJtable(String where, String name) {
		this.setTitle("员工业绩详情表");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 自动适配所有控件大小
		this.setSize(310, 500);
		// frame.pack();
		// 设置窗体位置在屏幕中央
		this.setLayout(null);// 设置当前窗体空布局
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// this.setUndecorated(true);
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH); // 最大化
		this.setContentPane(incomeTableJpanel);// 设置背景图片
		this.init();
		this.where = where;
		this.name = name;
		this.bindData();

		// 显示窗体
		this.setVisible(true);
	}

	public void init() {
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.jTable.setBackground(Color.gray);
		this.jTable.setForeground(Color.blue);
		this.jTable.setGridColor(Color.blue);
		this.jScrollPane = new JScrollPane();
		this.jScrollPane.getViewport().add(jTable);
		this.jScrollPane.setBounds(0, 150, 305, 322);
		this.add(jScrollPane);
	}

	public void bindData() {

		Income in = new Income();
		UserInfo userInfo = new UserInfo();
		userInfo.setU_name(this.name);
		in.setI_data("%" + where + "%");
		in.setU_id(userService.getUserInfo(userInfo).get(0).getU_id());
		String[] co = new String[] { "时间", "单号", "员工", "收入" };
		this.dtm = new DefaultTableModel(new Object[][] {}, co);
		this.jTable.setModel(dtm);
		List<Income> incomeList3 = incomeService.getIncome(in);
		for (Income i : incomeList3) {
			String[] day = i.getI_data().split("-");
			String[] _day = day[2].split(" ");
			this.dtm.addRow(new Object[] {
					day[0] + "年" + day[1] + "月" + _day[0] + "号" + _day[1]
							+ "时刻", i.getI_id(),
					userService.getUserInfo(userInfo).get(0).getU_name(),
					i.getI_money()});
		
		}

	}
}
