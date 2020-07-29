package CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import CardGame.Card.Rank;
import CardGame.Card.Suit;

public class DeckOfCards {

	public static final int CARD_NUM = 52;
	
	private List<Card> cards;
	
	private int currentCardId;
	
	public DeckOfCards() {
		
		// create the array  
		cards = new ArrayList<Card>(CARD_NUM);
		
		// initialize all 52 card objects in the newly created array
		reset();
	}
	
	public void reset() {
		cards.clear();
		
		int i = 0;
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				cards.add(new Card(s, r));
			}
		}
		
		currentCardId = 0;
	}
	
	// deal the next card in the deck
	public Card deal() {
		if(currentCardId < CARD_NUM)
			return cards.get(currentCardId++);
		else {
			System.out.println("Out of card error!");
			return null;
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public String toString() {
		String s = "";
		
		int k = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				Card card = cards.get(k);
				s += card.toString() + "\t";
				k++;
			}
			s += "\n";
		}
		return s;
	}


	public static void main(String[] args) {
		DeckOfCards deckOfCards = new DeckOfCards();
		System.out.println(deckOfCards.toString());
		System.out.println();
		
		deckOfCards.shuffle();
		
		System.out.println(deckOfCards.toString());
		System.out.println(deckOfCards.deal().toString());
		System.out.println(deckOfCards.deal().toString());
		System.out.println();
		
		deckOfCards.reset();
		System.out.println(deckOfCards.toString());
	}
}
