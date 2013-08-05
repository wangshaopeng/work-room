package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.BaseDao;



import dao.SericeDao;
import entity.Serice;

public class SericeDaoImpl implements SericeDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public int getCount() {
		// TODO Auto-generated method stub
		int count=0;
		try {
			String sql="select count(*) from serice";
			conn=BaseDao.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int getPage(int lineSize) {
		// TODO Auto-generated method stub
		int allPage=0;
		int allCount=0;
		allCount=this.getCount();
		allPage=(allCount%lineSize==0)?(allCount/lineSize):(allCount/lineSize+1);
		return allPage;
	}

	
	

	

	public List<Serice> getPageList(int currentPage, int lineSize)
	{
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try
		{
			String sql="select * from (select rownum as rn,p.* from(select * from serice)p where rownum<=?) where rn>?";
			conn=BaseDao.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, currentPage*lineSize);
			ps.setInt(2, (currentPage-1)*lineSize);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Serice s=new Serice();
				s.setId(rs.getInt("id"));
				s.setTitle(rs.getString("title"));
				s.setCost(rs.getDouble("cost"));
				s.setCost_time(rs.getDouble("cost_time"));
				list.add(s);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateSerice(Serice s)
	{
		// TODO Auto-generated method stub
		int result=0;
		try
		{
			String sql="update serice set title=?,cost=?,cost_time=? where id=?";
			conn=BaseDao.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, s.getTitle());
			ps.setDouble(2, s.getCost());
			ps.setDouble(3, s.getCost_time());
			ps.setInt(4, s.getId());
			result=ps.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Serice getSericeWithId(int id)
	{
		// TODO Auto-generated method stub
		Serice s=null;
		try
		{
			String sql="select * from serice where id=?";
			conn=BaseDao.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				s=new Serice();
				s.setId(rs.getInt("id"));
				s.setTitle(rs.getString("title"));
				s.setCost(rs.getDouble("cost"));
				s.setCost_time(rs.getDouble("cost_time"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public int addSerice(Serice s)
	{
		// TODO Auto-generated method stub
		int result=0;
		try
		{
			String sql="insert into serice(id,title,cost,cost_time) values(serice_seq.nextval,?,?,?)";
			conn=BaseDao.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, s.getTitle());
			ps.setDouble(2, s.getCost());
			ps.setDouble(3, s.getCost_time());
			result=ps.executeUpdate();
		} catch (SQLException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int DeleteSerice(int id)
	{
		// TODO Auto-generated method stub
		System.out.println("id:"+id);
		int result=0;
		String sql ="delete from serice where id =?";
		try {
			conn=BaseDao.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return result;
	}
}
/*
	String sql="select *"
+"from"+"("
+"select t.*, rownum as r"
+"from"
+"("
+"select* from serice where rownum<=? order by"
+")"
+")"
+"where r<?";

*/
