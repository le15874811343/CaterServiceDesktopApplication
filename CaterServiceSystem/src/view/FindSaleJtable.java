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
import entity.MenuInfo;
import entity.Sale;
/**
 * 销售情况列表
 * @author Administrator
 *
 */
public class FindSaleJtable extends JFrame{
	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	private IncomeTableJpanel incomeTableJpanel=new IncomeTableJpanel();
   private String where;
   private MenuService menuService=new MenuService();
	public FindSaleJtable( String where) {
		this.setTitle("销量情况表");
		
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
		Sale in=new Sale();
		   SaleService saleService=new SaleService();
			in.setS_date("%"+where+"%");
			MenuInfo menuInfo=new MenuInfo();
			if(where.equals("")){
				List<Sale> incomeList4 = saleService.findSaleByYear(in);
				String[] co = new String[] { "年份", "菜品","销量" };
				this.dtm = new DefaultTableModel(new Object[][] {}, co);
				this.jTable.setModel(dtm);
				for(Sale i:incomeList4){
					String[] month =i.getS_date().split("-");
					menuInfo.setM_id(i.getM_id());
				this.dtm.addRow(new Object[]{month[0]+"年",menuService.getMenInfoList(menuInfo).get(0).getM_name(),i.getS_count()+"份"});	
					
				}
			}
			else{
		if(where.split("-").length==1){
			List<Sale> incomeList2 = saleService.findSaleByMonth(in);
			String[] co = new String[] { "月份", "菜品","销量" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
			for(Sale i:incomeList2){
				String[] month =i.getS_date().split("-");
				menuInfo.setM_id(i.getM_id());
			this.dtm.addRow(new Object[]{month[1]+"月",menuService.getMenInfoList(menuInfo).get(0).getM_name(),i.getS_count()+"份"});	
				
			}
		}
		if(where.split("-").length==2){
			List<Sale> incomeList = saleService.findSaleByDay(in);
			String[] co = new String[] { "日", "菜品","销量" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
			for(Sale i:incomeList){
				String[] day =i.getS_date().split("-");
				String[] _day=day[2].split(" ");
				menuInfo.setM_id(i.getM_id());
				this.dtm.addRow(new Object[]{day[0]+"年"+day[1]+"月"+_day[0]+"号",menuService.getMenInfoList(menuInfo).get(0).getM_name(),i.getS_count()+"份"});	
			}
		}
		if(where.split("-").length==3){
			List<Sale> incomeList3 = saleService.findSale(in);
			String[] co = new String[] { "时刻", "菜品","销量" };
			this.dtm = new DefaultTableModel(new Object[][] {}, co);
			this.jTable.setModel(dtm);
			for(Sale i:incomeList3){
				String[] day =i.getS_date().split("-");
				String[] _day=day[2].split(" ");
				menuInfo.setM_id(i.getM_id());
				this.dtm.addRow(new Object[]{ day[0]+"年"+day[1]+"月"+_day[0]+"号"+_day[1]+"时刻：",menuService.getMenInfoList(menuInfo).get(0).getM_name(),i.getS_count()+"份"});	
				
			}
		}
	}
	
}
}
