import java.awt.Color;

/**
 * represents a playing card in a deck
 */
public class Card implements ILoC{
	Color color;
	String suit;
	char rank;
	int value;
	
	Card(Color color, String suit, char rank, int value) {
		this.color = color;
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}
	Color red = Color.red;
    Card king = new Card(red, "King", 'K', 10);

}



//  1) make method for getting random card
//  2) 
