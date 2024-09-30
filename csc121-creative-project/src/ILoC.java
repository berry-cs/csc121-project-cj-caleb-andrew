
// to represent a list of cards

import java.util.Objects;

interface ILoC {
	// public ??? ilocMethod(...);

	/** adds new random card to list of random cards */
	// public ILoC randomCard
}




//an empty list of cards
class MTLoC implements ILoC {

	MTLoC() {}

	/* TEMPLATE:
public ??? ilobMethod(...) {
...
}
	 */

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

