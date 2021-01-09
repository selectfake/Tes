package cn.edu.jsu.zhangren.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
/**
 * ����Ա�������
 * 
 *
 */
public class adminframe extends JFrame {

	private JPanel contentPane;
File file = new File ("E:\\test\\Message.txt");
	File file1 =new File ("E:\\test\\Reserve.txt");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminframe frame = new adminframe();
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
	
	public adminframe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(adminframe.class.getResource("/background/.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);//���������ʾ
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	
		
		
		
//		setMaximizable(true);
//		setIconifiable(true);
//		setClosable(true);
//		setFrameIcon(new ImageIcon(AdminFunction.class.getResource("/background/10.png")));
		setTitle("����Ա");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);//���������ʾ

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1, 1);
		getContentPane().add(desktopPane);

		JButton btnNewButton = new JButton("�������");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader br = null;
			try {
				br =new BufferedReader(new FileReader(file1));
				if(file1.length()==0)
					JOptionPane.showMessageDialog(null, "���޶���");
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				String str = null;
				String st=null;
			
				try {
					while ((str = br.readLine()) != null) {
						JOptionPane.showMessageDialog(null," " + str);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(135, 28, 141, 27);
		getContentPane().add(btnNewButton);

		JButton change = new JButton("�޸���Ӱʦ��Ϣ");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Change c1 = new Change();
				c1.setVisible(true);
			}
		});
		change.setBounds(135, 108, 141, 27);
		getContentPane().add(change);

		JButton btnNewButton_2 = new JButton("�������");//ÿ������һ������
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));
					if(file.length()==0)
						JOptionPane.showMessageDialog(null, "��������");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String str = null;
				String st=null;
				
				try {
					while ((str = br.readLine()) != null) {
						
						JOptionPane.showMessageDialog(null, " " + str);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		btnNewButton_2.setBounds(135, 68, 141, 27);
		getContentPane().add(btnNewButton_2);

		JButton delete = new JButton("ɾ����Ӱʦ��Ϣ");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				DeleteMessage a = DeleteMessage.getInstance();
//				desktopPane.add(a);
//				a.setVisible(true);
//				try {
//					a.setSelected(true);
//				} catch (PropertyVetoException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				DeleteMessage a =new DeleteMessage();
				a.setVisible(true);
			}
		});
		delete.setBounds(135, 148, 141, 27);
		getContentPane().add(delete);

		JButton addm = new JButton("������Ӱʦ��Ϣ");
		addm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMessage a1 = new AddMessage();
				a1.setVisible(true);
			}
		});
		addm.setBounds(134, 188, 142, 27);
		getContentPane().add(addm);
	}

}
