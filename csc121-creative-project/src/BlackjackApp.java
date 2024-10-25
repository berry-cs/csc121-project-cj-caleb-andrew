import processing.core.*;
import processing.event.*;
import java.awt.Color;


/* Implement game play logic
// final static- to set constant so no magic (floating) numbers
 * used named constant instead of hardcoding
 * can name all the constants in 1 place in app class

1) Add functionality to move cards from a hand to the "table" or from the deck to a hand.
2) Maybe design a "Button" class(es) to represent actions that should happen.
3) Make sure test cases are defined and working.

 */

/**
 * Provides the scaffolding to launch a Processing application
 */
public class BlackjackApp extends PApplet {	// <----- 1. rename AppTemplate everywhere in this file
	IWorld w;

	public void settings() {
		this.size(1400, 800);
	}
	
	/* temporary placeholder for the full deck, will develop method to generate 
	 *  randomly sorted deck later on
	 */
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
																											
	
	
	

	public void setup() {
		w = new BlackjackWorld (new Hand(new ConsLoC(new Card(Color.RED, "Hearts", 'K', false),
				new ConsLoC(new Card(Color.RED, "Hearts", '5', false),
						new MTLoC())), 
				new Posn(700, 150)), 
				new Hand(new ConsLoC(new Card(Color.BLACK, "Spades", 'T', true),
						new ConsLoC(new Card(Color.RED, "Diamonds", 'A', true),
								new MTLoC())),
						new Posn(700, 600)), new Bet (Color.GREEN, true, 100), FullDeck);
	}


	public void draw() {
		w = w.update();
		w.draw(this);
	}

	@Override
	public void mousePressed(MouseEvent mev) {
		w = w.mousePressed(mev);
	}

	@Override
	public void mouseReleased(MouseEvent mev) {
		w = w.mouseReleased(mev);
	}

	@Override
	public void mouseMoved(MouseEvent mev) {
		w = w.mouseMoved(mev);
	}

	@Override
	public void mouseDragged(MouseEvent mev) {
		w = w.mouseDragged(mev);
	}

	@Override
	public void mouseClicked(MouseEvent mev) {
		w = w.mouseClicked(mev);
	}

	@Override
	public void mouseEntered(MouseEvent mev) {
		w = w.mouseEntered(mev);
	}

	@Override
	public void mouseExited(MouseEvent mev) {
		w = w.mouseExited(mev);
	}

	@Override
	public void mouseWheel(MouseEvent mev) {
		w = w.mouseWheel(mev);
	}

	@Override
	public void keyPressed(KeyEvent kev) {
		w = w.keyPressed(kev);
	}

	@Override
	public void keyReleased(KeyEvent kev) {
		w = w.keyReleased(kev);
	}

	@Override
	public void keyTyped(KeyEvent kev) {
		w = w.keyTyped(kev);
	}

	public static void main(String[] args) {
		PApplet.runSketch(new String[] { BlackjackApp.class.getName() }, new BlackjackApp());
	}
}
