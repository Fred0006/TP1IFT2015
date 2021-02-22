package lindermayer;

import java.util.*;

import lindermayer.Symbol.Seq;

public class Symbol {
	
	public char character;
    public String action;

    public Symbol(char character){
        this.character = character;
    }

    public Symbol(char character, String action){
        this.character = character;
        this.action = action;
    }
    
    public interface Seq extends Iterable<Symbol>{
    	public boolean hasNext();
		public Character next();
    }
    
    
    

}
