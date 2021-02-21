package lindermayer;

import java.util.ArrayList;

public class Main {
	public double x;
	public double y;
	public double ang;
	
	public static void main(String[] args) {
		
		Start(args[0]);
		
		
		
	}
	
	public static void Start(String s) {
		LSystem lSyst = new LSystem();
		MyTurtle tortue = new MyTurtle(null,null,null);
		JSONTools jSon = new JSONTools(s,lSyst, tortue);
		
	}
	
	
	
	
	
	
	
	
}
