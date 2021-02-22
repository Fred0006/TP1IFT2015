package lindermayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
		public double x;
		public double y;
		public double ang;
		
		public static Arrays alphabet;
		public static String axiom;
		//public static 
		
		
		public static void main(String[] args) throws IOException {
			
			LSystem lSyst = new LSystem();
			MyTurtle tortue = new MyTurtle();
			JSONTools jSon = new JSONTools(args[0],lSyst, tortue);
			int iter = Integer.parseInt(args[1]);
			
			lSyst.applyRules(lSyst.axiom, iter);
			
			String SequenceFInal = lSyst.sequebceFinal.seq;
			System.out.println(SequenceFInal);
			
			
			
			
			lSyst.tell(tortue, null);
			
			
		
		
		}
		
		
		

}
