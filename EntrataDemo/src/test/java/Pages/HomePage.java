package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Initializing locators
	@FindBy(xpath="//a[@id='cookie-accept']")
    WebElement acceptCookieBtn;
    
    @FindBy(xpath="//div[@class='hp-sub-title-2']")
    WebElement homePageText;
    
    @FindBy(xpath="//a[@class='signin-button mb-full']")
    WebElement signInBtn;
    
    @FindBy(linkText="Schedule Your Demo")
    WebElement scheduleDemoBtn;
    
    @FindBy(xpath="//a[@href='/privacy-policy']")
    WebElement privacyPolicyLink;
    
    @FindBy(tagName = "a")
    List<WebElement> allLinks;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    public void clickAcceptCookieBtn() {
    	wait.until(ExpectedConditions.visibilityOf(acceptCookieBtn));
    	acceptCookieBtn.click();
    }
    
    public String verifyHomePageText() {
        wait.until(ExpectedConditions.visibilityOf(homePageText));
        return homePageText.getText();
    }
    
    public void clickSignInBtn() {
    	wait.until(ExpectedConditions.visibilityOf(signInBtn));
    	signInBtn.click();
    }
    
    public void clickScheduleDemoBtn() {
    	wait.until(ExpectedConditions.elementToBeClickable(scheduleDemoBtn));
    	scheduleDemoBtn.click();
    }
    
    public void scrollToPrivacyPolLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", privacyPolicyLink); // Scrolls the element into view
    }
    
    public void clickPrivacyPolLink() {
    	privacyPolicyLink.click();
    }
    
    public List<WebElement> getAllLinks() {
        return allLinks;
    }

}
