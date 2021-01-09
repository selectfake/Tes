package cn.edu.jsu.zhangren.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.Toolkit;
import java.io.File;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
/**
 * 定义主界面类
 * @author 10073
 *
 */
public class main {

	private JFrame frame;
	private JDesktopPane desktopPane;

	public static void main(String[] args) {
		
		// 当前系统的风格
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public main() {
		initialize();
	}

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("摄影约拍管理系统");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(main.class.getResource("/photo16/photografy.png")));
		frame.setBounds(100, 100, 709, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗口最大化
		
		 desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("source"+File.separator+"/background/dusk.png");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBackground(Color.WHITE);
		frame.getContentPane().add(desktopPane,BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(main.class.getResource("/photo16/menu.png")));
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u767B\u5F55");
		mnNewMenu_1.setIcon(new ImageIcon(main.class.getResource("/photo16/user.png")));
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("管理员登录");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin as= new adminlogin();
				as.setVisible(true);
				
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("用户登录");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIFrame(User.getInstance());
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("注册账户");
		mntmNewMenuItem_1.setIcon(new ImageIcon(main.class.getResource("/photo16/rigister.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIFrame(Register.getInstance());
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0,52, 53);
		desktopPane.add(toolBar);
		
		JButton player = new JButton("");//点击播放音乐
		player.setIcon(new ImageIcon(main.class.getResource("/photo32/player.jpg")));
		player.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new play("E:\\music\\blue.mp3").start();
				
			}
		});
		toolBar.add(player);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(1870, 0, 52, 50);
		desktopPane.add(toolBar_1);
		
		JButton btnNewButton = new JButton("");
		toolBar_1.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(main.class.getResource("/photo32/guanbi.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING) );
			}
		});
	}
		public void showIFrame(JInternalFrame jif) {
			//获取面板当中所有的子窗体
			JInternalFrame[] jif1 =desktopPane.getAllFrames();
			if(jif1.length>0) return;
//			for(JInternalFrame tmp:jif1)
//			{
//				if(tmp==jif) return;
//			}
			desktopPane.add(jif);
			jif.setVisible(true);//设置子窗体可见
			try {
				jif.setSelected(true);//选中子窗体
			} catch (PropertyVetoException e1) {
			e1.printStackTrace();
			}
			UiUtil.setFrameCenter(jif); 
		}
}
