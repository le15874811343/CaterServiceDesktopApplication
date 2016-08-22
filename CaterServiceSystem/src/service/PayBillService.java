package service;

import java.util.ArrayList;

import entity.PayBill;
import dao.*;
public class PayBillService {
	private PayBillDao dao=new PayBillDao();
  public int addPayBill(PayBill payBill){
	  return  dao.addPayBill(payBill);
  }
  public ArrayList<PayBill> getPayBill(PayBill payBill){
	  return dao.getPayBill(payBill);
  }
  public int deletePayBill(PayBill payBill){
	  return dao.deletePayBill(payBill);
  }
}
