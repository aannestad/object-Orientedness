package inf101.games.invaders;

public class Rectangle implements IRectangle {
	
	private final int x;
	private final int y;
	private final int width;
	private final int height;
	private final IPosition position;
	
	public Rectangle(int x, int y, int width, int height) {
	  
	  position = new Position(x,y);
		
	  this.x = x;
	  this.y = y;
	 		
	  if(width<0){
		  throw new IllegalArgumentException("Width must be positive: " + width);
	  }
	  
	  this.width = width;
	  
	  if(height<0){
		  throw new IllegalArgumentException("Height must be positive: " + height);
	  }
		
	  this.height = height;
		
	}

	@Override
	public boolean contains(IPosition pos) {
		
		if(this.getX() < pos.getX() && pos.getX() < this.getX()+this.getWidth() &&
	       this.getY() < pos.getY() && pos.getY() < this.getY()+this.getHeight()){
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(IRectangle other) {
		if(this.getX() < other.getX() &&
		   other.getX() + other.getWidth() < this.getX() + this.getWidth() &&
		   this.getY() < other.getY() &&
		   other.getY() + other.getHeight() < this.getY() + this.getHeight()){
		      return true;
	       }
		   return false;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public IPosition getPosition() {
		return position;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public IRectangle move(int deltaX, int deltaY) {
		
		IRectangle rect = new Rectangle(this.getX()+deltaX, this.getY()+deltaY, this.getWidth(), this.getHeight());
		return rect;
	}

	@Override
	public IRectangle moveTo(int newX, int newY) {
		
		IRectangle rect = new Rectangle(newX, newY, this.getWidth(), this.getHeight());
		return rect;
	}

	@Override
	public boolean overlaps(IRectangle rect) {
       if(this.getX() < rect.getX() + rect.getWidth() && 
		  this.getX() + this.getWidth() > rect.getX() &&
		  this.getY() < rect.getY() + rect.getHeight() &&
		  this.getY() + this.getHeight() > rect.getY()){
		     return true;
		  }
	   return false;
	}
}
