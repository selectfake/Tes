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
 * 定义留言类
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
	 * 定义构造方法创建窗体及组件.
	 */
	public iotxt() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(iotxt.class.getResource("/background/.png")));
		setTitle("请输入留言");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//窗口居中

		JLabel lblNewLabel = new JLabel("请输入留言");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(129, 33, 148, 41);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(63, 87, 279, 125);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel Tip1 = new JLabel("");
		Tip1.setForeground(Color.RED);
		Tip1.setFont(new Font("宋体", Font.PLAIN, 20));
		Tip1.setBounds(448, 59, 214, 33);
		contentPane.add(Tip1);

		// 给JTextField添加焦点事件
		textField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				String t1 = textField.getText();// 留言


				Boolean flag = true;
				if (t1.length() == 0) {
					Tip1.setText("留言不能为空");
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

		JButton btnNewButton = new JButton("发送");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = textField.getText();// 留言


				Boolean flag = true;
				if (t1.length() == 0) {
					Tip1.setText("留言不能为空");
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
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(144, 225, 113, 29);
		contentPane.add(btnNewButton);

	}

/**
 * 定义增加留言方法
 * @param t1
 */
	public static void addtotxt(String t1) {

		//该这里的路径
		File file = new File("E:\\test\\Message.txt");

		try (FileWriter fw = new FileWriter(file, true);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);) {

			String row = null;

			while ((row = br.readLine())!=null) {

				if(row.contains(t1)) {
					JOptionPane.showMessageDialog(null, "此留言已存在，不能增加");
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





