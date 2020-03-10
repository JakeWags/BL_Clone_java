package minigames.util;

import minigames.blackjack.BJ_Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Deck {
	protected List<Card> deck;

	public Deck() {
		this.deck = new ArrayList<>();
		initDeck();
	}

	protected void initDeck() {}

	protected void addCard(Card card) {
		deck.add(card);
	}

	public List<Card> getDeck() {
		return deck;
	}

	public int size() {
		return deck.size();
	}

	public Card getRandomCard() {
		int n = (int)Math.round(Math.random() * (size() - 1));
		Card d = deck.get(n);
		deck.remove(d);
		return d;
	}

	@Override
	public String toString() {
		return deck.toString();
	}
}
