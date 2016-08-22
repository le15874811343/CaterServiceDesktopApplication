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
 * �����״ͼ����
 * @author �ŵ�,�ƻ�
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
		   NumberFormat format = NumberFormat.getPercentInstance();// ��ȡ��ʽ����ʵ�� 

	        format.setMinimumFractionDigits(2);// ����С��λ 
	    	if(where.equals("")){
				int count=0;
				List<Income> incomeList2 = incomeservice.getI_MoneyByYear(in);
				for(Income c:incomeList2){
					count+=c.getI_money();
				}
			for(Income i:incomeList2){
				String[] month =i.getI_data().split("-");
					dataset.setValue(month[0]+"��:"+"����"+ i.getI_money()+"Ԫ"+"���ʣ�"+format.format(i.getI_money()/(double)count),i.getI_money());
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
				dataset.setValue(month[1]+"��:"+"����"+ i.getI_money()+"Ԫ"+"���ʣ�"+format.format(i.getI_money()/(double)count),i.getI_money());
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
				dataset.setValue(day[0]+"��"+day[1]+"��"+_day[0]+"��:"+"����"+i.getI_money()+"Ԫ"+"����"+format.format(i.getI_money()/(double)count),i.getI_money());
	
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

				dataset.setValue(day[0]+"��"+day[1]+"��"+_day[0]+"��"+_day[1]+"ʱ�̣�"+"����"+i.getI_money()+"Ԫ"+"����"+format.format(i.getI_money()/(double)count),i.getI_money()  );
		}
		}
	}
        JFreeChart chart = ChartFactory.createPieChart3D("�����״ͼ", dataset,  
        		 true,  true, true);  
        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
     
        plot.setStartAngle(150D);  
      
        plot.setDirection(Rotation.CLOCKWISE);  
      
        plot.setForegroundAlpha(1F);  
    
        plot.setNoDataMessage("��������ʾ");  
      
        plot.setBackgroundPaint(ChartColor.WHITE);  
         ChartFrame frame = new ChartFrame("�������ͼ ", chart, true);  
         frame.pack();  
         frame.setVisible(true);  
  
    
    }  
}
