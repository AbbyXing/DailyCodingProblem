package CardGame;

public class Card {

	public enum Suit {
		SPADES,
		HEARTS,
		DIAMONDS,
		CLUBS
	}
	
	public enum Rank {
		TWO,
	    THREE,
	    FOUR,
	    FIVE,
	    SIX,
	    SEVEN,
	    EIGHT,
	    NINE,
	    TEN,
	    JACK,
	    QUEEN,
	    KING,
	    ACE
	}
	
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public String toString() {
		String s = "";
		s += this.suit + "-" + this.rank;
		
		return s;
	}
}
