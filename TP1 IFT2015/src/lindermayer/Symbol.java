package lindermayer;

import java.util.Iterator;

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
    
    class Sequence implements Seq {
    	
    	String seq;
        int index = 0;

        public Sequence(String seq){
            this.seq = seq;
        }

		@Override
		public Iterator<Symbol> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
        public boolean hasNext(){
            return index < seq.length();
        }
        
        public Character next(){
            index++;
            return seq.charAt(index-1);
        }
    	
    }

}
