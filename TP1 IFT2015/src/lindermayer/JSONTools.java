package lindermayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;


public class JSONTools{
	public String[] varNames;
	public JSONObject JSonObjc;
	public InputStream input;
	
	public JSONTools(String fileName)  {
		String sourceName = "src/"+ fileName;
		/*File path = new File(sourceName);
		String jSonString = jSonReader(sourceName);
		JSonObjc = getJSONObj(jSonString);
		varNames = JSONObject.getNames(JSonObjc);  */
	}			
		
	public JSONObject getJSONObj(String jSonString) {
		return new JSONObject(jSonString);
	}
	
	public boolean objExist(JSONObject jsonObj, String key) {
		Object o;
		try {
			o = jsonObj.get(key);
		} catch (Exception e){
			return false;
		}
		return o != null;
	}
	

		
		public String jSonReader(String path) {	
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
				String line = reader.readLine();
				while(reader.readLine()!= null) {
					line += reader.readLine();
				}
				reader.close();
				return line;
				
			}catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
	
	
	

}