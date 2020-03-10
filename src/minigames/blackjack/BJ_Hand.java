package minigames.blackjack;

import minigames.util.Hand;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BJ_Hand extends Hand {
	private List<BJ_Card> hand;
	private int value;
	private List<Integer> ace_indexes;
	private int current_ace_index;

	public BJ_Hand() {
		this.hand = new ArrayList<BJ_Card>();
		this.value = 0;
		this.ace_indexes = new ArrayList<Integer>();
		this.current_ace_index = 0;
	}

	public void addCard(BJ_Card card) {
		hand.add(card);
		if (card.getName().equals("ace"))
			ace_indexes.add((hand.size() - 1));
		sumValues();
	}

	public void addCard(String name) {
		addCard(new BJ_Card(name));
	}

	public int getValue() {
		return value;
	}

	public List<BJ_Card> getHand() {
		return hand;
	}

	public BJ_Card getCard(int index) {
		return hand.get(index);
	}

	public void clearHand() {
		this.hand = new ArrayList<BJ_Card>();
	}

	private boolean hasAce() {
		return !ace_indexes.isEmpty();
	}

	private void changeAce(@NotNull BJ_Card card) {
		card.setValue(1);
		current_ace_index++;
	}

	private void sumValues() {
		this.value = 0;
		for (BJ_Card c : hand)
			value += c.getValue();

		if (value > 21 && hasAce() && current_ace_index < ace_indexes.size()) {
			changeAce(hand.get(ace_indexes.get(current_ace_index)));
			sumValues();
		}
	}

	@Override
	public int size() {
		return hand.size();
	}

	@Override
	public String toString() {
		List<String> ret_val = new ArrayList<String>();
		for (BJ_Card c : hand)
			ret_val.add(c.toString());
		return ret_val + " :: Value = " + getValue();
	}

	// testing purposes only
	public static void main(String[] args) {
		BJ_Hand h = new BJ_Hand();

		h.addCard(new BJ_Card("two"));
		h.addCard(new BJ_Card("four"));
		h.addCard(new BJ_Card("ace"));

		// should be:
		// [two, four, ace] :: Value = 17
		System.out.println(h);

		// INVALID, should throw InvalidCardException
		/*
		h.addCard(new BJ_Card("four"));
		System.out.println(h);
		*/

		// Testing just putting a name
		h.addCard("four");

		// should be:
		// [two, four, ace, four] :: Value = 21
		System.out.println(h);
	}
}
