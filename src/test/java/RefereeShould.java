import grid.Board;
import grid.Cell;
import org.junit.Test;
import throwables.DuplicateTokenError;
import types.Tokens;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RefereeShould {

    @Test
    public void determineAWinner() throws DuplicateTokenError {
        Board board = new Board();
        board.add(Tokens.O, new Cell(0,0));
        board.add(Tokens.O, new Cell(1,0));
        board.add(Tokens.O, new Cell(2,0));
        assertThat(Referee.whoWon(board), is(Tokens.O));

        Board board1 = new Board();
        board1.add(Tokens.O, new Cell(0,0));
        board1.add(Tokens.O, new Cell(1,1));
        board1.add(Tokens.O, new Cell(2,2));
        assertThat(Referee.whoWon(board1), is(Tokens.O));

        Board board2 = new Board();
        board2.add(Tokens.X, new Cell(0,2));
        board2.add(Tokens.X, new Cell(1,1));
        board2.add(Tokens.X, new Cell(2,0));
        assertThat(Referee.whoWon(board2), is(Tokens.X));

        Board board3 = new Board();
        board3.add(Tokens.X, new Cell(1,2));
        board3.add(Tokens.X, new Cell(1,1));
        board3.add(Tokens.X, new Cell(1,0));
        assertThat(Referee.whoWon(board3), is(Tokens.X));

        Board noWinner = new Board();
        assertThat(Referee.whoWon(noWinner), nullValue());
    }

}
