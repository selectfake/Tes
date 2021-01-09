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
 * 管理员登录界面
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
	 * 定义构造方法创建窗体及组件.
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
		setTitle("管理员登录");
//		setClosable(true);
//		setMaximizable(true);
//		setIconifiable(true);
		setBounds(100, 100, 500, 400);
		this.setLocationRelativeTo(null);//窗体居中显示
		
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("source"+File.separator+"/background/1.png");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
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
	 * 定义关闭方法
	 */
	public void cl() {
		this.dispose();
	}
}
