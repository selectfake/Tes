package cn.edu.jsu.zhangren.view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cn.edu.jsu.zhangren.service.registerservice;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * ����ע����
 * @author 10073
 *
 */
public class Register extends JInternalFrame {

	private static Register cf1 = null;
	private JTextField textField;
	private JPasswordField passwordField;

	public static synchronized Register getInstance() {
		if (cf1 == null) {
			cf1 = new Register();
		}
		return cf1;
	}

	public static void main() {

	}
	/**
	 * ���幹�췽���������弰���.
	 */
	public Register() {
		setBounds(100, 100, 450, 300);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		setForeground(Color.WHITE);

		setFrameIcon(new ImageIcon(Register.class.getResource("/background/.png")));
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("ע��");
		setBounds(100, 100, 512, 382);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(87, 68, 72, 18);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(87, 142, 72, 18);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(162, 65, 149, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(162, 139, 149, 24);
		getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = textField.getText();
				String password = passwordField.getText();

				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��", "Tip", JOptionPane.WARNING_MESSAGE);
				} else if (password.equals("")) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "Tip", JOptionPane.WARNING_MESSAGE);
				} else {
					int ans = registerservice.tores(id, password);
					if (ans == 1) {
						cl();
					}
				}
			}
		});
		btnNewButton.setBounds(204, 199, 72, 27);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Register.class.getResource("/background/1.png")));
		lblNewLabel_2.setBounds(0, 0, 496, 346);
		getContentPane().add(lblNewLabel_2);
	}
	/**
	 * ����رշ���
	 */
	public void cl() {
		this.dispose();
	}
}
