package minigames.util;

import java.util.ArrayList;
import java.util.List;

public interface Hand_Interface {
	List<Card> hand = new ArrayList<Card>();

	public void addCard(Card card);

	public void addCard(String name);

	public void clearHand();

	public int size();


}
