package nc.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {

	//���ݿ����ӳ�
	static List<Connection> cons = new  ArrayList<Connection>();
	
	public synchronized static Connection getConnection(){
		
		Connection con =null;
		if(cons.size()>0){
			return cons.remove(0);
		}
		//���û�����ӳ�
		for (int i = 0; i < 5; i++) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//��������
				try {
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/b2be?serverTimezone=UTC&characterEncoding=UTF-8","root","123456");
					cons.add(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return cons.remove(0);
	}
	
	/**
	 * �ر��������ӺͶ���
	 * @param rs �رս����
	 * @param ps �ر�Ԥ����
	 * @param con �ر�����
	 */
	public static void close(ResultSet rs,PreparedStatement ps,Connection con){
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ѯ
	 * @param sql
	 * @param param
	 * @return
	 */
	public List<Map<String,Object>> select(String sql,Object[]param){
		
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			ps = con.prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					ps.setObject(i+1, param[i]);
				}
			}
			rs= ps.executeQuery();
			
			//ȡ����
			ResultSetMetaData metaData = rs.getMetaData();
			int count = metaData.getColumnCount();
			
			while(rs.next()){
				Map<String, Object> map = new HashMap<String,Object>();
				for (int i = 1; i <= count; i++) {
					map.put(metaData.getColumnName(i).toLowerCase(), rs.getObject(metaData.getColumnName(i)));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, ps, con);
		}
		
		return list;
		
	}
	
	/**
	 * ��ɾ�� ����
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean updateByParams(String sql , Object param[]){
		boolean flag  = false;
		Connection con = getConnection();
		PreparedStatement ps=null;
		 try {
			ps = con.prepareStatement(sql);
			if(param!=null){
				for (int i = 1; i <= param.length; i++) {
					ps.setObject(i, param[i-1]);
				}
			}
			int n = ps.executeUpdate();
			if(n>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null,ps,con);
		}
		return flag;
		
	}
	/**
	 * ��ɾ�� ����
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean batchUpdateByParams(String sql , Object param[][]){
		Connection con = getConnection();
		PreparedStatement ps=null;
		 try {
			ps = con.prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					for (int j = 1; j < param[i].length; j++) {
						ps.setObject(j, param[j-1]);
					}
					ps.addBatch();
				}
				 ps.executeBatch();
				 return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null,ps,con);
		}
		return false;
		
	}
}
