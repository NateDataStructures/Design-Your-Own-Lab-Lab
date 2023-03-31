import java.util.Scanner;

public class controller {
	// commands for the game
	public static final String MOVE = "move";
	public static final String QUIT = "quit";
	public static final String HELP = "help";
	public static final String FLIP = "flip";
	public static final String pull = "pull";
	public static final String TRANSFER = "transfer";
	public static final String CHEAT = "cheat";


	public static void controller(Solitaire game) throws Exception {
		System.out.println("Welcome to Solitaire!");

		Scanner input = new Scanner(System.in);
		System.out.println("Hint: use \"help\" to see a list of commands");
		System.out.print("Enter a command: ");

		String command = input.next();
		while(!command.equals(QUIT) && !game.isWon()) {
			if(command.equals(MOVE)) {
				System.out.print("Enter the pile name to move from: ");
				String from = input.next();
				System.out.print("Enter the pile name to move to: ");
				String to = input.next();
				try {
					game.moveCard(from, to);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			} else if(command.equals(FLIP)) {
				System.out.print("Enter the pile name to flip: ");
				String pile = input.next();
				game.flipCard(pile);
			} else if(command.equals(pull)) {
				game.pullCard();
			} else if(command.equals(TRANSFER)) {
				System.out.print("Enter the pile name to transfer from: ");
				String from = input.next();
				System.out.print("Enter the pile name to transfer to: ");
				String to = input.next();
				System.out.print("Enter the number of cards to transfer: ");
				int num = input.nextInt();

				try {
					game.moveCard(from, to, num);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (command.equals(HELP)) {
				System.out.println("Commands:");
				System.out.println("move: move a card from one pile to another");
				System.out.println("quit: quit the game");
				System.out.println("help: print this list of commands");
				System.out.println("flip: flip a card in a pile");
				System.out.println("pull: pull a card from the deck");
				System.out.println("transfer: transfer a number of cards from one pile to another");

				System.out.print("Press enter to continue");
				input.nextLine();
				input.nextLine();



			} else if(command.equals(CHEAT)){
				game.cheat();
			}
			else {
				System.out.println("Invalid command");
			}
			game.printPiles();
			System.out.print("Enter a command: ");

			command = input.next();

		}
		if(game.isWon()) {
			System.out.println("You won!");
		}
		input.close();

	}
}
