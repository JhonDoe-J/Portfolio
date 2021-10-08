package mypack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServletController")
public class LogoutServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutServletController() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding( "UTF-8" );
		String resultPage = "/ErrorPage.jsp";

		try {

		HttpSession session = request.getSession(true);
	    session.invalidate();

        resultPage = "/BeforeTop.html";

		}catch (Exception e) {
            request.setAttribute("exception", e);
            resultPage = "/ErrorPage.jsp";

			}
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
		}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
