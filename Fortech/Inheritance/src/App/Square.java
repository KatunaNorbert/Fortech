package App;

public class Square extends Rectangle{

	public Square() {
		super();
	}
	
	public Square(double side) {
		super(side,side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side,side,color,filled);
	}
	
	public double getSize() {
		return super.getLength();
	}
	
	public void setLength(double side) {
		super.setLength(side);
	}
	
	public void setWidth(double side) {
		super.setWidth(side);
	}
	
	public void setSize(double side) {
		setLength(side);
		setWidth(side);
	}

	@Override
	public String toString() {
		return "A Square whith side= " + super.getLength() + " which is a subclass of " + super.toString();
	}
	
	/*Metodele getArea() si getPerimeter() nu trebuie suprascrise deoarece un patrat este un dreptunghi in care 
	lungime este egala cu latimea deci daca initializa lungimea si latimea in dreptung astfel incat sa contina
	aceleasi valori metodele respective vor fii corecte */ 
	
}
