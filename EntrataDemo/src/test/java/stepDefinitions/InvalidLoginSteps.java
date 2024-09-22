package stepDefinitions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.EntrataSignInPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class InvalidLoginSteps {

	WebDriver driver;
	HomePage homepage;
	EntrataSignInPage entrataSignInPage;
	LoginPage loginpage;

	// navigating to entrata homepage
	@Given("the user has navigated to entrata website")
	public void the_user_has_navigated_to_entrata_website() {
		driver = new ChromeDriver();
		driver.get("https://www.entrata.com/c");
		driver.manage().window().maximize();

	}

	@And("the user clicks on Sign In button")
	public void the_user_clicks_on_sign_in_button() {
		try {
			homepage = new HomePage(driver);
			homepage.clickAcceptCookieBtn();
			String actualHomePageText = homepage.verifyHomePageText();
			Assertions.assertEquals("Property management software", actualHomePageText);
			homepage.clickSignInBtn();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@And("the user lands on entrata signIn page")
	public void the_user_lands_on_entrata_signIn_page() {
		try {
			entrataSignInPage = new EntrataSignInPage(driver);
			String actualSignInHeadingText = entrataSignInPage.verifySignInHeadingTxt();
			Assertions.assertEquals("Entrata powers residents and property managers", actualSignInHeadingText);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

	}

	@And("the user clicks on property manager login button")
	public void the_user_clicks_on_property_manager_login_button() {
		entrataSignInPage.clickPropManLoginBtn();
	}

	@And("the user lands on login page")
	public void the_user_lands_on_login_page() {
		try {
			loginpage = new LoginPage(driver);
			String actualLoginPageHeadingTxt = loginpage.verifyLoginPageHeadingTxt();
			Assertions.assertEquals("Sign in", actualLoginPageHeadingTxt);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	@When("the user enters invalid {string} and {string}")
	public void the_user_enters_invalid_and(String username, String password) {
		try {
			loginpage.enterUserAndPass(username, password);
			loginpage.clickSignIn();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

	}

	@Then("the user gets invalid credentials message.")
	public void the_user_gets_invalid_credentials_message() {
		try {
			String actualInvalidCredMsg = loginpage.verifyInvalidCredMsg();
			Assertions.assertTrue(actualInvalidCredMsg.contains("The username and password provided are not valid. Please try again."),"Login was successful");

			driver.close();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

}
