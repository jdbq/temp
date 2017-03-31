package gasoline.store.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gasoline.store.model.GasBean;
import gasoline.store.utility.DBConnectUtil;

/**
 * Servlet implementation class ListRecordServlet
 */

public class ListRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
        // TODO Auto-generated constructor stub
	private Connection connection = null;
	public void init() throws ServletException{
		connection = DBConnectUtil.getConnection(); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(connection != null){
			System.out.println("Connected with database");
			ResultSet res = new GasBean().viewRecord(connection);
			
			request.setAttribute("forexRecords", res);
			
			request.getRequestDispatcher("displayrecords.jsp")
			.forward(request, response);
		}
		else{
			System.out.println("Cannot connect to database");
		}
			
		
	}

}
