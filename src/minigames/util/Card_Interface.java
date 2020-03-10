package minigames.util;

public interface Card_Interface {
	String name = "";
	int value = 0;

	public String getName();

	public void setName(String name);

	public int getValue();

	public void setValue(int value);

	@Override
	public String toString();
}
