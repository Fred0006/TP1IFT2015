<<<<<<< HEAD
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
=======
package lindermayer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
		public double x;
		public double y;
		public double ang;
		
		public static Arrays alphabet;
		public static String axiom;
		//public static 
		
		
		public static void main(String args[]) {
			
			Start(args[0]);
			
		}
		
		public static void Start(String s) {
			LSystem lSyst = new LSystem();
			MyTurtle tortue = new MyTurtle();
			JSONTools jSon = new JSONTools(s,lSyst, tortue);
			
			jSon.JSonObjc.get(s);
				
		}
		
		
		

}
>>>>>>> branch 'master' of https://github.com/Fred0006/TP1IFT2015
