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
import service.MenuService;
import service.SaleService;


import entity.Income;
import entity.MenuInfo;
import entity.Sale;
/**
 * ���������״ͼ
 * @author �ƻ�,�ŵ�
 *
 */
public class SaleCreateColumnChartView extends JFrame{
private String where;
private MenuService menuService=new MenuService();
	public SaleCreateColumnChartView(String where){
		this.where=where;
		createColumnChart();
	}
	
	public void createColumnChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Sale in=new Sale();
	   SaleService saleService=new SaleService();
		in.setS_date("%"+where+"%");
		MenuInfo menuInfo=new MenuInfo();
		if(where.equals("")){
			List<Sale> incomeList4 = saleService.findSaleByYear(in);
			JFreeChart chart = ChartFactory.createBarChart("������״ͼ", "���", "������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("������״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		for(Sale i:incomeList4){
			String[] month =i.getS_date().split("-");
			menuInfo.setM_id(i.getM_id());
			 dataset.addValue(i.getS_count(),month[0]+"�꣺"+ menuService.getMenInfoList(menuInfo).get(0).getM_name()+"����"+i.getS_count()+"��",""+ menuService.getMenInfoList(menuInfo).get(0).getM_name());
			
		}
		}
		else{
		if(where.split("-").length==1){
			List<Sale> incomeList2 = saleService.findSaleByMonth(in);
			JFreeChart chart = ChartFactory.createBarChart("������״ͼ", "�·�", "������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("������״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		for(Sale i:incomeList2){
			String[] month =i.getS_date().split("-");
			menuInfo.setM_id(i.getM_id());
			 dataset.addValue(i.getS_count(),month[1]+"��:"+ menuService.getMenInfoList(menuInfo).get(0).getM_name()+"����"+i.getS_count()+"��",""+ menuService.getMenInfoList(menuInfo).get(0).getM_name());
			
		}
		}
		if(where.split("-").length==2){
			List<Sale> incomeList = saleService.findSaleByDay(in);
			JFreeChart chart = ChartFactory.createBarChart("������״ͼ", "��", "������",
					dataset, PlotOrientation.VERTICAL, true,  true, true);
			ChartFrame frame=new ChartFrame ("������״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		for(Sale i:incomeList){
			String[] day =i.getS_date().split("-");
			String[] _day=day[2].split(" ");
			menuInfo.setM_id(i.getM_id());
			 dataset.addValue(i.getS_count(),day[0]+"��"+day[1]+"��"+_day[0]+"��:"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"����"+i.getS_count()+"��",menuService.getMenInfoList(menuInfo).get(0).getM_name());
		}
		}
		if(where.split("-").length==3){
			List<Sale> incomeList3 = saleService.findSale(in);
			JFreeChart chart = ChartFactory.createBarChart("������״ͼ", "ʱ��", "ʱ������",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("������״ͼ ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // ����ɫ����
			cp.setRangeGridlinePaint(ChartColor.GRAY); // ������ɫ����
			frame.pack();
			frame.setVisible(true);
		for(Sale i:incomeList3){
			String[] day =i.getS_date().split("-");
			String[] _day=day[2].split(" ");
			menuInfo.setM_id(i.getM_id());
			 dataset.addValue(i.getS_count(), day[0]+"��"+day[1]+"��"+_day[0]+"��"+_day[1]+"ʱ�̣�"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"����"+i.getS_count()+"��", menuService.getMenInfoList(menuInfo).get(0).getM_name());
		}
		}
	}
	}

}
