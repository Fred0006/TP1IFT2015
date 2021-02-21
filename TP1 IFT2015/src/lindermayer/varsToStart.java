package lindermayer;

import java.util.ArrayList;
import java.util.HashMap;

public class varsToStart {
//
	public HashMap<String, String[]> rules;
	public String axiom;
	public HashMap<String, String> actions;
	public HashMap<String, ArrayList[]> parameters;
	
	
	public varsToStart() {
		String [] alphabet = {"F", "[", "]", "+", "-"};
	
		String [] ruleForF = {"FF-[-F+F+F]+[+F-F-F]", "FF+[-F]+F"};
		rules.put("F", ruleForF);
		axiom = "F";
		
		actions.put("F","draw");
		actions.put("[","push");
		actions.put("]","ppop");
		actions.put("-","turnL");
		actions.put("+","turnR");
	}
	
	//
	//public String symbol (String lettre) {
	//}

}
