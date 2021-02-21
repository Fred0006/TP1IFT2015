package lindermayer;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;


public class LSystem {////
	
	static ArrayList<Double> turtle_posX = new ArrayList(); // On enregistre la liste des positions de X.
    static ArrayList<Double> turtle_posY = new ArrayList(); // On enregistre la liste des positions de y.
    
    private static HashMap<Character,Symbol> charToSym = new HashMap<>(); // permet de faire le lien entre le nouveua charactï¿½re jouter et sa classe symbole
    public static HashMap<Symbol, ArrayList<Sequence>> rules;
    // Je l'est changï¿½ en type Sequence parceque getAxion nous oblige ï¿½ retourner un element de type Symbol.seq
	public static Sequence axiom;
	public HashMap<String, String> actions;
	// Tous les symbols n'ont pas de  rules mais on peut rajouter des rules ï¿½ un symbol qui n'en avait pas.
	public HashMap<String, ArrayList[]> parameters; // pas sur des assignation pour le hashMap
	
    public static Symbol charactere; // pas sur
	
	/**
     * constructeur vide monte un systï¿½me avec alphabet vide et sans rï¿½gles
     */
    /* mï¿½thodes d'initialisation de systï¿½me */
	public LSystem() {
		// TODO Auto-generated constructor stub
	}
	
	// changement de la fonction en static car utilisation dans le JSON
	
    public static Symbol addSymbol(char sym) {
    	Symbol symbol = new Symbol(sym);
    	charToSym.put(sym,symbol); //charToSym transformï¿½ en static dï¿½ au changement de la fonction en static
		return charactere; // pareil ï¿½ cahrTosym
	}
    
    
    public static void addRule(Symbol sym, String expansion) {
    	Sequence nouvelleSeq = new Sequence(expansion);
    	
    	// verifie que la clï¿½ ï¿½ pas dï¿½ja de liste de rï¿½gles
    	if(rules.containsKey(sym)) {
    		rules.get(sym).add(nouvelleSeq);
    	}
    	else { // si on attribut une sequence ï¿½ une nouvelle clï¿½ qui n'en avait pas avant
    		ArrayList<Sequence> ruleForKey = new ArrayList<>();
        	ruleForKey.add(nouvelleSeq);
        	rules.put(sym, ruleForKey);
    	}
   }
    
    public static void setAction(Symbol sym, String action) {
    	sym.action = action;
    }
    
    public static void setAxiom(String str){
    	axiom = new Sequence(str);
    }
    
    public Symbol.Seq getAxiom(){
    	return axiom;
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
 
<<<<<<< HEAD
    /* opérations avancées */
   public Symbol.Seq applyRules(Symbol.Seq seq, int n) {
	   
   }
=======
    /* opï¿½rations avancï¿½es */
<<<<<<< HEAD
    //public Symbol.Seq applyRules(Symbol.Seq seq, int n) {...}
>>>>>>> tipo
=======
   public Symbol.Seq applyRules(Symbol.Seq seq, int n) {
	   
   }
    /* retourne BoundingBox pour le dessin   public Rectangle2D tell(Turtle turtle, Symbol.Seq seq, int n){
	   
   }
..}
 
>>>>>>> new
    /* retourne BoundingBox pour le dessin */
   public Rectangle2D tell(Turtle turtle, Symbol.Seq seq, int n){
	   
   }

	public static void readJSONFile(String file, LSystem S, Turtle T) throws java.io.IOException {
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file))); // lecture de fichier JSON avec JSONTokener
        JSONArray alphabet = input.getJSONArray("alphabet");
        String axiom = input.getString("axiom");
	}

}
