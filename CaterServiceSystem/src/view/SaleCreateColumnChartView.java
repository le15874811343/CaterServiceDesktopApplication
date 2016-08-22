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
 * 销售情况柱状图
 * @author 唐华,张丹
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
			JFreeChart chart = ChartFactory.createBarChart("销售柱状图", "年份", "月销量",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("销售柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		for(Sale i:incomeList4){
			String[] month =i.getS_date().split("-");
			menuInfo.setM_id(i.getM_id());
			 dataset.addValue(i.getS_count(),month[0]+"年："+ menuService.getMenInfoList(menuInfo).get(0).getM_name()+"销量"+i.getS_count()+"份",""+ menuService.getMenInfoList(menuInfo).get(0).getM_name());
			
		}
		}
		else{
		if(where.split("-").length==1){
			List<Sale> incomeList2 = saleService.findSaleByMonth(in);
			JFreeChart chart = ChartFactory.createBarChart("销售柱状图", "月份", "月销量",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("销售柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		for(Sale i:incomeList2){
			String[] month =i.getS_date().split("-");
			menuInfo.setM_id(i.getM_id());
			 dataset.addValue(i.getS_count(),month[1]+"月:"+ menuService.getMenInfoList(menuInfo).get(0).getM_name()+"销量"+i.getS_count()+"份",""+ menuService.getMenInfoList(menuInfo).get(0).getM_name());
			
		}
		}
		if(where.split("-").length==2){
			List<Sale> incomeList = saleService.findSaleByDay(in);
			JFreeChart chart = ChartFactory.createBarChart("销售柱状图", "日", "日销量",
					dataset, PlotOrientation.VERTICAL, true,  true, true);
			ChartFrame frame=new ChartFrame ("销售柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		for(Sale i:incomeList){
			String[] day =i.getS_date().split("-");
			String[] _day=day[2].split(" ");
			menuInfo.setM_id(i.getM_id());
			 dataset.addValue(i.getS_count(),day[0]+"年"+day[1]+"月"+_day[0]+"号:"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"销量"+i.getS_count()+"份",menuService.getMenInfoList(menuInfo).get(0).getM_name());
		}
		}
		if(where.split("-").length==3){
			List<Sale> incomeList3 = saleService.findSale(in);
			JFreeChart chart = ChartFactory.createBarChart("销售柱状图", "时刻", "时刻销量",
					dataset, PlotOrientation.VERTICAL, true, true, true);
			ChartFrame frame=new ChartFrame ("销售柱状图 ",chart,true);
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
			cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
			frame.pack();
			frame.setVisible(true);
		for(Sale i:incomeList3){
			String[] day =i.getS_date().split("-");
			String[] _day=day[2].split(" ");
			menuInfo.setM_id(i.getM_id());
			 dataset.addValue(i.getS_count(), day[0]+"年"+day[1]+"月"+_day[0]+"号"+_day[1]+"时刻："+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"销量"+i.getS_count()+"份", menuService.getMenInfoList(menuInfo).get(0).getM_name());
		}
		}
	}
	}

}
