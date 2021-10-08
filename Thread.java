package mypack;

//Threadテーブルの内容を定義
public class Thread {
	private String threadtitle; //スレッド名
	private String username;    //ユーザ名
	private String texts;       //投稿内容
	private String posteddate;  //投稿日時

	public Thread() {
	}

	public Thread(String threadtitle) {
		super();
		this.threadtitle = threadtitle;
	}

	public Thread(String username, String texts,String posteddate) {
		this.username = username;
		this.texts = texts;
		this.posteddate = posteddate;
	}

	public Thread(String threadtitle,String username, String texts ,String posteddate) {
		super();
		this.threadtitle = threadtitle;
		this.username = username;
		this.texts = texts;
		this.posteddate = posteddate;
	}

	public String getThreadtitle() {
		return threadtitle;
	}
	public void setThreadtitle(String threadtitle) {
		this.threadtitle = threadtitle;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getTexts() {
		return texts;
	}
	public void setTexts(String texts) {
		this.texts = texts;
	}

	public String getPosteddate() {
		return posteddate;
	}

	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}

	@Override
	public String toString() {
		return "Thread [threadtitle=" + threadtitle + ", username=" + username + ", texts=" + texts + ", posteddate="
				+ posteddate + "]";
	}


}
