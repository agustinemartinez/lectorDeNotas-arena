package model;

public class Usuario {

	private String user;
	private String password;
	
	public Usuario(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public String getUser() { return user; }
	public void setUser(String user) { this.user = user; }
	public void setPassword(String password) { this.password = password; }

	public boolean correctPassword(String password) {
		return this.password.equals(password);
	}
	
}
