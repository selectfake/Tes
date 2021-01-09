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
 * ������������
 * @author 10073
 *
 */
public class main {

	private JFrame frame;
	private JDesktopPane desktopPane;

	public static void main(String[] args) {
		
		// ��ǰϵͳ�ķ��
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
	 * ���幹�췽���������弰���.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("��ӰԼ�Ĺ���ϵͳ");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(main.class.getResource("/photo16/photografy.png")));
		frame.setBounds(100, 100, 709, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//�������
		
		 desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("source"+File.separator+"/background/dusk.png");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("����Ա��¼");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin as= new adminlogin();
				as.setVisible(true);
				
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("�û���¼");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIFrame(User.getInstance());
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ע���˻�");
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
		
		JButton player = new JButton("");//�����������
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
			//��ȡ��嵱�����е��Ӵ���
			JInternalFrame[] jif1 =desktopPane.getAllFrames();
			if(jif1.length>0) return;
//			for(JInternalFrame tmp:jif1)
//			{
//				if(tmp==jif) return;
//			}
			desktopPane.add(jif);
			jif.setVisible(true);//�����Ӵ���ɼ�
			try {
				jif.setSelected(true);//ѡ���Ӵ���
			} catch (PropertyVetoException e1) {
			e1.printStackTrace();
			}
			UiUtil.setFrameCenter(jif); 
		}
}
