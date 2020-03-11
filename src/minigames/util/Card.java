package minigames.util;

import exceptions.InvalidCardException;

import java.util.Arrays;
import java.util.List;

public class Card implements Card_Interface {
	public static final List<String> CARD_NAMES = Arrays.asList(
			"two", "three", "four",
			"five", "six", "seven",
			"eight", "nine", "ten",
			"jack", "queen", "king", "ace"
	);

	protected String name;
	protected int value;
	protected Suit suit;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		if (Card.CARD_NAMES.contains(name)) {
			this.name = name;
		} else {
			throw new InvalidCardException();
		}
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		String v = name;
		while (v.length() < 6)
			v = " " + v;
		return  " ------- \n" +
				"|" + v + " |\n" +
				"|       |\n" +
				" -------";
	}
}
