package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
	@FindBy(xpath="//a[text=' Home']")
	private WebElement PageHeader ;
	
	@FindBy(xpath="//span[text()='Users']")
	private WebElement usersTab ;
	
	@FindBy(xpath="//span[text()='Courses']")
	private WebElement coursesTab;
	
	@FindBy(xpath="//a[text()=' Course List']")
	private WebElement  courseListLink;
	
	@FindBy(xpath="//a(text()=' Category")
	private WebElement categoryLink;
	@FindBy(xpath="//span[text()='Skillrary Admin']")
	private WebElement skillraryAdminIcon;
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signoutLink;
	
	
	//Initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		//Utilization
		public String getPageHeader() {
			return PageHeader.getText();
		}
		public void clickUserTab() {
			usersTab.click();
			
		}
		public void clickCoursesTab() {
			coursesTab.click();
			
			
		}
		public void clickCoursesListLink() {
			courseListLink.click();
		}
		public void clickCategoryLink() {
			categoryLink.click();
		}
		public void signOutOfApp1() {
			// TODO Auto-generated method stub
			
		}
		public void signOutOfApp() {
			// TODO Auto-generated method stub
			
		}
			
			
	
	

}
