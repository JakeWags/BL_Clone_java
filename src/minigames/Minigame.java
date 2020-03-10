package minigames;

public interface Minigame {
	/**
	 * Called to initialize and start playing the minigame
	 */
	public void play();

	void endGame();

	void reset();

	@Override
	public String toString();
}
