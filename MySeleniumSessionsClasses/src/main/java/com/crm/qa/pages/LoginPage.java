package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory--OR.
		@FindBy(name="uid")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(name="btn-Login")
		WebElement loginBtn;
		
		@FindBy(xpath="/html/body/div[4]/ol/li[1]/a")
		WebElement signUpBtn;
		
		//Initializing the Page Object.
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}

}
