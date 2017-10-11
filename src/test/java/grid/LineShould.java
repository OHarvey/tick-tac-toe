package grid;

import org.junit.Test;
import throwables.DuplicateTokenError;
import types.Token;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class LineShould {

    @Test
    public void getTokensInTheLine() throws DuplicateTokenError {
        Board board = new Board();
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);
        Cell cell3 = new Cell(0, 2);
        board.add(Token.O, cell1);
        board.add(Token.X, cell2);
        board.add(Token.O, cell3);

        Line line = new Line(cell1, cell2, cell3);

        assertThat(line.getTokensInLineFrom(board), containsInAnyOrder(Token.O, Token.O, Token.X));

    }

    @Test
    public void getTokenIfTheLineIsAWinner() throws DuplicateTokenError {
        Board board = new Board();
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);
        Cell cell3 = new Cell(0, 2);
        board.add(Token.X, cell1);
        board.add(Token.X, cell2);
        board.add(Token.X, cell3);

        Line line = new Line(cell1, cell2, cell3);

        assertThat(line.isLineAWinnerIn(board), is(Token.X));

    }


}
