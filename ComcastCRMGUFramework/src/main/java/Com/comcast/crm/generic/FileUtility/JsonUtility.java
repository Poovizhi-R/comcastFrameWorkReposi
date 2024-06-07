package Com.comcast.crm.generic.FileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws IOException, ParseException {
	FileReader fileR=new FileReader("./commondata/appCommondata.json");
	JSONParser parser=new JSONParser();
	Object obj=parser.parse(fileR);
	JSONObject map=(JSONObject)obj;
	String data=map.get(key).toString();
	return data;
}
}
