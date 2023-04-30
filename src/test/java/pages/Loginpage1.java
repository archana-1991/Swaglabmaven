package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.BaseClass1;

public class Loginpage1 extends BaseClass1 {
	
	WebDriver driver;
	
	//=====================objects==================
	
	@FindBy(id="user-name")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement LoginBtn;
	
	//==================Method=====================
	
	public Loginpage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
public void LoginFunction(String UserNameVal,String PasswordVal) {
	Username.sendKeys(UserNameVal);
	password.sendKeys(PasswordVal);
	LoginBtn.click();
	
}
}
