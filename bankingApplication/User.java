package bankingApplication;


public class User {
	String user_name;
	String user_email;
	CheckingsAccount user_C1;

	public User(String name, String email,CheckingsAccount C1) {
		user_name = name;
		user_C1 = C1;
		user_email=email;

	}

}