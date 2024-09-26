import java.util.Objects;

import processing.core.PApplet;

/** Animation with a blackjack card game
 * Use y or n keys to choose to hit or stand.
 * Use number keys to input bet amount
 * Use mouse clicks to start new game. 
 */
public class BlackjackWorld implements IWorld{
	
	Posn dealerHand;
	Posn playerHand;
	Boolean betPlaced;

	public BlackjackWorld(Posn dealerHand, Posn playerHand, Boolean betPlaced) {
		super();
		this.dealerHand = dealerHand;
		this.playerHand = playerHand;
		this.betPlaced = betPlaced;
	}

	@Override
	public int hashCode() {
		return Objects.hash(betPlaced);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackjackWorld other = (BlackjackWorld) obj;
		return Objects.equals(betPlaced, other.betPlaced);
	}



	@Override
	public String toString() {
		return "BlackjackWorld [betPlaced=" + betPlaced + "]";
	}

	/** draw a picture of the cards at this world's (x,y)
	 * 
	 */
	public PApplet draw(PApplet w) { 
		w.background(255);   // 0 = black, 255 = white
		w.fill(0,255,0); // solid green
		w.square(this.dealerHand, this.playerHand, 15);	
		return w; 
	}	


	/** produce an updates version of this
	 * world where the dealer has dealt the next card to the player
	 */
	public IWorld update() { 
		if (this.playerHand < 400) {
			return new BlackjackWorld (this.playerHand, this.playerHand);
		}else {
			return this;
		}

	}
}
