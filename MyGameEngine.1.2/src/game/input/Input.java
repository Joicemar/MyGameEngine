package game.input;


import game.classes.Imagen;

public class Input {
	
	
	public Input() {
		// TODO Auto-generated constructor stub
	}
	
	private static double X;
	private static double Y;
	
	public static double getX() {
		return X;
	}
	public static void setX(double x) {
		X = x;
	}
	public static double getY() {
		return Y;
	}
	public static void setY(double y) {
		Y = y;
	}
	
//	public double MousePositionX(Imagen e) {
//
//		double angle = Math.atan2(this.X - this.getX() - e.getX(), this.X - this.getX() - e.getX());
//		double targetX = Math.cos(angle);
//		return targetX;
//	}
//	
//	public double MousePositionY(Imagen e) {
//		
//		double angle = Math.atan2(this.X - this.getY() - e.getY(), this.X - this.getX() - e.getX());
//		double targetY = Math.sin(angle);
//		return targetY;
//	}
	
	public static boolean MousePressed;
	
	public static boolean RIGHT;
	public static boolean ENTER;
	public static boolean ESCAPE;
	public static boolean W;
	public static boolean A;
	public static boolean S;
	public static boolean D;
	public static boolean SPACE;
	public static boolean LEFT;
	public static boolean UP;
	public static boolean DOWN;
	
	

	

	
}
