package com.Controller;
import java.io.IOException;
import java.io.PrintWriter;

import com.Dao.RegisterDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		double accbalance=Double.parseDouble(request.getParameter("accbal"));
		RegisterDao rdao=new RegisterDao();
		int i=rdao.UpdateAccount(accn, accbalance);
		//Register r=new Register();
		if(i>0)
		{
			pw.print("<html><body bgcolor='pink'>");
			pw.print("<center><h1><u>Record Updated</u></h1></center>");
			pw.print("</body></html>");
		}
		else
		{
			pw.print("<html><body bgcolor='pink'>");
			pw.print("<center><h1>....Not Updated....</h1><br>");
			pw.print("<h4>Enter Valid Account no. to Update the Data</h4></center>");
			pw.print("</body></html>");
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
