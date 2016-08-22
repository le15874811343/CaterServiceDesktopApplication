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

import entity.Income;
import entity.UserInfo;
 /**
  * 收入表窗体
  * @author 甘运标,吴舟
  *
  */
public class FindIncome extends JFrame {
	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	private IncomService incomeService = new IncomService();
	private FindIncomeJpanel findIncomeJpanel = new FindIncomeJpanel();
	private IncomeTableJpanel incomeTableJpanel=new IncomeTableJpanel();
	private static Income income = new Income();
	private List<Income> list;
   private String where;
   private UserService userService=new UserService();
	public FindIncome( String where) {
		this.setTitle("收入情况");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 自动适配所有控件大小
		this.setSize(600, 600);
		// frame.pack();
		// 设置窗体位置在屏幕中央
		this.setLayout(null);// 设置当前窗体空布局
		this.setLocationRelativeTo(null);
		this.setResizable(false);
//		 this.setUndecorated(true);
//		 this.setExtendedState(JFrame.MAXIMIZED_BOTH); // 最大化
		 this.setContentPane(incomeTableJpanel);//设置背景图片
		this.init();
		this.where=where;
		this.bindData();

		// 显示窗体
		this.setVisible(true);
	}

	public void init() {
		this.jTable= new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		this.jTable.setBackground(Color.gray);
		this.jTable.setForeground(Color.blue);
		this.jTable.setGridColor(Color.blue);
		this.jScrollPane = new JScrollPane();
		this.jScrollPane.getViewport().add(jTable);
        this.jScrollPane.setBounds(0, 150, 595, 422);
		this.add(jScrollPane);
	}

	public void bindData() {
		Income in=new Income();
		IncomService incomeservice = new IncomService();
	
		in.setI_data("%"+where+"%");
		if(where.equals("")){
			List<Income> incomeList4=incomeservice.getI_MoneyByYear(in);
			String[] co = new String[] { "年", "收入情况" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
		for(Income i:incomeList4){
		
			
			String[] month =i.getI_data().split("-");
			this.dtm.addRow(new Object[]{month[0]+"年","收入"+i.getI_money()+"元"});
		}
		}
		else{
		if(where.split("-").length==1){
			List<Income> incomeList2 = incomeservice.getI_MoneyByMonth(in);
			String[] co = new String[] { "月份", "收入情况" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
		for(Income i:incomeList2){
		
			
			String[] month =i.getI_data().split("-");
			this.dtm.addRow(new Object[]{month[1]+"月","收入"+i.getI_money()+"元"});
		}
		}
		if(where.split("-").length==2){
			List<Income> incomeList = incomeservice.getI_MoneyByDay(in);
			String[] co = new String[] { "日", "收入情况"};
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
		for(Income i:incomeList){
		
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			this.dtm.addRow(new Object[]{day[0]+"年"+day[1]+"月"+_day[0]+"号","收入"+i.getI_money()+"元"});
		}
		}
		if(where.split("-").length==3){
			List<Income> incomeList3 = incomeservice.getIncome(in);
			
			String[] co = new String[] { "时刻", "收入情况" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
		for(Income i:incomeList3){
		
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			this.dtm.addRow(new Object[]{day[0]+"年"+day[1]+"月"+_day[0]+"号"+_day[1]+"时刻","收入"+i.getI_money()+"元"});
		}
		}
	}
	
}
}