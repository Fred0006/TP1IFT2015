package lindermayer;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;


public class LSystem {
	
	static ArrayList<Double> turtle_posX = new ArrayList(); // On enregistre la liste des positions de X.
    static ArrayList<Double> turtle_posY = new ArrayList(); // On enregistre la liste des positions de y.
    private HashMap<Character,Symbol> charToSym = new HashMap<>(); // permet de faire le lien entre le nouveua charactère jouter et sa classe symbole
    public HashMap<String, String[]> rules;
	public String axiom;
	public HashMap<String, String> actions;
	// Tous les symbols n'ont pas de  rules mais on peut rajouter des rules ç un symbol qui n'en avait pas.
	public HashMap<String, ArrayList[]> parameters; 
	
    public Symbol charactere; // pas sur
	
	/**
     * constructeur vide monte un système avec alphabet vide et sans règles
     */
    /* méthodes d'initialisation de système */
	public LSystem() {
		// TODO Auto-generated constructor stub
	}
	
    public Symbol addSymbol(char sym) {
    	Symbol symbol = new Symbol(sym);
    	charToSym.put(sym,symbol);
		return charactere; 
	}
    public void addRule(Symbol sym, String expansion) {
    	Sequence seq = new Sequence(expansion);
    	
    	if(rules.containsKey(sym)) {
    	}
    	
    }
    public void setAction(Symbol sym, String action) {
    	
    }
    public void setAxiom(String str){
    	
    }
 
    /* accès aux règles et exécution */
    public Symbol.Seq getAxiom(){
		return null;
		}
    //public Symbol.Seq rewrite(Symbol sym) {}
    public void tell(Turtle turtle, Symbol sym) {
    	
    }
 
    /* opérations avancées */
    //public Symbol.Seq applyRules(Symbol.Seq seq, int n) {...}
    /* retourne BoundingBox pour le dessin */
   // public Rectangle2D tell(Turtle turtle, Symbol.Seq seq, int n){ ...}

	public static void readJSONFile(String file, LSystem S, Turtle T) throws java.io.IOException {
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file))); // lecture de fichier JSON avec JSONTokener
        JSONArray alphabet = input.getJSONArray("alphabet");
        String axiom = input.getString("axiom");
	}

}
