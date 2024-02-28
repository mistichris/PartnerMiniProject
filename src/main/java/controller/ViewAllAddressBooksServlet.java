package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ListDetailsHelper;
import model.ListDetails;

/**
 * Servlet implementation class ViewAllAddressBooksServlet
 */
@WebServlet("/ViewAllAddressBooksServlet")
public class ViewAllAddressBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllAddressBooksServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDetailsHelper ldh = new ListDetailsHelper();
		List<ListDetails> detailsList = ldh.getLists();
		request.setAttribute("allLists", detailsList);
		//removed ifEmpty statement that was used in lab--didn't seem to work when table was empty
		getServletContext().getRequestDispatcher("/view-addressbooks.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
