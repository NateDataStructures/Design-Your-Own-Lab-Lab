import java.util.Collections;
import java.util.Stack;

public class Solitaire {
	private CardPile workingDeck;
	private Card currentPullCard;

	// the 4 done piles "Spades", "Hearts", "Clubs", "Diamonds"
	private CardPile spadesDone;
	private CardPile heartsDone;
	private CardPile clubsDone;
	private CardPile diamondsDone;

	// the 7 playing piles
	private CardPile play1;
	private CardPile play2;
	private CardPile play3;
	private CardPile play4;
	private CardPile play5;
	private CardPile play6;
	private CardPile play7;

	private Stack<Card> originalShuffledDeck;


	public Solitaire() {
		// make the 7 playing piles
		play1 = new CardPile();
		play2 = new CardPile();
		play3 = new CardPile();
		play4 = new CardPile();
		play5 = new CardPile();
		play6 = new CardPile();
		play7 = new CardPile();

		// make the 4 done piles
		spadesDone = new CardPile(2);
		heartsDone = new CardPile(2);
		clubsDone = new CardPile(2);
		diamondsDone = new CardPile(2);
	}

	public void createDeck() {
		originalShuffledDeck = new Stack<Card>();
		// create the deck
		String[] suits = {"spades", "hearts", "diamonds", "clubs"};
		for(int i = 0; i < suits.length; i++) {
			for(int j = 1; j <= 13; j++) {
				originalShuffledDeck.push(new Card(suits[i], j));
			}
		}
		// Shuffle the deck
		Collections.shuffle(originalShuffledDeck);
	}

	public void dealCards() {
		workingDeck = new CardPile();
		for(int i = 0; i < 52; i++) {
			workingDeck.addCard(originalShuffledDeck.pop());
		}

		// create the 7 piles with i cards per pile
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < i + 1; j++) {
				workingDeck.getTopCard().setIsInPullPile(false);
				if(i == 0) {
					play1.addCard(workingDeck.removeCard());
				} else if(i == 1) {
					play2.addCard(workingDeck.removeCard());
				} else if(i == 2) {
					play3.addCard(workingDeck.removeCard());
				} else if(i == 3) {
					play4.addCard(workingDeck.removeCard());
				} else if(i == 4) {
					play5.addCard(workingDeck.removeCard());
				} else if(i == 5) {
					play6.addCard(workingDeck.removeCard());
				} else if(i == 6) {
					play7.addCard(workingDeck.removeCard());
				}
			}
		}
		// Flip the top card
		play1.getTopCard().flip();
		play2.getTopCard().flip();
		play3.getTopCard().flip();
		play4.getTopCard().flip();
		play5.getTopCard().flip();
		play6.getTopCard().flip();
		play7.getTopCard().flip();
		currentPullCard = workingDeck.getTopCard();
	}

	public void moveCard(String from, String to) throws Exception {
		CardPile fromPile = stringToPile(from);
		CardPile toPile = stringToPile(to);
		fromPile.moveTopCardTo(toPile).setIsInPullPile(false);
	}

	public void moveCard(String from, String to, int numCards) throws Exception {
		CardPile fromPile = stringToPile(from);
		CardPile toPile = stringToPile(to);
		fromPile.moveMultipleCardsTo(toPile, numCards);
	}


	public void printPiles() {
		printer printer = new printer();
		printer.addPlayPile(play1);
		printer.addPlayPile(play2);
		printer.addPlayPile(play3);
		printer.addPlayPile(play4);
		printer.addPlayPile(play5);
		printer.addPlayPile(play6);
		printer.addPlayPile(play7);
		printer.setDeckPile(workingDeck);
		printer.addSuitPiles(spadesDone, heartsDone, clubsDone, diamondsDone);
		printer.printPiles();
	}

	public void flipCard(String pile) {
		CardPile pileToFlip = stringToPile(pile);
		pileToFlip.getTopCard().flip();

	}


	private CardPile stringToPile(String s) {
		switch(s) {
			case "p1":
				return play1;
			case "p2":
				return play2;
			case "p3":
				return play3;
			case "p4":
				return play4;
			case "p5":
				return play5;
			case "p6":
				return play6;
			case "p7":
				return play7;
			case "s":
				return spadesDone;
			case "h":
				return heartsDone;
			case "c":
				return clubsDone;
			case "d":
				return diamondsDone;
			case "pull":
				return workingDeck;
		}
		return null;
	}

	public void pullCard() {
		if(currentPullCard.getIsInPullPile()) {
			currentPullCard.setFlipped(true);
		}

		workingDeck.pullNextCard();
		currentPullCard = workingDeck.getTopCard();
		currentPullCard.setFlipped(true);
	}

	public boolean isWon() {
		if(spadesDone.getSize() == 13 && heartsDone.getSize() == 13 && clubsDone.getSize() == 13 && diamondsDone.getSize() == 13) {
			return true;
		}
		return false;
	}

	public void cheat() {
		spadesDone = new CardPile(2);
		heartsDone = new CardPile(2);
		clubsDone = new CardPile(2);
		diamondsDone = new CardPile(2);
		for(int i = 1; i <= 13; i++) {
			spadesDone.addCard(new Card("spades", i));
			heartsDone.addCard(new Card("hearts", i));
			clubsDone.addCard(new Card("clubs", i));
			diamondsDone.addCard(new Card("diamonds", i));
		}
		spadesDone.getTopCard().flip();
		heartsDone.getTopCard().flip();
		clubsDone.getTopCard().flip();
		diamondsDone.getTopCard().flip();
	}
}

