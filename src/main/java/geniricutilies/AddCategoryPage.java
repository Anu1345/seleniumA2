package geniricutilies;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AddCategoryPage extends BaseClass {
	@Test
	public void addCategoryTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertEquals(category.getPageHeader(), "Category");

		category.clickNewButton();
		 Thread.sleep(3000);
		soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
		Map<String, String> map = excel.readFromExcel("Add Category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		soft.assertEquals(category.getsuccessMessage(), "Success!");
		category.deleteCategory(web, map.get("Name"));
		soft.assertEquals(category.getsuccessMessage(), "Success!");
		if (category.getsuccessMessage().equals("Success!")upadateTestStatus)
			excel.upadateTestStatus("Add Category", "Pass", IConstantpath.EXCEL_PATH);
		else
			excel.("Add Category", "Fail", IConstantpath.EXCEL_PATH);
		soft.assertAll();

	}

}

		
	

