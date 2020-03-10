package minigames.blackjack;

import minigames.Minigame;
import minigames.util.Deck;

import java.util.Scanner;

public class Blackjack implements Minigame {
	private BJ_Hand p_hand, d_hand;
	private BJ_Hand[] hands;
	private Deck deck;
	private boolean playing = true;

	private Scanner s = new Scanner(System.in);

	public Blackjack() {
		init();
	}

	private void init() {
		this.p_hand = new BJ_Hand();
		this.d_hand = new BJ_Hand();
		this.hands = new BJ_Hand[]{p_hand,d_hand};
		this.deck = new BJ_Deck();
		this.deal(hands, 2);
		this.playing = true;
	}

	private void deal(BJ_Hand[] hands, int n) {
		for(BJ_Hand h : hands)
			for (int i = 0; i < n; i++)
				h.addCard((BJ_Card)deck.getRandomCard());
	}

	@Override
	public void play() {
		System.out.println("It's time to play some blackjack!");
		System.out.println("I'll deal you in, get as close to 21 as possible without going over and beat me!");
		System.out.println("Here's your cards: " + p_hand);
		System.out.println("The dealer's hand looks like this: [****, " + d_hand.getCard(d_hand.size() - 1) + "]");

		while(playing) {
			if (makeAction() == 1) {
				hit(p_hand);
				System.out.println("Here's your new cards: " + p_hand);
				System.out.println("The dealer's hand looks like this: [****, " + d_hand.getCard(d_hand.size() - 1) + "]");
			} else
				stay();

			if (p_hand.getValue() > 21) {
				System.out.println("Bust! You went over 21.");
				lose();
			}
		}

		System.out.println("\nWould you like to play again? (Y/N)");
		System.out.println("-->");
		String input = s.nextLine();
		if (input.equals("Y"))
			reset();
	}

	private int makeAction() {
		System.out.println("Would you like to hit or stay?");
		System.out.println("1: Hit\n2: Stay");
		String input = s.nextLine();

		if (input.equals("1") || input.equals("2"))
			return Integer.parseInt(input);
		else {
			System.out.println("\n=======================");
			System.out.println("Invalid Input");
			System.out.println("=======================\n");
			makeAction();
		}

		return 0;
	}

	private void hit(BJ_Hand hand) {
		deal(new BJ_Hand[]{hand}, 1);
		System.out.println("The new card is a " + hand.getCard(hand.size() - 1));
	}

	private void stay() {
		dealerActions();
		endGame();
	}

	private void dealerActions() {
		if (d_hand.getValue() > 21) {
			System.out.println("The dealer went over 21...");
			System.out.println("The dealer's hand looked like this: " + d_hand);
			win();
		} else if (d_hand.getValue() < 17) {
			hit(d_hand);
			dealerActions();
		} else
			compareScores();
	}

	private void compareScores() {
		System.out.println(p_hand);
		System.out.println(d_hand);

		if (p_hand.getValue() > d_hand.getValue())
			win();
		else if (p_hand.getValue() < d_hand.getValue())
			lose();
		else
			tie();
	}

	private void win() {
		System.out.println("You win!");
		endGame();
	}

	private void lose() {
		System.out.println("You lose...");
		endGame();
	}

	private void tie() {
		System.out.println("===========================");
		System.out.println("=   You tied! Try again   =");
		System.out.println("===========================");
		endGame();
		reset();
	}

	@Override
	public void endGame() {
		this.playing = false;
	}

	@Override
	public void reset() {
		init();
		play();
	}

	@Override
	public String toString() {
		return "Blackjack{}";
	}

	public static void main(String[] args) {
		Blackjack b = new Blackjack();
		b.play();
	}
}
