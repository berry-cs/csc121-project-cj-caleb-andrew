
// to represent a list of cards

import java.util.Objects;

import processing.core.PApplet;

interface ILoC {

	/* draws this list on the window */
	PApplet drawCards(PApplet w, Posn loc, boolean spread);
	
	// public ??? ilocMethod(...);

	/** adds new random card to list of random cards */
	// public ILoC randomCard
	
	/** returns the first card in a list of cards, or null if the list is empty */
	Card getFirst();
	
	/** returns the rest of the list of cards, or an MTLoC if the list had only one card */
	ILoC removeTop();
}




//an empty list of cards
class MTLoC implements ILoC {

	MTLoC() {}

	/* TEMPLATE:
public ??? ilobMethod(...) {
...
}
	 */
	
	/* draws this list on the window */
	public PApplet drawCards(PApplet w, Posn loc, boolean spread) {
		return w;
	}
	
	/** returns the first card in a list of cards, or null if the list is empty */
	public Card getFirst() {
		return null;
		// bogus return value, should not ever get to this
	}
	
	/** returns the rest of the list of cards, or an MTLoC if the list had only one card */
	public ILoC removeTop() {
		return this;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MTLoC;
	}

	@Override
	public int hashCode() {
		return MTLoC.class.hashCode();
	}

	@Override
	public String toString() {
		return "MTLoC []";
	}
}


// to represent a card added to a list of cards
class ConsLoC implements ILoC {
	Card first;
	ILoC rest;

	ConsLoC(Card first, ILoC rest) {
		this.first = first;
		this.rest = rest;
	}
	
	/* draws this list on the window */
	public PApplet drawCards(PApplet w, Posn loc, boolean spread) {
		this.first.draw(w, loc);
		if (spread) {
			this.rest.drawCards(w, loc.translate(new Posn(20, 20)), spread);
		} else {
			this.rest.drawCards(w, loc, spread);
		}
		return w;
	}
	
	public ILoC removeTop() {
		return this.rest;
	
	}
	
	/** returns the first card in a list of cards, or null if the list is empty */
	public Card getFirst() {
		return this.first;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsLoC other = (ConsLoC) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}

	@Override
	public String toString() {
		return "ConsLoC [first=" + first + ", rest=" + rest + "]";
	}


	/* TEMPLATE:
	  public ??? ilocMethod(...) {
	    ... this.first ...     -- Card
	    ... this.rest ...     -- ILoC

	    ... this.first.cardMethod(...) -- ???
	    ... this.rest.ilocMethod(...) -- ???    // recursive just like racket function template (rest)//
	  }
	 */
}

