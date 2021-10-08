package mypack;

import java.util.List;

//Beans：渡された値を格納しその値でDAOメソッドへアクセスする

public class ThreadBean {

	private Thread thread;				  //Threadテーブル
	private List<Thread> threads;		  //スレッドの現在の内容表示用
	private List<String> allthreadtitles;//スレッド名の一覧表示用


	public ThreadBean() {
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

	public List<String> getAllthreadtitles() {
		return allthreadtitles;
	}

	public void setAllthreadtitles(List<String> allthreadtitles) {
		this.allthreadtitles = allthreadtitles;
	}


	public void executeCreateNewThread(Thread thread) throws Exception {
        //try-with-resouce文でThreadDAOオブジェクトを生成
        try (ThreadDAO threadDAO = new ThreadDAO() ){
            //受け取ったThread型の値でDAOのスレッド作成メソッドを実行
            threadDAO.createNewThread(thread);
        }
    }

	public void executeGetThread(Thread thread) throws Exception{
		try(ThreadDAO threadDAO = new ThreadDAO()){
			//受け取ったThread型のスレッド名でDAOのスレッド内容表示メソッドを実行
			threads = threadDAO.getThread(thread.getThreadtitle());
		}
	}

	public List<String> executeGetAllThreads() throws Exception{
		try(ThreadDAO threadDAO = new ThreadDAO()){
			//スレッド一覧表示メソッドを実施
			allthreadtitles = threadDAO.getAllThreads();
		}
		return allthreadtitles;
	}
}
