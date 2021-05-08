package facadePattern;

public class FacadePatternDemo {	
	public static void main(String[] args)
	{
		ShapeMaker sm = new ShapeMaker();
		System.out.println("Drawing a circle...");
		sm.drawCircle();
		System.out.println("Drawing a rectangle...");
		sm.drawRectangle();
		System.out.println("Drawing a square...");
		sm.drawSquare();
	}
}
