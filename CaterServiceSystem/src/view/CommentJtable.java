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
 * 查询评价表
 * @author 乐家良
 *
 */
public class CommentJtable extends JFrame {
	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	private IncomService incomeService = new IncomService();
	private FindIncomeJpanel findIncomeJpanel = new FindIncomeJpanel();
	private IncomeTableJpanel incomeTableJpanel = new IncomeTableJpanel();
	private static Income income = new Income();
	private List<Income> list;
	private String where;
	private UserService userService = new UserService();

	public CommentJtable(String where) {
		this.setTitle("评价情况");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 自动适配所有控件大小
		this.setSize(450, 500);
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
		this.jScrollPane.setBounds(0, 150, 445, 322);
		this.add(jScrollPane);
	}

	public void bindData() {

		CommentService commentService = new CommentService();
		Comment in = new Comment();
		UserInfo userInfo = new UserInfo();
		in.setDate("%" + where + "%");
		String[] co = new String[] { "时间", "服务态度", "口感", "备注", "单号", "服务员" };
		this.dtm = new DefaultTableModel(new Object[][] {}, co);
		this.jTable.setModel(dtm);
		List<Comment> incomeList3 = commentService.getComment(in);
		for (Comment i : incomeList3) {
			userInfo.setU_id(i.getU_id());
			String[] day = i.getDate().split("-");
			String[] _day = day[2].split(" ");
			this.dtm.addRow(new Object[] {
					day[0] + "年" + day[1] + "月" + _day[0] + "号" + _day[1]
							+ "时刻", i.getService(), i.getTaste(), i.getNote(),
					i.getI_id(),
					userService.getUserInfo(userInfo).get(0).getU_name() });
		}

	}
}
