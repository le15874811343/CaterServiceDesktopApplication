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
  * �������
  * @author ���˱�,����
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
		this.setTitle("�������");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// �Զ��������пؼ���С
		this.setSize(600, 600);
		// frame.pack();
		// ���ô���λ������Ļ����
		this.setLayout(null);// ���õ�ǰ����ղ���
		this.setLocationRelativeTo(null);
		this.setResizable(false);
//		 this.setUndecorated(true);
//		 this.setExtendedState(JFrame.MAXIMIZED_BOTH); // ���
		 this.setContentPane(incomeTableJpanel);//���ñ���ͼƬ
		this.init();
		this.where=where;
		this.bindData();

		// ��ʾ����
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
			String[] co = new String[] { "��", "�������" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
		for(Income i:incomeList4){
		
			
			String[] month =i.getI_data().split("-");
			this.dtm.addRow(new Object[]{month[0]+"��","����"+i.getI_money()+"Ԫ"});
		}
		}
		else{
		if(where.split("-").length==1){
			List<Income> incomeList2 = incomeservice.getI_MoneyByMonth(in);
			String[] co = new String[] { "�·�", "�������" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
		for(Income i:incomeList2){
		
			
			String[] month =i.getI_data().split("-");
			this.dtm.addRow(new Object[]{month[1]+"��","����"+i.getI_money()+"Ԫ"});
		}
		}
		if(where.split("-").length==2){
			List<Income> incomeList = incomeservice.getI_MoneyByDay(in);
			String[] co = new String[] { "��", "�������"};
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
		for(Income i:incomeList){
		
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			this.dtm.addRow(new Object[]{day[0]+"��"+day[1]+"��"+_day[0]+"��","����"+i.getI_money()+"Ԫ"});
		}
		}
		if(where.split("-").length==3){
			List<Income> incomeList3 = incomeservice.getIncome(in);
			
			String[] co = new String[] { "ʱ��", "�������" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
		for(Income i:incomeList3){
		
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			this.dtm.addRow(new Object[]{day[0]+"��"+day[1]+"��"+_day[0]+"��"+_day[1]+"ʱ��","����"+i.getI_money()+"Ԫ"});
		}
		}
	}
	
}
}