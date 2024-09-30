import processing.core.PApplet;

/**
 * represents a hand in blackjack, which consists of at least two cards
 *   but at most 11 cards
 */

public class Hand implements IWorld {
	ILoC cards;
	Posn loc;
	
	Hand(ILoC cards, Posn loc) {
		this.cards = cards;
		this.loc = loc;
	}
	
	/** draw a picture of the cards at this hand's (x,y)
	 * 
	 */
	public PApplet draw(PApplet w) { 
		cards.drawCards(w, this.loc, true);
		//drawCard(w, this.card1, this.loc);
		return w;
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
