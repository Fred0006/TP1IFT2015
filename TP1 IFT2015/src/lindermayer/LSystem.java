package lindermayer;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;


public class LSystem {////
	
	static ArrayList<Double> turtle_posX = new ArrayList(); // On enregistre la liste des positions de X.
    static ArrayList<Double> turtle_posY = new ArrayList(); // On enregistre la liste des positions de y.
    
    private static HashMap<Character,Symbol> charToSym = new HashMap<>(); // permet de faire le lien entre le nouveua charact�re jouter et sa classe symbole
    public static HashMap<Symbol, ArrayList<Sequence>> rules;
    // Je l'est chang� en type Sequence parceque getAxion nous oblige � retourner un element de type Symbol.seq
	public static String axiom;
	public HashMap<String, String> actions;
	// Tous les symbols n'ont pas de  rules mais on peut rajouter des rules � un symbol qui n'en avait pas.
	public HashMap<String, ArrayList[]> parameters; // pas sur des assignation pour le hashMap
	
    public static Symbol charactere;
	
	
	public LSystem() {
		
	}
	
	// changement de la fonction en static car utilisation dans le JSON
	
    public static Symbol addSymbol(char sym) {
    	Symbol symbol = new Symbol(sym);
    	charToSym.put(sym,symbol); //charToSym transform� en static d� au changement de la fonction en static
		return charactere; // pareil � cahrTosym
	}
    
    
    public static void addRule(Symbol sym, String expansion) {
    	Sequence nouvelleSeq = new Sequence(expansion);
    	
    	// verifie que la cl� � pas d�ja de liste de r�gles
    	if(rules.containsKey(sym)) {
    		rules.get(sym).add(nouvelleSeq);
    	}
    	else { // si on attribut une sequence � une nouvelle cl� qui n'en avait pas avant
    		ArrayList<Sequence> ruleForKey = new ArrayList<>();
        	ruleForKey.add(nouvelleSeq);
        	rules.put(sym, ruleForKey);
    	}
   }
    
    public static void setAction(Symbol sym, String action) {
    	sym.action = action;
    }
    
    public static void setAxiom(String str){
    	LSystem.axiom = str;
    }
    
    public String getAxiom(){
    	return LSystem.axiom;
    }
    
    public Symbol.Seq rewrite(Symbol sym) {
    	ArrayList<Sequence> rulesOfKey = rules.get(sym);
    	
    	if(rulesOfKey != null) {
    		int choixAlea = (int) Math.floor(Math.random()*rulesOfKey.size());
        	return rulesOfKey.get(choixAlea);
    	}
    	else {
    		return null;
    	}
    	}
    
    public void tell(Turtle turtle, Symbol sym) {
    	String action = sym.action;
    	
    	if("draw".equals(action)) { turtle.draw(); }
    	else if ("move".equals(action))  {
    		turtle.move(); 
    	}
    	else if ("turnR".equals(action)) 
    		turtle.turnR(); 
    	else if ("turnL".equals(action)) 
    		turtle.turnL(); 
    	else if ("push".equals(action))  
    		turtle.push(); 
    	else if ("pop".equals(action))  
    		turtle.pop(); 
    	
    	turtle_posX.add(turtle.getPosition().getX());
    	turtle_posY.add(turtle.getPosition().getY());
    	
    }
 

    /* op�rations avanc�es */
   public Symbol.Seq applyRules(Symbol.Seq seq, int n) {
	   
   }
    //retourne BoundingBox pour le dessin   public Rectangle2D tell(Turtle turtle, Symbol.Seq seq, int n){
   public Rectangle2D tell(Turtle turtle, Symbol.Seq seq, int n){
	   
   }

	public static void readJSONFile(String file, LSystem S, Turtle T) throws java.io.IOException {
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file))); // lecture de fichier JSON avec JSONTokener
        JSONArray alphabet = input.getJSONArray("alphabet");
        String axiom = input.getString("axiom");
	}

}
