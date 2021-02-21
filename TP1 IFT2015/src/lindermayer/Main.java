package lindermayer;
import java.util.ArrayList;

public class Main {
		public double x;
		public double y;
		public double ang;
		
		//public 
		
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
