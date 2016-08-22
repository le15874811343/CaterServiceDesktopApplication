package view;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import service.*;

import entity.*;

/**
 * 桌子列表面板
 * @author 乐家良
 *
 */
public class TableJTable extends JPanel{
	private JTable jTable;
	private DefaultTableModel dtmd;
	private JTable jTable1;
	private DefaultTableModel dtmd1;
	private JTable jTable2;
	private DefaultTableModel dtmd2;
	private JScrollPane jScrollPane;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTabbedPane tab;
	private TableService tableService=new TableService();
   public TableJTable(){

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
		String[] columnNames = new String[] { "桌号", "状态", "卓型" };
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
	   this.jScrollPane=new JScrollPane();
	   this.jScrollPane.getViewport().add(jTable);
	   this.jScrollPane1=new JScrollPane();
	   this.jScrollPane1.getViewport().add(jTable1);
	   this.jScrollPane2=new JScrollPane();
	   this.jScrollPane2.getViewport().add(jTable2);
	   this.tab=new JTabbedPane(JTabbedPane.LEFT);
	   tab.add(jScrollPane, "小桌");
	   tab.add(jScrollPane1, "大桌");
	   tab.add(jScrollPane2, "包厢");
		this.add(tab);
		this.tab.setBounds(0, 0, 480, 480);
   }
   public void bindData(){
	   TableUse	tableUse=new TableUse();
	      ArrayList<TableUse> tableList=   tableService.getTable(tableUse);
	      for(TableUse t:tableList){
	    	  if(t.getT_note().trim().equals("小桌")){
	    		  this.dtmd.addRow(new Object[]{t.getT_deskno()+"号桌",t.getT_state(),t.getT_note()});
	    	  }
	    	  if(t.getT_note().trim().equals("大桌")){
	    		  this.dtmd1.addRow(new Object[]{t.getT_deskno()+"号桌",t.getT_state(),t.getT_note()});
	    	  }
	    	  if(t.getT_note().trim().equals("包厢")){
	    		  this.dtmd2.addRow(new Object[]{t.getT_deskno(),t.getT_state(),t.getT_note()});
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
			this.bindData();
   }
}
