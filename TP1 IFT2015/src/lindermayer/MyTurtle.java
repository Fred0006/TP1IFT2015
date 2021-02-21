package lindermayer;

import java.awt.geom.Point2D;
import java.util.Stack;

public class MyTurtle implements Turtle {
	public int distanceD; // A Revoir son utilit�
	public State currentState;
    public Stack<State> previousStates = new Stack<>();
    public double distanceUnitaire;
    public double angleUnitaire;
    
    
    private class State {
    	
    	public double posX;
        public double posY;
        public double angle;
        
        public State(double posX ,double posY, double angle){
            this.posX = posX;
            this.posY = posY;
            this.angle = angle;
    	} 
    }

	public MyTurtle(){

	}
	
	public void setPosition(double posX ,double posY, double angle) {
		this.currentState = new State(posX,posY,angle);
	}
	
	
    @Override
    public void draw() {
    	double nouveauX = distanceUnitaire*Math.cos(Math.toRadians(currentState.angle));
        double nouveauY =distanceUnitaire*Math.sin(Math.toRadians(currentState.angle));
        currentState = new State(nouveauX , nouveauY , currentState.angle);
    }

    @Override
    public void move() {
    	double nouveauX = distanceUnitaire*Math.cos(Math.toRadians(currentState.angle));
        double nouveauY =distanceUnitaire*Math.sin(Math.toRadians(currentState.angle));
        currentState = new State(nouveauX , nouveauY , currentState.angle);
    }

    @Override
    public void turnR() {
        double nouvelAngle = currentState.angle - angleUnitaire;
        currentState = new State(currentState.posX , currentState.posY , nouvelAngle);
    }

    @Override
    public void turnL() {
    	double nouvelAngle = currentState.angle + angleUnitaire;
        currentState = new State(currentState.posX , currentState.posY , nouvelAngle);
    }

    public void push() {
    	previousStates.push(currentState);
    }

    public void pop() {
    	previousStates.pop();
    	currentState = previousStates.peek();
    }

    public void stay() {
    	// Ne sert �......RIEN
    }

    public void init(Point2D position, double angle_deg) {
    	currentState = new State(position.getX() , position.getY() , angle_deg);
    	previousStates.clear();
    }

    public Point2D getPosition() {
        return new Point2D.Double(currentState.posX , currentState.posY);
    }

    public double getAngle() {
        return currentState.angle;
    }

    public void setUnits(double step, double delta) {
    	distanceUnitaire = step;
    	angleUnitaire = delta;
    }

}
