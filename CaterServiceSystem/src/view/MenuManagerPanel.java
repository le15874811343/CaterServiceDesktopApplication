package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * 菜品管理背景面板
 * @author Administrator
 *
 */
public class MenuManagerPanel extends JPanel{
	  public MenuManagerPanel(){
		   this.setLayout(null);
	   }

	@Override
	public  void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Image image=new ImageIcon("images/菜背.jpg").getImage();
		g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(),this);
			
		
		
	}
}
