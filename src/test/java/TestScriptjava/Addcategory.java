package TestScriptjava;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import geniricutilies.BaseClass;
import geniricutilies.IConstantpath;

public class Addcategory extends BaseClass {
	@Test
	public void addCategoryTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertEquals(category.getPageHeader(), "Category");

		category.clickNewButton();
		 Thread.sleep(3000);
		soft.assertEquals(Addcategory.getPageHeader(), "Add New Category");
		Map<String, String> map = excel.readFromExcel("Add Category");
		Addcategory.setName(map.get("Name"));
		Addcategory.clickSave();
		soft.assertEquals(category.getsuccessMessage(), "Success!");
		category.deleteCategory(web, map.get("Name"));
		soft.assertEquals(category.getsuccessMessage(), "Success!");
		if (category.getsuccessMessage().equals("Success!"))
			excel.upadateTestStatus("Add Category", "Pass", IConstantpath.EXCEL_PATH);
		else
			excel.upadateTestStatus("AddCategory","Fail",IConstantpath.EXCEL_PATH);soft.assertAll();
		
	
	}

	private static void clickSave() {
		// TODO Auto-generated method stub
		
	}

	private static void setName(String string) {
		// TODO Auto-generated method stub
		
	}

	private static String getPageHeader() {
		// TODO Auto-generated method stub
		return null;
	}

}
