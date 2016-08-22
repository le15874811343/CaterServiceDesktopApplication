package view;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.*;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.Rotation;

import service.IncomService;
import service.MenuService;
import service.SaleService;


import entity.Income;
import entity.MenuInfo;
import entity.Sale;
/**
 * 销售情况饼状图
 * @author 唐华,张丹
 *
 */
public class SalePieChart3DView extends JFrame{
private String where;
private SaleService saleService=new SaleService();
private MenuService menuService=new MenuService();
	public SalePieChart3DView(String where){
		this.where=where;
	createPieChart3D();
	}
	public void createPieChart3D() {  
		DefaultPieDataset dataset = new DefaultPieDataset();
		Sale in=new Sale();
		in.setS_date("%"+this.where+"%");
		IncomService incomeservice = new IncomService();
	        MenuInfo menuInfo=new MenuInfo();
	        NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例 

	        format.setMinimumFractionDigits(2);// 设置小数位 

	        if(where.split("-").length==1){
				int count=0;
				List<Sale> incomeList4=saleService.findSaleByYear(in);
				for(Sale c:incomeList4){
					count+=c.getS_count();
				}
			for(Sale i:incomeList4){
				String[] month =i.getS_date().split("-");
				menuInfo.setM_id(i.getM_id());
					dataset.setValue(month[0]+"年:"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"销量"+ i.getS_count()+"份"+"比率："+format.format((double)i.getS_count()/(double)count),i.getS_count());
			}
			}
	        else{
	       if(where.split("-").length==1){
			int count=0;
			List<Sale> incomeList2 =saleService.findSaleByMonth(in);
			for(Sale c:incomeList2){
				count+=c.getS_count();
			}
		for(Sale i:incomeList2){
			String[] month =i.getS_date().split("-");
			menuInfo.setM_id(i.getM_id());
				dataset.setValue(month[1]+"月:"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"销量"+ i.getS_count()+"份"+"比率："+format.format((double)i.getS_count()/(double)count),i.getS_count());
		}
		}
		if(where.split("-").length==2){
			int count=0;
			List<Sale> incomeList =saleService.findSaleByDay(in);
			for(Sale c:incomeList){
				count+=c.getS_count();
			}
		for(Sale i:incomeList){
			String[] day =i.getS_date().split("-");
			String[] _day=day[2].split(" ");
			menuInfo.setM_id(i.getM_id());
				dataset.setValue(day[0]+"年"+day[1]+"月"+_day[0]+"号:"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"销量"+i.getS_count()+"份"+"比率"+format.format((double)i.getS_count()/(double)count),i.getS_count());
	
		}
		}
		if(where.split("-").length==3){
			int count=0;
			List<Sale> incomeList3= saleService.findSale(in);
			for(Sale c:incomeList3){
				count+=c.getS_count();
			}
		for(Sale i:incomeList3){
			String[] day =i.getS_date().split("-");
			String[] _day=day[2].split(" ");
			menuInfo.setM_id(i.getM_id());
				dataset.setValue(day[0]+"年"+day[1]+"月"+_day[0]+"号"+_day[1]+"时刻："+ menuService.getMenInfoList(menuInfo).get(0).getM_name()+"销量"+i.getS_count()+"份"+"比率"+format.format((double)i.getS_count()/(double)count),i.getS_count()  );
		}
		}
	        }
        JFreeChart chart = ChartFactory.createPieChart3D("销量饼状图", dataset,  
               true, true,  true);  
        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
     
        plot.setStartAngle(150D);  
      
        plot.setDirection(Rotation.CLOCKWISE);  
      
        plot.setForegroundAlpha(1F);  
    
        plot.setNoDataMessage("无数据显示");  
      
        plot.setBackgroundPaint(ChartColor.WHITE); 
        chart.getLegend().setHeight(100.0);
         ChartFrame frame = new ChartFrame("销量比率图 ", chart,true);
         frame.pack();
         frame.setVisible(true);  
    
    }  
}
