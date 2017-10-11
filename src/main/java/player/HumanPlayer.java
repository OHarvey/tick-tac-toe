package player;

import grid.Board;
import grid.Cell;
import interactions.CliPrinter;
import interactions.Response;
import throwables.DuplicateTokenError;
import types.Token;

public class HumanPlayer implements Player {

    private final Token TOKEN;
    private final Board BOARD;
    private final CliPrinter PRINTER = new CliPrinter();

    public HumanPlayer(Board BOARD, Token TOKEN) {
        this.TOKEN = TOKEN;
        this.BOARD = BOARD;
    }

    public void move(Cell cell) throws DuplicateTokenError {
        try {
            BOARD.add(TOKEN, cell);
        } catch (ArrayIndexOutOfBoundsException e) {
            PRINTER.print("Its a three by three BOARD! Starting from 0,0 (top right) and ending at 2,2 (bottom left)");
            move();
        }
    }

    public void move() {
        Response response = new Response();
        String row = response.invoke("What Row do you want to place a counter? ").getResponse();
        String col = response.invoke("What Column do you want to place a counter? ").getResponse();

        try {
            move(new Cell(Integer.parseInt(row), Integer.parseInt(col)));
        } catch (DuplicateTokenError duplicateTokenError) {
            PRINTER.print("Duplicated Cell.... Try again!");
            move();
        }
    }

    public Token getToken() {
        return TOKEN;
    }

    @Override
    public String toString() {
        return "Human!";
    }

}
