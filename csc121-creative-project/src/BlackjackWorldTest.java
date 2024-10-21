import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class BlackjackWorldTest {
	Color red = Color.red;
	//Card king = new Card(red, "Hearts", 'K', 10, true);
	//Hand h1 = new Hand(king);



    Hand tester = new Hand(new ConsLoC(new Card(Color.RED, "Hearts", '2', false), new MTLoC()), new Posn(100, 100));
	Hand test2 = new Hand(new MTLoC(), new Posn(100,100));

	Deck testDeck = new Deck(new ConsLoC(new Card(Color.RED, "Hearts", 'A', false),
			new ConsLoC(new Card(Color.RED, "Hearts", '2', false),
					new ConsLoC(new Card(Color.RED, "Diamonds", '4', false),
							new ConsLoC(new Card(Color.RED, "Diamonds", '5', false),
									new ConsLoC(new Card(Color.BLACK, "Clubs", '5', false),
											new MTLoC()))))));


	// BlackjackWorld w1 = new BlackjackWorld(new Posn(50, 50), new Posn(100, 100));
	// BlackjackWorld w2 = new BlackjackWorld(new Posn(50, 50), new Posn(98, 98));
	// BlackjackWorld w3 = new BlackjackWorld(new Posn(50, 50), new Posn(50, 50));
	// BlackjackWorld w4 = new BlackjackWorld(new Posn(100, 50), new Posn(0, 70));

	@Test
	void testUpdate() {
		//	assertEquals(w2, w1.update());
		//	assertEquals(w3, w3.update());
	}

	
	// METHODS CURRENTLY NOT WORKING
	/*
	@Test
	void testRemoveCard() {
		assertEquals(new Deck(new ConsLoC(new Card(Color.RED, "Hearts", '2', false),
						new ConsLoC(new Card(Color.RED, "Diamonds", '4', false),
								new ConsLoC(new Card(Color.RED, "Diamonds", '5', false),
										new ConsLoC(new Card(Color.BLACK, "Clubs", '5', false),
												new MTLoC()))))), testDeck.removeCard());
	}
	*/
	

	@Test
	void testAddCard() {
			assertEquals(new Hand(new ConsLoC(new Card(Color.RED, "Hearts", 'A', false), 
					       new ConsLoC(new Card(Color.RED, "Hearts", '2', false), 
					    	  new MTLoC())), new Posn(100, 100)), tester.addCard(testDeck));
			assertEquals(new Hand(new ConsLoC(new Card(Color.RED, "Hearts", 'A', false), 
					       new ConsLoC(new Card(Color.RED, "Hearts", '2', false), 
					    	  new MTLoC())), new Posn(100, 100)).toString(), tester.addCard(testDeck).toString());
	}
	

}
