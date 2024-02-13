package com.contactsApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.contactsApp.base.BaseClass;

public class addContactPage extends BaseClass{
	// Page Factory: Object Repository
	@FindBy(xpath="//h3[text()='Create a new Contact']")
	WebElement heading;
	
	// Form input field elements
	@FindBy(xpath="//input[@name='fName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='nameInitials']")
	WebElement nameInitials;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailElement;
	
	@FindBy(xpath="//input[@name='phoneNumber']")
	WebElement phoneElement;
	
	@FindBy(xpath="//input[@name='nativeState']")
	WebElement nativeStateElement;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement cityElement;
	
	@FindBy(xpath="//input[@name='dob']")
	WebElement dobElement;
	
	@FindBy(xpath="//input[@name='company']")
	WebElement companyNameElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//a[@class='btn btn-secondary' and text()=' View Contact Card']")
	WebElement viewContactListBtn;
	
	@FindBy(xpath="//a[@class='btn btn-secondary' and text()=' View Contact Card']")
	WebElement viewContactCardBtn;
	
	//Initialize the page objects
	public addContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions available on home page
	public void waitForPageLoad() {
		
	}
	
	public String validateHeading() {
		return heading.getText();
	}
	
	public void createNewContact(String fNm, String lNm, String mail, String phoneNum, String nativeState, String cityDetails, String birthDate, String comp) {
		firstName.sendKeys(fNm);
		lastName.sendKeys(lNm);
		emailElement.sendKeys(mail);
		phoneElement.sendKeys(phoneNum);
		nativeStateElement.sendKeys(nativeState);
		cityElement.sendKeys(cityDetails);
		dobElement.sendKeys(birthDate);
		companyNameElement.sendKeys(comp);
	}
	
	public void clickNameInitials() {
		nameInitials.click();
	}
	
	public void submitDetails() {
		submitButton.click();
	}
	
}
