package lindermayer;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public double x;
	public double y;
	public double ang;
	
	
	public static void main(String args[]) throws IOException {
		
		Start(args[0]);
	}
	
	public static void Start(String s) throws IOException {
		LSystem lSyst = new LSystem();
		MyTurtle tortue = new MyTurtle();
		JSONTools jSon = new JSONTools(s,lSyst, tortue);
		
		jSon.JSonObjc.get(s);
			
	}
	
	
	
	
	
	
	
	
}