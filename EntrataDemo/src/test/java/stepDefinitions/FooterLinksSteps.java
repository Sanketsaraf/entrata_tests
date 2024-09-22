package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.PrivacyPolicyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FooterLinksSteps {
	WebDriver driver;
	HomePage homepage;
	PrivacyPolicyPage privacyPolicyPage;

	// navigating to entrata homepage and scrolling to footer
	@Given("I scroll to the footer of the homepage")
	public void i_scroll_to_the_footer_of_the_homepage() {
		driver = new ChromeDriver();
		driver.get("https://www.entrata.com/c");
		driver.manage().window().maximize();
		homepage = new HomePage(driver);
		homepage.clickAcceptCookieBtn();
		homepage.scrollToPrivacyPolLink();

	}

	@When("I click on the Privacy Policy link")
	public void i_click_on_the_privacy_policy_link() {
		homepage.clickPrivacyPolLink();
	}

	@Then("I should be navigated to the Privacy Policy page")
	public void i_should_be_navigated_to_the_privacy_policy_page() {
		try {
			privacyPolicyPage = new PrivacyPolicyPage(driver);
			String actualPrivacyPolTxt = privacyPolicyPage.verifyPrivacyPolHeading();
			Assertions.assertEquals("Privacy Policies", actualPrivacyPolTxt);

			driver.close();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

}
