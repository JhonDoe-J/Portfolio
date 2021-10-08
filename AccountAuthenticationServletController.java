package mypack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccountAuthenticationServletController")
public class AccountAuthenticationServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AccountAuthenticationServletController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		String resultPage = "/ErrorPage.jsp";

		try {
			//Login.htmlから渡された情報を受け取る
			String yuuzaamei = request.getParameter("yuuzaamei");
			String pasuwaado = request.getParameter("pasuwaado");

			//Beansのインスタンスを取得、受け取った情報をBeanに格納→アカウント認証メソッド実行
			UserBean userBean = new UserBean();
			userBean.setUser(new User(yuuzaamei,pasuwaado));

			//入力されたユーザ名/パスワードがDB上で合致＝TRUE (戻り値がnullでなければ)
			if(userBean.executeAccountAuthentication() != null) {

				HttpSession session = request.getSession();
				session.setAttribute("yuuzaamei", yuuzaamei);

				request.setAttribute("userBean",userBean);
				resultPage = "/LoggedinView.jsp";

			}else {
				resultPage = "/LoginFailed.html";

			}

		}catch (Exception e) {
			//エラーキャッチされた場合、改めてforward先をエラー画面に設定
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
