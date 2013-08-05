package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SericeDao;
import dao.impl.SericeDaoImpl;
import entity.Serice;

public class SericeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SericeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=gbk");
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		String path="error.jsp";
		String status=null;
		status=request.getParameter("status");
		List list=new ArrayList();
		SericeDao sdao=new SericeDaoImpl();
		if(status!=null&&!status.equals(""))
		{
			//分页
			if(status.equals("list"))
			{
				int currentPage=1;//当前页数
				int lineSize=5;//，每页显示的条数
				int totalPage=0; //总页数
				String cp=request.getParameter("cp");
				if(cp!=null&&!cp.equals(""))
				{
					currentPage=Integer.parseInt(cp);
				}
				String ls=request.getParameter("lineSzie");
				if(ls!=null&&!ls.equals(""))
				{
					lineSize=Integer.parseInt(ls);
				}
				totalPage=sdao.getPage(lineSize);
				list=sdao.getPageList(currentPage, lineSize);
				//数组
				int arr[]=new int[totalPage];
				for(int i=0;i<arr.length;i++)
				{
					arr[i]=i+1;
				}
			
				request.setAttribute("pages", arr);
				request.setAttribute("list", list);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("lineSize", lineSize);
				request.setAttribute("totalPage", totalPage);
				path="index.jsp";
				
			}
			//跳转到修改
			if(status.equals("update"))
			{
				Serice s=null;
				path="update.jsp";
				String id=request.getParameter("id");
				int uid=0;
				if(id!=null&&!id.equals(""))
				{
					//按ID查询Serice对象
					s=sdao.getSericeWithId(Integer.parseInt(id));
					
			}
				request.setAttribute("mySerice",s );
			}
			if(status.equals("change"))
			{
				String title=request.getParameter("title");
				String cost=request.getParameter("cost");
				Double ucost=0.00;
				if(cost!=null&&!cost.equals(""))
				{
					ucost=Double.valueOf(cost);
				}
				String cost_time=request.getParameter("cost_time");
				Double ucost_time=0.00;
				if(cost_time!=null&&!cost_time.equals(""))
				{
					ucost_time=Double.valueOf(cost_time);
				}
				String id=request.getParameter("id");
				int uid=0;
				if(id!=null&&!id.equals(""))
				{
					uid=Integer.parseInt(id);
				}
				Serice s=new Serice();
				s.setId(uid);
				s.setTitle(title);
				s.setCost(ucost);
				s.setCost_time(ucost_time);
				int result=0;
				result=sdao.updateSerice(s);
				if(result>0)
				{
					path="SericeServlet?status=list";
				}
			}
			if(status.equals("insert"))
			{
				int reuslt=0;
				Serice s=new Serice();
				String title=request.getParameter("utitle");
				String cost=request.getParameter("ucost");
				
				Double aCost=0.00;
				if(cost!=null&&!cost.equals(""))
				{
					aCost=Double.valueOf(cost);
				}
				String cost_time=request.getParameter("ucost_time");
				Double aCost_time=0.00;
				if(cost_time!=null&&!cost_time.equals(""))
				{
					aCost_time=Double.valueOf(cost_time);
				}
				
				s.setTitle(title);
				s.setCost(aCost);
				s.setCost_time(aCost_time);
				reuslt=sdao.addSerice(s);
				if(reuslt>0)
				{
					path="SericeServlet?status=list";
				}
			}
			if(status.equals("delete"))
			{
				String id=request.getParameter("id");
				int uid=0;
				if(id!=null&&!id.equals(""))
				{
					uid=Integer.parseInt(id);
				}
				int result=0;
				result=sdao.DeleteSerice(uid);
				if(result>0)
				{
					path="SericeServlet?status=list";
				}
				
			}
			
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
