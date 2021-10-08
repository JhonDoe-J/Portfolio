package mypack;

import java.util.List;

public class UserBean {

	private User user;
	private List<User> users;

	public UserBean() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void executeCreateNewAccount() throws Exception {
		try(UserDAO userDAO = new UserDAO()){
			userDAO.createNewAccount(user);
		}
	}

	public User executeAccountAuthentication() throws Exception{
		try(UserDAO userDAO = new UserDAO()){

			return userDAO.accountAuthentication(user);
		}

	}



}
