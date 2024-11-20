import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class BlackjackWorldTest {
	
	
	@Test
	void test() {
		Color red = Color.red;
		//Card king = new Card(red, "Hearts", 'K', 10, true);
		//Hand h1 = new Hand(king);

		Hand tester = new Hand(new ArrayList<Card>(Arrays.asList(new Card[]{new Card(Color.RED, "Hearts", '2', false)})), new Posn(100, 100));
		Hand test2 = new Hand(new ArrayList<Card>(), new Posn(100,100));
		
		Deck testDeck = new Deck(new ArrayList<Card>(Arrays.asList(new Card[]{new Card(Color.RED, "Hearts", 'A', false),
																			   new Card(Color.RED, "Hearts", '2', false),
																			   new Card(Color.RED, "Diamonds", '4', false),
																			   new Card(Color.BLACK, "Clubs", '5', false)})));
		
		
	
	
	Hand dealer1 = new Hand(new ArrayList<Card>(Arrays.asList(new Card[]{new Card(Color.RED, "Diamonds", 'A', false), 
			       new Card(Color.RED, "Hearts", 'A', false)})), new Posn(700, 200));

	Hand player1 = new Hand(new ArrayList<Card>(Arrays.asList(new Card[]{new Card(Color.BLACK, "Spades", '7', false),
				   new Card(Color.BLACK, "Clubs", '2', false)})), new Posn(700,600));

	Bet bet1 = new Bet(Color.RED, true, 100);


	BlackjackWorld bjw1 = new BlackjackWorld(dealer1, player1, bet1, testDeck, 0);
	
	testRemoveCard(testDeck);
	testAddCard(tester, testDeck);
	testFlipCard(tester);

	}
	// BlackjackWorld w1 = new BlackjackWorld(new Posn(50, 50), new Posn(100, 100));
	// BlackjackWorld w2 = new BlackjackWorld(new Posn(50, 50), new Posn(98, 98));
	// BlackjackWorld w3 = new BlackjackWorld(new Posn(50, 50), new Posn(50, 50));
	// BlackjackWorld w4 = new BlackjackWorld(new Posn(100, 50), new Posn(0, 70));

	@Test
	void testUpdate() {
		//	assertEquals(w2, w1.update());
		//	assertEquals(w3, w3.update());
	}




	void testRemoveCard(Deck testDeck) {
		assertEquals(new Deck(new ArrayList<Card>(Arrays.asList(new Card[] {
				   new Card(Color.RED, "Hearts", '2', false),
				   new Card(Color.RED, "Diamonds", '4', false),
				   new Card(Color.BLACK, "Clubs", '5', false)}))), testDeck.removeCard());
	}


	void testAddCard(Hand tester, Deck testDeck) {

		
		assertTrue(new Hand(new ArrayList<Card>(Arrays.asList(new Card[] {new Card(Color.RED, "Hearts", '2', true), 
				new Card(Color.RED, "Hearts", '2', false)})), 
				new Posn(100, 100)).equals(tester.addCard(testDeck)));
	}

	@Test
	void testKeyPressed() {
		// tested interactively, the 'h' key adds another card to the player's hand
		// and the rest of the keys do not do anything
	}
	
	void testFlipCard(Hand tester) {
		assertEquals(new Card(Color.RED, "Hearts", '2', true), tester.getCards().get(0).flipCard());
	}


}
