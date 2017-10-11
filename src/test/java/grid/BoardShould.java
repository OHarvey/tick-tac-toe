package grid;


import org.junit.Test;
import throwables.DuplicateTokenError;
import types.Token;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardShould {
    Token EMPTY = Token.EMPTY;

    @Test
    public void beEmptyOnCreation(){
        Board board = new Board();

        assertThat(board.grid(), is(new Token[][]{{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}}));
    }

    @Test
    public void addTokenAtIndex() throws DuplicateTokenError {
        Board board = new Board();
        Cell cell = new Cell(2, 2);

        board.add(Token.O, cell);

        assertThat(board.grid(), is(new Token[][]{{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, Token.O}}));
    }

    @Test
    public void getTokenAtIndex() throws DuplicateTokenError {
        Board board = new Board();
        Cell cell = new Cell(2, 0);

        board.add(Token.O, cell);


        assertThat(board.tokenAtIndex(cell), is(Token.O));
    }

    @Test(expected = DuplicateTokenError.class)
    public void notAllowTwoTokensOnTheSameIndex() throws DuplicateTokenError {
        Board board = new Board();
        Cell cell = new Cell(2, 0);

        board.add(Token.O, cell);
        board.add(Token.X, cell);
    }

}
