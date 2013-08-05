package dao.impl;

import dao.SericeDao;
import entity.Serice;

public class test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SericeDao sdao=new SericeDaoImpl();
		Serice s=new Serice();
		s.setTitle("sdfsdf");
		s.setCost(12.00);
		s.setCost_time(12.00);
		int result=sdao.addSerice(s);
		System.out.println(result);
		

	}

}
