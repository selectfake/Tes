package cn.edu.jsu.zhangren.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
/**
 * �����û�������
 * @author 10073
 *
 */
public class userframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userframe frame = new userframe();
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
	public userframe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(userframe.class.getResource("/photo16/photografy.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		setTitle("�û�");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);//���ھ���
		
		JButton btnNewButton = new JButton("�����Ӱʦ���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FindMessage d3=new FindMessage();
				d3.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setBounds(131, 57, 159, 27);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("���Խ���");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iotxt a1 = new iotxt();
				a1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(131, 108, 159, 27);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("��ӰʦԤ��");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reserve r1 =new Reserve();
				r1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(131, 166, 159, 27);
		getContentPane().add(btnNewButton_2);

	}

}
