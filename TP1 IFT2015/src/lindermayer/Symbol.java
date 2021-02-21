package lindermayer;

public class Symbol {
	
	private final char value;
	
    public Symbol(char c){
        this.value = c;
    }
    
    @Override
    public String toString(){
        return Character.toString(value);
    }
    
    public interface Seq extends Iterable<Symbol>{
    	
    }    

}
