package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ContactItemsHelper;
import model.ContactItems;

/**
 * Servlet implementation class NavigationServlet
 */

//Larry will do

@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ContactItemsHelper dao = new ContactItemsHelper();
		String act = request.getParameter("doThisToItem");
		
		String path = "/viewAllItemsServlet";
		
		//delete item 
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ContactItems itemToDelete = dao.searchForContactItemsById(tempId);
				dao.deleteItem(itemToDelete);
				} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
				}
		} else if (act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ContactItems itemToEdit = dao.searchForContactItemsById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			path = "/edit-item.jsp";
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		}else if (act.equals("add")) {
				 path = "/index.html";
				 }
		getServletContext().getRequestDispatcher(path).forward(request, response);
		}

}
