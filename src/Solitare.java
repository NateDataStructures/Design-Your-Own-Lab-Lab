import java.util.Collections;
import java.util.Stack;

public class Solitare {


	private MyCircularlyDoublyLinkedList<Card> workingDeck;
	private Card currentPullCard;

	// the 4 done piles
	private MyCircularlyDoublyLinkedList<Card> done1;
	private MyCircularlyDoublyLinkedList<Card> done2;
	private MyCircularlyDoublyLinkedList<Card> done3;
	private MyCircularlyDoublyLinkedList<Card> done4;

	// the 7 playing piles
	private MyCircularlyDoublyLinkedList<Card> play1;
	private MyCircularlyDoublyLinkedList<Card> play2;
	private MyCircularlyDoublyLinkedList<Card> play3;
	private MyCircularlyDoublyLinkedList<Card> play4;
	private MyCircularlyDoublyLinkedList<Card> play5;
	private MyCircularlyDoublyLinkedList<Card> play6;
	private MyCircularlyDoublyLinkedList<Card> play7;

	private Stack<Card> originalShuffledDeck;



	public Solitare(){
		// Make the shuffled deck
		createDeck();
		// move the cards to the working deck
		workingDeck = new MyCircularlyDoublyLinkedList<Card>();
		for (int i = 0; i < 52; i++) {
			workingDeck.addLast(originalShuffledDeck.pop());
		}
		// make the 7 playing piles
		play1 = new MyCircularlyDoublyLinkedList<Card>();
		play2 = new MyCircularlyDoublyLinkedList<Card>();
		play3 = new MyCircularlyDoublyLinkedList<Card>();
		play4 = new MyCircularlyDoublyLinkedList<Card>();
		play5 = new MyCircularlyDoublyLinkedList<Card>();
		play6 = new MyCircularlyDoublyLinkedList<Card>();
		play7 = new MyCircularlyDoublyLinkedList<Card>();

		// make the 4 done piles
		done1 = new MyCircularlyDoublyLinkedList<Card>();
		done2 = new MyCircularlyDoublyLinkedList<Card>();
		done3 = new MyCircularlyDoublyLinkedList<Card>();
		done4 = new MyCircularlyDoublyLinkedList<Card>();

		// deal the cards
		dealCards();






	}

	public void createDeck(){
		originalShuffledDeck = new Stack<Card>();
		// create the deck
		String[] suits = {"spades", "hearts", "diamonds", "clubs"};
		for(int i = 0; i < suits.length; i++){
			for(int j = 1; j <= 13; j++){
				originalShuffledDeck.push(new Card(suits[i], j));
			}
		}
		// Shuffle the deck
		Collections.shuffle(originalShuffledDeck);

	}

	public void dealCards() {
	}
}
