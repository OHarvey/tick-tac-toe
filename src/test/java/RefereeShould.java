import grid.Board;
import grid.Cell;
import org.junit.Test;
import throwables.DuplicateTokenError;
import types.Token;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RefereeShould {

    @Test
    public void determineAWinner() throws DuplicateTokenError {
        Board board = new Board();
        board.add(Token.O, new Cell(0, 0));
        board.add(Token.O, new Cell(1, 0));
        board.add(Token.O, new Cell(2, 0));
        assertThat(Referee.whoWon(board), is(Token.O));

        Board board1 = new Board();
        board1.add(Token.O, new Cell(0, 0));
        board1.add(Token.O, new Cell(1, 1));
        board1.add(Token.O, new Cell(2, 2));
        assertThat(Referee.whoWon(board1), is(Token.O));

        Board board2 = new Board();
        board2.add(Token.X, new Cell(0, 2));
        board2.add(Token.X, new Cell(1, 1));
        board2.add(Token.X, new Cell(2, 0));
        assertThat(Referee.whoWon(board2), is(Token.X));

        Board board3 = new Board();
        board3.add(Token.X, new Cell(1, 2));
        board3.add(Token.X, new Cell(1, 1));
        board3.add(Token.X, new Cell(1, 0));
        assertThat(Referee.whoWon(board3), is(Token.X));

        Board noWinner = new Board();
        assertThat(Referee.whoWon(noWinner), is(Token.EMPTY));
    }

}
