package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.ScheduleDemoFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScheduleDemoFormSteps {

	WebDriver driver;
	HomePage homepage;
	ScheduleDemoFormPage scheduleDemoFormPage;

	// navigating to entrata homepage
	@Given("user has navigated to entrata website")
	public void user_has_navigated_to_entrata_website() {
		driver = new ChromeDriver();
		driver.get("https://www.entrata.com/c");
		driver.manage().window().maximize();
	}

	@And("the user clicks on Schedule Your Demo button")
	public void the_user_clicks_on_schedule_your_demo_button() {
		try {
			homepage = new HomePage(driver);
			homepage.clickAcceptCookieBtn();
			homepage.clickScheduleDemoBtn();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@And("the user lands on form page")
	public void the_user_lands_on_form_page() {
		try {
			scheduleDemoFormPage = new ScheduleDemoFormPage(driver);
			scheduleDemoFormPage.verifyScheduleDemoHeadingTxt();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@And("the user enters {string}, {string}, {string}, {string} and {string}")
	public void the_user_enters_and(String firstname, String lastname, String email, String companyName,
			String phoneNumber) {
		try {
			scheduleDemoFormPage.enterFormDetails(firstname, lastname, email, companyName, phoneNumber);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@And("the user selects {string} from unit count dropdown")
	public void the_user_selects_from_unit_count_dropdown(String unitCount) {
		try {
			scheduleDemoFormPage.selectUnitCountDropdownOption(unitCount);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@And("the user enters {string}")
	public void the_user_enters(String jobTitle) {
		try {
			scheduleDemoFormPage.enterJobTitle(jobTitle);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@And("the user selects {string}")
	public void the_user_selects(String imoption) {
		try {
			scheduleDemoFormPage.selectIamDropdownOption(imoption);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@When("the user scrolls down")
	public void the_user_scrolls_down() {
		try {
			scheduleDemoFormPage.scrollToScheduleDemoBtn();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@Then("the Schedule Demo buton is displayed")
	public void the_schedule_demo_button_is_displayed() {
		try {
			boolean isButtonDisplayed = scheduleDemoFormPage.isScheduleDemoBtnDisplayed();
			Assertions.assertTrue(isButtonDisplayed, "Submit button is not displayed!");
			driver.close();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

	}

}
