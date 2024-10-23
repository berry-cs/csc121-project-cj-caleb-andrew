import java.awt.Color;
import java.util.Objects;

import processing.core.PApplet;

public class Deck{
	ILoC deck;
	/*
	Deck HeartsDeck = new Deck(new ConsLoC(new Card(Color.RED, "Hearts", 'A', false),
			new ConsLoC(new Card(Color.RED, "Hearts", '2', false),
					new ConsLoC(new Card(Color.RED, "Hearts", '3', false),
							new ConsLoC(new Card(Color.RED, "Hearts", '4', false),
									new ConsLoC(new Card(Color.RED, "Hearts", '5', false),
											new ConsLoC(new Card(Color.RED, "Hearts", '6', false),
													new ConsLoC(new Card(Color.RED, "Hearts", '7', false),
															new ConsLoC(new Card(Color.RED, "Hearts", '8', false),
																	new ConsLoC(new Card(Color.RED, "Hearts", '9', false),
																			new ConsLoC(new Card(Color.RED, "Hearts", 'T', false),
																					new ConsLoC(new Card(Color.RED, "Hearts", 'J', false),
																							new ConsLoC(new Card(Color.RED, "Hearts", 'Q', false),
																									new ConsLoC(new Card(Color.RED, "Hearts", 'K', false),
																											new MTLoC()))))))))))))));
	Deck DiamondsDeck = new Deck(new ConsLoC(new Card(Color.RED, "Diamonds", 'A', false),
			new ConsLoC(new Card(Color.RED, "Diamonds", '2', false),
					new ConsLoC(new Card(Color.RED, "Diamonds", '3', false),
							new ConsLoC(new Card(Color.RED, "Diamonds", '4', false),
									new ConsLoC(new Card(Color.RED, "Diamonds", '5', false),
											new ConsLoC(new Card(Color.RED, "Diamonds", '6', false),
													new ConsLoC(new Card(Color.RED, "Diamonds", '7', false),
															new ConsLoC(new Card(Color.RED, "Diamonds", '8', false),
																	new ConsLoC(new Card(Color.RED, "Diamonds", '9', false),
																			new ConsLoC(new Card(Color.RED, "Diamonds", 'T', false),
																					new ConsLoC(new Card(Color.RED, "Diamonds", 'J', false),
																							new ConsLoC(new Card(Color.RED, "Diamonds", 'Q', false),
																									new ConsLoC(new Card(Color.RED, "Diamonds", 'K', false),
																											new MTLoC()))))))))))))));
	Deck ClubsDeck = new Deck(new ConsLoC(new Card(Color.BLACK, "Clubs", 'A', false),
			new ConsLoC(new Card(Color.BLACK, "Clubs", '2', false),
					new ConsLoC(new Card(Color.BLACK, "Clubs", '3', false),
							new ConsLoC(new Card(Color.BLACK, "Clubs", '4', false),
									new ConsLoC(new Card(Color.BLACK, "Clubs", '5', false),
											new ConsLoC(new Card(Color.BLACK, "Clubs", '6', false),
													new ConsLoC(new Card(Color.BLACK, "Clubs", '7', false),
															new ConsLoC(new Card(Color.BLACK, "Clubs", '8', false),
																	new ConsLoC(new Card(Color.BLACK, "Clubs", '9', false),
																			new ConsLoC(new Card(Color.BLACK, "Clubs", 'T', false),
																					new ConsLoC(new Card(Color.BLACK, "Clubs", 'J', false),
																							new ConsLoC(new Card(Color.BLACK, "Clubs", 'Q', false),
																									new ConsLoC(new Card(Color.BLACK, "Clubs", 'K', false),
																											new MTLoC()))))))))))))));
	Deck SpadesDeck = new Deck(new ConsLoC(new Card(Color.BLACK, "Spades", 'A', false),
			new ConsLoC(new Card(Color.BLACK, "Spades", '2', false),
					new ConsLoC(new Card(Color.BLACK, "Spades", '3', false),
							new ConsLoC(new Card(Color.BLACK, "Spades", '4', false),
									new ConsLoC(new Card(Color.BLACK, "Spades", '5', false),
											new ConsLoC(new Card(Color.BLACK, "Spades", '6', false),
													new ConsLoC(new Card(Color.BLACK, "Spades", '7', false),
															new ConsLoC(new Card(Color.BLACK, "Spades", '8', false),
																	new ConsLoC(new Card(Color.BLACK, "Spades", '9', false),
																			new ConsLoC(new Card(Color.BLACK, "Spades", 'T', false),
																					new ConsLoC(new Card(Color.BLACK, "Spades", 'J', false),
																							new ConsLoC(new Card(Color.BLACK, "Spades", 'Q', false),
																									new ConsLoC(new Card(Color.BLACK, "Spades", 'K', false),
																											new MTLoC()))))))))))))));
	
	 Deck FullDeck = new Deck(new ConsLoC(new Card(Color.RED, "Hearts", 'A', false),
			new ConsLoC(new Card(Color.RED, "Hearts", '2', false),
					new ConsLoC(new Card(Color.RED, "Hearts", '3', false),
							new ConsLoC(new Card(Color.RED, "Hearts", '4', false),
									new ConsLoC(new Card(Color.RED, "Hearts", '5', false),
											new ConsLoC(new Card(Color.RED, "Hearts", '6', false),
													new ConsLoC(new Card(Color.RED, "Hearts", '7', false),
															new ConsLoC(new Card(Color.RED, "Hearts", '8', false),
																	new ConsLoC(new Card(Color.RED, "Hearts", '9', false),
																			new ConsLoC(new Card(Color.RED, "Hearts", 'T', false),
																					new ConsLoC(new Card(Color.RED, "Hearts", 'J', false),
																							new ConsLoC(new Card(Color.RED, "Hearts", 'Q', false),
																									new ConsLoC(new Card(Color.RED, "Hearts", 'K', false),
																											new ConsLoC(new Card(Color.RED, "Diamonds", 'A', false),
																													new ConsLoC(new Card(Color.RED, "Diamonds", '2', false),
																															new ConsLoC(new Card(Color.RED, "Diamonds", '3', false),
																																	new ConsLoC(new Card(Color.RED, "Diamonds", '4', false),
																																			new ConsLoC(new Card(Color.RED, "Diamonds", '5', false),
																																					new ConsLoC(new Card(Color.RED, "Diamonds", '6', false),
																																							new ConsLoC(new Card(Color.RED, "Diamonds", '7', false),
																																									new ConsLoC(new Card(Color.RED, "Diamonds", '8', false),
																																											new ConsLoC(new Card(Color.RED, "Diamonds", '9', false),
																																													new ConsLoC(new Card(Color.RED, "Diamonds", 'T', false),
																																															new ConsLoC(new Card(Color.RED, "Diamonds", 'J', false),
																																																	new ConsLoC(new Card(Color.RED, "Diamonds", 'Q', false),
																																																			new ConsLoC(new Card(Color.RED, "Diamonds", 'K', false),
																																																					new ConsLoC(new Card(Color.BLACK, "Clubs", 'A', false),
																																																							new ConsLoC(new Card(Color.BLACK, "Clubs", '2', false),
																																																									new ConsLoC(new Card(Color.BLACK, "Clubs", '3', false),
																																																											new ConsLoC(new Card(Color.BLACK, "Clubs", '4', false),
																																																													new ConsLoC(new Card(Color.BLACK, "Clubs", '5', false),
																																																															new ConsLoC(new Card(Color.BLACK, "Clubs", '6', false),
																																																																	new ConsLoC(new Card(Color.BLACK, "Clubs", '7', false),
																																																																			new ConsLoC(new Card(Color.BLACK, "Clubs", '8', false),
																																																																					new ConsLoC(new Card(Color.BLACK, "Clubs", '9', false),
																																																																							new ConsLoC(new Card(Color.BLACK, "Clubs", 'T', false),
																																																																									new ConsLoC(new Card(Color.BLACK, "Clubs", 'J', false),
																																																																											new ConsLoC(new Card(Color.BLACK, "Clubs", 'Q', false),
																																																																													new ConsLoC(new Card(Color.BLACK, "Clubs", 'K', false),
																																																																															new ConsLoC(new Card(Color.BLACK, "Spades", 'A', false),
																																																																																	new ConsLoC(new Card(Color.BLACK, "Spades", '2', false),
																																																																																			new ConsLoC(new Card(Color.BLACK, "Spades", '3', false),
																																																																																					new ConsLoC(new Card(Color.BLACK, "Spades", '4', false),
																																																																																							new ConsLoC(new Card(Color.BLACK, "Spades", '5', false),
																																																																																									new ConsLoC(new Card(Color.BLACK, "Spades", '6', false),
																																																																																											new ConsLoC(new Card(Color.BLACK, "Spades", '7', false),
																																																																																													new ConsLoC(new Card(Color.BLACK, "Spades", '8', false),
																																																																																															new ConsLoC(new Card(Color.BLACK, "Spades", '9', false),
																																																																																																	new ConsLoC(new Card(Color.BLACK, "Spades", 'T', false),
																																																																																																			new ConsLoC(new Card(Color.BLACK, "Spades", 'J', false),
																																																																																																					new ConsLoC(new Card(Color.BLACK, "Spades", 'Q', false),
																																																																																																							new ConsLoC(new Card(Color.BLACK, "Spades", 'K', false),
																																																																																																									new MTLoC())))))))))))))))))))))))))))))))))))))))))))))))))))));
																											
	
	
	
	/* draw this bet on the given window at the given location */
	public void draw(PApplet w) {
		w.imageMode(w.CENTER);
        w.image(w.loadImage("card back updated.png"), 125, 125);
	}




	Deck(ILoC deck) {
		super();
		this.deck = deck;
	}
	
	/** returns the first card in the deck */
	public Card getFirstCard() {
		return this.deck.getFirst();
	}
	
	/** returns the deck with the first card removed */
	public Deck removeCard() {
		return new Deck(this.deck.removeTop());
	}







	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}







	@Override
	public int hashCode() {
		return Objects.hash(deck);
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		return Objects.equals(deck, other.deck);
	}
	


}
