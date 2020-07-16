package inf101.games.invaders.sprites;

import inf101.games.invaders.IGame;
import inf101.games.invaders.IImage;
import inf101.games.invaders.InvadersGame;

public class Alien extends AbstractShip implements ISprite {
	private int speed = 1;
	private int delta = -speed;   // Initial direction set to left

    private double easeOfFire = 0.0002;   // Set to 1 gives constant fire, to zero: never fire
	
	public Alien(IImage image, int x, int y) {
		super(image, x, y);		
	}

	@Override
	public void step(IGame game){
		super.step(game);
		box = box.move(delta, 0);   // Base case movement: one step in the horizontal direction
		
		if(!game.getBoundingBox().contains(this.getBoundingBox())){      // if last step moved outside the board
			delta = -delta;                                              // Change direction of movement
			box = box.move(delta, this.getBoundingBox().getHeight());	 // Move down and back on the board				
		}
		
		// if(box.getX() == 0 || box.getX() + box.getWidth() + delta > game.getBoundingBox().getWidth() ){    // If at edge, move down (Update Y-coordinate, keep X)
				
		// Shoot
		if (InvadersGame.getRandom().nextDouble() > 1-easeOfFire){
			this.fire(game);
		}
	}
	
	@Override
	public boolean isAlien() {
		return true;
	}
	
	@Override
	public void hit(ISprite other, IGame game) {
		System.out.println("BOOM!");
		game.remove(this);    // Remove if alien gets hit (collides)
		game.addScore(1);     // Add score to player for killing the alien
	}		
}
