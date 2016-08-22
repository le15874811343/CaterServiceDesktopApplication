package view;

import javax.swing.*;

import service.CommentService;
import service.IncomService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.*;

/**
 * 点评窗口
 * 
 * @author 乐家良
 * 
 */
public class CommentJFrame extends JDialog implements ActionListener {
	private JRadioButton jRadioButton;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	private JRadioButton jRadioButton5;
	private JRadioButton jRadioButton6;
	private JRadioButton jRadioButton7;
	private JRadioButton jRadioButton8;
	private JRadioButton jRadioButton9;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JScrollPane jScrollPane;
	private JTextArea jTextArea;
	private JButton jButton;
	private ButtonGroup buttonGroup;
	private ButtonGroup buttonGroup1;
	private CommentPanel commentPanel = new CommentPanel();
	private CommentService commentService = new CommentService();
	private IncomService incomService=new IncomService();
	private Income income=new Income();
 private UserInfo userInfo;
	public CommentJFrame(UserInfo userInfo) {
		this.setTitle("感谢您的到来");
		this.setSize(600, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(commentPanel);
		this.setModal(true);
		this.userInfo=userInfo;
		income.setU_id(this.userInfo.getU_id());
		this.init();
		this.setVisible(true);
	}

	public void init() {
		this.jLabel = new JLabel("服务态度");
		this.jLabel.setBounds(50, 50, 100, 50);
		this.jLabel1 = new JLabel("极差");
		this.jLabel1.setBounds(50, 100, 100, 50);
		ImageIcon icon = new ImageIcon("images/一颗.png");
		this.jRadioButton = new JRadioButton();
		this.jRadioButton.setName("极差");
		this.jRadioButton.setBounds(150, 100, 100, 50);
		this.jLabel2 = new JLabel("差");
		this.jLabel2.setBounds(50, 150, 100, 50);
		this.jRadioButton1 = new JRadioButton();
		this.jRadioButton1.setName("差");
		this.jRadioButton1.setBounds(150, 150, 100, 50);
		this.jLabel3 = new JLabel("一般");
		this.jLabel3.setBounds(50, 200, 100, 50);
		this.jRadioButton2 = new JRadioButton();
		this.jRadioButton2.setName("一般");
		this.jRadioButton2.setBounds(150, 200, 100, 50);
		this.jLabel4 = new JLabel("好");
		this.jLabel4.setBounds(50, 250, 100, 50);
		this.jRadioButton3 = new JRadioButton();
		this.jRadioButton3.setName("好");
		this.jRadioButton3.setBounds(150, 250, 100, 50);
		this.jLabel5 = new JLabel("非常好");
		this.jLabel5.setBounds(50, 300, 100, 50);
		this.jRadioButton4 = new JRadioButton();
		this.jRadioButton4.setName("非常好");
		this.jRadioButton4.setBounds(150, 300, 100, 50);
		this.jLabel6 = new JLabel("菜品口感");
		this.jLabel6.setBounds(300, 50, 100, 50);
		this.jLabel7 = new JLabel("极差");
		this.jLabel7.setBounds(300, 100, 100, 50);
		this.jRadioButton5 = new JRadioButton();
		this.jRadioButton5.setName("极差");
		this.jRadioButton5.setBounds(400, 100, 100, 50);
		this.jLabel8 = new JLabel("差");
		this.jLabel8.setBounds(300, 150, 100, 50);
		this.jRadioButton6 = new JRadioButton();
		this.jRadioButton6.setName("差");
		this.jRadioButton6.setBounds(400, 150, 100, 50);
		this.jLabel9 = new JLabel("一般");
		this.jLabel9.setBounds(300, 200, 100, 50);
		this.jRadioButton7 = new JRadioButton();
		this.jRadioButton7.setName("一般");
		this.jRadioButton7.setBounds(400, 200, 100, 50);
		this.jLabel10 = new JLabel("好");
		this.jLabel10.setBounds(300, 250, 100, 50);
		this.jRadioButton8 = new JRadioButton();
		this.jRadioButton8.setName("好");
		this.jRadioButton8.setBounds(400, 250, 100, 50);
		this.jLabel11 = new JLabel("非常好");
		this.jLabel11.setBounds(300, 300, 100, 50);
		this.jRadioButton9 = new JRadioButton();
		this.jRadioButton9.setName("非常好");
		this.jRadioButton9.setBounds(400, 300, 100, 50);
		this.jScrollPane = new JScrollPane();
		this.jTextArea = new JTextArea();
		this.jScrollPane.getViewport().setView(jTextArea);
		this.jScrollPane.setBounds(0, 360, 580, 140);
		this.jButton = new JButton("完成");
		this.jButton.setBounds(260, 500, 80, 40);
		this.jRadioButton.setOpaque(false);
		this.jRadioButton1.setOpaque(false);
		this.jRadioButton2.setOpaque(false);
		this.jRadioButton3.setOpaque(false);
		this.jRadioButton4.setOpaque(false);
		this.jRadioButton5.setOpaque(false);
		this.jRadioButton6.setOpaque(false);
		this.jRadioButton7.setOpaque(false);
		this.jRadioButton8.setOpaque(false);
		this.jRadioButton9.setOpaque(false);
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup1 = new ButtonGroup();
		this.buttonGroup.add(jRadioButton);
		this.buttonGroup.add(jRadioButton1);
		this.buttonGroup.add(jRadioButton2);
		this.buttonGroup.add(jRadioButton3);
		this.buttonGroup.add(jRadioButton4);
		this.buttonGroup1.add(jRadioButton5);
		this.buttonGroup1.add(jRadioButton6);
		this.buttonGroup1.add(jRadioButton7);
		this.buttonGroup1.add(jRadioButton8);
		this.buttonGroup1.add(jRadioButton9);
		this.add(jLabel);
		this.add(jLabel1);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel5);
		this.add(jLabel6);
		this.add(jLabel7);
		this.add(jLabel8);
		this.add(jLabel9);
		this.add(jLabel10);
		this.add(jLabel11);
		this.add(jRadioButton);
		this.add(jRadioButton1);
		this.add(jRadioButton2);
		this.add(jRadioButton3);
		this.add(jRadioButton4);
		this.add(jRadioButton5);
		this.add(jRadioButton6);
		this.add(jRadioButton7);
		this.add(jRadioButton8);
		this.add(jRadioButton9);
		this.add(jScrollPane);
		this.add(jButton);
		this.jButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("完成")) {
			Comment comment = new Comment();
			if (jRadioButton.isSelected()) {
				comment.setService(jRadioButton.getName());
			}
			if (jRadioButton1.isSelected()) {
				comment.setService(jRadioButton1.getName());
			}
			if (jRadioButton2.isSelected()) {
				comment.setService(jRadioButton2.getName());
			}
			if (jRadioButton3.isSelected()) {
				comment.setService(jRadioButton3.getName());
			}
			if (jRadioButton4.isSelected()) {
				comment.setService(jRadioButton4.getName());
			}
			if (jRadioButton5.isSelected()) {
				comment.setTaste(jRadioButton5.getName());
			}
			if (jRadioButton6.isSelected()) {
				comment.setTaste(jRadioButton6.getName());
			}
			if (jRadioButton7.isSelected()) {
				comment.setTaste(jRadioButton7.getName());
			}
			if (jRadioButton8.isSelected()) {
				comment.setTaste(jRadioButton8.getName());
			}
			if (jRadioButton9.isSelected()) {
				comment.setTaste(jRadioButton9.getName());
			}
		List<Income> inList=	incomService.getIncome(income);
			comment.setU_id(this.userInfo.getU_id());
			comment.setI_id(inList.get(inList.size()-1).getI_id());
			comment.setNote(this.jTextArea.getText());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			comment.setDate(df.format(new java.util.Date()));
			if (comment.getService() == null) {
				JOptionPane.showMessageDialog(this, "请勾选服务态度选项");
			}
			if (comment.getTaste() == null) {
				JOptionPane.showMessageDialog(this, "请勾选菜品口味选项");
			}
			Comment findComment=new Comment();
			findComment.setI_id(comment.getI_id());
			if(commentService.getComment(findComment).size()!=0){
				JOptionPane.showMessageDialog(this, "禁止自己刷评价！");
			}
			else {
				if (commentService.addComment(comment) > 0) {
					JOptionPane.showMessageDialog(this, "感谢您的评价，祝您生活愉快");
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "发生了一个错误，请关闭评论窗并联系管理员");
				}
			}
		}
	}
}
