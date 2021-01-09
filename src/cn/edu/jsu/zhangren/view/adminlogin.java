package cn.edu.jsu.zhangren.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import cn.edu.jsu.zhangren.service.manferlogin;
import java.awt.Toolkit;
/**
 * ����Ա��¼����
 */
public class adminlogin extends JFrame {

	private JPanel contentPane;
private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin frame = new adminlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ���幹�췽���������弰���.
	 */
	
	public adminlogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(adminlogin.class.getResource("/background/.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		
		
		
		//setFrameIcon(new ImageIcon(Admin.class.getResource("/background/10.png")));
		setTitle("����Ա��¼");
//		setClosable(true);
//		setMaximizable(true);
//		setIconifiable(true);
		setBounds(100, 100, 500, 400);
		this.setLocationRelativeTo(null);//���������ʾ
		
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("source"+File.separator+"/background/1.png");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};

		desktopPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
	

		
		JButton denglu = new JButton("");
		denglu.setIcon(new ImageIcon(adminlogin.class.getResource("/photo32/login1.png")));
		denglu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = passwordField.getText();
				if(manferlogin.tologin(pwd)==1) {
					
					adminframe ad = new adminframe();
					ad.setVisible(true);
					
					cl();
			}
			}
		});
		denglu.setBounds(339, 112, 31, 33);
		desktopPane.add(denglu);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordField.setBounds(126, 112, 216, 33);
		desktopPane.add(passwordField);
	}
	/**
	 * ����رշ���
	 */
	public void cl() {
		this.dispose();
	}
}
