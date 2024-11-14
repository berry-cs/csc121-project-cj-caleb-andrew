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
	private static final int gameWidth = 1400;
	private static final int gameHeight = 800;

	public void settings() {
		this.size(gameWidth, gameHeight);
	}

	/* temporary placeholder for the full deck, will develop method to generate 
	 *  randomly sorted deck later on
	 */
	Deck FullDeck = new Deck();

	public void setup() {
		w = new BlackjackWorld (new Hand(new ConsLoC(FullDeck.getCard(0).flipCard(), new ConsLoC(FullDeck.getCard(1), 
										 new MTLoC())), new Posn(700, 150)), 
				
								new Hand(new ConsLoC(FullDeck.getCard(2).flipCard(), new ConsLoC(FullDeck.getCard(3).flipCard(),
										 new MTLoC())), new Posn(700, 600)),
								
								new Bet (Color.GREEN, true, 100),
								
								FullDeck,
								
								0);
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
