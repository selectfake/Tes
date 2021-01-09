package cn.edu.jsu.zhangren.view;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.zhangren.dao.DatabaseConnectionSql;
/**
 * �����������������
 * @author 10073
 *
 */
class Stu{
	private String xb;

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

}
/**
 * ���幹�췽���������弰���.
 */
public class DataOperate {
	// ��������
	private static String firstName = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	// ����Ů������
	private static String girl = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	// ������������
	private static String boy = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";

	public static int getNum(int start, int end) {// ������ط���ָ����Χ�������
		// Math.random()�������0.0��1.0֮�����
		return (int) (Math.random() * (end - start + 1) + start);
	}

	// ������ص绰��
	public static StringBuilder getStuno() {// ��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
		StringBuilder dh = new StringBuilder("551");// �绰ǰ3λ��ͬ
		StringBuilder dh1 = new StringBuilder(String.valueOf(getNum(1, 999)));// ���ȡ��3λ
		if (dh1.length() == 1) {
			dh1 = dh1.insert(0, "00");// �����1λ����ǰ������2��0
			dh = dh.append(dh1);// ǰ6λ���3λƴ�ӳɵ绰
		} else if (dh1.length() == 2) {
			dh1 = dh1.insert(0, "0");// �����2λ����ǰ������1��0
			dh= dh.append(dh1);
		} else {
			dh = dh.append(dh1);
		}
		return dh;
	}

	// ���������������
	public static String getChineseName(Stu s) {
		
		int index = getNum(0, firstName.length() - 1);// ���ȡ�����ַ����е�����λ��
		String first = firstName.substring(index, index + 1);// ��ȡ��λ�õ�����
		int sex = getNum(0, 1);// ���ȡ�Ա�����1Ϊ������0ΪŮ��
		String str = boy;// ��������Ϊ�����ַ���
		int length = boy.length();// ��ȡ�����ַ����ĳ���
		if (sex == 0) {// ��������ȡΪ0�������ָ�ΪŮ��
			str = girl;
			length = girl.length();
			s.setXb("Ů");
		}
		else s.setXb("��");
		index = getNum(0, length - 1);// �����ȡ���ֵ�λ��
		String second = str.substring(index, index + 1);// ��ȡ��λ���е�����
		int hasThird = getNum(0, 1);// �����ȡ�����Ƿ��е�������
		String third = "";// Ĭ��û�е�������
		if (hasThird == 1) {// ��������ȡΪ1�����е�������
			index = getNum(0, length - 1);
			third = str.substring(index, index + 1);
		}
		return first + second + third;// ��������
	}

	// �����Ա�
	public static String getSex(Stu s) {
		return s.getXb();
	}

	public static void main(String[] args) {
		Stu s=new Stu();
		ArrayList<String> alist = new ArrayList<String>();// ���弯��
		for (int i = 1; i <= 10;) {
			String dh = getStuno().toString();// �����ȡ�绰
			if (!alist.contains(dh)) {// �жϵ绰�Ƿ�Ψһ
				alist.add(dh);// ���绰���뼯��
				String xm = getChineseName(s);// �����ȡ����
				String xb = getSex(s);
				String zp = null;
				addCJ(dh, xm, xb,zp);// �����ݱ�����������
				i++;// �绰Ψһ��ѭ����������ִ��
			}
		}
		JOptionPane.showMessageDialog(null, "sucess");
	}
/**
 * �����������ݿ⣬ʵ��������
 * @param dh
 * @param xm
 * @param xb
 * @param zp
 */
	public static void addCJ(String dh, String xm, String xb,String zp) {
		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// ʹ��1�ж�����������ݿ����
		String sql = "insert into datainput(dh,xm,xb,zp) values(?,?,?,?)";// ʹ��ռλ������������
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����
			pstmt.setString(1, dh);// �����1��ռλ��������
			pstmt.setString(2, xm);// �����2��ռλ��������
			pstmt.setString(3, xb);// �����3��ռλ��������
			pstmt.setString(4, zp);// �����4��ռλ��������
			pstmt.executeUpdate();// ִ�в������

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * ���巵�����������ݷ���
 * @param sql
 * @return
 */
	public static Vector<Vector> getSelectAll(String sql) {
		Vector<Vector> rows = new Vector<Vector>();// ����Ҫ���ص����м�¼����
		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// ʹ��1�ж�����������ݿ����
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement
			ResultSet rs = pstmt.executeQuery();// ִ�в�ѯ��䣬����ŵ����ݼ���
			while (rs.next()) {// �������ݼ�
				Vector row = new Vector();// ����������
				row.add(rs.getString(1));// ��ȡ��һ���ֶε绰
				row.add(rs.getString(2));// ��ȡ�ڶ����ֶ�����
				row.add(rs.getString(3));// ��ȡ�������ֶ��Ա�
				row.add(rs.getString(4));// ��ȡ�������ֶ���Ʒ
				rows.add(row);// ����������ӵ���¼������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;// ��������������
	}
}