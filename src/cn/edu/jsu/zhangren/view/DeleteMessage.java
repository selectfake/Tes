package cn.edu.jsu.zhangren.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.zhangren.dao.AllDate;
import cn.edu.jsu.zhangren.dao.DatabaseConnectionSql;
import cn.edu.jsu.zhangren.vo.Peo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.awt.Toolkit;
/**
 * 定义删除类
 */
public class DeleteMessage extends JFrame {
//	private static DeleteMessage cframe = null;
//
//	public static synchronized DeleteMessage getInstance() {
//		if (cframe == null) {
//			cframe = new DeleteMessage();
//		}
//		return cframe;
//	}

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMessage frame = new DeleteMessage();
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
	public DeleteMessage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteMessage.class.getResource("/photo16/photografy.png")));
		setTitle("删除信息");
//		setIconifiable(true);
//		try {
//			setClosed(true);
//		} catch (PropertyVetoException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		setClosable(true);
		setBounds(100, 100, 863, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 28, 685, 314);
		contentPane.add(scrollPane);
		this.setLocationRelativeTo(null);//窗口居中

		String[] titles = { "姓名", "性别", "电话" ,"作品"};// 定义数组表示表格标题
		DefaultTableModel model = new DefaultTableModel(titles, 0);// 定义表格数据模型的表格标题和行数(为0行)
		table = new JTable(model) { // 实例化表格装载表格模型 //********************************//
			public boolean isCellEditable(int rowIndex, int columnIndex) { // 设置所有编号不可编辑,即第0列
				if (columnIndex == 0)
					return false;
				return true;
			}
		};

		List<Peo> peo = new AllDate().getAllPetData();
		for (Peo p : peo) {
			model.addRow(p.toString().split("\t"));
		}

		scrollPane.setViewportView(table);

////////////////////////////////////////////////////////////
		JButton btnDelete = new JButton("删除选中行");
		btnDelete.setBounds(314, 375, 207, 45);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
					if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "", JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
						String s = (String) table.getValueAt(table.getSelectedRow(), 0);
						model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						// 从表格数据中删除行,model1为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
						table.convertRowIndexToModel(table.getSelectedRow());
						DatabaseConnectionSql dbcs = new DatabaseConnectionSql();
						String sql = "delete from datainput where num=?";
						try (Connection conn = dbcs.getConnection(); // 获取数据库连接
								PreparedStatement pstmt = conn.prepareStatement(sql);) {// 实例化
							pstmt.setString(1, s); // 通配
							pstmt.executeUpdate();// 执行删除
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "请选择要删除的行");
					}
				}
			}
		});
		btnDelete.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		contentPane.add(btnDelete);
	}
}