package view;

import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.*;
/**
 * 收入查询背景面板
 * @author 甘运标
 *
 */
public class FindIncomeJpanel extends JPanel {
	public FindIncomeJpanel() {
		this.setLayout(null);
	}

	// 覆盖override 基类的方法
	public void paintComponent(Graphics g) {
		// Image 图片对象
		Image img = new ImageIcon("images/6.jpg").getImage();

		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
