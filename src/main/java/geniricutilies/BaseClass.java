package geniricutilies;

import java.util.Properties;

import org.apache.poi.ss.formula.functions.Address;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.AddNewCategoryPage;
import pompages.AddNewCoursePage;
import pompages.AddNewUserPage;
import pompages.CategoryPage;
import pompages.CouseListPage;
import pompages.HomePage;
import pompages.LoginPage;
import pompages.UserPage;


	public class BaseClass {
		protected WebDriver driver;
		protected Propertiesutility property;
		protected JavaUtility jutil;
		protected WebDrivrUtility web;
		protected ExcelUtility excel;
		
		protected LoginPage login;
		protected HomePage home;
		protected UserPage users;
		protected CouseListPage courseList;
		protected CategoryPage category;
		protected AddNewUserPage addUser; 
		protected AddNewCoursePage addCourse;
		protected AddNewCategoryPage addCategory;
		

		public static WebDriver sdriver;
		public static JavaUtility sjutil;

		//@BeforeSuite
		//@BeforeTest
		
		@BeforeClass
		public void classSetup()
		{
		web =new WebDrivrUtility();
		jutil=new JavaUtility();
		property=new Propertiesutility();
		excel=new ExcelUtility();
		
		property.propertiesInit(IConstantpath.PROPERTIES_FILE_PATH);
		
		driver=web.launchBrowserAndMiximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		sdriver=driver;
		sjutil=jutil;
		}
		@BeforeMethod
		public void methodSetup()
		{
		login=new LoginPage(driver);
		home=new HomePage(driver);
		users=new UserPage(driver);
		courseList=new CouseListPage(driver);
		category=new CategoryPage(driver);
		addUser=new AddNewUserPage(driver);
		addCourse=new AddNewCoursePage();
		addCategory=new AddNewCategoryPage();
		
		excel.excelInit(IConstantpath.EXCEL_PATH, "Sheet1");
		
		 web.navigateToApp(property.readFromProperties("url"));
		 Assert.assertEquals(login.getPageHeader(), "Login");
		 login.loginToApp(property.readFromProperties("username"),
		 property.readFromProperties("password"));
		 Assert.assertEquals(home.getPageHeader(),"Home");
		 
		 

		
		}
		@AfterMethod
		public void methodTearDown()
		{
			excel.closeExcel();
			home.signOutOfApp();
		}
		@AfterClass
		public void classTearDown()
		{
			web.quitAllWindow();
			
		}
		
		//@AfterTest
		//@AfterSuite


}
	
