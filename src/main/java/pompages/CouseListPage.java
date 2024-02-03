package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import geniricutilies.WebDrivrUtility;

public class CouseListPage {
	//Declaration
	@FindBy(xpath="//h1[normalize-space(text())='Course List']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[text='new']")
	private WebElement newButton;
	
	 private String deletepath="//td[text()='%s']/ancestor::tr"+"/descendant::button[text()='Delete']";
	@FindBy(xpath="delete")
	private WebElement deleteButton;
	
	@FindBy(xpath="//h4[text()='Success!']")
	private WebElement successMessage;
	
	//Initialization
	public CouseListPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
		
	}
	public void clickNewButton() {
		newButton.click();
		}
	public void deleteCourse(WebDrivrUtility web, String CourseName) {
		web.convertPathToWebElement(deletepath, CourseName).click();
		deleteButton.click();
	}
	public String getsuccessMessage() {
		return successMessage.getText();
	}

}
