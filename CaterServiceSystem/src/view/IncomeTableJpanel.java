package view;

import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.*;
/**
 * �����񱳾�ͼ
 * @author ���˱�
 *
 */
public class IncomeTableJpanel extends JPanel {
	public IncomeTableJpanel() {
		this.setLayout(null);
	}

	// ����override ����ķ���
	public void paintComponent(Graphics g) {
		// Image ͼƬ����
		Image img = new ImageIcon("images/���� 2.jpg").getImage();

		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
