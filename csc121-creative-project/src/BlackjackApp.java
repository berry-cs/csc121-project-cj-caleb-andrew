import processing.core.*;
import processing.event.*;
import java.awt.Color;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class BlackjackApp extends PApplet {	// <----- 1. rename AppTemplate everywhere in this file
	IWorld w;

	public void settings() {
		this.size(400, 400);
	}

	public void setup() {
		w = new BlackjackWorld (new Hand(new ConsLoC(new Card(Color.RED, "Hearts", 'K', false),
											new ConsLoC(new Card(Color.RED, "Hearts", '5', false),
											new MTLoC())), 
										 new Posn(200, 50)), 
							    new Hand(new ConsLoC(new Card(Color.BLACK, "Spades", 'T', true),
							    			new ConsLoC(new Card(Color.RED, "Diamonds", 'A', true),
							    					new MTLoC())),
							    		new Posn(250, 325)), true, 100);	// <----- 2. create your initial world object
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
