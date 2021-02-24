package lindermayer;

import java.util.ArrayList;
import java.util.Iterator;
import lindermayer.Symbol.Seq;

class Sequence implements Seq {
	
	public String seq;
    public static int index = 0;
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
    	  if (index < seq.length()) return true;
        return false;
    }

    public Character next(){
        char ans = seq.charAt(index);
    	index++;
        return ans;
    }
	
    public String toString() {
    	System.out.println(this.seq);
    	return this.seq;
    }
    
}
