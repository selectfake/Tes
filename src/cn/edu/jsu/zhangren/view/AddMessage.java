package cn.edu.jsu.zhangren.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.zhangren.dao.DatabaseConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
/**
 * 增加摄影师信息
 */
public class AddMessage extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField sex;
	private JTextField phone;
	private JTextField zp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMessage frame = new AddMessage();
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
	public AddMessage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddMessage.class.getResource("/background/.png")));
		setTitle("增加摄影师信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblNewLabel.setBounds(31, 13, 72, 18);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(133, 10, 120, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("性别");
		lblNewLabel_1.setBounds(31, 57, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		sex = new JTextField();
		sex.setBounds(131, 54, 122, 24);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("电话");
		lblNewLabel_2.setBounds(31, 98, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		phone = new JTextField();
		phone.setBounds(133, 95, 120, 24);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("作品");
		lblNewLabel_3.setBounds(31, 148, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		zp = new JTextField();
		zp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		zp.setBounds(132, 145, 121, 24);
		contentPane.add(zp);
		zp.setColumns(10);
		
		JButton btnadd = new JButton("增加");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				addcommodity(name.getText(),sex.getText(),phone.getText(),zp.getText());
				JOptionPane.showMessageDialog(null, "增加成功");
				name.setText("");
				sex.setText("");
				phone.setText("");
				zp.setText("");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnadd.setBounds(305, 13, 113, 153);
		contentPane.add(btnadd);
		
		
	
	
	    }
	
private Connection conn = null;
private PreparedStatement stmt = null;
private JTextField textField;
/*向数据库中增加商品信息*/
public void addcommodity(String xm,String xb,String dh,String zp) throws SQLException {
	String sql = "replace into curriculumdesign.datainput(xm,xb,dh,zp)values(?,?,?,?)";
	DatabaseConnectionSql DbCM=new DatabaseConnectionSql();
	conn=DbCM.getConnection();
	stmt = conn.prepareStatement(sql);
 stmt.setString(1,xm);
 stmt.setString(2,xb);
 stmt.setString(3,dh);
 stmt.setString(4,zp);
 stmt.executeUpdate();
}
}