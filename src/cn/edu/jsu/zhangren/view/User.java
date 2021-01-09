package cn.edu.jsu.zhangren.view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import cn.edu.jsu.zhangren.service.loginservice;

import javax.swing.event.AncestorEvent;
/**
 * �����û���¼��
 * @author 10073
 *
 */
public class User extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private static User cf1 = null;
	private JTextField zh;
	private JPasswordField passwordField_1;

	public static synchronized User getInstance() {
		if (cf1 == null) {
			cf1 = new User();
		}
		return cf1;
	}
	/**
	 * ���幹�췽���������弰���.
	 */
	private User() {
		setFrameIcon(new ImageIcon(User.class.getResource("/background/.png")));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("�û�");
		setBounds(100, 100, 500, 400);
		



		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("source"+File.separator+"/background/1.png");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("�˻�");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}

			public void ancestorMoved(AncestorEvent arg0) {
			}

			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		lblNewLabel.setBounds(97, 99, 72, 18);
		desktopPane.add(lblNewLabel);

		zh = new JTextField();
		zh.setBounds(164, 96, 193, 24);
		desktopPane.add(zh);
		zh.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(97, 160, 72, 18);
		desktopPane.add(lblNewLabel_1);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(164, 157, 193, 24);
		desktopPane.add(passwordField_1);

		JButton btnNewButton = new JButton("��¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = zh.getText();
				String password = passwordField_1.getText();

				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��", "Tip", JOptionPane.WARNING_MESSAGE);
				} else if (password.equals("")) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "Tip", JOptionPane.WARNING_MESSAGE);
				} else {

					int ans = loginservice.tologin(id, password);
					if (ans == 1) {
						
						userframe uf =new userframe();
						uf.setVisible(true);
						cl();
					}

				}

			}
		});
		btnNewButton.setBounds(210, 231, 63, 24);
		desktopPane.add(btnNewButton);

	}
	/**
	 * ����رշ���
	 */
	public void cl() {
		this.dispose();
	}
}
