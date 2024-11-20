import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
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
		//	w.background(255);   // 0 = black, 255 = white
		w.fill(255,255,255); // solid green
		
		
		

		// adds in table background
		w.imageMode(PApplet.CENTER);
		w.image(w.loadImage("table game start.png"), 700, 400);


		w.text("Game Step: " + this.gameStep, 1200, 150);




		if(this.gameStep >= 1) {
			w.image(w.loadImage("table.jpg"), 700, 400);
			w.textFont(w.createFont("Times New Roman", 18));
			w.text("Game Step: " + this.gameStep, 1200, 150);
			this.deck.draw(w);
			this.bet.draw(w);
		}

		if(this.gameStep >= 2) {
			this.dealerHand.draw(w);
			this.playerHand.draw(w);
			w.textSize(30);
			w.textAlign(PApplet.CENTER);
		//	w.fill(255,255,255);
			w.textFont(w.createFont("Times New Roman", 40));
			w.text("Player Value: " + this.playerHand.total(), 925, 600);
			//this.incrementGameStep();
		}

		if(this.gameStep >= 4) {
			w.text("Dealer Value: " + this.dealerHand.total(), 925, 200);
			//this.dealerHand.cards.get(1).flipCard();
			//this.dealerHand.draw(w);
			//this.incrementGameStep();
		}

		if(this.gameStep >= 5) {
			w.textSize(40);
			//w.fill(255,255,255);
			if(this.playerHand.total() > 21) {
				w.text("Bust! You lose!", 700, 400);
				w.text("You lost $" + this.bet.value + ".00", 700, 500);
			}
			else if(this.playerHand.total() == 21) {
				//w.text("Blackjack! You win!", 700, 400);
				w.image(w.loadImage("bj1 tp.png"), 700, 400);
				w.text("You won $" + this.bet.value*2.5 + "0", 700, 500);
			}
			else if(this.dealerHand.total() > 21) {
				w.text("Dealer bust! You win!", 700, 400);
				w.text("You won $" + this.bet.value*2 + ".00", 700, 500);
			}
			else if(this.dealerHand.total() == 21) {
				w.text("Dealer blackjack! You lose!", 700, 400);
				w.text("You lost $" + this.bet.value + ".00", 700, 500);
			}
			else if(this.playerHand.total() > this.dealerHand.total()) {
				w.text("You beat the dealer! You win!", 700, 400);
				w.text("You won $" + this.bet.value*2 + ".00", 700, 500);
			}
			else if(this.dealerHand.total() > this.playerHand.total()) {
				w.text("The dealer beat you! You lose!", 700, 400);
				w.text("You lost $" + this.bet.value + ".00", 700, 500);
			}
			else if(this.playerHand.total() == this.dealerHand.total()) {
				w.text("Stand-Off! It's a tie!", 700, 400);
			}
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
			System.out.println("current key pressed: " + kev.getKey());
			if(kev.getKey() == 'h') {
				System.out.println("game step: " + this.gameStep);
				return new BlackjackWorld(this.dealerHand, this.playerHand.addCard(this.deck), this.bet, this.deck, this.gameStep);
			}
			else if(kev.getKey() == 's') {
				System.out.println("dealer second card before flipping: " + dealerHand.getCards().get(1).toString());   //temporary, for debugging
				dealerHand.getCards().get(1).flipCard();
				System.out.println("dealer second card after flipping: " + dealerHand.getCards().get(1).toString());   //temporary, for debugging
				//gameStep++;
				return incrementGameStep();
				//return new BlackjackWorld(this.dealerHand, this.playerHand, this.bet, this.deck, this.gameStep + 1);
			}
		}


		return this;

	}

	/** produce an updated state of this world after a mouse click event */
	public IWorld mouseClicked(MouseEvent mev) {
		if(this.gameStep == 0) {
			return incrementGameStep();
		}
		if(this.gameStep == 5) {
			Deck FullDeck = new Deck();
			
			//ArrayList<Card> d1 = new ArrayList<Card>(Arrays.asList(FullDeck.getCard(0).flipCard(), FullDeck.getCard(1)));
			
			Hand dealer = new Hand(new ArrayList<Card>(Arrays.asList(FullDeck.getCard().flipCard(), FullDeck.getCard())), new Posn(700, 150));
			
			Hand player = new Hand(new ArrayList<Card>(Arrays.asList(FullDeck.getCard().flipCard(), FullDeck.getCard().flipCard())), new Posn(700, 600));
			
			return new BlackjackWorld (dealer, 
					
					player,
					
					new Bet (Color.GREEN, true, 100),
					
					FullDeck,
					
					0);
		}

		return this;
	}


	private IWorld incrementGameStep() {
		this.gameStep = gameStep + 1;
		return this;
	}

	private int getBetAmount() {
		String msg = "Please enter bet amount: ";

		while (true) {
			try {
				String input = JOptionPane.showInputDialog(msg);
				int amt = Integer.parseInt(input);
				// check amt is a valid value for a bet ......
				if (amt >= 1) {
					return amt;
				} else {
					msg = "Bet must be at least $1. Please enter bet amount: ";
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
			this.bet.value = amt;
			// do what you need to to update the Bet
			return incrementGameStep();
		}
		else if(this.gameStep == 2) {
			// TODO
			// shuffle deck and deal initial cards
			// increment gameStep to 3 once cards have been dealt
			return incrementGameStep();
		}

		else if(this.gameStep == 3) {
			// TODO
			if(this.playerHand.total() >= 21) { // if the player gets blackjack or busts, go to end game
				incrementGameStep();
				dealerHand.getCards().get(1).flipCard();
				return incrementGameStep();
			}
			// allow key input from user for hit/stand
			// increment gameStep to 4 if user stands
			// increment gameStep directly to 5 if the user busts or has blackjack
		}

		else if(this.gameStep == 4) {
			// TODO
			// automated dealer action
			if(this.dealerHand.total() > 21) { // if the dealer busts
				return incrementGameStep();
			}
			else if(this.dealerHand.total() >= 17) {  // if the dealer is dealt 17 or more, he must stand
				return incrementGameStep();
			}
			else {
				return new BlackjackWorld(this.dealerHand.addCard(this.deck), this.playerHand, this.bet, this.deck, this.gameStep);
			}
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
