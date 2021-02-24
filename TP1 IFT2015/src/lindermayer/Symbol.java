
package lindermayer;


import lindermayer.Symbol.Seq;

public class Symbol {
	
	public String character;
    public String action;

    public Symbol(String character){
        this.character = character;
    }

    public Symbol(String character, String action){
        this.character = character;
        this.action = action;
    }
    
    public interface Seq extends Iterable<Symbol>{
    	public boolean hasNext();
		public Character next();
    }
  
}
