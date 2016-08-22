package view;

import java.awt.*;
import javax.swing.*;
/**
 * µÇÂ¼±³¾°Ãæ°å
 * @author ÀÖ¼ÒÁ¼
 *
 */
public class LoginFreamPanel extends JPanel {
    @Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
	
			Image image=new ImageIcon("images/01.jpg").getImage();
		g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(),this);
	}

	public LoginFreamPanel(){
    	this.setLayout(null);
    }
}
