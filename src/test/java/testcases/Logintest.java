package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.Loginpage1;

public class Logintest extends BaseClass1{
	
	@Test
	public void ValidLogin() throws FilloException {
		
		Recordset recordset=connection.executeQuery("select * from Sheet1 where TestName ='ValidLogin'");
		recordset.next();
		
		String Username=recordset.getField("UserName");
		String Password=recordset.getField("Password");
		
		Loginpage1 login=new Loginpage1(driver);
		login.LoginFunction(Username,Password);
		
		String ActPageURL=driver.getCurrentUrl();
		String ExpPageURL="https://www.saucedemo.com/inventory.html";
		
		Assert.assertEquals(ActPageURL, ExpPageURL);
		
	}
	@Test(enabled=true)
public void InvalidLogin() throws FilloException {
		
		
		Recordset recordset=connection.executeQuery("select * from Sheet1 where TestName='Invalidlogin'");
		recordset.next();
		String Username=recordset.getField("UserName");
		String Password=recordset.getField("Password");
		
		Loginpage1 login=new Loginpage1(driver);
		login.LoginFunction(Username,Password);
		WebElement error=driver.findElement(By.cssSelector("h3[data-test='error']"));
		
		String ActError=error.getText();
		String ExpError="Epic sadface: Username and password do not match any user in this service";
		
		Assert.assertEquals(ActError,ExpError);
	
}
	private void executeQuery(String string) {
		// TODO Auto-generated method stub
		
	}
}	
