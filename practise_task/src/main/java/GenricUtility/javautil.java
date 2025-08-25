package GenricUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class javautil {
	
	@Test
	public void getdate() {
		
		Date dateobj=new Date() ;
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateobj);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String daterequrierd = sim.format(cal.getTime());
	}
	
	public int getrandom() {
		Random random=new Random();
		int num = random.nextInt(5000);
		return num;
		
		}

}
