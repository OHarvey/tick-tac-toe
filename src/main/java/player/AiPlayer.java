package player;

import grid.Board;
import grid.Cell;
import interactions.CliPrinter;
import throwables.DuplicateTokenError;
import types.Token;

public class AiPlayer implements Player {
    private final Token token;
    private final Board board;
    private final CliPrinter cliPrinter;

    public AiPlayer(Board board, Token token) {
        this.token = token;
        this.board = board;
        cliPrinter = new CliPrinter();
    }

    @Override
    public void move(Cell cell) throws DuplicateTokenError {
        board.add(token, cell);
    }

    @Override
    public void move() {
        cliPrinter.print("Doing Nothing... for now. ");
    }

    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "Machine";
    }
}
