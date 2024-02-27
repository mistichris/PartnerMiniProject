package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ListAddressHelper;

/**
 * Servlet implementation class ViewAllItemsServlet
 */
@WebServlet("/ViewAllItemsServlet")
public class ViewAllItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllItemsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListAddressHelper dao = new ListAddressHelper();	//create instance of ListAddressHelper to access helper objects
		request.setAttribute("allAddresses", dao.showAllAddresses());  	//set the variable to use in the view all address-list.jsp page
		String path = "/address-list.jsp";		//set path for the servlet to redirect to
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
