import grid.Board;
import interactions.CliPrinter;
import interactions.Response;
import player.AiPlayer;
import player.HumanPlayer;
import player.Player;
import types.Token;

public class Application {

    private static Board gameBoard;
    private static final CliPrinter cliPrinter = new CliPrinter();
    private static Token token;
    private static Player HUMAN;
    private static Player COMPUTER;

    public static void main(String[] args) {
        cliPrinter.print("**** Starting Game ****");
        setUserToken();
        init();

        Player currentPlayer = HUMAN;
        while (Referee.whoWon(gameBoard) == Token.EMPTY) {
            cliPrinter.print("*** New Turn: " + currentPlayer + " - " + currentPlayer.getToken());
            cliPrinter.print(gameBoard.toString());

            currentPlayer.move();

            currentPlayer = swapPlayer(currentPlayer);
            cliPrinter.print("End Of Turn ");
        }
    }

    public static void init() {
        gameBoard = new Board();
        setUpPlayers(token);
    }

    protected static void setHuman(Player human) {
        HUMAN = human;
    }


    protected static Player swapPlayer(Player currentPlayer) {
        return (currentPlayer instanceof AiPlayer) ? HUMAN : COMPUTER;
    }

    private static void setUpPlayers(Token token) {
        HUMAN = new HumanPlayer(gameBoard, token);
        Token aiToken = (token == Token.X) ? Token.O : Token.X;
        COMPUTER = new AiPlayer(gameBoard, aiToken);
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    private static void setUserToken() {
        Response response = new Response().invoke("What Token do you want to be? X or O?");
        token = convertToToken(response.getResponse());
    }

    private static Token convertToToken(String s) throws IllegalArgumentException {
        if (s.equalsIgnoreCase("x")) {
            return Token.X;
        } else if (s.equalsIgnoreCase("o")) {
            return Token.O;
        }
        throw new IllegalArgumentException("There wasnt a x or an o!");
    }
}