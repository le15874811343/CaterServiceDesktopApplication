package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Ω·’À¥∞ÃÂ±≥æ∞√Ê∞Â
 * @author ¡ı—Ù–Ò
 *
 */
public class InformationJPanel extends JPanel {
	public InformationJPanel() {

		this.setVisible(true);
		this.setLayout(null);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
	
	
	}
	public void paintComponent(Graphics g) {
		int x = 0, y = 0;
		
		
		ImageIcon icon = new ImageIcon("images/u=2354154098,3765781052&fm=206&gp=0.jpg");
		g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height,
				this);

	}

}
