package view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

import javax.swing.*;
/**
 * Ð¡×À±³¾°Ãæ°å
 * @author ÀÖ¼ÒÁ¼
 *
 */
public class TablePane extends JPanel {

	public TablePane()
	{
		this.setLayout(null);
		
	
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Image img=new ImageIcon("images/20120522_9a07c43d3ebd04e304bfYaHUz39r3q0g.jpg").getImage();
		g.drawImage(img, 0, 0, this.getWidth(), this.getWidth(), this);
	}
	
	
}
