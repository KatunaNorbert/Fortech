package main;
import MoveExceptions.*;
import movable.*;
public class Main {
		
	public static void main(String []args) throws MoveUpOutOfPlainException, MoveDownOutOfPlainException, MoveLeftOutOfPlainException, MoveRightOutOfPlainException, InvalidSpeedException, InvalideRadiusException, MovableInitializationException {
		MovablePoint p=new MovablePoint(500,-500,500,500);
		System.out.println(p.toString());
		p.moveUp();
		System.out.println(p.toString());
		p.moveUp();
		System.out.println(p.toString());
		p.moveRight(500);
		p.moveDown(500);
		p.moveDown(500);
		System.out.println(p.toString());
		
		MovableCircle c=new MovableCircle(-500,0,500,500,100);
		System.out.println(c.toString());
		c.moveUp();
		System.out.println(c.toString());
		c.moveRight();
		System.out.println(c.toString());
		c.moveUp(300);
		System.out.println(c.toString());
	}
	
}
