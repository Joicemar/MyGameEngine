package game.classes;


public abstract class Elements {

	protected int x, y; 
	protected int width, height;
	protected String name;
	protected double speed = 5;
	public String ID;
	public boolean right, up, left, down;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
	public String getId() {
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public void moveX(double speed) {
		x += speed;
	}
	
	public void moveY(double speed) {
		y += speed;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


//	public void render(Graphics g) {
//		// TODO Auto-generated method stub
//		
//	}
	
}
