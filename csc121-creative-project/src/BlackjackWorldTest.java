import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BlackjackWorldTest {
	
	
	@Test
	void test() {
		// hand with the 2 of Hearts, face down
		Hand tester = new Hand(new ArrayList<Card>(Arrays.asList(new Card[]{new Card(Color.RED, "Hearts", '2', false)})), new Posn(100, 100));
		
		// deck with the Ace of Hearts, 2 of Hearts, 4 of Diamonds, and 5 of Clubs
		Deck testDeck = new Deck(new ArrayList<Card>(Arrays.asList(new Card[]{new Card(Color.RED, "Hearts", 'A', false),
																			   new Card(Color.RED, "Hearts", '2', false),
																			   new Card(Color.RED, "Diamonds", '4', false),
																			   new Card(Color.BLACK, "Clubs", '5', false)})));

	testRemoveCard(testDeck);
	testAddCard(tester, testDeck);
	testFlipCard(tester);

	}
	
	@Test
	void testUpdate() {

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
