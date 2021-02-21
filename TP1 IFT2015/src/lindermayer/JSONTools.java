package lindermayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.*;


public class JSONTools{
	
	public JSONObject JSonObjc;
	
	
	public JSONTools(String fileName,LSystem S, MyTurtle T) throws IOException  {
		
		String file = "src/"+ fileName;
		JSonObjc = readJSONFile(file,null,null);
	}			

	  public JSONObject readJSONFile(String file, LSystem S, MyTurtle T) throws java.io.IOException {
		  	
	   JSONObject jSonInput = new JSONObject(new JSONTokener(new java.io.FileReader("Instructions"))) ;
		       
       JSONArray alphabet = jSonInput.getJSONArray("alphabet");

       LSystem.setAxiom(jSonInput.getString("axiom"));

       JSONObject rules = jSonInput.getJSONObject("rules");

       for (int i = 0; i < alphabet.length(); i++) {
           String letter = alphabet.getString(i);
           Symbol sym = LSystem.addSymbol(letter.charAt(0));

           if (rules.has(letter)) {
               JSONArray all_rules = rules.getJSONArray(letter);
               for (int j = 0; j < all_rules.length(); j++) {
            	   LSystem.addRule(sym, all_rules.getString(j));
               }
           }

           JSONObject actions = jSonInput.getJSONObject("actions");

           if (actions.has(letter)) {
               String letterAction = actions.getString(letter);
               LSystem.setAction(sym, letterAction);
           }

       }
       
       JSONObject system_params = jSonInput.getJSONObject("parameters"); // tt ce qui a dans parameters
       JSONArray startJSON = system_params.getJSONArray("start"); // recupere le tableau start
       double start[] = new double[3];
       for(int i=0; i<=2; i++){
    	   start[i] = Double.parseDouble(startJSON.getString(i));
    	   }
       //MyTurtle.init(new Position(start[0],start[1]),start[2]);
       
       double unit_step = system_params.getDouble("step");
       double unit_angle = system_params.getDouble("angle");
       
       
       //MyTurtle.setUnits(unit_step, unit_angle);
	    
       //return input;
       return system_params;
   }
	
}