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
