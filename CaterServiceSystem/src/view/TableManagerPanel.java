package view;
/**
 * ���ӹ��������
 * @author Administrator
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
public class TableManagerPanel extends JPanel{
   public TableManagerPanel(){
	   this.setLayout(null);
   }

@Override
public  void paintComponent(Graphics g) {
	// TODO Auto-generated method stub
	Image image=new ImageIcon("images/�ͱ�.jpg").getImage();
	g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(),this);
		
	
	
}
}
