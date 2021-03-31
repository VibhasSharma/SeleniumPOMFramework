package com.contactsApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.contactsApp.base.BaseClass;

public class contactListPage extends BaseClass{

	@FindBy(xpath="//h3[text()='Contact List']")
	WebElement headingContactList;
	
	//Initialize the page objects
	public contactListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeading() {
		return headingContactList.getText();
	}
}
