package lindermayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.*;

public class JSONTools{
	public ArrayList[] alphabet;
	//private HashMap<?,?> simbol; 
	
	public String axiom;
	public HashMap<String, String[]> rulesSet;
	public HashMap<String, String> actions;
	public HashMap<String, ArrayList<?>> parameters;
	
    public JSONObject JSonObjc;

	
	
	public JSONTools(String fileName,LSystem S, MyTurtle T) throws IOException  {
		//init vars
		
		String file = "src/"+ fileName;
		JSonObjc = readJSONFile(file);
		extractAlphabet();
		getAxiom();
		
		// Set LSystem
		S.setAxiom(this.axiom);
		
		// Set MyTurtle
		MyTurtleSetUnits(T);
	}			

	
		////.... Variables extraction.....////
	
		public JSONObject readJSONFile(String file) throws java.io.IOException {
			JSONObject jSonInput = new JSONObject(new JSONTokener(new java.io.FileReader("Instructions")));
			return jSonInput;
		}
			
		
		@SuppressWarnings("unchecked")
		public void extractAlphabet() {
			JSONArray alph = JSonObjc.getJSONArray("alphabet");
			alphabet = new ArrayList[alph.length()]; 
			for(int i =0; i<alph.length();i++ ) {
				Symbol sym = new Symbol((char) alph.get(i));
				alphabet[i].add(sym);
			}
		}
		
		public void getAxiom(){
			axiom = JSonObjc.getString("axiom");
			
		}

		JSONObject rules = JSonObjc.getJSONObject("rules");
			
		public void buildRulesSet() {
			for (int i = 0; i < alphabet.length(); i++) {
				String letter = alphabet.getString(i);
				Symbol sym = addSymbol(letter.charAt(0));
			}
	
	       for (int i = 0; i < alphabet.length(); i++) {
	           String letter = alphabet.getString(i);
	           Symbol sym = LSystem.addSymbol(letter.charAt(0));
	
				if (rules.has(letter)) {
					JSONArray all_rules = rules.getJSONArray(letter);
					for (int j = 0; j < all_rules.length(); j++) {
						addRule(sym, all_rules.getString(j));
					}
				}
	
	
	           if (rules.has(letter)) {
	               JSONArray all_rules = rules.getJSONArray(letter);
	               for (int j = 0; j < all_rules.length(); j++) {
	            	   LSystem.addRule(sym, all_rules.getString(j));
	               }
	           }
	
				
				
				JSONObject actions = jSonInput.getJSONObject("actions");
	
				if (actions.has(letter)) {
					String letterAction = actions.getString(letter);
					setAction(sym, letterAction);
				}
	
	
	           if (actions.has(letter)) {
	               String letterAction = actions.getString(letter);
	               LSystem.setAction(sym, letterAction);
	           }

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
       
      
       return system_params;
       

	
	
	     
		JSONObject system_params = jSonInput.getJSONObject("parameters"); // tt ce qui a dans parameters

	       JSONArray startJSON = system_params.getJSONArray("start"); // recupere le tableau start
	       double start[] = new double[3];
	       for(int i=0; i<=2; i++){
	           start[i] = Double.parseDouble(startJSON.getString(i));
	       }

	       MyTurtle.init(new Position(start[0],start[1]),start[2]);

	       double unit_step = system_params.getDouble("step");
	       double unit_angle = system_params.getDouble("angle");

	      
	  
	  
		  public HashMap<?,?> extractRules(String S,String S){
			  HashMap<String,String> rulesMap = new HashMap<String, String>();
			  
			  return rulesMap;
		  }
	  // update L-System
		  
		  
		  
		  
		  
	 // Update MyTurtle
		public void MyTurtleSetUnits(MyTurtle T) {
		    T.setUnits(unit_step, unit_angle);  
		}
	  
 
	
}
































