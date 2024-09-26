/**
 * represents a hand in blackjack, which consists of at least two cards
 *   but at most 11 cards
 */

public class Hand implements IWorld {
	Card card1;
	Card card2;
	Card card3;
	Card card4;
	Card card5;
	Card card6;
	Card card7;
	Card card8;
	Card card9;
	Card card10;
	Card card11;
	
	Hand(Card card1, Card card2, Card card3, Card card4, 
			Card card5, Card card6, Card card7, Card card8, 
			Card card9, Card card10, Card card11) {
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
		this.card6 = card6;
		this.card7 = card7;
		this.card8 = card8;
		this.card9 = card9;
		this.card10 = card10;
		this.card11 = card11;
	}

	
}
