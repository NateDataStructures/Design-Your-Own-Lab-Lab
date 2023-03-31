import java.io.Console;
import java.util.ArrayList;

public class printer {
	// colors
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[90m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_WHITE = "\u001B[37m";
	final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


	ArrayList<CardPile> playPiles;
	ArrayList<CardPile> finalPiles;
	CardPile deckPile;


	public printer() {
		playPiles = new ArrayList<>();
		finalPiles = new ArrayList<>();
	}

	public void addPlayPile(CardPile pile) {
		playPiles.add(pile);
	}

	public void addSuitPiles(CardPile spades, CardPile hearts, CardPile clubs, CardPile diamonds) {
		finalPiles.add(spades);
		finalPiles.add(hearts);
		finalPiles.add(clubs);
		finalPiles.add(diamonds);
	}

	public void setDeckPile(CardPile deck) {
		deckPile = deck;
	}

	public void printPiles() {
		Console col = System.console();

		// num-color-suit
		// 10-R-S

		String playPileFormat = "%-8s%-8s%-8s%-8s%-8s%-8s%-8s%n";

		String finalPileFormat = "%-8s%-8s%-8s%-8s%n";

		System.out.format(playPileFormat, "Spades", "Hearts", "Clubs", "Diamonds", " ", " ", "Deck");

		System.out.format(playPileFormat, "------", "------", "------", "------", " ", " ", "------");

		for(int i = 0; i < 7; i++) {
			if(i < 4) {
				if(finalPiles.get(i).getPile().size() > 0) {
					if(finalPiles.get(i).getPile().get(0).getColor() == "Red") {
						System.out.print(ANSI_RED);
					} else {
						System.out.print(ANSI_BLACK);
					}
					System.out.format("%-8s", finalPiles.get(i).getCard(1).toString());
					System.out.print(ANSI_RESET);
				} else {
					System.out.format("%-8s", "");
				}
			} else if(i == 6) {
				if(deckPile.getTopCard().getColor() == "red") {
					System.out.print(ANSI_RED);
				} else {
					System.out.print(ANSI_BLACK);
				}
				System.out.format("%-8s", deckPile.getTopCard().toString());
			} else {
				System.out.format("%-8s", "");

			}
		}
		System.out.print(ANSI_RESET);

		System.out.println();

		System.out.format(playPileFormat, "Deck 1", "Deck 2", "Deck 3", "Deck 4", "Deck 5", "Deck 6", "Deck 7");
		System.out.format(playPileFormat, "------", "------", "------", "------", "------", "------", "------");

		for(int i = 0; i < 13; i++) {
			for(int j = 0; j < playPiles.size(); j++) {
				if(playPiles.get(j).getPile().size() > i) {
					if(playPiles.get(j).getPile().get(i).getColor() == "red" && playPiles.get(j).getPile().get(i).getFlipped()) {
						System.out.print(ANSI_RED);
					} else if(playPiles.get(j).getPile().get(i).getColor() == "black" && playPiles.get(j).getPile().get(i).getFlipped()) {
						System.out.print(ANSI_BLACK);
					}
					System.out.format("%-8s", playPiles.get(j).getPile().get(i).toString());
					System.out.print(ANSI_RESET);
				} else {
					System.out.format("%-8s", "");
				}
			}
			System.out.println();
		}

	}
}
