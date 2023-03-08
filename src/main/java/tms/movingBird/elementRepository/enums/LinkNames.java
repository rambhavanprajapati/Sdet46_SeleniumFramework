package tms.movingBird.elementRepository.enums;

public enum LinkNames {
	
	ADMIN_LOGIN("Admin Login"),
	SIGN_IN("/ Sign In"),
	SIGN_UP("Sign Up"),
	HOME("Home"),
	ABOUT("About"),
	TOUR_PACKAGES("Tour Packages"),
	TERMS_OF_USE("Terms of Use"),
	CONTACT_US("Contact Us"),
	ENQUIRY(" Enquiry "),
	MY_PROFILE("My Profile"),
	CHANGE_PASSWORD("Change Password"),
	MY_TOUR_HISTORY("My Tour History"),
	ISSUE_TICKETS("Issue Tickets"),
	LOGOUT("/ Logout"),
	FROM_DATE("datepicker"),
	TO_DATE("datepicker1");
	
	private String linkName;
	
	private LinkNames(String linkName)
	{
		this.linkName=linkName;
	}
	
	public String getLink()
	{
		return linkName;
	}
}
