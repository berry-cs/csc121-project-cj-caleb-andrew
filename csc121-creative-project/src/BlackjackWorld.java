import java.util.Objects;

import javax.swing.JOptionPane;

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
	 *  2 = dealing initial cards
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

		w.text("Game Step: " + this.gameStep, 1100, 150);
		
		this.deck.draw(w);
		
		if(this.gameStep >= 1) {
			this.bet.draw(w);
		}

		if(this.gameStep >= 2) {
			this.dealerHand.draw(w);
			this.playerHand.draw(w);
			this.incrementGameStep();
		}
		
		
		//this.deck.draw(w);
		



		return w; 
	}	

	/** hits or stands for the player in response to the 'h' and 's' keys
	 *   'h' = hit (add another card to the player's hand)
	 *   's' = stand (do not add any more cards) */
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == 'Z') {
			return new BlackjackWorld(this.dealerHand, this.playerHand, this.bet, this.deck, this.gameStep + 1);
		}


		if(this.gameStep == 3) {
			if(kev.getKey() == 'h') {
				return new BlackjackWorld(this.dealerHand, this.playerHand.addCard(this.deck), this.bet, this.deck.removeCard(), this.gameStep);
			}
			else if(kev.getKey() == 's') {
				return new BlackjackWorld(this.dealerHand, this.playerHand, this.bet, this.deck, this.gameStep + 1);
			}
		}


		return this;

	}

	/** produce an updated state of this world after a mouse click event */
	public IWorld mouseClicked(MouseEvent mev) {
		if(this.gameStep == 0) {
			return incrementGameStep();
		}

		return this;
	}


	private IWorld incrementGameStep() {
		return new BlackjackWorld(this.dealerHand, this.playerHand, this.bet, this.deck, this.gameStep + 1);
	}

	private int getBetAmount() {
		String msg = "Please enter bet amount: ";

		while (true) {
			try {
				String input = JOptionPane.showInputDialog(msg);
				int amt = Integer.parseInt(input);
				// check amt is a valid value for a bet ......
				if (amt >= 0) {
					return amt;
				} else {
					msg = "Amount cannot be negative. Please enter bet amount: ";
				}
			} catch ( NumberFormatException e ) {
				msg = "Invalid number. Please enter bet amount: ";
			}
		}
	}


	/** produce an updated state of this world after one time tick */
	public IWorld update() { 



		if(this.gameStep == 1) {
			int amt = getBetAmount();
			// do what you need to to update the Bet
			return incrementGameStep();
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
			// automated dealer action
			// increment gameStep to 5 once dealer's turn is done
		}

		else if(this.gameStep == 5) {
			// TODO
			// declare winner/loser, pay out, and game over
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
