package mypack;

public class User {

	String yuuzaamei = null;
	String pasuwaado = null;
	String createddate = null;

	public User() {
	}

	public User(String yuuzaamei, String pasuwaado) {
		super();
		this.yuuzaamei = yuuzaamei;
		this.pasuwaado = pasuwaado;
	}

	public User(String yuuzaamei, String pasuwaado, String createddate) {
		super();
		this.yuuzaamei = yuuzaamei;
		this.pasuwaado = pasuwaado;
		this.createddate = createddate;
	}

	public String getYuuzaamei() {
		return yuuzaamei;
	}
	public void setYuuzaamei(String yuuzaamei) {
		this.yuuzaamei = yuuzaamei;
	}
	public String getPasuwaado() {
		return pasuwaado;
	}
	public void setPasuwaado(String passuwaado) {
		this.pasuwaado = passuwaado;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	@Override
	public String toString() {
		return "User [yuuzaamei=" + yuuzaamei + ", passuwaado=" + pasuwaado + ", createddate=" + createddate + "]";
	}

}
