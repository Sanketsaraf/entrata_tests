package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntrataSignInPage {

	WebDriver driver;

	//Initializing locators
	@FindBy(xpath = "//h1[@class='sign-in-heading']")
	WebElement signInHeadingText;

	@FindBy(xpath = "//div[@class='button-wrapper sign-in']/a[1]")
	WebElement propManLoginBtn;
	
	public EntrataSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifySignInHeadingTxt() {
		return signInHeadingText.getText();
	}

	public void clickPropManLoginBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(propManLoginBtn));
		propManLoginBtn.click();
	}

}
