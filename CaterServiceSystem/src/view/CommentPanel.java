package view;
import java.awt.*;


import javax.swing.*;
/**
 * ��ѯ������屳��ͼƬ
 * @author Administrator
 *
 */
public class CommentPanel extends JPanel{
    public CommentPanel(){
    	this.setLayout(null);
    }

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Image img=new ImageIcon("images/����.jpg").getImage();
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
    
}
