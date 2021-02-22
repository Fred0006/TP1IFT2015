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
	public ArrayList<String> alphabet;
	public HashMap<?,?> simbol; 
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
		createRulesSet(S);
		
		// Set MyTurtle
		MyTurtleSetUnits(T);
	}			

			////.... Variables extraction.....////

	
		public JSONObject readJSONFile(String file) throws java.io.IOException {
			JSONObject jSonInput = new JSONObject(new JSONTokener(new java.io.FileReader("Instructions")));
			return jSonInput;
		}
			
		//alphabet
		@SuppressWarnings("unchecked")
		public void extractAlphabet() {
			JSONArray alph = JSonObjc.getJSONArray("alphabet");
			for(int i =0; i<alph.length();i++ ) {
				String sym = (String) alph.get(i);
				this.alphabet.add(i, sym);
			}
		}
		
		//axiom
		public void getAxiom(){
			axiom = JSonObjc.getString("axiom");	
		}

		
		// rules
		public void createRulesSet(LSystem LSys) {
					/*  from LSystem  public void addRule(Symbol sym, String expansion)  */
		
			JSONObject rules = this.JSonObjc.getJSONObject("rules"); 

			for (int i = 0; i < this.alphabet.size(); i++) {
				String letter = this.alphabet.get(i);
				Symbol sym = LSys.addSymbol(letter.charAt(0));
	
				if (rules.has(letter)) {
					JSONArray all_rules = rules.getJSONArray(letter);
					for (int k = 0; k < all_rules.length(); k++) {
						LSys.addRule(sym, all_rules.getString(k));
					}
				}
	       }
	  	}	
       
		
		public void setActions() {
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
		/*
       JSONObject system_params = this.JSonObjc.getJSONObject("parameters"); // tt ce qui a dans parameters
       JSONArray startJSON = system_params.getJSONArray("start"); // recupere le tableau start
       double start[] = new double[3];
       for(int i=0; i<=2; i++){
    	   start[i] = Double.parseDouble(startJSON.getString(i));
    	   }
       //MyTurtle.init(new Position(start[0],start[1]),start[2]);
       
       double unit_step = system_params.getDouble("step");
       double unit_angle = system_params.getDouble("angle");
       
      
       return system_params;
		 */

	
	
	     
		   JSONObject system_params = this.JSonObjc.getJSONObject("parameters"); // tt ce qui a dans parameters

	       JSONArray startJSON = system_params.getJSONArray("start"); // recupere le tableau start
	       double start[] = new double[3];
	       for(int n=0; i<=2; i++){
	           start[n] = Double.parseDouble(startJSON.getString(n));
	       }

	       MyTurtle.init(new Position(start[0],start[1]),start[2]);

	       double unit_step = system_params.getDouble("step");
	       double unit_angle = system_params.getDouble("angle");

	      
	  
	  
		  public HashMap<String,String> extractRules(String S, String A) {
			HashMap<String,String> rulesMap = new HashMap<String, String>();
			  
			  return rulesMap;
		  }
	  // update L-System
		  
		  
  
		  
		  
	 // Update MyTurtle
		public void MyTurtleSetUnits(MyTurtle T) {
		    T.setUnits(unit_step, unit_angle);  
		}
	  
 
	
}
































