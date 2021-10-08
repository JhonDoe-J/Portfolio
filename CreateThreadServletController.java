package mypack;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//スレッド作成サーブレット

@WebServlet("/CreateThreadServletController")
public class CreateThreadServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateThreadServletController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding( "UTF-8" ); //日本語文字化け防止
		String resultPage = "/ErrorPage.jsp"; //forward先＝次ページ、初期値はエラー画面に設定

		try {
			//CreateNewThread.htmlから渡された情報を受け取る
			String threadtitle = request.getParameter("threadtitle");
			String username = request.getParameter("username");
			String texts = request.getParameter("texts");

			//現在の日時はここで取得
			String posteddate = String.valueOf(Calendar.getInstance().getTime());

			//Beansのインスタンスを取得、受け取った情報をセット→スレッド作成メソッド実行
			ThreadBean threadBean = new ThreadBean();
			threadBean.setThread(new Thread(threadtitle,username,texts,posteddate));
			threadBean.executeCreateNewThread(threadBean.getThread());

			//受け取った情報を次ページへ渡す為セット
			//スレッド作成においてエラーが無ければ次ページに作成されたスレッドを表示するページを設定
			request.setAttribute("threadBean",threadBean);
			resultPage = "/PostThreadView.jsp";


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
