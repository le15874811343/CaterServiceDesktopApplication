package service;
import java.util.List;

import dao.*;
import entity.MenuInfo;
public class MenuService {
	private MenuDao menuDao=new MenuDao();
	public List<MenuInfo> getMenInfoList(MenuInfo menuinfo){
		return menuDao.getMenInfoList(menuinfo);
	}
	public int addMenu(MenuInfo menuInfo){
		return menuDao.addMenu(menuInfo);
	}
	public int deleteMenu(MenuInfo menuInfo){
		return menuDao.deleteMenu(menuInfo);
	}
	public int updataMenu(MenuInfo newMenuInfo,MenuInfo oldMenuInfo){
		return menuDao.updataMenu(newMenuInfo, oldMenuInfo);
	}
}
