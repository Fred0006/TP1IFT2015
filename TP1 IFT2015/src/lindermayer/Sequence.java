package lindermayer;

import java.util.ArrayList;
import java.util.Iterator;
import lindermayer.Symbol.Seq;

class Sequence implements Seq {// implementer une liste de symbol
	
	public String seq;
    public int index = 0;
    public ArrayList<Symbol> listSymbol = new ArrayList<>();
    
    
    public Sequence(String seq){
        this.seq = seq;
    }
    
    public void addSymbol (Symbol symbol) {
    	this.listSymbol.add(symbol);
    }

	@Override
	public Iterator<Symbol> iterator() {
		return this.listSymbol.iterator();
	}
	
    public boolean hasNext(){
        return index < seq.length();
    }

    public Character next(){
        index++;
        return seq.charAt(index-1);
    }
	
	/*
	 * public class MyIterator<Symbol> implements Iterator<Symbol> {
		
		int positionIndex = 0;
		ArrayList<Symbol> listeInterne;
		
		public MyIterator(ArrayList<Symbol> listeInterne) {
			this.listeInterne = listeInterne;
		}
		
		@Override
		public boolean hasNext(){
	        return index < seq.length();
	    }
	    
		@Override
	    public Symbol next(){
	        index++;
	        return seq.charAt(index-1);
	    }
	}
	 */
	
	
}
