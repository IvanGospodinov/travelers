package model;

public class User {

	
	
	private int userID;
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String pictureURL;
	
	public User(String userName, String password, String email, String firstName, String lastName, String puctureUTL) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pictureURL = pictureURL;

	}
	
	
	
	
	public User(String email, String password) {
		super();
		this.password = password;
		this.email = email;
	}




	public String getPictureURL() {
		return pictureURL;
	}


	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		if (validateString(userName)) {
			this.userName = userName;
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if (validateString(password)) {
			this.password = password;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (validateString(email)) {
			this.email = email;
		}
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if (validateString(firstName)) {
			this.firstName = firstName;
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if (validateString(lastName)) {
			this.lastName = lastName;
		}
	}
	
	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	private static boolean validateString(String string) {
		return (string != null) && (string.length() > 0);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	
}
