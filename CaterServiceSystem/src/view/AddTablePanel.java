package view;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import db.Dbutil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.*;
import service.*;
import java.util.*;
import java.io.*;
/**
 * 餐桌添加面板
 * @author 乐家良
 *
 */
public class AddTablePanel extends JPanel implements ActionListener {
	private JLabel jLabel;
	private JLabel jLabel2;
	private JRadioButton jRadioButton;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JTextField jTextField;
	private ButtonGroup buttonGroup;
	private JButton button;
	private JFileChooser fileChooser;
	private JTextField jTextField1;
	private JButton jButton1;
	private File file;
	private TableService tableService = new TableService();
	private JButton button2;
	private FileNameExtensionFilter filter;
	public AddTablePanel() {
		this.setSize(500, 500);
		this.setLayout(null);
		this.init();
	}

	public void init() {
		this.jLabel = new JLabel("桌名:");
		this.jLabel.setBounds(100, 100, 40, 40);
		this.jLabel2 = new JLabel("桌型:");
		this.jLabel2.setBounds(100, 200, 40, 40);
		this.jTextField = new JTextField();
		this.jTextField.setBounds(150, 100, 200, 40);
		this.jRadioButton = new JRadioButton("小桌");
		this.jRadioButton.setBounds(150, 200, 70, 40);
		this.jRadioButton1 = new JRadioButton("大桌");
		this.jRadioButton1.setBounds(220, 200, 70, 40);
		this.jRadioButton2 = new JRadioButton("包厢");
		this.jRadioButton2.setBounds(290, 200, 70, 40);
		this.jRadioButton.setOpaque(false);
		this.jRadioButton1.setOpaque(false);
		this.jRadioButton2.setOpaque(false);
		this.fileChooser = new JFileChooser();
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton);
		this.buttonGroup.add(jRadioButton1);
		this.buttonGroup.add(jRadioButton2);
		this.jTextField1 = new JTextField();
		this.jTextField1.setEditable(false);
		this.filter=new FileNameExtensionFilter("所有图片文件","png","gif","ico","tif","tiff","jpg","jpeg","jpe","jfif","bmp","dib");
		this.jButton1 = new JButton("确定");
		this.button2=new JButton("重置");
		this.button = new JButton("添加图片");
		this.button.setBounds(100, 280, 100, 40);
		this.jButton1.setBounds(100, 400, 100, 40);
		this.button2.setBounds(250, 400, 100, 40);
		this.jTextField1.setBounds(200, 280, 150, 40);
		this.jLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel.setForeground(new Color(92, 167, 186));
		this.jLabel2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jLabel2.setForeground(new Color(92, 167, 186));
		this.jRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton.setForeground(new Color(92, 167, 186));
		this.jRadioButton1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton1.setForeground(new Color(92, 167, 186));
		this.jRadioButton2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jRadioButton2.setForeground(new Color(92, 167, 186));
		this.button.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button.setForeground(new Color(92, 167, 186));
		this.button2.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.button2.setForeground(new Color(92, 167, 186));
		this.jButton1.setFont(new Font("华文行楷", Font.PLAIN, 14));
		this.jButton1.setForeground(new Color(92, 167, 186));
		this.jTextField.setOpaque(false);
		this.jTextField1.setOpaque(false);
		this.jTextField1.setText("非必须添加项");
		this.add(jLabel);
		this.add(jTextField);
		this.add(jRadioButton);
		this.add(jRadioButton1);
		this.add(jRadioButton2);
		this.add(button);
		this.add(jTextField1);
		this.add(jButton1);
		this.add(jLabel2);
		this.add(button2);
		this.button.addActionListener(this);
		this.jButton1.addActionListener(this);
		this.button2.addActionListener(this);
	}
public void clearElement(){
	this.jTextField.setText("");
	this.jTextField1.setText("非必须添加项");
	this.file=null;
	this.buttonGroup.clearSelection();
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("添加图片")) {
			this.fileChooser.setAcceptAllFileFilterUsed(false);
			this.fileChooser.setFileFilter(filter);
			this.fileChooser.showOpenDialog(null);
			file = this.fileChooser.getSelectedFile();
			if (file != null) {
				this.jTextField1.setText(file.getName());
			}
		}
		if (e.getActionCommand().equals("确定")) {
			TableUse tableUse = new TableUse();
			tableUse.setT_deskno(this.jTextField.getText());
			if (tableUse.getT_deskno().equals("")) {
				JOptionPane.showMessageDialog(this, "请填写桌名");
			}
			if (!tableUse.getT_deskno().equals("")) {
				if (tableService.getTable(tableUse).size() == 0) {
					if (this.jRadioButton.isSelected()) {
						tableUse.setT_note(this.jRadioButton.getText());
					}
					if (this.jRadioButton1.isSelected()) {
						tableUse.setT_note(this.jRadioButton1.getText());
					}
					if (this.jRadioButton2.isSelected()) {
						tableUse.setT_note(this.jRadioButton2.getText());
					}
					if (tableUse.getT_note() == null) {
						JOptionPane.showMessageDialog(this, "请选择桌型");
					}
					if (tableUse.getT_note() != null) {
						if (file != null) {
								try {
									FileInputStream fileInputStream = new FileInputStream(
											file);
									BufferedInputStream bufferedInputStream = new BufferedInputStream(
											fileInputStream);
									FileOutputStream fileOutputStream = new FileOutputStream(
											"images/" + tableUse.getT_deskno()+".png", false);
									BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
											fileOutputStream);
									byte[] b = new byte[1024];
									
										if (tableService.addTable(tableUse) > 0) {
											JOptionPane.showMessageDialog(this,
													"添加成功");
											try {
												int count = bufferedInputStream.read(b,
														0, 1024);
												while (count > 0) {
													bufferedOutputStream.write(b, 0,
															count);
													count = bufferedInputStream.read(b,
															0, 1024);
												}
												bufferedOutputStream.close();

										}catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}

										JOptionPane.showMessageDialog(this,
												"配图成功");
									} 
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							


						} else {
							if (tableService.addTable(tableUse) > 0) {
								JOptionPane.showMessageDialog(this, "添加成功");
							}
							JOptionPane.showMessageDialog(this, "没有进行配图");
						}
					}
				}

				else {
					JOptionPane.showMessageDialog(this, "重复的桌名");
				}
			}

		}
		if(e.getActionCommand().equals("重置")){
		this.clearElement();
		}
	}
}
