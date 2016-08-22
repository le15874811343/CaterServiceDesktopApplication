package view;

import java.awt.*;

import javax.swing.*;

/**
 * ∞¸œ·±≥æ∞√Ê∞Â
 * 
 * @author ¿÷º“¡º
 * 
 */
public class TablePane3 extends JPanel {
	public TablePane3() {
		this.setLayout(null);

	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Image img = new ImageIcon("images/20081223103553296_2.jpg").getImage();
		g.drawImage(img, 0, 0, this.getWidth(), this.getWidth(), this);
	}

}
