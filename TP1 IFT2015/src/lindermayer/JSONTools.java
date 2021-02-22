package lindermayer;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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
		alphabet = new ArrayList<String>(); 
		rulesSet = new HashMap<String, String[]>();
		actions  = new HashMap<String, String>() ;
		parameters = new HashMap<String, ArrayList<?>>();
		
		
		
		//init vars
		String file = "src/"+ fileName;
		JSonObjc = readJSONFile(file);
		extractAlphabet();
		getAxiom();
		
		// Set LSystem
		S.setAxiom(this.axiom);
		createRulesSet(S);
		setActions(S);
		
		// Set MyTurtle
		initTortue(T);
		
	}			

			////.... Variables extraction.....////

		public JSONObject readJSONFile(String file) throws java.io.IOException {
			
			JSONObject jSonInput = new JSONObject(new JSONTokener(new java.io.FileReader(file)));
			return jSonInput;
		}
			
		//alphabet
		@SuppressWarnings("unchecked")
		public void extractAlphabet() {
			JSONArray alph = JSonObjc.getJSONArray("alphabet");
			//int taille = alph.length();
			for(int i =0; i<alph.length();i++ ) {
				String sym = (String) alph.get(i);
				this.alphabet.add(i,sym);
			}
			System.out.println("Alphabet fini");
		}
		
		//axiom
		public void getAxiom(){
			axiom = JSonObjc.getString("axiom");	
		}

		
		// rules
		public void createRulesSet(LSystem LSys) {
			JSONObject rules = this.JSonObjc.getJSONObject("rules"); 
			
			for (int i = 0; i < this.alphabet.size(); i++) {
				String letter = this.alphabet.get(i);
				String str = ""+letter.charAt(0);
				Symbol sym = new Symbol(str);
	
				if (rules.has(letter)) {
					JSONArray all_rules = rules.getJSONArray(letter);
					for (int k = 0; k < all_rules.length(); k++) {
						LSys.addRule(sym, all_rules.getString(k));
					}
				}
			 }
			System.out.println("rules fini");
	  	}	
       
		
		public void setActions(LSystem LSys) {
				JSONObject actions = this.JSonObjc.getJSONObject("actions");
	
				for (int i = 0; i < this.alphabet.size(); i++) {
					String letter = this.alphabet.get(i);
					String str = ""+letter.charAt(0);
					Symbol sym = new Symbol(str);
		
					if (actions.has(letter)) {
		               String letterAction = actions.getString(letter);
		               LSys.setAction(sym, letterAction);
					}
				}
				System.out.println("Actions fini");
		}		
		
	     
		public void initTortue(MyTurtle T) {
		   JSONObject system_params = this.JSonObjc.getJSONObject("parameters"); // tt ce qui a dans parameters

	       JSONArray startJSON = system_params.getJSONArray("start"); // recupere le tableau start
	       
	       double start[] = new double[3];
	       for(int n=0; n<=2; n++){
	           start[n] = startJSON.getDouble(n);
	       }
	       
	       double unit_step = system_params.getDouble("step");
	       double unit_angle = system_params.getDouble("angle");
	       
	       // Update MyTurtle
	       T.init(new Point2D.Double(start[0],start[1]),start[2]);
		   
	       T.setUnits(unit_step, unit_angle);
		
	       System.out.println("totue int fini");
		}
	
}
































