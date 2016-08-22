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
 * Ա��ҵ����ϸ��Ϣ��
 * @author �ּ���
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
		this.setTitle("Ա��ҵ�������");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// �Զ��������пؼ���С
		this.setSize(310, 500);
		// frame.pack();
		// ���ô���λ������Ļ����
		this.setLayout(null);// ���õ�ǰ����ղ���
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// this.setUndecorated(true);
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH); // ���
		this.setContentPane(incomeTableJpanel);// ���ñ���ͼƬ
		this.init();
		this.where = where;
		this.name = name;
		this.bindData();

		// ��ʾ����
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
		String[] co = new String[] { "ʱ��", "����", "Ա��", "����" };
		this.dtm = new DefaultTableModel(new Object[][] {}, co);
		this.jTable.setModel(dtm);
		List<Income> incomeList3 = incomeService.getIncome(in);
		for (Income i : incomeList3) {
			String[] day = i.getI_data().split("-");
			String[] _day = day[2].split(" ");
			this.dtm.addRow(new Object[] {
					day[0] + "��" + day[1] + "��" + _day[0] + "��" + _day[1]
							+ "ʱ��", i.getI_id(),
					userService.getUserInfo(userInfo).get(0).getU_name(),
					i.getI_money()});
		
		}

	}
}
