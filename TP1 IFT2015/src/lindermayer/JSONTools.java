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

import LSystem.Sequence;
import LSystem.Symbol;


public class JSONTools{
	public Arrays alphabet;
	private HashMap<?,?> simbol; 
	public String axiom;
	
	
	public JSONObject JSonObjc;
	
	
<<<<<<< HEAD
	public JSONTools(String fileName,LSystem S, MyTurtle T) throws IOException  {
		
=======
	public JSONTools(String fileName,LSystem S, MyTurtle T)  {
>>>>>>> branch 'master' of https://github.com/Fred0006/TP1IFT2015
		String file = "src/"+ fileName;
		JSonObjc = readJSONFile(file);
		setAxiom();
		
		// Set LSystem
		
		
		// Set MyTurtle
		MyTurtleSetUnits(T);
		
		
		
	}			

	
	
		public JSONObject readJSONFile(String file) throws java.io.IOException {
			JSONObject jSonInput = new JSONObject(new JSONTokener(new java.io.FileReader("Instructions")));
			return jSonInput;
		}
			
		
		public void extractAlphabet() {
			JSONArray alphabet = jSonInput.getJSONArray("alphabet");
		}
		
		public void setAxiom(){
			axiom = JSonObjc.getString("axiom");
		}

<<<<<<< HEAD
       LSystem.setAxiom(jSonInput.getString("axiom"));
=======
		
		
		JSONObject rules = jSonInput.getJSONObject("rules");
>>>>>>> branch 'master' of https://github.com/Fred0006/TP1IFT2015

		for (int i = 0; i < alphabet.length(); i++) {
			String letter = alphabet.getString(i);
			Symbol sym = addSymbol(letter.charAt(0));

<<<<<<< HEAD
       for (int i = 0; i < alphabet.length(); i++) {
           String letter = alphabet.getString(i);
           Symbol sym = LSystem.addSymbol(letter.charAt(0));
=======
			if (rules.has(letter)) {
				JSONArray all_rules = rules.getJSONArray(letter);
				for (int j = 0; j < all_rules.length(); j++) {
					addRule(sym, all_rules.getString(j));
				}
			}
>>>>>>> branch 'master' of https://github.com/Fred0006/TP1IFT2015

<<<<<<< HEAD
           if (rules.has(letter)) {
               JSONArray all_rules = rules.getJSONArray(letter);
               for (int j = 0; j < all_rules.length(); j++) {
            	   LSystem.addRule(sym, all_rules.getString(j));
               }
           }
=======
			
			
			JSONObject actions = jSonInput.getJSONObject("actions");
>>>>>>> branch 'master' of https://github.com/Fred0006/TP1IFT2015

			if (actions.has(letter)) {
				String letterAction = actions.getString(letter);
				setAction(sym, letterAction);
			}

<<<<<<< HEAD
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
=======
		}
		private void extractRules() {
	
		
		}
	
	     
		JSONObject system_params = jSonInput.getJSONObject("parameters"); // tt ce qui a dans parameters

	       JSONArray startJSON = system_params.getJSONArray("start"); // recupere le tableau start
	       double start[] = new double[3];
	       for(int i=0; i<=2; i++){
	           start[i] = Double.parseDouble(startJSON.getString(i));
	       }

	       MyTurtle.init(new Position(start[0],start[1]),start[2]);

	       double unit_step = system_params.getDouble("step");
	       double unit_angle = system_params.getDouble("angle");

	      
	  
	  
		  public Arrays<String[]> extractRules(){
			  
			  
		  
		  }
	  // update L-System
		  
		  
		  
		  
		  
	 // Update MyTurtle
		public void MyTurtleSetUnits(MyTurtle T) {
		    T.setUnits(unit_step, unit_angle);  
		}
	  
       
/*
 *
 * alphabet: tableau de symboles (strings)
 * rules: règles comme un objet d’associations symbole → tableau de strings (toutes les règles pour un symbole)
* axiom: chaîne de départ (string)
* actions: associations symbole → instruction de tortue
* parameters: objet avec step (d), angle (δ), et start qui est un tableau avec 3 éléments numériques du l’état initial (x, y, θ)*/

>>>>>>> branch 'master' of https://github.com/Fred0006/TP1IFT2015
	
}
































