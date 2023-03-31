public class Tester {
	public static void main(String[] args) throws Exception {

		Solitaire game = new Solitaire();

		game.createDeck();
		game.dealCards();
		game.printPiles();
		controller.controller(game);

	}
}
