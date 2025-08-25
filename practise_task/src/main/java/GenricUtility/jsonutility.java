package GenricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class jsonutility {
	@Test
	public String getDatafromjsonfile(String key) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/resources/testdata/common.json"));
		JSONObject map=(JSONObject)obj;
		
		String data = map.get(key).toString();
		
		return data ;
		
	}

}
