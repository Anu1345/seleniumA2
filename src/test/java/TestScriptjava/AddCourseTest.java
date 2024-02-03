package TestScriptjava;


import java.util.Map;

import org.testng.annotations.Test;

import geniricutilies.BaseClass;
//This test verifies if user is able to couseTest
public class AddCourseTest extends BaseClass{
	@Test
	
	public void addCourseTest(){
		home.clickCoursesListLink();
		home.clickCoursesListLink();
		courseList.clickNewButton();
		
		Map<String,String>map=excel.readFromExcel("Add Course");
		addCourse.selectName(map.get("Name"));
		addCourse.selectCtegory(web, map.get("Category"));
		addCourse.setPrice(map.get("Price"));
		addCourse.UploadPhoto("Photo");
		addCourse.setDescription(map.get("Description"),web);
		addCourse.click();
		
		System.out.println("courseList.getSuccessMessage");
		courseList.deleteCourse(web,map.get("Name"));
		System.out.println("couselist.getsuccessMessage()");
		
		
	}

}
