package com.apd.inteliserve.general;

import java.util.List;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
public class Keyword extends BaseTest{





	//Login to InteliApp

	public static void loginInteliApp() throws Exception{
		clickAcceptLink();
		getEmailTextBox();
		clickSignInButton();
		selectUserName();
	}
	
	// Login , Hamburger and Logout Page Keywords
	
	public static void clickAcceptLink() throws Exception{
		driver.findElement((Lib.getLocator("ACCEPT_LINK"))).click();
	}
	public static void getEmailTextBox() throws Exception{
		driver.findElement(Lib.getLocator("EMAIL_TEXTBOX")).sendKeys(Lib.getPropertyValue("Email"));
	}
	public static void clickSignInButton() throws Exception{
		driver.findElement(Lib.getLocator("SIGNIN_BUTTON")).click();
	}
	public static void selectUserName() throws Exception{
		driver.findElement(Lib.getLocator("SELECT_USERNAME")).click();
	}
	public static void clickHamburgerMenu() throws Exception{
	driver.findElement(Lib.getLocator("HAMBURER_MENU")).click();
	}
	public static void clickLogoutLink() throws Exception{
	driver.findElement(Lib.getLocator("LOGOUT_LINK")).click();
	}
	
	//waits

	public static void waitForIvaChatToLoad() throws InterruptedException{
		Thread.sleep(15000);
	}
	public static void waitForMaxmimunTimeToLoad() throws InterruptedException{
		Thread.sleep(10000);
	}
	public static void waitForMiniumTimeToLoad() throws InterruptedException{
		Thread.sleep(5000);
	}

	// Call An Agent Page Keywords

	public void clickCallAnAgentMenu() throws Exception{
		driver.findElement(Lib.getLocator("CALL_AN_AGENT_LINK")).click();
	}
	public String getCallAnAgentHeaderText() throws Exception{
		return driver.findElement((Lib.getLocator("CALL_AN_AGENT_HEADER"))).getText();
	}
	public MobileElement getAgentNumber() throws Exception{
		return driver.findElement(Lib.getLocator("AGENT_NUMBER"));
	}

	// Schedule Contact Page Keywords

	public void clickScheduleContactMenu() throws Exception{
		driver.findElement(Lib.getLocator("SCHEDULE_CONTACT_LINK")).click();
	}
	public MobileElement getEditTextBox() throws Exception{
		return driver.findElement(Lib.getLocator("EDIT_TEXTBOX"));
	}
	public void clickYesButton() throws Exception{
		driver.findElement(Lib.getLocator("YES_BUTTON")).click();
	}
	public void clickNoButton() throws Exception{
		driver.findElement(Lib.getLocator("NO_BUTTON")).click();
	}
	public void clickChatToggleButton() throws Exception{
		driver.findElement(Lib.getLocator("CHAT_TOGGLE_BUTTON")).click();
	}
	public List<AndroidElement> getIVAText() throws Exception{
		return driver.findElements(Lib.getLocator("IVA_TEXT"));
	}
	public void closeChatNotes() throws Exception{
		driver.findElement(Lib.getLocator("CLOSE_CHAT_NOTES")).click();
	}
	public void clickToggleButton() throws Exception{
		driver.findElement(Lib.getLocator("TOGGLE_BUTTON")).click();
	}
	public void clickMuteIcon() throws Exception{
		driver.findElement(Lib.getLocator("MUTE_ICON")).click();
	}
	public void clickUnMuteIcon() throws Exception{
		driver.findElement(Lib.getLocator("UNMUTE_ICON")).click();
	}
	public void clickResetIcon() throws Exception{
		driver.findElement(Lib.getLocator("RESET_ICON")).click();
	}

	// Create Ticket Page Keywords

	public void clickCreateTicketMenu() throws Exception{
		driver.findElement(Lib.getLocator(("CREATE_TICKET_LINK"))).click();

	}
	public String getcreteTicketTitleText() throws Exception{
		return driver.findElement(Lib.getLocator("CREATE_TICKET_TITLE")).getText();
	}
	public MobileElement getTitleTextBox() throws Exception{
		return driver.findElement(Lib.getLocator("TITLE_TEXTBOX"));
	}
	public MobileElement getDiscriptionTextBox() throws Exception{
		return driver.findElement(Lib.getLocator("DESCRIPTION_TEXTBOX"));
	}
	public void clickCreateTicketButton() throws Exception{
		driver.findElement(Lib.getLocator("CREATE_TICKET_BUTTON")).click();
	}

	// Home Page Keywords

	public void clickHomeMenu() throws Exception{
		driver.findElement(Lib.getLocator("HOME_LINK")).click();
	}
	public void clickSendMessage() throws Exception{
		driver.findElement(Lib.getLocator("SEND_MESSAGE")).click();
	}
	public MobileElement viewVideo() throws Exception{
		return driver.findElement(Lib.getLocator("VIDEO_VIEW"));
	}
	public void playVideo() throws Exception{
		driver.findElement(Lib.getLocator("VIDEO_PLAY")).click();
	}

	// Outages Page Keywords

	public void clickOutagesMenu() throws Exception{
		driver.findElement(Lib.getLocator("OUTAGES_LINK")).click();
	}
	public void clickExchangeOutageItem() throws Exception{
		driver.findElement(Lib.getLocator("EXCHNAGE_OUTAGE")).click();
	}

}





