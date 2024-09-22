package stepDefinitions;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AllLinksSteps {

	WebDriver driver;
	HomePage homepage;

	// navigating to entrata homepage
	@Given("I am on the Entrata homepage")
	public void i_am_on_the_entrata_homepage() {
		driver = new ChromeDriver();
		driver.get("https://www.entrata.com/c");
		driver.manage().window().maximize();
		homepage = new HomePage(driver);
		homepage.clickAcceptCookieBtn();
	}

	@Then("I should be able to retrieve all links and print their count and text")
	public void i_should_be_able_to_retrieve_all_links_and_print_their_count_and_text() {
		try {
			// Get all links using the Page Object
			List<WebElement> links = homepage.getAllLinks();

			// Print the total number of links
			System.out.println("Total number of links on the page: " + links.size());

			// Print the text of each link
			for (WebElement link : links) {
				String linkText = link.getText().trim(); // Trim whitespace
				String href = link.getAttribute("href"); // Get the link's URL

				// Handle cases where link text is blank
				if (linkText.isEmpty()) {
					System.out.println("Link with empty text. URL: " + href);
				} else {
					System.out.println("Link Text: " + linkText + " | URL: " + href);
				}
			}

			driver.close();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

}
