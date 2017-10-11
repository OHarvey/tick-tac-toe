import grid.Board;
import grid.Line;
import interactions.CliPrinter;
import types.Token;


public class Referee {

    private static CliPrinter cliPrinter = new CliPrinter();

    public static Token whoWon(Board board) {
        Token token = null;
        for (Line line : board.getAllLines()) {
            token = line.isLineAWinnerIn(board);
            if (notEmptyToken(token)) {
                cliPrinter.print(token + " Won with a line containing these cells: " + line);
                break;
            }
        }

        return token;
    }

    private static boolean notEmptyToken(Token winningToken) {
        return winningToken != Token.EMPTY;
    }

}