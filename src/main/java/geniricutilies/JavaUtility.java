package geniricutilies;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains reusable method to perform java related operations
 * 
 * @author admin
 */

public class JavaUtility {
	/**
	 * This method fetch current date and time in specified format
	 * 
	 * @return
	 */
	public String getCurrentTime() {
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return sdf.format(data);
	}

}
