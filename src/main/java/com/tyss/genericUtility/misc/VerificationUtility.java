package com.tyss.genericUtility.misc;

/**
 * This class contains generic methods for verification purpose
 * @author Zero Touch
 *
 */
public class VerificationUtility {

	/**
	 * This with will verify for exact value
	 * @param actual
	 * @param expected
	 */
	public void exactVerify(String actual, String expected, String strategy, String pageNameOrTCname)
	{
		if(strategy.equalsIgnoreCase("TC")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" TC is pass");
			}
			else
			{
				System.out.println(pageNameOrTCname+" TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" page Displayed");
			}
			else
			{
				System.out.println(pageNameOrTCname+" page not Displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("element")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" is showing");
			}
			else
			{
				System.out.println(pageNameOrTCname+" is not showing");
			}
		}
	}

	/**
	 * This method will verify for partial data
	 * @param actual
	 * @param expected
	 */
	public void partialVerify(String actual, String expected, String strategy, String pageNameOrTCname)
	{
		if(strategy.equalsIgnoreCase("TC")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" TC is pass");
			}
			else
			{
				System.out.println(pageNameOrTCname+" TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" page Displayed");
			}
			else
			{
				System.out.println(pageNameOrTCname+" page not Displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("element")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" is showing");
			}
			else
			{
				System.out.println(pageNameOrTCname+" is not showing");
			}
		}
	}
}
