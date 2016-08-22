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
 * ������״ͼ����
 * @author �ŵ����ƻ�
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
			JFreeChart chart = ChartFactory.createBarChart("������״ͼ", "��", "������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("������״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		
		for(Income i:incomeList4){
			String[] month =i.getI_data().split("-");
			 dataset.addValue(i.getI_money(),month[0]+"��:"+"����"+i.getI_money()+"Ԫ",month[0]);
			
		}
		}
		else{
		if(where.split("-").length==1){
			List<Income> incomeList2 = incomeservice.getI_MoneyByMonth(in);
			JFreeChart chart = ChartFactory.createBarChart("������״ͼ", "�·�", "������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("������״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		
		for(Income i:incomeList2){
			String[] month =i.getI_data().split("-");
			 dataset.addValue(i.getI_money(),month[1]+"��:"+"����"+i.getI_money()+"Ԫ",month[1]);
			
		}
		}
		if(where.split("-").length==2){
			List<Income> incomeList = incomeservice.getI_MoneyByDay(in);
			JFreeChart chart = ChartFactory.createBarChart("������״ͼ", "��", "������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("������״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		for(Income i:incomeList){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			 dataset.addValue(i.getI_money(),day[0]+"��"+day[1]+"��"+_day[0]+"��:"+"����"+i.getI_money()+"Ԫ",_day[0]);
		}
		}
		if(where.split("-").length==3){
			List<Income> incomeList3 = incomeservice.getIncome(in);
			JFreeChart chart = ChartFactory.createBarChart("������״ͼ", "ʱ��", "ʱ������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("������״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		for(Income i:incomeList3){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
			 dataset.addValue(i.getI_money(),day[0]+"��"+day[1]+"��"+_day[0]+"��"+_day[1]+"ʱ�̣�"+"����"+i.getI_money()+"Ԫ", _day[1]);
		}
		}
	}
	}
}
