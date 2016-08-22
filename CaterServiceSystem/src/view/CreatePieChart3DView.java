package view;
import java.awt.*;
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


import entity.Income;
/**
 * 收入饼状图窗体
 * @author 张丹,唐华
 *
 */
public class CreatePieChart3DView extends JFrame{
private String where;
	public CreatePieChart3DView(String where){
		this.where=where;
	createPieChart3D();
	}
	public void createPieChart3D() {  
		DefaultPieDataset dataset = new DefaultPieDataset();
		Income in=new Income();
		in.setI_data("%"+this.where+"%");
		IncomService incomeservice = new IncomService();
		   NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例 

	        format.setMinimumFractionDigits(2);// 设置小数位 
	    	if(where.equals("")){
				int count=0;
				List<Income> incomeList2 = incomeservice.getI_MoneyByYear(in);
				for(Income c:incomeList2){
					count+=c.getI_money();
				}
			for(Income i:incomeList2){
				String[] month =i.getI_data().split("-");
					dataset.setValue(month[0]+"年:"+"收入"+ i.getI_money()+"元"+"比率："+format.format(i.getI_money()/(double)count),i.getI_money());
			}
			}
	    	else{
		if(where.split("-").length==1){
			int count=0;
			List<Income> incomeList2 = incomeservice.getI_MoneyByMonth(in);
			for(Income c:incomeList2){
				count+=c.getI_money();
			}
		for(Income i:incomeList2){
			String[] month =i.getI_data().split("-");
				dataset.setValue(month[1]+"月:"+"收入"+ i.getI_money()+"元"+"比率："+format.format(i.getI_money()/(double)count),i.getI_money());
		}
		}
		if(where.split("-").length==2){
			int count=0;
			List<Income> incomeList = incomeservice.getI_MoneyByDay(in);
			for(Income c:incomeList){
				count+=c.getI_money();
			}
		for(Income i:incomeList){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");
				dataset.setValue(day[0]+"年"+day[1]+"月"+_day[0]+"号:"+"收入"+i.getI_money()+"元"+"比率"+format.format(i.getI_money()/(double)count),i.getI_money());
	
		}
		}
		if(where.split("-").length==3){
			int count=0;
			List<Income> incomeList3= incomeservice.getIncome(in);
			for(Income c:incomeList3){
				count+=c.getI_money();
			}
		for(Income i:incomeList3){
			String[] day =i.getI_data().split("-");
			String[] _day=day[2].split(" ");

				dataset.setValue(day[0]+"年"+day[1]+"月"+_day[0]+"号"+_day[1]+"时刻："+"收入"+i.getI_money()+"元"+"比率"+format.format(i.getI_money()/(double)count),i.getI_money()  );
		}
		}
	}
        JFreeChart chart = ChartFactory.createPieChart3D("收入饼状图", dataset,  
        		 true,  true, true);  
        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
     
        plot.setStartAngle(150D);  
      
        plot.setDirection(Rotation.CLOCKWISE);  
      
        plot.setForegroundAlpha(1F);  
    
        plot.setNoDataMessage("无数据显示");  
      
        plot.setBackgroundPaint(ChartColor.WHITE);  
         ChartFrame frame = new ChartFrame("收入比率图 ", chart, true);  
         frame.pack();  
         frame.setVisible(true);  
  
    
    }  
}
