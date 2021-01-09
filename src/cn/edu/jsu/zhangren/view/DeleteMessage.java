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
 * ����ɾ����
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
	 * ���幹�췽���������弰���.
	 */
	public DeleteMessage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteMessage.class.getResource("/photo16/photografy.png")));
		setTitle("ɾ����Ϣ");
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
		this.setLocationRelativeTo(null);//���ھ���

		String[] titles = { "����", "�Ա�", "�绰" ,"��Ʒ"};// ���������ʾ������
		DefaultTableModel model = new DefaultTableModel(titles, 0);// ����������ģ�͵ı����������(Ϊ0��)
		table = new JTable(model) { // ʵ�������װ�ر��ģ�� //********************************//
			public boolean isCellEditable(int rowIndex, int columnIndex) { // �������б�Ų��ɱ༭,����0��
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
		JButton btnDelete = new JButton("ɾ��ѡ����");
		btnDelete.setBounds(314, 375, 207, 45);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
					if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "", JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
						String s = (String) table.getValueAt(table.getSelectedRow(), 0);
						model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
						// �ӱ��������ɾ����,model1ΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
						table.convertRowIndexToModel(table.getSelectedRow());
						DatabaseConnectionSql dbcs = new DatabaseConnectionSql();
						String sql = "delete from datainput where num=?";
						try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ�����
								PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����
							pstmt.setString(1, s); // ͨ��
							pstmt.executeUpdate();// ִ��ɾ��
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
					}
				}
			}
		});
		btnDelete.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		contentPane.add(btnDelete);
	}
}