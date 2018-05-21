package App;

public class Circle extends Shape {

	private double radius;

	public Circle() {
		super();
		radius = 1.0;

	}

	public Circle(double radius) {
		super();
		this.radius = radius;

	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;

	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(String color, boolean filled) {
		super(color, filled);
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "A Circle with radius= " + radius + " which is a sublas of " + super.toString();
	}

}
