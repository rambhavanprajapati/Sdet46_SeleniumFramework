package tms.movingBird.elementRepository.enums;

public enum TabNames {
	
	ADMINISTRATOR("Administrator"),
	TOUR_PACKAGES(" Tour Packages"),
	MANAGE_USERS("Manage Users"),
	MANAGE_BOOKING("Manage Booking"),
	MANAGE_ISSUES("Manage Issues"),
	MANAGE_ENQUIRIES("Manage Enquiries"),
	MANAGE_PAGES("Manage Pages");
	
private String tabName;
	
	private TabNames(String tabName)
	{
		this.tabName=tabName;
	}
	
	public String getTab()
	{
		return tabName;
	}
}
