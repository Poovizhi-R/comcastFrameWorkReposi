package Com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
public String getDataFromPropertiesFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("./commondata/commondata.properties");
	Properties poj=new Properties();
	poj.load(fis);
	String data=(String)poj.getProperty(key);
	return data;
}
}
