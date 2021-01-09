package cn.edu.jsu.zhangren.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
/**
 * ����������
 * @author 10073
 *
 */
public class iotxt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iotxt frame = new iotxt();
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
	public iotxt() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(iotxt.class.getResource("/background/.png")));
		setTitle("����������");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//���ھ���

		JLabel lblNewLabel = new JLabel("����������");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel.setBounds(129, 33, 148, 41);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setBounds(63, 87, 279, 125);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel Tip1 = new JLabel("");
		Tip1.setForeground(Color.RED);
		Tip1.setFont(new Font("����", Font.PLAIN, 20));
		Tip1.setBounds(448, 59, 214, 33);
		contentPane.add(Tip1);

		// ��JTextField��ӽ����¼�
		textField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				String t1 = textField.getText();// ����


				Boolean flag = true;
				if (t1.length() == 0) {
					Tip1.setText("���Բ���Ϊ��");
					flag = false;
				
				} else {
					Tip1.setText("");
				}
			}
		});

		textField.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {


			}
		});

		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = textField.getText();// ����


				Boolean flag = true;
				if (t1.length() == 0) {
					Tip1.setText("���Բ���Ϊ��");
					flag = false;
				
				} else {
					Tip1.setText("");
				}

				
				
				if (flag) {

					addtotxt(t1);
					textField.setText("");

				}

			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(144, 225, 113, 29);
		contentPane.add(btnNewButton);

	}

/**
 * �����������Է���
 * @param t1
 */
	public static void addtotxt(String t1) {

		//�������·��
		File file = new File("E:\\test\\Message.txt");

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

			fw.write(t1 + "\t" + "\n");
			JOptionPane.showMessageDialog(null, "success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}





