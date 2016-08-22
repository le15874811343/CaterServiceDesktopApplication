package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import db.Dbutil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.*;
import service.*;

import java.util.*;
import java.io.*;
/**
 * ��Ʒ������
 * @author �ּ���
 *
 */
public class AddMenuPanel extends JPanel implements ActionListener, KeyListener {
	private JLabel jLabel;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JRadioButton jRadioButton;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JTextField jTextField;
	private JTextField jTextField2;
	private ButtonGroup buttonGroup;
	private JButton button;
	private JFileChooser fileChooser;
	private JTextField jTextField1;
	private JButton jButton1;
	private File file;
	private MenuService menuService = new MenuService();
	private JButton button2;
	private FileNameExtensionFilter filter;

	public AddMenuPanel() {
		this.setSize(500, 500);
		this.setLayout(null);
		this.init();
	}

	public void init() {
		this.jLabel = new JLabel("�۸�:");
		this.jLabel.setBounds(80, 120, 40, 40);
		this.jLabel2 = new JLabel("����:");
		this.jLabel2.setBounds(80, 200, 40, 40);
		this.jLabel3 = new JLabel("����:");
		this.jLabel3.setBounds(80, 50, 40, 40);
		this.jTextField = new JTextField();
		this.jTextField.setBounds(150, 120, 200, 40);
		this.jTextField2 = new JTextField();
		this.jTextField2.setBounds(150, 50, 200, 40);
		this.jRadioButton = new JRadioButton("С��");
		this.jRadioButton.setBounds(120, 200, 70, 40);
		this.jRadioButton1 = new JRadioButton("���");
		this.jRadioButton1.setBounds(190, 200, 70, 40);
		this.jRadioButton2 = new JRadioButton("��");
		this.jRadioButton2.setBounds(260, 200, 70, 40);
		this.jRadioButton3 = new JRadioButton("��Ʒ");
		this.jRadioButton3.setBounds(320, 200, 70, 40);
		this.jRadioButton.setOpaque(false);
		this.jRadioButton1.setOpaque(false);
		this.jRadioButton2.setOpaque(false);
		this.jRadioButton3.setOpaque(false);
		this.filter = new FileNameExtensionFilter("����ͼƬ�ļ�", "png", "gif",
				"ico", "tif", "tiff", "jpg", "jpeg", "jpe", "jfif", "bmp",
				"dib");
		this.fileChooser = new JFileChooser();
		this.buttonGroup = new ButtonGroup();
		this.buttonGroup.add(jRadioButton);
		this.buttonGroup.add(jRadioButton1);
		this.buttonGroup.add(jRadioButton2);
		this.buttonGroup.add(jRadioButton3);
		this.jTextField1 = new JTextField();
		this.jTextField1.setEditable(false);
		this.jButton1 = new JButton("ȷ��");
		this.button2 = new JButton("����");
		this.button = new JButton("���ͼƬ");
		this.button.setBounds(100, 280, 100, 40);
		this.jButton1.setBounds(100, 400, 100, 40);
		this.button2.setBounds(250, 400, 100, 40);
		this.jTextField1.setBounds(200, 280, 150, 40);
		this.jLabel.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jLabel.setForeground(new Color(92, 167, 186));
		this.jLabel3.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jLabel3.setForeground(new Color(92, 167, 186));
		this.jLabel2.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jLabel2.setForeground(new Color(92, 167, 186));
		this.jRadioButton.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jRadioButton.setForeground(new Color(92, 167, 186));
		this.jRadioButton1.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jRadioButton1.setForeground(new Color(92, 167, 186));
		this.jRadioButton2.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jRadioButton2.setForeground(new Color(92, 167, 186));
		this.jRadioButton3.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jRadioButton3.setForeground(new Color(92, 167, 186));
		this.button.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.button.setForeground(new Color(92, 167, 186));
		this.button2.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.button2.setForeground(new Color(92, 167, 186));
		this.jButton1.setFont(new Font("�����п�", Font.PLAIN, 14));
		this.jButton1.setForeground(new Color(92, 167, 186));
		this.jTextField.setOpaque(false);
		this.jTextField1.setOpaque(false);
		this.jTextField2.setOpaque(false);

		this.jTextField1.setText("�Ǳ��������");
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
		this.add(jRadioButton3);
		this.add(jLabel3);
		this.add(jTextField2);
		this.button.addActionListener(this);
		this.jButton1.addActionListener(this);
		this.button2.addActionListener(this);
		this.jTextField.addKeyListener(this);
	}
	public void clearElement(){
		this.jTextField.setText("");
		this.jTextField1.setText("�Ǳ��������");
		this.jTextField2.setText("");
		this.file=null;
		this.buttonGroup.clearSelection();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("���ͼƬ")) {
			this.fileChooser.setAcceptAllFileFilterUsed(false);
			this.fileChooser.setFileFilter(filter);
			this.fileChooser.showOpenDialog(null);
			file = this.fileChooser.getSelectedFile();
			if (file != null) {
				this.jTextField1.setText(file.getName());
			}
		}
		if (e.getActionCommand().equals("ȷ��")) {
			MenuInfo menuInfo = new MenuInfo();
			menuInfo.setM_name(this.jTextField2.getText());
			if (menuInfo.getM_name().equals("")) {

				JOptionPane.showMessageDialog(this, "����д����");
			}
			if (!menuInfo.getM_name().equals("")) {
				if (menuService.getMenInfoList(menuInfo).size() == 0) {
					if (this.jTextField.getText().equals("")) {
						JOptionPane.showMessageDialog(this, "������۸�");
					}
					if (!this.jTextField.getText().equals("")) {
						menuInfo.setM_price(Double.parseDouble(this.jTextField
								.getText()));
					}
					if (this.jRadioButton.isSelected()) {
						menuInfo.setM_type(this.jRadioButton.getText());
					}
					if (this.jRadioButton1.isSelected()) {
						menuInfo.setM_type(this.jRadioButton1.getText());
					}
					if (this.jRadioButton2.isSelected()) {
						menuInfo.setM_type(this.jRadioButton2.getText());
					}
					if (this.jRadioButton3.isSelected()) {
						menuInfo.setM_type(this.jRadioButton3.getText());
					}
					if (menuInfo.getM_type() == null) {
						JOptionPane.showMessageDialog(this, "��ѡ������");
					}
					if (menuInfo.getM_type() != null
							&& menuInfo.getM_price() != 0) {
						if (file != null) {

							try {
								FileInputStream fileInputStream = new FileInputStream(
										file);
								BufferedInputStream bufferedInputStream = new BufferedInputStream(
										fileInputStream);
								FileOutputStream fileOutputStream = new FileOutputStream(
										"images/" + menuInfo.getM_name()
												+ ".jpg", false);
								BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
										fileOutputStream);
								byte[] b = new byte[1024];

								if (menuService.addMenu(menuInfo) > 0) {
									JOptionPane.showMessageDialog(this, "��ӳɹ�");
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

									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									JOptionPane.showMessageDialog(this, "��ͼ�ɹ�");
								}
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else {
							if (menuService.addMenu(menuInfo) > 0) {
								JOptionPane.showMessageDialog(this, "��ӳɹ�");
							}
							JOptionPane.showMessageDialog(this, "û�н�����ͼ");
						}
					}
				}

				else {
					JOptionPane.showMessageDialog(this, "�ظ��Ĳ���");
				}
			}

		}
		if (e.getActionCommand().equals("����")) {
			this.clearElement();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar = e.getKeyChar();
		if(!this.jTextField.getText().equals("")&&this.jTextField.getText().indexOf(".")<0){
		if (keyChar=='.'||(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)) {

		} else {
			e.consume(); // �ؼ������ε��Ƿ�����
		}
		}
		else{
			if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

			} else {
				e.consume(); // �ؼ������ε��Ƿ�����
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
