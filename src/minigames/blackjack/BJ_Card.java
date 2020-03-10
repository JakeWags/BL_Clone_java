package minigames.blackjack;

import minigames.util.Card;

public class BJ_Card extends Card {
	public BJ_Card(String name) {
		setName(name);
		setValue(BJ_Card.getCardValue(name));
	}

	public static int getCardValue(String name) {
		if (Card.CARD_NAMES.contains(name)) {
			int index = Card.CARD_NAMES.indexOf(name);
			// return 11 if ace, 10 if ten - king, and corresponding value otherwise
			return (!name.equals("ace")) ? ((index < 8) ? index + 2 : 10) : 11;
		} else {
			return 0;
		}
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public int getValue() {
		return super.getValue();
	}

	@Override
	public void setValue(int value) {
		super.setValue(value);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	// testing purposes only
	public static void main(String[] args) {
		Card a = new BJ_Card("two");
		// should be: "two"
		System.out.println(a);

		Card b = new BJ_Card("king");
		// should be: "king"
		System.out.println(b);

		// INVALID, should throw InvalidCardException
		/*
		Card c = new BJ_Card("abc");
		System.out.println(c);
		*/
	}
}
