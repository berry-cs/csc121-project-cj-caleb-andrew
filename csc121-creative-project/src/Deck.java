import processing.core.PApplet;

public class Deck{
	ILoC deck;
	
	
	
	
	/* draw this bet on the given window at the given location */
	public void draw(PApplet w) {
		w.fill(0);
		w.rectMode(PApplet.CENTER);
		w.rect(50, 50, 20, 40);
	}




	Deck(ILoC deck) {
		super();
		this.deck = deck;
	}

}
