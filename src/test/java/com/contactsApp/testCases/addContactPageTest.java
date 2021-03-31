package com.contactsApp.testCases;

import org.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.contactsApp.base.BaseClass;
import com.contactsApp.pages.addContactPage;
import com.contactsApp.utils.utilityClass;

public class addContactPageTest extends BaseClass{
	
	//Global page variables
	addContactPage addContact;
	utilityClass utility;
	String sheetName = "newContact";
	
	//Initialize the constructor of base class
	public addContactPageTest() {
		super();
	}
		
	@BeforeMethod
	public void setup() {
		initialize();

		//creating object of add contact and utility page
		utility = new utilityClass();
		addContact = new addContactPage();
	}
	
//	@Test(priority=1)
//	public void addContactPageHeadingTest() {
//		String heading = addContact.validateHeading();
//		Assert.assertEquals(heading, "Create a new Contact", "Title doesnot match");
//	}
	
	@DataProvider
	public Object[][] getContactsTestData() throws InvalidFormatException{
		Object data[][] = utilityClass.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getContactsTestData")
	public void addNewContactTest(String fName, String lName, String email, String phone, String state, String city, String dob, String company) {
		addContact.createNewContact(fName, lName, email, phone, state, city, dob, company);
		addContact.clickNameInitials();
		addContact.submitDetails();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
