package lindermayer;
import java.awt.geom.Rectangle2D;
import org.json.*;

public class LSystem {
	public Symbol charactere;
	
	public class Symbol {
		
		public String caractere;
		
		public Symbol(String caractere) {
			this.caractere = caractere;
		}
	}
	
	/**
     * constructeur vide monte un système avec alphabet vide et sans règles
     */
    /* méthodes d'initialisation de système */
	public LSystem() {
		// TODO Auto-generated constructor stub
	}
	
    public Symbol addSymbol(char sym) {
		return charactere;
	}
    public void addRule(Symbol sym, String expansion) {
    	
    }
    public void setAction(Symbol sym, String action) {
    	
    }
    public void setAxiom(String str){
    	
    }
 
    /* accès aux règles et exécution */
   // public Symbol.Seq getAxiom(){}
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
