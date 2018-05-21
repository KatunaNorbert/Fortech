package movable;

import MoveExceptions.*;


public class MovableCircle implements Movable{

	private int radius;
	private MovablePoint center;
	
	public MovableCircle(int x,int y, int xSpeed, int ySpeed, int radius) throws InvalideRadiusException, MovableInitializationException  {
		center=new MovablePoint(x,y,xSpeed,ySpeed);
		if(PLAIN_X_MAX-Math.abs(Math.abs(x)+radius)<0 || Math.abs(PLAIN_X_MIN)-Math.abs(Math.abs(x)+radius)<0 || PLAIN_Y_MAX-Math.abs(Math.abs(y)+radius)<0 || Math.abs(PLAIN_X_MIN)-Math.abs(Math.abs(y)+radius)<0)
			throw new InvalideRadiusException("Invalide radius, cercle out of plain");
		setRadius(radius);
	}
	
	
	public int getRadius() {
		return radius;
	}
	@Override
	public String toString() {
		return "MovableCircle [radius=" + radius + ", center=" + center + "]";
	}


	public void setRadius(int radius) throws InvalideRadiusException {
		if(radius<=0 || radius>PLAIN_X_MAX-Math.abs(center.getX()) || radius>Math.abs(PLAIN_X_MIN)-Math.abs(center.getX()) || radius>PLAIN_Y_MAX-Math.abs(center.getY()) || radius>Math.abs(PLAIN_Y_MIN)-Math.abs(center.getY())) {
			throw new InvalideRadiusException("The radius must be between (0,"+(PLAIN_X_MAX-Math.abs(center.getX()))+")");
		}
		this.radius = radius;
	}
	public MovablePoint getCenter() {
		return center;
	}
	public void setCenter(MovablePoint center) {
		this.center = center;
	}
	@Override
	public void moveUp() throws MoveUpOutOfPlainException, InvalidSpeedException {
		moveUp(center.getySpeed());
		
	}
	@Override
	public void moveDown() throws MoveDownOutOfPlainException, InvalidSpeedException {
		moveDown(center.getySpeed());
		
	}
	@Override
	public void moveLeft() throws MoveLeftOutOfPlainException, InvalidSpeedException {
		moveLeft(center.getxSpeed());
		
	}
	@Override
	public void moveRight() throws MoveRightOutOfPlainException, InvalidSpeedException {
		moveRight(center.getxSpeed());
		
	}
	@Override
	public void moveUp(int howMuch) throws InvalidSpeedException, MoveUpOutOfPlainException {
		if(howMuch<=0 || howMuch>500) throw new InvalidSpeedException("The speed that you want to move with must be between (0 - 501)");
		if((Movable.PLAIN_Y_MAX-center.getY())<howMuch+radius) {
			throw new MoveUpOutOfPlainException("You can't move the point up with " + howMuch);
		}else {
			center.setY(center.getY()+howMuch);
		}
	}
	@Override
	public void moveDown(int howMuch) throws InvalidSpeedException, MoveDownOutOfPlainException {
		if(howMuch<=0 || howMuch>500) throw new InvalidSpeedException("The speed that you want to move with must be between (0 - 501)");
		if(((center.getY()<0) && Math.abs(Movable.PLAIN_X_MIN)-Math.abs(center.getY())<howMuch+radius) || ((center.getY()>0 && (Math.abs(Movable.PLAIN_X_MIN-center.getY())<howMuch+radius)))) {
			throw new MoveDownOutOfPlainException("You can't move the point down with " + howMuch);
		}
		else {
			center.setY(center.getY()-howMuch);
		}
	}
	@Override
	public void moveLeft(int howMuch) throws InvalidSpeedException, MoveLeftOutOfPlainException {
		if(howMuch<=0 || howMuch>500) throw new InvalidSpeedException("The speed that you want to move with must be between (0 - 501)");
		if(((center.getX()<0) && Math.abs(Movable.PLAIN_X_MIN)-Math.abs(center.getX())<howMuch+radius) || ((center.getX()>0 && (Math.abs(Movable.PLAIN_X_MIN-center.getX())<howMuch+radius)))) {
			throw new MoveLeftOutOfPlainException("You can't move the point left with " + howMuch);
		}
		else {
			center.setX(center.getX()-howMuch);
		}
	}
	@Override
	public void moveRight(int howMuch) throws InvalidSpeedException, MoveRightOutOfPlainException {
		if(howMuch<=0 || howMuch>500) throw new InvalidSpeedException("The speed that you want to move with must be between (0 - 501)");
		if((Movable.PLAIN_Y_MAX-center.getX())<howMuch+radius) {
			throw new MoveRightOutOfPlainException("You can't move the point right with " + howMuch);
		}else {
			center.setX(center.getX()+howMuch);
		}
	}
	
}
