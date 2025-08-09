package com.Controller;
import java.io.IOException;
import java.io.PrintWriter;

import com.Dao.RegisterDao;
import com.Model.Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		Login lobj=new Login();
		lobj.setUname(uname);
		lobj.setPass(pass);
		RegisterDao rd=new RegisterDao();
		boolean b=rd.validateUser(lobj);
		if(b)
		{
			
			response.sendRedirect("Home2.html");
			pw.print("<h1>Logged In SuccessFully...</h1><br>");
		}
		else
		{
			pw.print("<html><body bgcolor='pink'>");
		
			pw.print("<h1><center>Oops ! Something Went Wrong...Please try again later...</center></h1>");
			pw.print("</html></body>");
		}
		/*
		try 
		{ 
			con=m.getConnection();
			pstate=con.prepareStatement("select * from AccountInfo where accno=?");//101
			pstate.setInt(1,accno);
			ResultSet rs=pstate.executeQuery();//select
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"
						+rs.getString(2)+"\t"+rs.getDouble(3));
				pw.print("<h1>....LOGIN SUCCESSFULLY....</h1>");
				pw.println("<html><body>");  

				Statement stmt=con.createStatement();
				ResultSet rst = stmt.executeQuery("select * from AccountInfo");  
				pw.println("<table border=1 width=50% height=50%>");  
				pw.println("<tr><th>AccNo</th><th>CustName</th><th>Balance</th><tr>");  
				while(rst.next()) 
				{    
					pw.println("<tr><td>"+"\t" +rst.getInt(1) +"\t "+"</td><td>" +"\t"+ rst.getString(2) + "\t"+"</td><td>" + "\t"+rst.getDouble(3) + "\t"+"</td></tr>");   
				}  
				pw.println("</table>");  
				pw.println("</html></body>"); 
			}
			else
				pw.print("<h1>....Invalid Data....</h1>");

			con.close();
		}
		catch (Exception e) 
		{  
			System.out.println();  
		} */ 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
