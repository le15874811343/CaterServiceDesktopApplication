package view;
import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import service.*;

import entity.*;
/**
 * 菜品表
 * @author 乐家良
 *
 */
public class MenuJTable extends JPanel {
	private JTable jTable;
	private DefaultTableModel dtmd;
	private JTable jTable1;
	private DefaultTableModel dtmd1;
	private JTable jTable2;
	private JTable jTable3;
	private DefaultTableModel dtmd2;
	private DefaultTableModel dtmd3;
	private JScrollPane jScrollPane;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JTabbedPane tab;
	private MenuService menuService=new MenuService();
   public MenuJTable(){

		this.setSize(500, 500);
		this.setLayout(new GridLayout());
		this.init();
		this.bindData();
   }
   public void init(){
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] columnNames = new String[] { "编号","菜名", "价格", "类型" };
	   this.dtmd=new DefaultTableModel(new Object[][] {}, columnNames);
	   this.jTable.setModel(dtmd);
	   this.jTable1 = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	   this.dtmd1=new DefaultTableModel(new Object[][] {}, columnNames);
	   this.jTable1.setModel(dtmd1);
	   this.jTable2 = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	   this.dtmd2=new DefaultTableModel(new Object[][] {}, columnNames);
	   this.jTable2.setModel(dtmd2);
	   this.jTable3 = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	   this.dtmd3=new DefaultTableModel(new Object[][] {}, columnNames);
	   this.jTable3.setModel(dtmd3);
	   this.jScrollPane=new JScrollPane();
	   this.jScrollPane.getViewport().add(jTable);
	   this.jScrollPane1=new JScrollPane();
	   this.jScrollPane1.getViewport().add(jTable1);
	   this.jScrollPane2=new JScrollPane();
	   this.jScrollPane2.getViewport().add(jTable2);
	   this.jScrollPane3=new JScrollPane();
	   this.jScrollPane3.getViewport().add(jTable3);
	   this.tab=new JTabbedPane(JTabbedPane.LEFT);
	   tab.add(jScrollPane, "小炒");
	   tab.add(jScrollPane1, "火锅");
	   tab.add(jScrollPane2, "汤");
	   tab.add(jScrollPane3, "饮品");
		this.add(tab);
		this.tab.setBounds(0, 0, 480, 480);
   }
   public void bindData(){
	  MenuInfo menuInfo=new MenuInfo();
	   ArrayList<MenuInfo> menulList=(ArrayList<MenuInfo>) menuService.getMenInfoList(menuInfo);
	      for(MenuInfo m:menulList){
	    	  if(m.getM_type().equals("小炒")){
	    		  this.dtmd.addRow(new Object[]{m.getM_id(),m.getM_name(),m.getM_price(),m.getM_type()});
	    	  }
	    	  if(m.getM_type().equals("火锅")){
	    		  this.dtmd1.addRow(new Object[]{m.getM_id(),m.getM_name(),m.getM_price(),m.getM_type()});
	    	  }
	    	  if(m.getM_type().equals("汤")){
	    		  this.dtmd2.addRow(new Object[]{m.getM_id(),m.getM_name(),m.getM_price(),m.getM_type()});
	    	  }
	    	  if(m.getM_type().equals("饮品")){
	    		  this.dtmd3.addRow(new Object[]{m.getM_id(),m.getM_name(),m.getM_price(),m.getM_type()});
	    	  }
	      }
   }
   public void clearRow(){
	  int n= this.dtmd.getRowCount();
	while(n-->0){
		dtmd.removeRow(0);
	}
	  int n1= this.dtmd1.getRowCount();
		while(n1-->0){
			dtmd1.removeRow(0);
		}
		  int n2= this.dtmd2.getRowCount();
			while(n2-->0){
				dtmd2.removeRow(0);
			}
			int n3= this.dtmd3.getRowCount();
			while(n3-->0){
				dtmd3.removeRow(0);
			}
			this.bindData();
   }
}



