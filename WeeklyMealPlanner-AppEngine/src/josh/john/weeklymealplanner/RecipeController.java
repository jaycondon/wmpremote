package josh.john.weeklymealplanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		switch (action) {
		case "add":
			
			break;
		case "delete":
			response.sendRedirect("DeleteRecipe.jsp");
			break;
		case "update":
			response.sendRedirect("UpdateRecipe.jsp");
			break;
		case "read":
			
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		switch (action) {
		case "add":
			addRecipe(request, response);
			break;
		case "delete":
			deleteRecipe(null, response);
			break;
		case "update":
			recipeArray(request, response);
			updateRecipe(null, null);
			break;
		case "read":
			listRecipe(request, response);
			break;
		}
	}

	public void addRecipe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Recipe rec = new Recipe(request.getParameter("recipeName"),
				request.getParameter("recipeMethod"),
				request.getParameter("recipeIngredients"));

		try {
			pm.makePersistent(rec);
		} finally {
			pm.close();
		}
	}

	public void updateRecipe(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
	}

	public void deleteRecipe(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

	}

	public void listRecipe(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Extent ex = pm.getExtent(Recipe.class, true);
		Iterator iter = ex.iterator();
		while (iter.hasNext()) {
			Recipe obj = (Recipe) iter.next();
			response.getWriter().print(
					"<html><body><h1><table><td>" + obj.getName()
							+ "</td></table></h1></body></html>");
		}

	}

	public List<Recipe> recipeArray(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Recipe> recipeList = new ArrayList<Recipe>();
		Extent e = pm.getExtent(Recipe.class, true);

		Iterator iter = e.iterator();
		while (iter.hasNext()) {
			Recipe obj = (Recipe) iter.next();
			recipeList.add(obj);
		}

		return recipeList;
	}

}