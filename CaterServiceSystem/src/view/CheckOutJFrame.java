package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import entity.*;
import service.*;

/**
 * 结账窗体
 * 
 * @author 刘阳旭
 * 
 */
public class CheckOutJFrame extends JDialog implements ActionListener,
		DocumentListener,KeyListener {
	private PayBillService payBillService = new PayBillService();
	private TableUse tableUse;
	private JTable jTable;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField jTextField;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField8;
	private JTextField jTextField4;
	private JButton jButton;
	private JButton jButton2;
	private IncomService incomService = new IncomService();
	private TableService tableService = new TableService();
	private ArrayList<PayBill> payBillList;
	private MenuService menuService = new MenuService();
	private SaleService saleService = new SaleService();
	private UserInfo userInfo;
	Font fnt = new Font("STXingkai", 1, 25);
	Font fnt2 = new Font("STXingkai", 1, 15);

	public CheckOutJFrame(TableUse tableUse,UserInfo userInfo) {

		this.setSize(584, 600);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.init();
		this.tableUse = tableUse;
		this.userInfo=userInfo;
		this.bindData();
		this.setModal(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setVisible(true);
	}

	public void init() {
		ShouyintaiJPanel p1 = new ShouyintaiJPanel();
		this.getContentPane().add(p1);
		InformationJPanel p2 = new InformationJPanel();
		p2.setBounds(3, 150, 575, 40);
		this.getContentPane().add(p2);
		PaymentJTable p3 = new PaymentJTable();
		p3.setBounds(3, 410, 575, 140);
		this.getContentPane().add(p3);
		this.jLabel = new JLabel("消费金额合计：");
		this.jLabel2 = new JLabel("应收金额：");
		this.jLabel3 = new JLabel("实收金额：");
		this.jLabel4 = new JLabel("找零：");
		this.jButton = new JButton("完成结账");
		this.jButton2 = new JButton("退出结账");
		this.jTextField = new JTextField();
		this.jTextField2 = new JTextField();
		this.jTextField3 = new JTextField();
		this.jTextField8 = new JTextField();
		this.jTextField4 = new JTextField();
		this.jLabel.setFont(fnt);
		this.jLabel2.setFont(fnt);
		this.jLabel3.setFont(fnt);
		this.jLabel4.setFont(fnt);
		this.jButton.setFont(fnt2);
		this.jButton2.setFont(fnt2);
		this.jLabel.setBounds(10, 10, 190, 30);
		this.jLabel2.setBounds(310, 10, 160, 30);
		this.jLabel3.setBounds(10, 50, 220, 30);
		this.jLabel4.setBounds(310, 50, 220, 30);
		this.jTextField4.setBounds(470, 50, 80, 30);
		this.jButton.setBounds(120, 90, 100, 30);
		this.jButton2.setBounds(300, 90, 100, 30);
		this.jTextField.setBounds(150, 50, 150, 30);
		this.jTextField2.setBounds(200, 10, 80, 30);
		this.jTextField3.setBounds(470, 10, 80, 30);
		this.jTextField2.setEditable(false);
		this.jTextField3.setEditable(false);
		this.jTextField4.setEditable(false);
		this.jLabel5 = new JLabel("桌台号：");

		this.jLabel5.setFont(fnt2);

		this.jLabel5.setBounds(10, 10, 70, 20);

		this.jTextField8.setBounds(100, 10, 80, 20);
		this.jTextField8.setEditable(false);
		this.jTextField.getDocument().addDocumentListener(this);
		this.jTextField.addKeyListener(this);
		p2.add(jLabel5);
		p2.add(jTextField8);
		p3.add(jLabel);
		p3.add(jLabel2);
		p3.add(jLabel3);
		p3.add(jLabel4);
		p3.add(jTextField);
		 p3.add(jTextField4);
		p3.add(jButton);
		p3.add(jButton2);
		p3.add(jTextField2);
		p3.add(jTextField3);
		Object[] columnNames = { "序号", "菜品名称", "单价", "数量", "金额" };
		Object[][] data = new Object[][] {};
		this.jTable = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.dtm = new DefaultTableModel(data, columnNames);
		this.jTable.setModel(dtm);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(3, 200, 575, 200);
		this.add(jScrollPane);
		this.jButton.addActionListener(this);
		this.jButton2.addActionListener(this);

	}

	public void bindData() {
		int count = 0;
		PayBill payBill = new PayBill();
		payBill.setT_deskno(this.tableUse.getT_deskno());
		this.jTextField8.setText(this.tableUse.getT_deskno());
		payBillList = payBillService.getPayBill(payBill);
		for (int i = 0; i < payBillList.size(); i++) {
			dtm.addRow(new Object[] {
					i,
					payBillList.get(i).getV_name(),
					payBillList.get(i).getV_price(),
					payBillList.get(i).getV_count(),
					payBillList.get(i).getV_price()
							* Integer.parseInt(payBillList.get(i).getV_count()) });
			count += payBillList.get(i).getV_price()
					* Integer.parseInt(payBillList.get(i).getV_count());
		}
		this.jTextField2.setText(Integer.toString(count));
		this.jTextField3.setText(Integer.toString(count));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().trim().equals("完成结账")) {
			if (Double.parseDouble(this.jTextField3.getText()) > 0) {
				if(!this.jTextField4.getText().equals("")){
				if(Double.parseDouble(this.jTextField4.getText()) >=0){
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Income income = new Income();
				income.setU_id(this.userInfo.getU_id());
				income.setI_money(Double.parseDouble(this.jTextField3.getText()));
				income.setI_data(df.format(new java.util.Date()));
				if (incomService.addIncom(income) > 0) {
					JOptionPane.showMessageDialog(this, "结账成功");
					for (PayBill p : payBillList) {
						MenuInfo menuinfo = new MenuInfo();
						menuinfo.setM_name(p.getV_name());
						Sale sale = new Sale();
						sale.setM_id(menuService.getMenInfoList(menuinfo)
								.get(0).getM_id());
						sale.setS_count(Integer.parseInt(p.getV_count()));
						sale.setS_date(df.format(new java.util.Date()));
						saleService.addSale(sale);
					}
					PayBill payBill = new PayBill();
					payBill.setT_deskno(this.tableUse.getT_deskno());
					payBillService.deletePayBill(payBill);
					this.tableUse.setT_state("空闲");
					if (tableService.updataTable(this.tableUse) > 0) {      
						JOptionPane.showMessageDialog(this,
								this.tableUse.getT_deskno() + "桌已重置为空闲，请点击刷新更新桌子状态");
						this.dispose();
					} else {
						JOptionPane.showMessageDialog(this, "错误！");
					}
				} else {
					JOptionPane.showMessageDialog(this, "错误！");
				}
			}
				else{
					JOptionPane.showMessageDialog(this, "实收金额小于应收金额！");	
				}
			}
				else{
					JOptionPane.showMessageDialog(this, "请输入实收金额！");
				}
			} else {
				JOptionPane.showMessageDialog(this, "应付款为0");
			}
		}
		if (e.getActionCommand().trim().equals("退出结账")) {
			this.dispose();
		}

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	 Double res=(Double.parseDouble(this.jTextField.getText())-Double.parseDouble(this.jTextField3.getText()));
	    this.jTextField4.setText(res.toString());
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(!this.jTextField.getText().equals("")){
		 Double res=(Double.parseDouble(this.jTextField.getText())-Double.parseDouble(this.jTextField3.getText()));
		    this.jTextField4.setText(res.toString());
		}
		else{
			this.jTextField4.setText("");
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		 Double res=(Double.parseDouble(this.jTextField.getText())-Double.parseDouble(this.jTextField3.getText()));
		    this.jTextField4.setText(res.toString());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar = e.getKeyChar();
		if (!this.jTextField.getText().equals("")
				&& this.jTextField.getText().indexOf(".") < 0) {
			if (keyChar == '.'
					|| (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)) {

			} else {
				e.consume(); // 关键，屏蔽掉非法输入
			}
		} 
		 else {
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

				} else {
					e.consume(); // 关键，屏蔽掉非法输入
				}
			}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
