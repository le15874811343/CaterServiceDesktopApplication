package view;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * ��̨�������
 * @author �ּ���
 *
 */
public class Mypanel extends JPanel{
public Mypanel()
{
	this.setLayout(null);
}

@Override
public void paintComponent(Graphics g) {
	// TODO Auto-generated method stub
	Image img=new ImageIcon("images/����.jpg").getImage();
	g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(), this);
}






}
