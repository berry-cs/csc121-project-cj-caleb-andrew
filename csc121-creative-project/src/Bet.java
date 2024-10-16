import java.awt.Color;

import processing.core.PApplet;

public class Bet {
	Color color; // red (or black) chips
	boolean betPlaced; // is the bet placed on the table
	int value;

	Bet(Color color, boolean betPlaced, int value) {
		this.color = color;
		this.betPlaced = betPlaced;
		this.value = value;
	}

	/* draw this bet on the given window at the given location */
	public void draw(PApplet w, Posn betLoc) {
		w.fill(color.getRGB());
		w.rectMode(PApplet.CENTER);
		w.rect(betLoc.getX(), betLoc.getY(), 20, 40);


	}


}
