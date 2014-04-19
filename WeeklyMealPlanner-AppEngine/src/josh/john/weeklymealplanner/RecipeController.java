package josh.john.weeklymealplanner;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String action = null;

	public void init(ServletConfig servletConfig) throws ServletException {
		this.action = servletConfig.getInitParameter("action");
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
				.print("<html><body><h1>inside do post" + action + "</h1></body></html>");
		switch (action) {
		case "add":
			addRecipe(request, response);
			break;
		case "delete":
			deleteRecipe(null, response);
			break;
		case "update":
			updateRecipe(null, null);
			break;
		case "list":
			listRecipe(request, response);
			break;
		}
	}

	public void addRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		response.getWriter().print(
				"<html><body><h1>addRecipe Action" + action + "</h1></body></html>");
        Recipe rec = new Recipe(request.getParameter("recipeName"), request.getParameter("recipeMethod"), request.getParameter("recipeIngredients"));

        try {
            pm.makePersistent(rec);
        } finally {
            pm.close();
        }
	}

	public void updateRecipe(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.getWriter().print(
				"<html><body><h1>updateRecipe Action" + action + "</h1></body></html>");
	}

	public void deleteRecipe(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.getWriter().print(
				"<html><body><h1>deleteRecipe Action" + action + "</h1></body></html>");
	}

	public void listRecipe(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.getWriter().print(
				"<html><body><h1>listRecipe Action" + action + "</h1></body></html>");

	}

}