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
		String act = request.getParameter("doActionToContact");
		
		String path = "/viewAllItemsServlet";
		System.out.println(act);
		//delete item 
		if (act.equals("Delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				System.out.println("TempId: " + tempId);
				ContactItems itemToDelete = dao.searchForContactItemsById(tempId);
				dao.deleteItem(itemToDelete);
				} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
				}
			//unable to delete an item that is already contained in a list-- have to remove from lists first
		} else if (act.equals("Edit")) {
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
