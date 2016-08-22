package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Ω·’À±≥æ∞√Ê∞Â
 * @author ¡ı—Ù–Ò
 *
 */
public class ShouyintaiJPanel extends JPanel {
	public ShouyintaiJPanel() {
             this.setSize(582,150);
             this.setVisible(true);
             this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));
             
	}

	public void paintComponent(Graphics g) {
		int x = 0, y = 0;
		
		
		ImageIcon icon = new ImageIcon("images/u=2843233550,2506648617&fm=21&gp=0.jpg");
		g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height,
				this);
	
	}
}
