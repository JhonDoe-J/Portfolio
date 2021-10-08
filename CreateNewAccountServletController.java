package mypack;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateNewAccountServletController")
public class CreateNewAccountServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateNewAccountServletController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding( "UTF-8" );
		String resultPage = "/ErrorPage.jsp";

		try {
			//CreateNewAccount.htmlから渡された情報を受け取る
			String yuuzaamei = request.getParameter("yuuzaamei");
			String pasuwaado = request.getParameter("pasuwaado");

			String createddate = String.valueOf(Calendar.getInstance().getTime());

			HttpSession session = request.getSession();
			session.setAttribute("yuuzaamei", yuuzaamei);

			//Beansのインスタンスを取得、受け取った情報をBeanに格納→アカウント作成メソッド実行
			UserBean userBean = new UserBean();
			userBean.setUser(new User(yuuzaamei,pasuwaado,createddate));
			userBean.executeCreateNewAccount();

			//session

			//スレッド作成においてエラーが無ければ次ページにアカウント作成完了ページを設定
			request.setAttribute("userBean",userBean);
			resultPage = "/AccountCreatedView.jsp";


		}catch (SQLIntegrityConstraintViolationException e) {
			//入力ユーザ名が既に存在する場合
            request.setAttribute("SQLIntegrityConstraintViolationException", e);
            resultPage = "/CreateNewAccount2.html";

		}catch (Exception e) {
            request.setAttribute("exception", e);
            resultPage = "/ErrorPage.jsp";
		}
		//resultPageへfoward実施
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
