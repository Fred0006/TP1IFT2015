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
	
}
