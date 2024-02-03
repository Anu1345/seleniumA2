package geniricutilies;

import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains all reusable methods to perform driver related operations
 * @author admin
 */

public class WebDrivrUtility {
	WebDriver driver;  
	/**
	 * This method is used to launch specified browser and maximize it
	 * @author admin
	 * @return
	 */
	private Object OutPutType;
	private Object jutil;

	public WebDriver launchBrowserAndMiximize(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser Info");
		}
		driver.manage().window().maximize();
		return driver;

	}
	/**
	 * This method is used to navigate to specified url
	 * @param url
	 */

	public void navigateToApp(String url) {
		driver.get(url);
		/**
		 * This method is an implicit wait statement which waits until element is found
		 * @paran time
		 
		
	 
		 */

	}

	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	public WebElement explictWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * This method wait to until element on the web page is enabled to receive click
	 * @param element
	 * @param time
	 * @return
	 */

	public WebElement explictWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * This method is used to wait until appears on the web page
	 * @param time
	 * @param title
	 * @return
	 */

	public Boolean explicitlyWait(long time, String title) {
		WebDriverWait wait = new WebDriverWait(driver, time);

		return wait.until(ExpectedConditions.titleContains(title));

	}
	public void mouseHoverToElement(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on an element
	 * @param element
	 */
	public void doubleClickonElement(WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();

	}
	/**
	 * This method is used to perform right click on element 
	 * 
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
		/**
		 * This method is use to drag and drag and drop an element to target location
		 * @param element
		 * @param target
		 */
		public void dragAndDropAnElement(WebElement element, WebElement target) {
			Actions action=new Actions(driver);
			action.dragAndDrop(element, target).perform();
			
		}
	 
		
	
	/**
	 * This method is used to switch to frame based on specified index
	 * @param index
	 */
	
	

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame based on specified id ar name attribute
	 * @param idoName
	 */

	public void switchToFrame(String idoName) {
		driver.switchTo().frame(idoName);
	}
	/**
	 * This method is used switch to frame based on frame element
	 * @param frameElement
	 */

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to switch back to the default web page
	 */

	public void switchBackFrame() {

		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to select an element frame drop down based on element index
	 * @param element
	 * @param index
	 */
	public void selectFromDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method is udsed to select an element  from drop down based on value 
	 * @param element
	 * @param value
	 */

	public void selectfromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to select an element from drop down based on visible text 
	 * @param text
	 * @param element
	 */

	public void selectfromDropDown(String text, WebElement element) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method is fetches all the elements from drop down
	 * @param element
	 * @return
	 */

	public List<WebElement> getDropdownList(WebElement element) {
		Select select = new Select(element);
		return select.getOptions();

	}
	/**
	 * This method is used to capture screenshot of the web page
	 * @param driver
	 * @param jutil
	 * @param className
	 */
	
	

	public void captureScreenshot(WebDriver driver, JavaUtility jutil, String className) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot" + className + "_" + jutil.getCurrentTime() + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *  This method is used to scroll till the specified element on the web page
	 * @param element
	 */

	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntView(true)", element);
	}
	/**
	 * This method is used to handle alert pop up
	 * @param status
	 */

	public void handleAlert(String status) {
		Alert al = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok"));
			
		al.accept();
	}
	/**
	 * This method is used to switch to child browser
	 */

	public void switchToChildBrowser() {
		Set<String> windowIDs = driver.getWindowHandles();
		for (String window : windowIDs) {
			driver.switchTo().window(window);
		}
	}
	/**
	 * This method is used returns parent window adress
	 * @return
	 */

	public String getParentWindow() {
		return driver.getWindowHandle();
	}
	/**
	 * This method is used to switch to specified window
	 * @param window
	 */

	public void switchToWindow(String window) {
		driver.switchTo().window(window);
	}
	/**
	 * This method is used to close the current tab
	 */


public void closeBrowser() {
	driver.close();
}
/**
* This method is used to quit all the windows
*/
 
public void quitAllWindow() {
	driver.quit();
}

public WebElement convertPathToWebElement(String path, String replaceData) {
	String requiredPath=String.format(path,replaceData);
	WebElement element =driver.findElement(By.xpath(requiredPath));
	return element;
	
}

}



