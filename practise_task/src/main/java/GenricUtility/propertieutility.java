package GenricUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class propertieutility {
	@Test
	public String getdatafromproperty(String key) throws IOException {
		FileInputStream fis =new FileInputStream("./src/test/resources/testdata/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		
		return data;
		
	}

}
