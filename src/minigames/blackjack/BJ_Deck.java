package minigames.blackjack;

import minigames.util.Card;
import minigames.util.Deck;

public class BJ_Deck extends Deck {
	public BJ_Deck() {
		super();
	}

	@Override
	protected void initDeck() {
		for (String name : Card.CARD_NAMES)
			for (int i = 0; i < 4; i++)
				addCard(new BJ_Card(name));
	}

	// For testing
	public static void main(String[] args) {
		BJ_Deck d = new BJ_Deck();
		System.out.println(d);
	}
}
