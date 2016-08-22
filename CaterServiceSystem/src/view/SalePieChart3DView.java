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
 * ���������״ͼ
 * @author �ƻ�,�ŵ�
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
	        NumberFormat format = NumberFormat.getPercentInstance();// ��ȡ��ʽ����ʵ�� 

	        format.setMinimumFractionDigits(2);// ����С��λ 

	        if(where.split("-").length==1){
				int count=0;
				List<Sale> incomeList4=saleService.findSaleByYear(in);
				for(Sale c:incomeList4){
					count+=c.getS_count();
				}
			for(Sale i:incomeList4){
				String[] month =i.getS_date().split("-");
				menuInfo.setM_id(i.getM_id());
					dataset.setValue(month[0]+"��:"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"����"+ i.getS_count()+"��"+"���ʣ�"+format.format((double)i.getS_count()/(double)count),i.getS_count());
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
				dataset.setValue(month[1]+"��:"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"����"+ i.getS_count()+"��"+"���ʣ�"+format.format((double)i.getS_count()/(double)count),i.getS_count());
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
				dataset.setValue(day[0]+"��"+day[1]+"��"+_day[0]+"��:"+menuService.getMenInfoList(menuInfo).get(0).getM_name()+"����"+i.getS_count()+"��"+"����"+format.format((double)i.getS_count()/(double)count),i.getS_count());
	
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
				dataset.setValue(day[0]+"��"+day[1]+"��"+_day[0]+"��"+_day[1]+"ʱ�̣�"+ menuService.getMenInfoList(menuInfo).get(0).getM_name()+"����"+i.getS_count()+"��"+"����"+format.format((double)i.getS_count()/(double)count),i.getS_count()  );
		}
		}
	        }
        JFreeChart chart = ChartFactory.createPieChart3D("������״ͼ", dataset,  
               true, true,  true);  
        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
     
        plot.setStartAngle(150D);  
      
        plot.setDirection(Rotation.CLOCKWISE);  
      
        plot.setForegroundAlpha(1F);  
    
        plot.setNoDataMessage("��������ʾ");  
      
        plot.setBackgroundPaint(ChartColor.WHITE); 
        chart.getLegend().setHeight(100.0);
         ChartFrame frame = new ChartFrame("��������ͼ ", chart,true);
         frame.pack();
         frame.setVisible(true);  
    
    }  
}
