package lindermayer;

import java.awt.geom.Point2D;
import java.util.Stack;

public class MyTurtle implements Turtle {
	public State currentState;
    public Stack<State> statesHistory;
    public double distanceUnitaire;
    public double angleUnitaire;
    
	public MyTurtle(){
		currentState = new State();
		statesHistory = new Stack<State>();
		}
	
	public void setPosition(double posX ,double posY, double angle) {
		currentState.setState(posX, posY, angle);
	}
	
    @Override
    public void draw() {
    	double nouveauX = distanceUnitaire*Math.cos(Math.toRadians(currentState.getAngle()));
        double nouveauY =distanceUnitaire*Math.sin(Math.toRadians(currentState.getAngle()));
        currentState.setState(nouveauX , nouveauY , currentState.getAngle());
    }

    @Override
    public void move() {
    	double nouveauX = distanceUnitaire*Math.cos(Math.toRadians(currentState.getAngle()));
        double nouveauY =distanceUnitaire*Math.sin(Math.toRadians(currentState.getAngle()));
        currentState.setState(nouveauX , nouveauY , currentState.getAngle());
    }

    @Override
    public void turnR() {
        double nouvelAngle = currentState.getAngle() - angleUnitaire;
        currentState.setState(currentState.getPosX() , currentState.getPosX(), nouvelAngle);
    }

    @Override
    public void turnL() {
    	double nouvelAngle = currentState.getAngle() + angleUnitaire;
        currentState.setState(currentState.getPosX(), currentState.getPosY() , nouvelAngle);
    }

    public void push() {
    	statesHistory.push(currentState);
    }

    public void pop() {
    	statesHistory.pop();
    	currentState = statesHistory.peek();
    }

    public void stay() {
    	// Ne sert �......RIEN
    }

    public void init(Point2D position, double angle_deg) {
    	currentState.setState(position.getX() , position.getY() , angle_deg);
    	statesHistory.clear();
    }

    public Point2D getPosition() {
        return new Point2D.Double(currentState.getPosX() , currentState.getPosY());
    }

    public double getAngle() {
        return currentState.getAngle();
    }

    public void setUnits(double step, double delta) {
    	distanceUnitaire = step;
    	angleUnitaire = delta;
    }
    
    // State Class
    private static class State {
    	
    	public double posX;
    	public double posY;
    	public double angle;
        
        public State(){
           
    	} 
        
        public void setState(double posX ,double posY, double angle) {
        	this.posX = posX;
        	this.posY = posY;
        	this.angle = angle;
        }
        
        public double getPosX() {
			return posX;
		}

		public void setPosX(double posX) {
			this.posX = posX;
		}

		public double getPosY() {
			return posY;
		}

		public void setPosY(double posY) {
			this.posY = posY;
		}

		public double getAngle() {
			return angle;
		}

		public void setAngle(double angle) {
			this.angle = angle;
		}
        
         
    }
  }
