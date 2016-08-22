package service;
import dao.*;
import java.util.*;

import entity.Income;
public class IncomService {
  private IncomeDao dao=new IncomeDao();
  public int addIncom(Income income){
	  return dao.addIncom(income);
  }
  public List<Income> getIncome(Income income){
	  return dao.getIncome(income);
  }
  public List<Income> getI_MoneyByMonth(Income income){
	  return dao.getI_MoneyByMonth(income);
  }
  public List<Income> getI_MoneyByDay(Income income){
	  return dao.getI_MoneyByDay(income);
  }
  public List<Income> getCountByMonth(Income income){
	  return dao.getCountByMonth(income);
  }
  public List<Income> getCountByDay(Income income){
	  return dao.getCountByDay(income);
  }
  public List<Income> getI_MoneyByYear(Income income){
	  return dao.getI_MoneyByYear(income);
  }
  public List<Income> getCountByYear(Income income){
	  return dao.getCountByYear(income);
  }
}
