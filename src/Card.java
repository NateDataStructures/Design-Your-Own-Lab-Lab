import java.util.Objects;

public class Card {
	private String suit; // spades, hearts, diamonds, clubs
	private int value; // 1-13, 1 is Ace, 11 is Jack, 12 is Queen, 13 is King
	private String color; // red or black
	private String ID;

	public Card(String suit, int value) {
		suit = suit.toLowerCase();
		this.suit = suit;
		this.value = value;
		if (suit.equals("spades") || suit.equals("clubs")) {
			color = "black";
		} else {
			color = "red";
		}

	}

	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public String getColor() {
		return color;
	}
}
