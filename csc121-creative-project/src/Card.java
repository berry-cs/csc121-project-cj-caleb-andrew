import java.awt.Color;

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
		w.fill(color.getRGB());
		w.rectMode(PApplet.CENTER);
		w.rect(cardLoc.getX(), cardLoc.getY(), 20, 40);
		
	}
	
	
}


//  1) make method for getting random card
//  2) 
