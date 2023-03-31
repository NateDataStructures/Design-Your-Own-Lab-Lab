import java.util.ArrayList;

public class CardPile extends Exception{

	private Boolean isPull = false;
	protected Boolean isFinalPile = false;
	private MyCircularlyDoublyLinkedList<Card> pile;
	private int currentCard = 0;

	public CardPile() {
		pile = new MyCircularlyDoublyLinkedList<Card>();
	}


	public CardPile(int type) {
		// 0 for regular, 1 for draw, 2 for final
		pile = new MyCircularlyDoublyLinkedList<Card>();
		if (type == 1) {
			isPull = true;
		} else if (type == 2) {
			isFinalPile = true;
		}
	}

	public boolean addCard(Card card) {
		pile.addLast(card);
		return true;
	}

	public void setIsPull(Boolean isPull) {
		this.isPull = isPull;
	}


	public Card removeCard() {
		return pile.removeLast();
	}

	public Card getTopCard(){
		if (isFinalPile) {
			return pile.getFirst();
		} else {
			return pile.getLast();
		}
	}

	public int getSize() {
		return pile.size();
	}

	public Card getCard(int index) {
		return pile.get(index);
	}

	public MyCircularlyDoublyLinkedList<Card> getPile() {
		return pile;
	}

	public boolean canFlip() {
		if (!this.getTopCard().getFlipped()) {
			return true;
		} else {
			return false;
		}
	}

	public void pullNextCard(){
		pile.shift();
	}

	public Card moveTopCardTo(CardPile otherPile) throws Exception{
		if(otherPile.isFinalPile){
			if(otherPile.getSize() == 0){
				if(this.getTopCard().getValue() == 1){
					otherPile.addCard(this.removeCard());
				} else {
					throw new Exception("Invalid Move - " + this.getTopCard().getValue() + " " + otherPile.getTopCard().getValue() + " " + this.getTopCard().getSuit() + " " + otherPile.getTopCard().getSuit() + "");
				}
			} else {
				if(this.getTopCard().getValue() == otherPile.getTopCard().getValue() + 1 && this.getTopCard().getSuit() == otherPile.getTopCard().getSuit()){
					otherPile.addCard(this.removeCard());
				} else {
					throw new Exception("Invalid Move - " + this.getTopCard().getValue() + " " + otherPile.getTopCard().getValue() + " " + this.getTopCard().getSuit() + " " + otherPile.getTopCard().getSuit() + "");
				}
			}
		} else {
			if(otherPile.getSize() == 0){
				if(this.getTopCard().getValue() == 13){
					otherPile.addCard(this.removeCard());
				} else {
					throw new Exception("Invalid Move - " + this.getTopCard().getValue() + " " + otherPile.getTopCard().getValue() + " " + this.getTopCard().getSuit() + " " + otherPile.getTopCard().getSuit() + "");
				}
			} else {
				if(this.getTopCard().getValue() == otherPile.getTopCard().getValue() - 1 && this.getTopCard().getColor() != otherPile.getTopCard().getColor()){
					otherPile.addCard(this.removeCard());
				} else {
					throw new Exception("Invalid Move - " + this.getTopCard().getValue() + " " + otherPile.getTopCard().getValue() + " " + this.getTopCard().getSuit() + " " + otherPile.getTopCard().getSuit() + "");
				}
			}
		}
		return otherPile.getTopCard();

	}

	public void moveMultipleCardsTo(CardPile otherPile, int numCards) throws Exception{
		ArrayList<Card> cardsToMove = new ArrayList<Card>();
		numCards = this.getSize() - numCards;

		if(otherPile.isFinalPile){
			throw new Exception("Invalid Move - cannot move multiple cards to final pile");
		} else {
			if(otherPile.getSize() == 0){
				if(this.getCard(numCards).getValue() == 13){
					for(int i = this.getSize() - 1; i >= numCards; i--){
						cardsToMove.add(this.getCard(i));
					}
					for(int i = 0; i < cardsToMove.size(); i++){
						otherPile.addCard(cardsToMove.get(i));
						this.removeCard();
					}
				} else {
					throw new Exception("Invalid Move - " + this.getCard(numCards).getValue() + " " + otherPile.getTopCard().getValue() + " " + this.getCard(numCards).getSuit() + " " + otherPile.getTopCard().getSuit() + "");
				}
			} else {
				if(this.getCard(numCards).getValue() == otherPile.getTopCard().getValue() - 1 && this.getCard(numCards).getColor() != otherPile.getTopCard().getColor()){
					for(int i = this.getSize() - 1; i >= numCards; i--){
						cardsToMove.add(this.removeCard());
					}
					for(int i = cardsToMove.size() - 1; i >= 0; i--){
						if(cardsToMove.get(i).getValue() == otherPile.getTopCard().getValue() - 1 && cardsToMove.get(i).getColor() != otherPile.getTopCard().getColor()){
							otherPile.addCard(cardsToMove.get(i));
						} else {
							throw new Exception("Invalid Move - " + this.getCard(numCards).getValue() + " " + otherPile.getTopCard().getValue() + " " + this.getCard(numCards).getSuit() + " " + otherPile.getTopCard().getSuit() + "");
						}

					}
				} else {
					throw new Exception("Invalid Move - " + this.getCard(numCards).getValue() + " " + otherPile.getTopCard().getValue() + " " + this.getCard(numCards).getSuit() + " " + otherPile.getTopCard().getSuit() + "");
				}
			}
		}
	}

	public void clear() {
		pile = new MyCircularlyDoublyLinkedList<>();
	}
}
