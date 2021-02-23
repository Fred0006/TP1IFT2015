package lindermayer;


public class Symbol {
	
	public String character;
    public String action;

    public Symbol(String character){
        this.character = character;
    }

     
    public interface Seq extends Iterable<Symbol>{
			
    	public boolean hasNext();

		public Character next();
    }
  
}
