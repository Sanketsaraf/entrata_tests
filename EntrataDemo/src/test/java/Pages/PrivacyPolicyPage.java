package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivacyPolicyPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Initializing locators
	@FindBy(xpath="//h1[@class='privacy-heading add']")
    WebElement privacyPolHeadingTxt;
    
    public PrivacyPolicyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    public String verifyPrivacyPolHeading() {
    	wait.until(ExpectedConditions.visibilityOf(privacyPolHeadingTxt));
    	return privacyPolHeadingTxt.getText();
    }

}
