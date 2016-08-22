package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 * 结账商品列表面板
 * @author 刘阳旭
 *
 */
public class PaymentJTable extends JPanel{
	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField jTextField;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JButton	jButton;
	private JButton	jButton2;
	Font fnt = new Font("STXingkai",1,25);
	Font fnt2 = new Font("STXingkai",1,15);
	 
	
	public PaymentJTable(){
	    this.setSize(300, 300);
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