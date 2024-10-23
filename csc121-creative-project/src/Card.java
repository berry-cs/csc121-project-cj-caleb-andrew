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


	/** returns true if the Card is a Heart */
	public boolean isHeart() {
		if(this.suit.equals("Hearts")) {
			return true;
		}
		else {
			return false;
		}
	}

	/** returns true if the Card is a Diamond */
	public boolean isDiamond() {
		if(this.suit.equals("Diamonds")) {
			return true;
		}
		else {
			return false;
		}
	}

	/** returns true if the Card is a Club */
	public boolean isClub() {
		if(this.suit.equals("Clubs")) {
			return true;
		}
		else {
			return false;
		}
	}

	/** returns true if the Card is a Spades */
	public boolean isSpade() {
		if(this.suit.equals("Spades")) {
			return true;
		}
		else {
			return false;
		}
	}

	/** draw this card on the given window at the given location */
	public void draw(PApplet w, Posn cardLoc) {
		w.imageMode(w.CENTER);
		if(this.faceUp) {
			if(this.isHeart()) {
				if(this.rank =='2') {
					w.image(w.loadImage("2 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='3') {
					w.image(w.loadImage("3 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='4') {
					w.image(w.loadImage("4 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='5') {
					w.image(w.loadImage("5 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='6') {
					w.image(w.loadImage("6 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='7') {
					w.image(w.loadImage("7 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='8') {
					w.image(w.loadImage("8 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='9') {
					w.image(w.loadImage("9 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='T') {
					w.image(w.loadImage("10 Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='J') {
					w.image(w.loadImage("Jack Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='Q') {
					w.image(w.loadImage("Queen Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='K') {
					w.image(w.loadImage("King Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='A') {
					w.image(w.loadImage("Ace Hearts.png"), cardLoc.getX(), cardLoc.getY());
				}
				else {

				}
			}
			else if(this.isDiamond()) {
				if(this.rank =='2') {
					w.image(w.loadImage("2 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='3') {
					w.image(w.loadImage("3 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='4') {
					w.image(w.loadImage("4 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='5') {
					w.image(w.loadImage("5 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='6') {
					w.image(w.loadImage("6 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='7') {
					w.image(w.loadImage("7 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='8') {
					w.image(w.loadImage("8 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='9') {
					w.image(w.loadImage("9 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='T') {
					w.image(w.loadImage("10 Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='J') {
					w.image(w.loadImage("Jack Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='Q') {
					w.image(w.loadImage("Queen Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='K') {
					w.image(w.loadImage("King Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='A') {
					w.image(w.loadImage("Ace Diamonds.png"), cardLoc.getX(), cardLoc.getY());
				}
				else {

				}
			}
			else if(this.isClub()) {
				if(this.rank =='2') {
					w.image(w.loadImage("2 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='3') {
					w.image(w.loadImage("3 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='4') {
					w.image(w.loadImage("4 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='5') {
					w.image(w.loadImage("5 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='6') {
					w.image(w.loadImage("6 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='7') {
					w.image(w.loadImage("7 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='8') {
					w.image(w.loadImage("8 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='9') {
					w.image(w.loadImage("9 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='T') {
					w.image(w.loadImage("10 Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='J') {
					w.image(w.loadImage("Jack Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='Q') {
					w.image(w.loadImage("Queen Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='K') {
					w.image(w.loadImage("King Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='A') {
					w.image(w.loadImage("Ace Clubs.png"), cardLoc.getX(), cardLoc.getY());
				}
				else {

				}
			}
			else if(this.isSpade()) {
				if(this.rank =='2') {
					w.image(w.loadImage("2 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='3') {
					w.image(w.loadImage("3 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='4') {
					w.image(w.loadImage("4 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='5') {
					w.image(w.loadImage("5 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='6') {
					w.image(w.loadImage("6 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='7') {
					w.image(w.loadImage("7 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='8') {
					w.image(w.loadImage("8 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='9') {
					w.image(w.loadImage("9 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='T') {
					w.image(w.loadImage("10 Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='J') {
					w.image(w.loadImage("Jack Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='Q') {
					w.image(w.loadImage("Queen Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='K') {
					w.image(w.loadImage("King Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else if(this.rank =='A') {
					w.image(w.loadImage("Ace Spades.png"), cardLoc.getX(), cardLoc.getY());
				}
				else {

				}
			}
			else {

			}
		}
		else {
			w.image(w.loadImage("card back updated.png"), cardLoc.getX(), cardLoc.getY());
		}
	}

	/* draw this card on the given window at the given location */
	//	public void draw(PApplet w, Posn cardLoc) {
	//w.fill(color.getRGB());
	//w.rectMode(PApplet.CENTER);
	//w.rect(cardLoc.getX(), cardLoc.getY(), 20, 40);
	//	w.imageMode(w.CENTER);
	//    w.image(w.loadImage("card back updated.png"), cardLoc.getX(), cardLoc.getY());


	//	}

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
