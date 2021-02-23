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
			
			LSystem lSyst = new LSystem( );
			MyTurtle tortue = new MyTurtle();
			
			JSONTools jSon = new JSONTools(args[0],lSyst, tortue);
			
			int iter = Integer.parseInt(args[1]);
			
			
			
			lSyst.applyRules(lSyst.axiom, iter);
			System.out.println("rules applied");
			
			String SequenceFInal = lSyst.sequebceFinal.seq;
			System.out.println("Sequanse fini");
			
			
			System.out.println(SequenceFInal);
			
			for(int i = 0; i< SequenceFInal.length();i++) {
				lSyst.tell(tortue, (Symbol)lSyst.charToSym.get(""+SequenceFInal.charAt(i)));
				System.out.println(lSyst.actions.get(""+SequenceFInal.charAt(i))+ " : " + lSyst.turtle_posX.get(i) +
				          lSyst.turtle_posY.get(i) + lSyst.turtle_angle.get(i));
			}
			
			
			
		}
		
		
		
		
		
		
	 
}
