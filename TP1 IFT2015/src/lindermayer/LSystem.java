package lindermayer;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.json.*;


public class LSystem {
	
	static ArrayList<Double> turtle_posX = new ArrayList(); // On enregistre la liste des positions de X.
    static ArrayList<Double> turtle_posY = new ArrayList(); // On enregistre la liste des positions de y.
    
    private static HashMap<Character,Symbol> charToSym = new HashMap<>(); // permet de faire le lien entre le nouveua charactère jouter et sa classe symbole
    public static HashMap<Symbol, ArrayList<Sequence>> rules;
    // Je l'est changé en type Sequence parceque getAxion nous oblige à retourner un element de type Symbol.seq
	public static Sequence axiom;
	public HashMap<String, String> actions;
	// Tous les symbols n'ont pas de  rules mais on peut rajouter des rules ç un symbol qui n'en avait pas.
	public HashMap<String, ArrayList[]> parameters; // pas sur des assignation pour le hashMap
	
    public static Symbol charactere; // pas sur
	
	/**
     * constructeur vide monte un système avec alphabet vide et sans règles
     */
    /* méthodes d'initialisation de système */
	public LSystem() {
		// TODO Auto-generated constructor stub
	}
	
	// changement de la fonction en static car utilisation dans le JSON
	
    public Symbol addSymbol(char sym) {
    	Symbol symbol = new Symbol(sym);
    	charToSym.put(sym,symbol); //charToSym transformé en static dû au changement de la fonction en static
		return charactere; // pareil à cahrTosym
	}
    
    
    public void addRule(Symbol sym, String expansion) {
    	Sequence nouvelleSeq = new Sequence(expansion);
    	
    	// verifie que la clé à pas déja de liste de règles
    	if(rules.containsKey(sym)) {
    		rules.get(sym).add(nouvelleSeq);
    	}
    	else { // si on attribut une sequence à une nouvelle clé qui n'en avait pas avant
    		ArrayList<Sequence> ruleForKey = new ArrayList<>();
        	ruleForKey.add(nouvelleSeq);
        	rules.put(sym, ruleForKey);
    	}
   }
    
    public void setAction(Symbol sym, String action) {
    	sym.action = action;
    }
    
    public  void setAxiom(String str){
    	axiom = new Sequence(str);
    }
    
    
    public Sequence getAxiom(){
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
    	
    	if("draw".equals(action))
    		turtle.draw(); 
    	else if ("move".equals(action))  
    		turtle.move(); 
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
 
    /* opérations avancées */
    public Symbol.Seq applyRules(Symbol.Seq seq, int n) {
    	if(n==0) {
    		return seq;
    	}
    	
        Sequence seqReponse = new Sequence("");
        
        while (seq.hasNext()) {
            Symbol sym = charToSym.get(seq.next());
            seqReponse.seq = seqReponse.seq + rewrite(sym);
            }
        
        return applyRules(seqReponse,n-1);// Retourne la sequence final 
    	
    }
    
    /* retourne BoundingBox pour le dessin */
    public Rectangle2D tell(Turtle turtle, Symbol.Seq seq, int n){
    	double Xmin , Xmax, Ymin, Ymax;
    	
    	Xmin  = Collections.min(turtle_posX);
        Xmax = Collections.max(turtle_posX);
        Ymin = Collections.min(turtle_posY);
        Ymax = Collections.max(turtle_posY);
        
        double largeurRect = Xmax-Xmin;
        double hauteurRect = Ymax-Ymin;
        
        Rectangle2D rectangle = new Rectangle();
        rectangle.setRect(Xmin,Ymax,largeurRect,hauteurRect);
        
        return rectangle;
    }

	public static void readJSONFile(String file, LSystem S, Turtle T) throws java.io.IOException {
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file))); // lecture de fichier JSON avec JSONTokener
        JSONArray alphabet = input.getJSONArray("alphabet");
        String axiom = input.getString("axiom");
	}


}
