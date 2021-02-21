package lindermayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import lindenmayer.LSystem;
import lindenmayer.Turtle;


public class JSONTools{
	public String[] varNames;
	public JSONObject JSonObjc;
	public InputStream input;
	
	public JSONTools(String fileName)  {
		
		String file = "src/"+ fileName;
		JSonObjc = readJSONFile(file,null,null);
	}			

	public JSONObject readJSONFile(String file, LSystem S, Turtle T) throws java.io.IOException {
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file))); // lecture de fichier JSON avec JSONTokener
        JSONArray alphabet = input.getJSONArray("alphabet");
        String axiom = input.getString("axiom");
        String letter = alphabet.getString(0);
        char sym = letter.charAt(0); // un caractère
       // S.setAxiom(axiom);
        
       return input;
}
	
}