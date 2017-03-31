package gasoline.store.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gasoline.store.model.GasBean;
import gasoline.store.utility.DBConnectUtil;
import gasoline.store.utility.GasBeanMaker;

/**
 * Servlet implementation class GasolineStoreServlet
 */

public class GasolineStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection connection = null;
	public void init() throws ServletException{
		connection = DBConnectUtil.getConnection(); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fuelType = request.getParameter("fuelType");
		int lNum = Integer.parseInt(request.getParameter("lNum"));
		String ccType = request.getParameter("ccType");
		long cNum = Long.parseLong(request.getParameter("cNum"));
		
		try{
			gasoline.store.utility.ValidateCreditCardNumber.validateNumber(request.getParameter("cNum"));
			GasBean sb = GasBeanMaker.getInstance(fuelType, lNum, ccType, cNum, connection);
			request.setAttribute("PayAmount", sb);
			
			RequestDispatcher disp = request.getRequestDispatcher("Results.jsp");
			disp.forward(request, response);
		}catch(Exception e){
			System.out.println(e);
			out.println("<h1 align=\"center\" style=\"color: red;\"> INVALID CREDIT CARD NUMBER! tRY aGAIN</h1>");
			RequestDispatcher err = request.getRequestDispatcher("index.jsp");
			err.include(request,response);
		}
		
		
	}

}
