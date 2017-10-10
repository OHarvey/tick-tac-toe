import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardShould {
    Tokens EMPTY = Tokens.EMPTY;

    @Test
    public void beEmptyOnCreation(){
        Board board = new Board();

        assertThat(board.grid(), is(new Tokens[][]{{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY},{EMPTY, EMPTY, EMPTY}}));
    }

    @Test
    public void addTokenAtIndex() throws DuplicateTokenError {
        Board board = new Board();
        Cell cell = new Cell(2, 2);

        board.add(Tokens.O, cell);

        assertThat(board.grid(), is(new Tokens[][]{{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY},{EMPTY, EMPTY, Tokens.O}}));
    }

    @Test
    public void getTokenAtIndex() throws DuplicateTokenError {
        Board board = new Board();
        Cell cell = new Cell(2, 0);

        board.add(Tokens.O, cell);


        assertThat(board.tokenAtIndex(cell), is(Tokens.O));
    }

    @Test(expected = DuplicateTokenError.class)
    public void notAllowTwoTokensOnTheSameIndex() throws DuplicateTokenError {
        Board board = new Board();
        Cell cell = new Cell(2, 0);

        board.add(Tokens.O, cell);
        board.add(Tokens.X, cell);
    }

}
