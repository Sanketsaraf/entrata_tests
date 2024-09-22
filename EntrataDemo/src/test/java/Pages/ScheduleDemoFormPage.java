package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleDemoFormPage {

	WebDriver driver;

	// Initializing locators
	@FindBy(xpath = "//div[@id='alkghq']/h1")
	WebElement scheduleDemoHeadingTxt;

	@FindBy(id = "FirstName")
	WebElement firstName;

	@FindBy(id = "LastName")
	WebElement lastname;

	@FindBy(id = "Email")
	WebElement emailadd;

	@FindBy(id = "Company")
	WebElement companyName;

	@FindBy(id = "Phone")
	WebElement phoneNumber;

	@FindBy(id = "Unit_Count__c")
	WebElement unitCountDropdown;

	@FindBy(id = "Title")
	WebElement jobTitle;

	@FindBy(id = "demoRequest")
	WebElement iamDropdown;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement scheduleDemoBtn;

	public ScheduleDemoFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyScheduleDemoHeadingTxt() {
		return scheduleDemoHeadingTxt.getText();
	}

	public void enterFormDetails(String fname, String lname, String email, String compName, String phoneNo) {
		firstName.sendKeys(fname);
		lastname.sendKeys(lname);
		emailadd.sendKeys(email);
		companyName.sendKeys(compName);
		phoneNumber.sendKeys(phoneNo);
	}

	public void selectUnitCountDropdownOption(String unitCount) {
		Select select = new Select(unitCountDropdown);
		select.selectByVisibleText(unitCount); // Select option by visible text
	}

	public void enterJobTitle(String jobT) {
		jobTitle.sendKeys(jobT);
	}

	public void selectIamDropdownOption(String iamoption) {
		Select select = new Select(iamDropdown);
		select.selectByVisibleText(iamoption); // Select option by visible text

	}

	public void scrollToScheduleDemoBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scheduleDemoBtn); // Scrolls the element into view
	}

	public boolean isScheduleDemoBtnDisplayed() {
		return scheduleDemoBtn.isDisplayed(); // Check if the button is visible on the page
	}

}
