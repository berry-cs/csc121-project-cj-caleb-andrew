import java.util.Objects;


import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/** Animation with a blackjack card game
 * Use h or s keys to choose to hit or stand.
 * Use number keys to input bet amount
 * Use mouse clicks to start new game. 
 */
public class BlackjackWorld implements IWorld{
	Hand dealerHand;
	Hand playerHand;
	Bet bet;
	Deck deck;

	int gameStep;        
	/*
	 *  0 = game start
	 *  1 = player bet input
	 *  2 = dealing inital cards
	 *  3 = player action (hit/stand)
	 *  4 = dealer action
	 *  5 = game over
	 */



	BlackjackWorld(Hand dealerHand, Hand playerHand, Bet bet, Deck deck, int gameStep) {
		super();
		this.dealerHand = dealerHand;
		this.playerHand = playerHand;
		this.bet = bet;
		this.deck = deck;
		this.gameStep = gameStep;
	}


	



	/** draw a picture of the cards at this world's (x,y)
	 * 
	 */
	public PApplet draw(PApplet w) { 
		w.background(255);   // 0 = black, 255 = white
		w.fill(0,255,0); // solid green
		
		// adds in table background
		w.imageMode(w.CENTER);
        w.image(w.loadImage("table.jpg"), 700, 400);
        
		this.dealerHand.draw(w);
		this.playerHand.draw(w);
		this.bet.draw(w);
		this.deck.draw(w);
		
		

		return w; 
	}	
	
	/** hits or stands for the player in response to the 'h' and 's' keys
	 *   'h' = hit (add another card to the player's hand)
	 *   's' = stand (do not add any more cards) */
	public IWorld keyPressed(KeyEvent kev) {
		if(kev.getKey() == 'h') {
			return new BlackjackWorld(this.dealerHand, this.playerHand.addCard(this.deck), this.bet, this.deck.removeCard(), this.gameStep);
		}
		else if(kev.getKey() == 's') {
			return new BlackjackWorld(this.dealerHand, this.playerHand, this.bet, this.deck, this.gameStep);
		}
		else {
			 return this;
		}
		
	}
	
	/** produce an updated state of this world after a mouse click event */
	public IWorld mouseClicked(MouseEvent mev) {
		return new BlackjackWorld(this.dealerHand, this.playerHand, this.bet, this.deck, this.gameStep + 1);
	}


	/** produce an updated state of this world after one time tick */
	public IWorld update() { 
		
		if(this.gameStep == 0) {
			// TODO
			// standard game beginning screen
			// increment gameStep to 1 on click
		}
		
		else if(this.gameStep == 1) {
			// TODO
			// allow bet input from user
			// increment gameStep to 2 after bet has been input
		}
		
		else if(this.gameStep == 2) {
			// TODO
			// shuffle deck and deal initial cards
			// increment gameStep to 3 once cards have been dealt
		}
		
		else if(this.gameStep == 3) {
			// TODO
			// allow key input from user for hit/stand
			// increment gameStep to 4 if user stands
			// increment gameStep directly to 5 if the user busts or has blackjack
		}
		
		else if(this.gameStep == 4) {
			// TODO
			// dealer action
			// increment gameStep to 5 once dealer's turn is done
		}
		
		else if(this.gameStep == 5) {
			// TODO
			// declare winner/loser, payout, and game over
			// reset gameStep back to 0 on click
		}

		// if gameStep is at a stage where the dealer supposed to do something:
		//      do that
		//      advance gameStep to the next number 


		return this;
	}






	@Override
	public int hashCode() {
		return Objects.hash(bet, dealerHand, deck, playerHand);
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
				&& Objects.equals(deck, other.deck) && Objects.equals(playerHand, other.playerHand);
	}






	@Override
	public String toString() {
		return "BlackjackWorld [dealerHand=" + dealerHand + ", playerHand=" + playerHand + ", bet=" + bet + ", deck="
				+ deck + "]";
	}



}
