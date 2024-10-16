import java.util.Objects;

import processing.core.PApplet;

/** Animation with a blackjack card game
 * Use y or n keys to choose to hit or stand.
 * Use number keys to input bet amount
 * Use mouse clicks to start new game. 
 */
public class BlackjackWorld implements IWorld{
	Hand dealerHand;
	Hand playerHand;

	Bet bet;



	//int gameStep         // -1 - game over; 0 = dealing initial cards; 1 =waiting for player H/S ; ...



	BlackjackWorld(Hand dealerHand, Hand playerHand, Bet bet) {
		super();
		this.dealerHand = dealerHand;
		this.playerHand = playerHand;
		this.bet = bet;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bet, dealerHand, playerHand);
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
		return Objects.equals(bet, other.bet) && Objects.equals(dealerHand, other.dealerHand)
				&& Objects.equals(playerHand, other.playerHand);
	}







	@Override
	public String toString() {
		return "BlackjackWorld [dealerHand=" + dealerHand + ", playerHand=" + playerHand + ", bet=" + bet + "]";
	}




	/** draw a picture of the cards at this world's (x,y)
	 * 
	 */
	public PApplet draw(PApplet w) { 
		w.background(255);   // 0 = black, 255 = white
		w.fill(0,255,0); // solid green

		this.dealerHand.draw(w);
		this.playerHand.draw(w);

		return w; 
	}	


	/** produce an updated state of this world after one time tick */
	public IWorld update() { 

		// if gameStep is at a stage where the dealer supposed to do something:
		//      do that
		//      advance gameStep to the next number 


		return this;
	}



}
