package dao;


import java.util.List;

import entity.Serice;

public interface SericeDao {
	public List<Serice> getPageList(int currentPage,int lineSize); //分页
	public int getCount(); //获取总数据总数量
	public int getPage(int lineSize); //获取总页数
	public int updateSerice(Serice s); //修改对象
	public int addSerice(Serice s); //增加一条信息
	public Serice getSericeWithId(int id);//按ID查询
	public int DeleteSerice(int id);//删除

}
