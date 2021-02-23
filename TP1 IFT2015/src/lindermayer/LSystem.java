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
    static ArrayList<Double> turtle_angle = new ArrayList();
    
    public static HashMap<String,Symbol> charToSym = new HashMap<>(); // permet de faire le lien entre le nouveua charactère jouter et sa classe symbole
    public static HashMap<Symbol, ArrayList<Sequence>> rules;
    // Je l'est changé en type Sequence parceque getAxion nous oblige à retourner un element de type Symbol.seq
	public  Sequence axiom;
	public HashMap<String, String> actions;
	// Tous les symbols n'ont pas de  rules mais on peut rajouter des rules ç un symbol qui n'en avait pas.
	public HashMap<String, ArrayList[]> parameters; // pas sur des assignation pour le hashMap
	
	public static Sequence sequebceFinal;
	
    public LSystem() {
    	rules = new HashMap<Symbol, ArrayList<Sequence>> ();
    	actions = new HashMap<String, String>();
    	sequebceFinal = new Sequence("");
    }
	
	// changement de la fonction en static car utilisation dans le JSON
	
    public Symbol addSymbol(String sym) {
    	Symbol symbol = new Symbol(sym);
    	charToSym.put(sym,symbol); //charToSym transformé en static dû au changement de la fonction en static
		return symbol; // pareil à cahrTosym
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
    	this.actions.put(sym.character, action);
    }
    
    public  void setAxiom(String str){
    	axiom = new Sequence(str);
    }
     
    public Sequence getAxiom(){
    	return this.axiom;
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
    	String action = this.actions.get(sym.character);
    	
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
    	turtle_angle.add(turtle.getAngle());
     	 	
    }
	
	
    /* opérations avancées */
    
    public Symbol.Seq applyRules(Symbol.Seq seq, int n) {
    	System.out.println("apply rules");
    	if(n==0) {
    		return seq;
    	}
 
        while (seq.hasNext()) {
            Symbol sym = charToSym.get(seq.next());
            this.sequebceFinal.seq = this.sequebceFinal.seq + rewrite(sym);
            }
        applyRules(this.sequebceFinal,n-1);
        return  this.sequebceFinal;  // Retourne la sequence final 
    	
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

	
}
