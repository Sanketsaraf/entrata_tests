package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	//Initializing locators
	@FindBy(xpath = "//h2[@class='fsm-header']/span")
	WebElement loginPageHeadingTxt;

	@FindBy(id = "entrata-username")
	WebElement username;

	@FindBy(id = "entrata-password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//p[@id='statusMessage']")
	WebElement invalidMsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginPageHeadingTxt() {
		return loginPageHeadingTxt.getText();
	}

	public void enterUserAndPass(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
	}

	public void clickSignIn() {
		signInBtn.click();
	}

	public String verifyInvalidCredMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(invalidMsg));
		return invalidMsg.getText();
	}

}
