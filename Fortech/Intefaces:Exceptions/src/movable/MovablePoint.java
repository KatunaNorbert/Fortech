package movable;

import MoveExceptions.*;

public class MovablePoint implements Movable{
	 
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;
	
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) throws MovableInitializationException {
		super();
		if(x>PLAIN_X_MAX || x<PLAIN_X_MIN){
			throw new MovableInitializationException("The given value for x is invalid");
		}
		if(y>PLAIN_Y_MAX || y<PLAIN_Y_MIN){
			throw new MovableInitializationException("The given value for y is invalid");
		}
		this.x = x;
		this.y = y;
		setxSpeed(xSpeed);
		setySpeed(ySpeed);
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getxSpeed() {
		return xSpeed;
	}
	public void setxSpeed(int xSpeed) throws MovableInitializationException {
		if(xSpeed>PLAIN_X_MAX/2 || xSpeed<PLAIN_X_MIN/2 || xSpeed<=0) {
			throw new MovableInitializationException("The x speed should be between (0-"+PLAIN_X_MAX/2+")");
		}
		this.xSpeed = xSpeed;
	}
	public int getySpeed() {
		return ySpeed;
	}
	public void setySpeed(int ySpeed) throws MovableInitializationException {
		if(ySpeed>PLAIN_Y_MAX/2 || ySpeed<PLAIN_Y_MIN/2 || ySpeed<=0) {
			throw new MovableInitializationException("The x speed should be between (0-"+PLAIN_Y_MAX/2+")");
		}
		this.ySpeed = ySpeed;
	}
	
	@Override
	public String toString() {
		return "MovablePoint [x=" + x + ", y=" + y + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
	}
	
	@Override
	public void moveUp() throws MoveUpOutOfPlainException, InvalidSpeedException{
		moveUp(ySpeed);
		
	}
	@Override
	public void moveDown() throws MoveDownOutOfPlainException, InvalidSpeedException {
		moveDown(ySpeed);
		
	}
	@Override
	public void moveLeft() throws MoveLeftOutOfPlainException, InvalidSpeedException {
		moveLeft(xSpeed);
		
	}
	
	@Override
	public void moveRight() throws MoveRightOutOfPlainException, InvalidSpeedException {
		moveRight(xSpeed);
		
	}
	@Override
	public void moveUp(int howMuch) throws MoveUpOutOfPlainException, InvalidSpeedException {
		if(howMuch<=0 || howMuch>500) throw new InvalidSpeedException("The speed that you want to move with must be between (0 - 501)");
		if((Movable.PLAIN_Y_MAX-y)<howMuch) {
			throw new MoveUpOutOfPlainException("You can't move the point up with " + howMuch);
		}else {
			y+=howMuch;
		}
		
	}
	@Override
	public void moveDown(int howMuch) throws MoveDownOutOfPlainException, InvalidSpeedException {
		if(howMuch<=0 || howMuch>500) throw new InvalidSpeedException("The speed that you want to move with must be between (0 - 501)");
		if(((y<0) && Math.abs(Movable.PLAIN_X_MIN)-Math.abs(y)<howMuch) || ((y>0 && (Math.abs(Movable.PLAIN_X_MIN-y)<howMuch)))) {
			throw new MoveDownOutOfPlainException("You can't move the point down with " + howMuch);
		}else {
			y-=howMuch;
		}
		
	}
	@Override
	public void moveLeft(int howMuch) throws InvalidSpeedException, MoveLeftOutOfPlainException {
		if(howMuch<=0 || howMuch>500) throw new InvalidSpeedException("The speed that you want to move with must be between (0 - 501)");
		if(((x<0) && Math.abs(Movable.PLAIN_X_MIN)-Math.abs(x)<howMuch) || ((x>0 && (Math.abs(Movable.PLAIN_X_MIN-x)<howMuch)))) {
			throw new MoveLeftOutOfPlainException("You can't move the point to left with " + howMuch);
		}
		else {
			x-=howMuch;
		}
	}
	@Override
	public void moveRight(int howMuch) throws InvalidSpeedException, MoveRightOutOfPlainException {
		if(howMuch<=0 || howMuch>500) throw new InvalidSpeedException("The speed that you want to move with must be between (0 - 501)");
		if((Movable.PLAIN_X_MAX-x)<howMuch) {
			throw new MoveRightOutOfPlainException("You can't move the point to right with " + howMuch);
		}
		else {
			x+=howMuch;
		}
	}
	
	
	
}
