package service;
import java.util.*;

import entity.*;
import dao.*;
public class TableService {
	private TableDao dao=new TableDao();
      public ArrayList<TableUse> getTable(TableUse tableUse){
    	  return  dao.getAllTable(tableUse);
      }
      public int updataTable(TableUse tableUse){
    	  return dao.updataTable(tableUse);
      }
      public int addTable(TableUse tableUse){
    	  return dao.addTable(tableUse);
      }
      public int deleteTable(TableUse tableUse){
    	  return dao.deleteTable(tableUse);
      }
      public int updataTable(TableUse tableUse,TableUse oldTableUse){
    	  return dao.updataTable(tableUse, oldTableUse);
      }
}
