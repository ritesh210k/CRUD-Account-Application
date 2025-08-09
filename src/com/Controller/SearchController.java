package com.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.Dao.RegisterDao;
import com.Model.Register;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		int accn=Integer.parseInt(request.getParameter("accno"));
		RegisterDao rdao=new RegisterDao();
		List<Register> lst=rdao.SearchAccount(accn);
		if(lst!=null)
		{
			Register r=lst.get(0);
			pw.print("<h1><center>....Account Found....</center></h1>");
			pw.println("<html><h2><body bgcolor='pink'>");  
			  
			pw.println("<table bgcolor='white' align='center' border=1 width=50% height=20% >");  
			pw.println("<tr><th>AccNo</th><th>CustName</th><th>Balance</th><th>UserName</th><th>Password</th><tr>");     
				pw.println("<tr><td>&nbsp&nbsp&nbsp&nbsp"+"\t"+r.getAccno() +"\t "+"</td><td>&nbsp&nbsp&nbsp&nbsp" +"\t"+ r.getCustname() + "\t"+"</td><td>&nbsp&nbsp&nbsp&nbsp" + "\t"+r.getAccbal() + "</td>\t"+"<td>&nbsp&nbsp&nbsp&nbsp"+r.getUname()+"</td>\t"+"<td>&nbsp&nbsp&nbsp&nbsp"+r.getPass()+"</td></tr>");    
			pw.println("</table>");  
			pw.println("</html></body>"); 
			
		}
		else
		{
			pw.print("<h1>..Data Not Found...</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
