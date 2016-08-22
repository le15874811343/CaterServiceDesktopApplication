package view;
 
import java.awt.*;

import javax.swing.*;

import javax.swing.JPanel;
/**
 * 员工管理窗体背景面板
 * @author 张丹
 *
 */
public class ColorJPone  extends JPanel{

	public ColorJPone(){
		this.setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Image img=new ImageIcon("images/renwu1.jpg").getImage();
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	

	
}
