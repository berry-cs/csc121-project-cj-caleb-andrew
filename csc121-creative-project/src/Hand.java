import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;

import processing.core.PApplet;

/**
 * represents a hand in blackjack, which consists of at least two cards
 *   but at most 11 cards
 */


/*
 * NEED REDESIGN
 * deck has been redesigned to use an ArrayList<Card> instead of an ILoC
 * need to redesign constructor and methods to use ArrayList
 */

public class Hand implements IWorld {
	ArrayList<Card> cards;
	Posn loc;
	
	Hand(ArrayList<Card> cards, Posn loc) {
		this.cards = cards;
		this.loc = loc;
	}

	
	/** draw a picture of the cards at this hand's (x,y)
	 * 
	 */
	public PApplet draw(PApplet w) { 
		for(int i = 0; i < cards.size(); i++) {
			if(i == 0) {
				cards.get(i).draw(w, loc);
			}
			cards.get(i).draw(w, loc.translate(new Posn(i*20, i*20)));
		}
		return w;
	}
	
	/** adds the first card from the given deck to the hand 
	 *   and turns the card face up 
	 */
	public Hand addCard(Deck d) {
		cards.addFirst(d.getFirstCard().flipCard());
		return this;
	}

	@Override
	public String toString() {
		return "Hand [cards=" + cards + ", loc=" + loc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards, loc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		return Objects.equals(cards, other.cards) && Objects.equals(loc, other.loc);
	}
	
	
	

		
	
	/*Card card2;
	Card card3;
	Card card4;
	Card card5;
	Card card6;
	Card card7;
	Card card8;
	Card card9;
	Card card10;
	Card card11;*/
	
	

}

// restructure to make interface with empty hand or list of cards
// 1) hit method- adds new card- 
// 2) stand method- stops hand and then dealer reveals hand
