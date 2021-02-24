package test.cuke.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoSiteStepDefs {

	private static RemoteWebDriver driver;
	private WebElement targ;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
		driver.manage().window().setSize(new Dimension(1366, 768));

	}

	@Given("^That I can access the demosite$")
	public void that_I_can_access_the_demosite() throws Throwable {
		driver.get("http://thedemosite.co.uk/");
	}

	@When("^I click on the register tab$")
	public void i_click_on_the_register_tab() throws Throwable {
		targ = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		targ.click();
	}

	@When("^I register a user$")
	public void i_register_a_user() throws Throwable {
		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		targ.sendKeys("guest");
	}

	@When("^I register a password$")
	public void i_register_a_password() throws Throwable {
		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		targ.sendKeys("guest");
	}

	@When("^I click on the login tab$")
	public void i_click_on_the_login_tab() throws Throwable {
		targ = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		targ.click();
	}

	@When("^I enter my user details$")
	public void i_enter_my_user_details() throws Throwable {
		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		targ.sendKeys("guest");
	}

	@When("^I enter my password details$")
	public void i_enter_my_password_details() throws Throwable {
		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		targ.sendKeys("guest");
	}

	@When("^I click login$")
	public void i_click_login() throws Throwable {
		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		targ.click();
	}

	@Then("^I should be able to log in successfully$")
	public void i_should_be_able_to_log_in_successfully() throws Throwable {
		assertEquals("**Successful Login**",
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
						.getText());

	}

	@After
	public void tearDown() {
		driver.close();
	}

	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;
	}

}
