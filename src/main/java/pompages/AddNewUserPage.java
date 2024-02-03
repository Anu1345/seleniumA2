package pompages;

import org.openqa.selenium.WebDriver;
//this test verifies if user able to create category
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUserPage {
	//Declaration
	@FindBy(xpath="//b[text()='Add New User']")
	private WebElement pageHeader;
	@FindBy(xpath="//input[@id='email' and@requried]")
	private WebElement emailTf;
	@FindBy(xpath="//input[@id='password' and@requried]")
	private WebElement passwordTf;
	@FindBy(xpath="//input[@id='firstname' and @requried]")
	private WebElement firstNameTf;

	@FindBy(xpath="//input[@id='lastname' and@requried]")
				private WebElement lastNameTf;
	@FindBy(xpath="//textarea[@id='adress']")
	private WebElement adressTextArea;
	@FindBy(xpath="//input[@id='contact']")
	private WebElement contactInfoTF;
	@FindBy(xpath="//input[@id='photo'])[2]")
	private WebElement photoUploadButton;
	@FindBy(xpath="//button[text()=' Save' and @name='add']")
	private WebElement saveButton;
	
	//Initialization
	public AddNewUserPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void setEmail(String password) {
		emailTf.sendKeys("email");
		
	}
	public void setPassword(String password) {
		passwordTf.sendKeys(password);
	}
	public void setFirstNmae(String firstname) {
		firstNameTf.sendKeys(firstname);}
	public void setLastName(String lastname) {
		lastNameTf.sendKeys(lastname);
	}
	public void setAddress(String address) {
		adressTextArea.sendKeys(address);
	}
	public void ContactInfo(String contact)
	{
		contactInfoTF.sendKeys(contact);}
	public void uploadPhoto(String photopath) {
	photoUploadButton.sendKeys(photopath);
}
public void ClickSave() {
	saveButton.click();
		
	
	
		
		
		
		
	}
	
	

}
