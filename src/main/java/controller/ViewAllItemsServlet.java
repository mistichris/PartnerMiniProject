package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ContactItemsHelper;

/**
 * Servlet implementation class ViewAllItemsServlet
 */
@WebServlet("/iewAllItemsServlet")
public class ViewAllItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllItemsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactItemsHelper dao = new ContactItemsHelper();	//create instance of ListAddressHelper to access helper objects
		request.setAttribute("allContacts", dao.showAllContacts());  	//set the variable to use in the view all address-list.jsp page
		String path = "/contact-list.jsp";		//set path for the servlet to redirect to
		if(dao.showAllContacts().isEmpty()){
			path = "/index.html";

		}
			
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
