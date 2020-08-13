package july20;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import june20the.SummationUtil;
import june20the.TestUtil;

public class Addition {
	

	
		
		@DataProvider
		public Object[][] getLogindata() throws Exception
		{
			Object data[][] =SummationUtil.getTestData("Sheet1");
			return data;
		}
		
		@Test(dataProvider="getLogindata")
		public void loginTest(String a,String b)
		{
			Double i=Double.parseDouble(a);  
			Double j=Double.parseDouble(b);  
		System.out.println(i+j);
		}
		
		

	}



