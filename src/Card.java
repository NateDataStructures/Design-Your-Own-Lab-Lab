public class Card {
	private String suit; // spades, hearts, diamonds, clubs
	private int value; // 1-13, 1 is Ace, 11 is Jack, 12 is Queen, 13 is King
	private String color; // red or black
	private String ID;
	private Boolean flipped;
	protected Boolean isInPullPile = false;

	public Card(String suit, int value) {
		suit = suit.toLowerCase();
		this.suit = suit;
		this.value = value;
		flipped = false;
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

	public Boolean getFlipped() {
		return flipped;
	}

	public void setFlipped(Boolean flipped) {
		this.flipped = flipped;
	}

	public void flip() {
		flipped = !flipped;
	}

	public String getID() {
		String temp = "";



		if (flipped) {
			// if face card
			if (value == 1) { //ACE-S
				temp = "ACE-" + suit.substring(0, 1);
			} else if (value == 11) { // JACK-S
				temp = "JACK-" + suit.substring(0, 1);
			} else if (value == 12) { // QUEEN-S
				temp = "QUEEN-" + suit.substring(0, 1);
			} else if (value == 13) {
				temp = "KING-" + suit.substring(0, 1);
			} else {
				temp = value + "-" + suit.substring(0, 1);
			}
		} else {
			temp = "XXXXXX";
		}
		return temp;
	}

	public Boolean canPlayMove(Card other){
		if(other.getValue() == this.getValue() - 1 && other.getColor() != this.getColor()){
			return true;
		}
		return false;
	}

	public void setIsInPullPile(Boolean isInPullPile) {
		this.isInPullPile = isInPullPile;
	}

	public Boolean getIsInPullPile(){
		return isInPullPile;
	}

	@Override
	public String toString() {
		return getID();
	}


}
