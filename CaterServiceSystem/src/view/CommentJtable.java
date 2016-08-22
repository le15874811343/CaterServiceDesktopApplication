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
 * ��ѯ���۱�
 * @author �ּ���
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
		this.setTitle("�������");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// �Զ��������пؼ���С
		this.setSize(450, 500);
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
		this.jScrollPane.setBounds(0, 150, 445, 322);
		this.add(jScrollPane);
	}

	public void bindData() {

		CommentService commentService = new CommentService();
		Comment in = new Comment();
		UserInfo userInfo = new UserInfo();
		in.setDate("%" + where + "%");
		String[] co = new String[] { "ʱ��", "����̬��", "�ڸ�", "��ע", "����", "����Ա" };
		this.dtm = new DefaultTableModel(new Object[][] {}, co);
		this.jTable.setModel(dtm);
		List<Comment> incomeList3 = commentService.getComment(in);
		for (Comment i : incomeList3) {
			userInfo.setU_id(i.getU_id());
			String[] day = i.getDate().split("-");
			String[] _day = day[2].split(" ");
			this.dtm.addRow(new Object[] {
					day[0] + "��" + day[1] + "��" + _day[0] + "��" + _day[1]
							+ "ʱ��", i.getService(), i.getTaste(), i.getNote(),
					i.getI_id(),
					userService.getUserInfo(userInfo).get(0).getU_name() });
		}

	}
}
