package service;
import java.util.ArrayList;

import entity.*;
import dao.*;
public class SaleService {
	private SaleDao saleDao=new SaleDao();
 public int addSale(Sale sale){
	 return  saleDao.addSale(sale);
 }
 public ArrayList<Sale> findSaleByYear(Sale sale){
	 return saleDao.findSaleByYear(sale);
 }
 public ArrayList<Sale> findSaleByMonth(Sale sale){
	 return saleDao.findSaleByMonth(sale);
 }
 public ArrayList<Sale> findSaleByDay(Sale sale){
	 return saleDao.findSaleByDay(sale);
 }
 public ArrayList<Sale> findSale(Sale sale){
	 return saleDao.findSale(sale);
 }
}
