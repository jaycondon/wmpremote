package josh.john.weeklymealplanner;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	final PersistenceManager pm = PMF.get().getPersistenceManager();
	protected String myParam = null;

	public void init(ServletConfig servletConfig) throws ServletException {
		
		
		
		
	}
	
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<html><body><h1>inside do post and recipe controller</h1></body></html>");
		switch (myParam) {
        case "/add": addRecipe();
                 break;
        case "/delete":  deleteRecipe(null);
                 break;
        case "/update":  updateRecipe(null, null);
                 break;
        case "/list":  listRecipe();
                 break;
		}
	}

	public void addRecipe() throws ServletException, IOException {
		
	}

	public void updateRecipe(String name, HttpServletRequest request) {

	}

	public void deleteRecipe(HttpServletRequest request) {

	}

	public void listRecipe() {


	}

}