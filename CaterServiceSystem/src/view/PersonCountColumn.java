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
import service.UserService;


import entity.Income;
import entity.UserInfo;
/**
 * 员工业绩统计柱状图
 * @author 乐家良
 *
 */
public class PersonCountColumn extends JFrame{
	private String where;
	private String name;
	private UserService userService=new UserService();
	public PersonCountColumn(String where,String name){
		this.where=where;
		this.name=name;
		createColumnChart();
	}
	
	public void createColumnChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Income in=new Income();
		IncomService incomeservice = new IncomService();
		UserInfo userInfo = new UserInfo();
		userInfo.setU_name(this.name);
		in.setI_data("%"+where+"%");
		in.setU_id(userService.getUserInfo(userInfo).get(0).getU_id());
		if(where.equals("")){
			List<Income> incomeList4 = incomeservice.getCountByYear(in);
			JFreeChart chart = ChartFactory.createBarChart(userService.getUserInfo(userInfo).get(0).getU_name()+"业绩柱状图", "月份", "笔数",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("业绩柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		
		for(Income i:incomeList4){
			String[] month =i.getI_data().split("-");
			 dataset.addValue(i.getI_id(),month[0]+"年:"+i.getI_id()+"笔",month[0]);
			
		}
		}
		else{
		if(where.split("-").length==1){
			List<Income> incomeList2 = incomeservice.getCountByMonth(in);
			JFreeChart chart = ChartFactory.createBarChart(userService.getUserInfo(userInfo).get(0).getU_name()+"业绩柱状图", "月份", "笔数",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("业绩柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		
		for(Income i:incomeList2){
			String[] month =i.getI_data().split("-");
			 dataset.addValue(i.getI_id(),month[1]+"月:"+i.getI_id()+"笔",month[1]);
			
		}
		}
		if(where.split("-").length==2){
			List<Income> incomeList = incomeservice.getCountByDay(in);
			JFreeChart chart = ChartFactory.createBarChart(userService.getUserInfo(userInfo).get(0).getU_name()+"业绩柱状图", "日", "日收入",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("业绩柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		for(Income i:incomeList){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			 dataset.addValue(i.getI_id(),day[0]+"年"+day[1]+"月"+_day[0]+"号:"+i.getI_id()+"笔",_day[0]);
		}
		}
		if(where.split("-").length==3){
			List<Income> incomeList3 = incomeservice.getIncome(in);
			JFreeChart chart = ChartFactory.createBarChart(userService.getUserInfo(userInfo).get(0).getU_name()+"业绩柱状图", "时刻", "时刻收入",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("业绩柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		for(Income i:incomeList3){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			 dataset.addValue(1,day[0]+"年"+day[1]+"月"+_day[0]+"号"+_day[1]+"时刻:"+1+"笔", _day[1]);
		}
		}
	}
	}

}

