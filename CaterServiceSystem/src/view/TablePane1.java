package view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

import javax.swing.*;
/**
 * ´ó×À±³¾°Ãæ°å
 * @author ÀÖ¼ÒÁ¼
 *
 */
public class TablePane1 extends JPanel{

	public TablePane1()
	{
		this.setLayout(null);
		
	
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Image img=new ImageIcon("images/20130320135134OycDz1Wd.jpg").getImage();
		g.drawImage(img, 0, 0, this.getWidth(), this.getWidth(), this);
	}
	
}
