package DefinationsStep;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObj.Card;
import PageObj.login;
import PageObj.orders;
import PageObj.search;
import PageObj.signup;
import PageObj.stores;
import Utility.readProperties;
import Utility.snaps;
public class signIn {

	WebElement e;
	Actions action;
	WebDriver driver;
	signup s;
	orders o;
	stores s1;
	search s2;
	readProperties prop=new readProperties();
	Logger log=Logger.getLogger("CucumberFramework");
	@Given("user launch the chrome browser")
	public void user_launch_the_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\saich\\git\\repository6\\CucumberFramework\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		log.info("chrome launched successfully");
		
	   
	}
	@When("user opens url {string}")
	public void user_opens_url(String string) throws IOException {
		s=new signup(driver);
		driver.get("https://www.urbanladder.com/");
		snaps.getScreenshot(driver,"user");
		log.info("url is opened");
	   
	}
	@And("click on profile")
	public void click_on_profile() throws InterruptedException {
		s.log1().click();
		Thread.sleep(5000);
	    
	}
	@And("click on signIn")
	public void click_on_sign_in() throws InterruptedException {
		s.sign1().click();
	   Thread.sleep(5000);
	   log.info("click on signin");
	}
	@And("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) throws InterruptedException {
	   s.email1().sendKeys("saicharanjetti21@gmail.com");
	   Thread.sleep(3000);
	   s.pwd1().sendKeys("Charan@123");
	}
	@And("click on signup")
	public void click_on_signup() throws InterruptedException, IOException {
		s.signup1().click();
		Thread.sleep(2000);
		snaps.getScreenshot(driver,"signup");
		log.info("user enters are valid details");
	    
	}
	@Then("close browser")
	public void close_browser() {
		driver.quit();
		log.info("browser closed successfully");
	    
	}
	
	@When("click on logIn")
	public void click_on_log_in() {
		login l=new login(driver);
		l.login1().click();
		log.info("user click on login");
	}
	@When("click on bulkorder")
	public void click_on_bulkorder() throws InterruptedException {
		o=new orders(driver);
		o.order1().click();
		Thread.sleep(3000); 
	   
	}
	@When("scrolldown webpage")
	public void scrolldown_webpage() throws InterruptedException, IOException {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2500)","");
		snaps.getScreenshot(driver,"scrolldown");
		log.info("page scrolled successfully");
		
	   
	}
	@When("click on privacy policy")
	public void click_on_privacy_policy() throws InterruptedException, IOException {
		o.uri1().click();
		Thread.sleep(2000);
		snaps.getScreenshot(driver,"privacy");
		log.info("user verify the privacy");
	    
	}
	@When("click on store")
	public void click_on_store() throws InterruptedException {
		s1=new stores(driver);
		s1.store1().click();
		Thread.sleep(2000);
	}
	@When("click on topdeals")
	public void click_on_topdeals() throws InterruptedException {
		s1.topdeal1().click();
		Thread.sleep(2000);
	}
	@When("click on sofas")
	public void click_on_sofas() throws IOException {
		s1.deal1().click();
		snaps.getScreenshot(driver,"sofas");
	}
	//@When("click on product")
	//public void click_on_product() {
		//s1.product1().click();
	//}
	@When("click on search box")
	public void click_on_search_box() {
		s2=new search(driver);
		s2.search1().click();
		
	    
	}
	@When("send text as {string}")
	public void send_text_as(String string) throws InterruptedException {
		s2.search1().sendKeys("sofas");
		Thread.sleep(2000);
	}
	@When("click on search button")
	public void click_on_search_button() throws IOException {
		s2.click1().click();
		snaps.getScreenshot(driver,"search");
	    
	}
	@Then("navigate back")
	public void navigate_back() {
		driver.navigate().back();
		log.info("driver is navigated");
	   
	}
	/*@Then("hover on products")
	public void hover_on_products() {
		action=new Actions(driver);
		action.moveToElement(s2.sofa1()).perform();
	    
	}
	@Then("hover on materials")
	public void hover_on_materials() {
		action.moveToElement(s2.material1()).perform();
	   
	}
	@Then("check the box")
	public void check_the_box() {
		s2.mat1().click();
	@Then("navigate back")
	public void navigate_back() {
		driver.navigate().back();
	   
	}*/
	@When("scroll webpage to some element")
	public void scroll_webpage_to_some_element() throws InterruptedException, IOException {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		WebElement e=driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[3]/a[7]"));
		
		jse.executeScript("arguments[0].scrollIntoView();",e);
		snaps.getScreenshot(driver,"element");
		System.out.println(e);
		
		
	    
	}
	/*@When("click on that element")
	public void click_on_that_element() throws InterruptedException {
		action=new Actions(driver);
		action.moveToElement(e).click();
		Thread.sleep(3000);
	   
	}*/
	@When("hover on topdeals")
	public void hover_on_topdeals() throws InterruptedException {
		WebElement e=driver.findElement(By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[1]/span"));
		action=new Actions(driver);
		action.moveToElement(e).perform();
		Thread.sleep(2000);
	    
	}
	@When("click on dining")
	public void click_on_dining() throws InterruptedException {
		WebElement e1=driver.findElement(By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[1]/div/div/ul/li[2]/div/a"));
		Thread.sleep(2000);
		action.click();
		
		driver.navigate().back();
		
	 }
	@When("click on gift cards")
	public void click_on_gift_cards() {
	    Card c=new Card(driver);
	    c.gc1().click();
	    if(driver.getTitle().contains("India"))
		{
			Assert.assertTrue(true);
			log.info("title is valid");
			
		}
		else {
			Assert.assertTrue(false);
			log.info("title is not match");
			
		}
	}
	@When("validate age title")
	public void validate_age_title() {
		String t=driver.getTitle();
		System.out.println(t);
		if(t.equals("Furniture Online: @Upto 70% Off on Wooden Furniture Online in India at Best Price - Urban Ladder"))
		{
			Assert.assertTrue(true);
			log.info("page title is valid");
			
		}
		else {
			Assert.assertTrue(false);
			log.info("page title is invalid");
			
		}
		
	}
	@When("scroll to some element")
	public void scroll_to_some_element() throws IOException {
		action=new Actions(driver);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement e=driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[4]/div[4]/div[3]/a"));
		jse.executeScript("arguments[0].scrollIntoView();",e);
		
		action.moveToElement(e).click(e);
		snaps.getScreenshot(driver,"scroll");
	}
}
