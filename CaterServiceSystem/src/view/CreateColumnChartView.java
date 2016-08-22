package view;
import java.awt.*;
import java.util.List;

import javax.swing.*;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import service.IncomService;


import entity.Income;
/**
 * 收入柱状图窗体
 * @author 张丹，唐华
 *
 */
public class CreateColumnChartView extends JFrame{
private String where;
	public CreateColumnChartView(String where){
		this.where=where;
		this.createColumnChart();
	}
	
	public void createColumnChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Income in=new Income();
		IncomService incomeservice = new IncomService();
		in.setI_data("%"+where+"%");
		if(where.equals("")){
			List<Income> incomeList4 = incomeservice.getI_MoneyByYear(in);
			JFreeChart chart = ChartFactory.createBarChart("收入柱状图", "年", "年收入",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("收入柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		
		for(Income i:incomeList4){
			String[] month =i.getI_data().split("-");
			 dataset.addValue(i.getI_money(),month[0]+"年:"+"收入"+i.getI_money()+"元",month[0]);
			
		}
		}
		else{
		if(where.split("-").length==1){
			List<Income> incomeList2 = incomeservice.getI_MoneyByMonth(in);
			JFreeChart chart = ChartFactory.createBarChart("收入柱状图", "月份", "月收入",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("收入柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		
		for(Income i:incomeList2){
			String[] month =i.getI_data().split("-");
			 dataset.addValue(i.getI_money(),month[1]+"月:"+"收入"+i.getI_money()+"元",month[1]);
			
		}
		}
		if(where.split("-").length==2){
			List<Income> incomeList = incomeservice.getI_MoneyByDay(in);
			JFreeChart chart = ChartFactory.createBarChart("收入柱状图", "日", "日收入",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("收入柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		for(Income i:incomeList){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			 dataset.addValue(i.getI_money(),day[0]+"年"+day[1]+"月"+_day[0]+"号:"+"收入"+i.getI_money()+"元",_day[0]);
		}
		}
		if(where.split("-").length==3){
			List<Income> incomeList3 = incomeservice.getIncome(in);
			JFreeChart chart = ChartFactory.createBarChart("收入柱状图", "时刻", "时刻收入",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("收入柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		for(Income i:incomeList3){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			 dataset.addValue(i.getI_money(),day[0]+"年"+day[1]+"月"+_day[0]+"号"+_day[1]+"时刻："+"收入"+i.getI_money()+"元", _day[1]);
		}
		}
	}
	}
}
