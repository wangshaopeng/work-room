package dao;


import java.util.List;

import entity.Serice;

public interface SericeDao {
	public List<Serice> getPageList(int currentPage,int lineSize); 
	public int getCount(); 
	public int getPage(int lineSize); 
	public int updateSerice(Serice s); 
	public int addSerice(Serice s);
	public Serice getSericeWithId(int id);
	public int DeleteSerice(int id);

}
