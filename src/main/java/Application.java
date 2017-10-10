import grid.Board;
import player.AiPlayer;
import player.HumanPlayer;
import player.Player;
import types.Tokens;

import java.util.Scanner;

public class Application {

    private static Board gameBoard;
    private static Tokens token;
    private static Scanner scanner = new Scanner(System.in);
    private static Player HUMAN;
    private static Player COMPUTER;

    public static void main(String[] args) {

        System.out.println("Starting Game");
        setUserToken();
        init();
        Player currentPlayer = HUMAN;
        while (Referee.whoWon(gameBoard) == null) {
            System.out.println("player.Player: " + currentPlayer + " - " + currentPlayer.getToken());
            System.out.println(gameBoard);

            currentPlayer.move();

            currentPlayer = swapPlayer(currentPlayer);
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

    private static void setUpPlayers(Tokens token) {
        HUMAN = new HumanPlayer(gameBoard, token);
        Tokens aiToken = (token == Tokens.X) ? Tokens.O : Tokens.X;
        COMPUTER = new AiPlayer(gameBoard, aiToken);
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    private static void setUserToken() {
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
        throw new IllegalArgumentException("There wasnt a x or an o!");
    }
}