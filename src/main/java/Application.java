import java.util.Scanner;

public class Application {

    private static Board gameBoard;
    private static Tokens token;
    private static Scanner scanner;
    private static Player HUMAN;
    private static Player COMPUTER;

    public static void main(String[] args) {
        System.out.println("Starting Game");
        setUserToken();
        init();
        Player currentPlayer = HUMAN;
        while (Referee.whoWon(gameBoard) == null) {
            System.out.println("Player: " + currentPlayer.token);
            System.out.println(gameBoard);

            currentPlayer.move();

            currentPlayer = swapPlayer(currentPlayer);
        }
    }


    public static void init() {
        gameBoard = new Board();
        setUpHumanPlayer(token);
    }

    protected static Player swapPlayer(Player currentPlayer) {
        return (currentPlayer instanceof AiPlayer) ? HUMAN : COMPUTER;
    }

    private static void setUpHumanPlayer(Tokens token) {
        HUMAN = new HumanPlayer(gameBoard, token);
        Tokens aiToken = token == Tokens.X ? Tokens.O : Tokens.X;
        COMPUTER = new AiPlayer(gameBoard, aiToken);
    }

    private static void setUserToken() {
        scanner = new Scanner(System.in);
        System.out.println("Choose your token: X or O ");
        token = convertToToken(scanner.nextLine());
        System.out.println(token);
    }

    private static Tokens convertToToken(String s) throws IllegalArgumentException {

        if (s.equalsIgnoreCase("x")) {
            return Tokens.X;
        } else if (s.equalsIgnoreCase("o")) {
            return Tokens.O;
        }
        //TODO: Ask for reentery of token
        throw new IllegalArgumentException("There wasnt a x or an o!");
    }

    /**
     * Used only for testing.
     */
    protected static void setHuman(Player human) {
        HUMAN = human;
    }

    public Board getGameBoard() {
        return this.gameBoard;
    }


}
