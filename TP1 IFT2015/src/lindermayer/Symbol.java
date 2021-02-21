package lindermayer;

import java.util.*;

public class Symbol {
	
	char character;
    String action;

    public Symbol(char character){
        this.character = character;
    }

    public Symbol(char character, String action){
        this.character = character;
        this.action = action;
    }
    
    public interface Seq extends Iterable<Symbol>{
    }
    

}
