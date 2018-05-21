package App;

public class Test {

	public static boolean TestFigures() {
		boolean works = true;
		Shape s = new Shape();
		System.out.println(s.toString());
		Circle c = new Circle();
		System.out.println(c.toString());
		Rectangle r = new Rectangle();
		System.out.println(r.toString());
		Square sq=new Square();
		System.out.println(sq.toString());
		
		if (s.isFilled() != true)
			works = false;
		if (s.getColor() != "green")
			works = false;
		s.setColor("yellow");
		s.setFilled(false);
		if (s.isFilled() != false)
			works = false;
		if (s.getColor() != "yellow")
			works = false;

		if (c.isFilled() != true)
			works = false;
		if (c.getColor() != "green")
			works = false;
		if (c.getRadius() != 1.0)
			works = false;
		c.setColor("black");
		c.setFilled(false);
		c.setRadius(3.5);
		if (c.isFilled() != false)
			works = false;
		if (c.getColor() != "black")
			works = false;
		if (c.getRadius() != 3.5)
			works = false;
		if (c.getArea() != 38.48451000647496)
			works = false;
		if (c.getPerimeter() != 21.991148575128552)
			works = false;

		if (r.isFilled() != true)
			works = false;
		if (r.getColor() != "green")
			works = false;
		if (r.getLength() != 1.0)
			works = false;
		if (r.getWidth() != 1.0)
			works = false;
		if (r.getArea() != 1)
			works = false;
		if (r.getPerimeter() != 4)
			works = false;
		
		if (sq.isFilled() != true)
			works = false;
		if (sq.getColor() != "green")
			works = false;
		sq.setSize(10);
		if (sq.getLength() != 10)
			works = false;
		if (sq.getWidth() != 10)
			works = false;
		if (sq.getArea() != 100)
			works = false;
		if (sq.getPerimeter() != 40)
			works = false;
		
		return works;

	}

}
