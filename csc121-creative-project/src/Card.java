import java.awt.Color;
import java.util.Objects;

import processing.core.PApplet;



/**
 * represents a playing card in a deck
 */
public class Card implements IWorld {
	Color color;
	String suit;
	char rank;			// 'T' means 10
	boolean faceUp;

	Card(Color color, String suit, char rank, boolean faceUp) {
		this.color = color;
		this.suit = suit;
		this.rank = rank;
		this.faceUp = faceUp;
	}

	/* draw this card on the given window at the given location */
	public void draw(PApplet w, Posn cardLoc) {
		//w.fill(color.getRGB());
		//w.rectMode(PApplet.CENTER);
		//w.rect(cardLoc.getX(), cardLoc.getY(), 20, 40);
		w.imageMode(w.CENTER);
        w.image(w.loadImage("card back updated.png"), cardLoc.getX(), cardLoc.getY());

		
	}

	@Override
	public String toString() {
		return "Card [color=" + color + ", suit=" + suit + ", rank=" + rank + ", faceUp=" + faceUp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, faceUp, rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(color, other.color) && faceUp == other.faceUp && rank == other.rank
				&& Objects.equals(suit, other.suit);
	}
	
	
}


//  1) make method for getting random card
//  2) 
