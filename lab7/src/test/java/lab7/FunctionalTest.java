package lab7;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://mile.by/");
		driver.findElement(By.xpath("//div[contains(@class, 'city-ip-popup')]/following-sibling::div")).click();
	}

	@Test
	public void testLogin() {
		driver.findElement(By.cssSelector("span[onclick='registerbutton();']")).click();

		WebElement searchInputLogin = driver.findElement(By.cssSelector("input[name='LOGIN']"));
		searchInputLogin.sendKeys("xenia-2001@mail.ru");

		WebElement searchInputPassword = driver.findElement(By.cssSelector("input[name='PASSWORD']"));
		searchInputPassword.sendKeys("12344321q");

		driver.findElement(By.cssSelector("button.btn-login")).click();

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.getCurrentUrl().equals("https://mile.by/personal/");
			}
		};

		new WebDriverWait(driver, 5).until(expectation);

		driver.navigate().to("https://mile.by/personal/private");

		WebElement accountFullName = driver.findElement(By.cssSelector("input[name='FIO']"));
		WebElement accountEmail = driver.findElement(By.cssSelector("input[name='EMAIL']"));

		Assert.assertEquals(accountFullName.getAttribute("value"), "Мальчикова");
		Assert.assertEquals(accountEmail.getAttribute("value"), "xenia-2001@mail.ru");

		driver.quit();
	}

	@After
	public void stopBrowser() {
		driver.quit();
	}
}