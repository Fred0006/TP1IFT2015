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
     * constructeur vide monte un syst�me avec alphabet vide et sans r�gles
     */
    /* m�thodes d'initialisation de syst�me */
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
 
    /* acc�s aux r�gles et ex�cution */
   // public Symbol.Seq getAxiom(){}
    //public Symbol.Seq rewrite(Symbol sym) {}
    public void tell(Turtle turtle, Symbol sym) {
    	
    }
 
    /* op�rations avanc�es */
    //public Symbol.Seq applyRules(Symbol.Seq seq, int n) {...}
    /* retourne BoundingBox pour le dessin */
   // public Rectangle2D tell(Turtle turtle, Symbol.Seq seq, int n){ ...}

	public static void readJSONFile(String file, LSystem S, Turtle T) throws java.io.IOException {
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file))); // lecture de fichier JSON avec JSONTokener
        JSONArray alphabet = input.getJSONArray("alphabet");
        String axiom = input.getString("axiom");
	}

}
