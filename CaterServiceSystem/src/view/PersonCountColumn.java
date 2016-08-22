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
 * Ա��ҵ��ͳ����״ͼ
 * @author �ּ���
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
			JFreeChart chart = ChartFactory.createBarChart(userService.getUserInfo(userInfo).get(0).getU_name()+"ҵ����״ͼ", "�·�", "����",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("ҵ����״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		
		for(Income i:incomeList4){
			String[] month =i.getI_data().split("-");
			 dataset.addValue(i.getI_id(),month[0]+"��:"+i.getI_id()+"��",month[0]);
			
		}
		}
		else{
		if(where.split("-").length==1){
			List<Income> incomeList2 = incomeservice.getCountByMonth(in);
			JFreeChart chart = ChartFactory.createBarChart(userService.getUserInfo(userInfo).get(0).getU_name()+"ҵ����״ͼ", "�·�", "����",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("ҵ����״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		
		for(Income i:incomeList2){
			String[] month =i.getI_data().split("-");
			 dataset.addValue(i.getI_id(),month[1]+"��:"+i.getI_id()+"��",month[1]);
			
		}
		}
		if(where.split("-").length==2){
			List<Income> incomeList = incomeservice.getCountByDay(in);
			JFreeChart chart = ChartFactory.createBarChart(userService.getUserInfo(userInfo).get(0).getU_name()+"ҵ����״ͼ", "��", "������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("ҵ����״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		for(Income i:incomeList){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			 dataset.addValue(i.getI_id(),day[0]+"��"+day[1]+"��"+_day[0]+"��:"+i.getI_id()+"��",_day[0]);
		}
		}
		if(where.split("-").length==3){
			List<Income> incomeList3 = incomeservice.getIncome(in);
			JFreeChart chart = ChartFactory.createBarChart(userService.getUserInfo(userInfo).get(0).getU_name()+"ҵ����״ͼ", "ʱ��", "ʱ������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("ҵ����״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		for(Income i:incomeList3){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			 dataset.addValue(1,day[0]+"��"+day[1]+"��"+_day[0]+"��"+_day[1]+"ʱ��:"+1+"��", _day[1]);
		}
		}
	}
	}

}

