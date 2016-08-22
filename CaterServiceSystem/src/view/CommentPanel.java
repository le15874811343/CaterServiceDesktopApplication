package view;
import java.awt.*;


import javax.swing.*;
/**
 * ≤È—Ø∆¿º€√Ê∞Â±≥æ∞Õº∆¨
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
		Image img=new ImageIcon("images/µ„∆¿.jpg").getImage();
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
    
}
