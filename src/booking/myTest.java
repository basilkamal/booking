package booking;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.css.model.Value;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTest extends parameters {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> popupScreens = driver.findElements(By.className("f0c216ee26"));
		if (!popupScreens.isEmpty() && popupScreens.get(0).isDisplayed()) {
			WebElement popupScreen = popupScreens.get(0);
			WebElement exit = popupScreen.findElement(By.className("f4552b6561"));
			exit.click();
		}

	}

	@Test(priority = 1)
	public void checkTheNextStayIsDisplayed() {
		// check Find your next stay IsDisplayed

		WebElement nextStayText = driver.findElement(By.className("fdb5f4323d"));
		System.out.println(nextStayText.getText());
		assertEquals(nextStayText.isDisplayed(), true);

	}

	@Test(priority = 2)
	public void selectAcity() {
		// select Aqaba/ Jordan in the In the field Where are you going

		WebElement WhereAreYouGoingField = driver.findElement(By.className("b7ab62d599"));
		WhereAreYouGoingField.click();

		WebElement aqabaButton = driver.findElement(By.id("autocomplete-result-1"));
		aqabaButton.click();
	}

	@Test(priority = 3)
	public void CheckInAndOutDate() {
		// Check-in Date and Check-out date are 24.December.2024 and 29.December.2024
		// respectively
		WebElement nextMonthButton = driver.findElement(By.cssSelector("button[aria-label='Next month']"));
		for (int i = 0; i < 6; i++) {
			nextMonthButton.click();
		}
		WebElement CheckIn = driver.findElement(By.cssSelector("span[aria-label='24 December 2024']"));
		CheckIn.click();
		WebElement CheckOut = driver.findElement(By.cssSelector("span[aria-label='29 December 2024']"));
		CheckOut.click();

	}

	@Test(priority = 4)
	public void numberOfRooms() {
		// Determine the number of rooms and children
		WebElement numberOfRooms = driver.findElement(By.className("ada2387af8"));
		numberOfRooms.click();

		driver.findElement(By.cssSelector(
				"button[class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 deab83296e bb803d8689 e91c91fa93'] span[class='fcd9eec8fb bf9a32efa5']"))
				.click();
		driver.findElement(By.cssSelector(
				"body > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > button:nth-child(3)"))
				.click();
		driver.findElement(By.cssSelector(
				"button[class='a83ed08757 c21c56c305 bf0537ecb5 ab98298258 d2529514af af7297d90d c213355c26']"))
				.click();

	}

	@Test(priority = 5)
	public void SearchButton() {
		// click the search button
		WebElement searchButton = driver.findElement(By.cssSelector(".a4c1805887.f671049264"));
		searchButton.click();
	}

	@Test(priority = 6)
	public void propertiesFoundNumber() {
		// print properties Found Number

		
		List<WebElement> PopupScreens = driver.findElements(By.className("dd5dccd82f"));
		if (!PopupScreens.isEmpty() && PopupScreens.get(0).isDisplayed()) {
			WebElement popupScreen = PopupScreens.get(0);
			WebElement Exit = popupScreen.findElement(By.cssSelector(".a83ed08757.c21c56c305.f38b6daa18.d691166b09.ab98298258.deab83296e.f4552b6561"));
			Exit.click();
		
		
		String number = "";
		try {
			WebElement propertiesFoundNum = driver.findElement(By.cssSelector(".fa4a3a8221.ae40efd959"));
			String textNumber = propertiesFoundNum.getText();
			// Extract the number from the text
			number = textNumber.replaceAll("\\D+", "");
		} catch (StaleElementReferenceException e) {
			WebElement propertiesFoundNum = driver.findElement(By.cssSelector(".fa4a3a8221.ae40efd959"));
			String textNumber = propertiesFoundNum.getText();
			// Extract the number from the text
			number = textNumber.replaceAll("\\D+", "");
		}

		System.out.println(number); 
		}

	}

	@Test(priority = 7)
	public void ScrollToElements() {
		// Scroll To Element"10" and print the hotel name and click to hart icon
		WebElement nextStayText = driver.findElement(By.cssSelector(
				"body > div:nth-child(6) > div:nth-child(1) > div:nth-child(8) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(23) > div:nth-child(1)"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'end'});",
				nextStayText);
		// print hotel name
		List<WebElement> hotelNames = driver.findElements(
				By.cssSelector(".fa298e29e2.b74446e476.e40c0c68b1.ea1d0cfcb7.d8991ab7ae.e8b7755ec7.ad0e783e41"));

		if (hotelNames.size() >= 10) {
			WebElement hotelNameElement = hotelNames.get(9);
			WebElement hh = hotelNameElement.findElement(By.cssSelector(".fa4a3a8221.b121bc708f"));
			System.out.println(hh.getText());
			// click icon hart
			WebElement heartIcon = hotelNameElement.findElement(By.className("f419a93f12"));
			heartIcon.click();

			// go to next trip
			WebElement nextTrip = driver.findElement(By.className("a3332d346a"));
			nextTrip.click();

		}

	}

	@Test(priority = 8 , enabled = false)
	public void checkThePrice() throws InterruptedException  {
		// check the price is lower 700
		
		
    }
	}


