package minigames.util;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand implements Hand_Interface {
	List<Card> hand = new ArrayList<Card>();

	@Override
	public void addCard(Card card) {
		hand.add(card);
	}

	@Override
	public void addCard(String name) { }

	@Override
	public void clearHand() {
		hand.clear();
	}

	@Override
	public int size() {
		return hand.size();
	}
}
