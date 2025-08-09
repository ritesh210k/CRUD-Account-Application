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
 * Servlet implementation class DisplayController
 */
@WebServlet("/DisplayController")
public class DisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterDao rd=new RegisterDao();
		List<Register> lst=rd.DisplayAccount();
		PrintWriter pw=response.getWriter();
		pw.print("<h1><center><u>Account Details</u></center></h1>");
		pw.println("<html><body bgcolor='pink'><center>");  
		pw.println("<table bgcolor='white' border=1 width=50% height=10%>");
		pw.println("<tr><th>AccNo</th><th>CustName</th><th>Balance</th><th>Username</th><th>Password</th><tr>"); 
		for(Register r:lst)
		{
			pw.println("<html><body><center>");  
			pw.println("<table bgcolor='white' border=3 width=50% height=10%>");
			pw.println("<tr><td>&nbsp&nbsp&nbsp&nbsp"+r.getAccno()+"</td><td>&nbsp&nbsp&nbsp&nbsp"+r.getCustname()+"</td><td>&nbsp&nbsp&nbsp&nbsp"+r.getAccbal()+"</td><td>&nbsp&nbsp&nbsp&nbsp"+r.getUname()+"</td><td>&nbsp&nbsp&nbsp&nbsp"+r.getPass()+"</td></tr>");    
			pw.println("</table>");  
			pw.println("</html></center></body>");
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
