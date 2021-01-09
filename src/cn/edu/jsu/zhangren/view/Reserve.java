package cn.edu.jsu.zhangren.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * ����Ԥ����
 * @author 10073
 *
 */
public class Reserve extends JFrame {

	private JPanel contentPane;
	private JTextField xm;
	private JTextField dh;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserve frame = new Reserve();
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
	public Reserve() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reserve.class.getResource("/background/.png")));
		setTitle("��ӰʦԤ��");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("������");
		lblNewLabel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel.setBounds(169, 45, 198, 41);
		contentPane.add(lblNewLabel);

		xm = new JTextField();
		xm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		xm.setFont(new Font("����", Font.PLAIN, 20));
		xm.setBounds(151, 86, 162, 33);
		contentPane.add(xm);
		xm.setColumns(10);

		JLabel Tip1 = new JLabel("");
		Tip1.setForeground(Color.RED);
		Tip1.setFont(new Font("����", Font.PLAIN, 20));
		Tip1.setBounds(448, 59, 214, 33);
		contentPane.add(Tip1);
		JLabel Tip2 = new JLabel("");
		Tip2.setForeground(Color.RED);
		Tip2.setFont(new Font("����", Font.PLAIN, 20));
		Tip2.setBounds(448, 59, 214, 33);
		contentPane.add(Tip1);

		// ��JTextField��ӽ����¼�
		xm.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				String t1 = xm.getText();// ����


				Boolean flag = true;
				if (t1.length() == 0) {
					Tip1.setText("��Ӱʦ��Ϣ����Ϊ��");
					flag = false;
				
				} else {
					Tip1.setText("");
				}
			}
		});

		xm.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {


			}
		});

		JButton btnNewButton = new JButton("Ԥ��");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = xm.getText();// Ԥ��
				String t2 = dh.getText();

				Boolean flag = true;
				if (t1.length() == 0) {
					Tip1.setText("��Ӱʦ���ֲ���Ϊ��");
					flag = false;
				
				} else {
					Tip1.setText("");
				}
				
				
				if(t2.length()==0) {
					Tip2.setText("�绰��Ϣ����Ϊ��");
				}else {
					Tip2.setText("");
				}
				
				
				if (flag) {

					addtotxt(t1,t2);
					xm.setText("");
					dh.setText("");
				}
				
				

			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(169, 172, 113, 29);
		contentPane.add(btnNewButton);
		
		dh = new JTextField();
		dh.setBounds(151, 125, 162, 33);
		contentPane.add(dh);
		dh.setColumns(10);
		
		lblNewLabel_1 = new JLabel("��Ӱʦ����");
		lblNewLabel_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblNewLabel_1.setBounds(61, 95, 90, 18);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("��ĵ绰");
		lblNewLabel_2.setBounds(66, 132, 72, 18);
		contentPane.add(lblNewLabel_2);

	}

/**
 * �������ӵ�txt�ĵ��ķ���
 * @param t1
 * @param t2
 */
	public static void addtotxt(String t1,String t2) {

		//�������·��
		File file = new File("E:\\test\\Reserve.txt");

		try (FileWriter fw = new FileWriter(file, true);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);) {

			String row = null;

			while ((row = br.readLine())!=null) {

				if(row.contains(t1)) {
					JOptionPane.showMessageDialog(null, "�������Ѵ��ڣ���������");
					return;
				}
			}

			fw.write("��Ӱʦ����:"+t1 + "       " +"��ĵ绰:"+ t2+"\n");
			JOptionPane.showMessageDialog(null, "success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}