import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {


    @Test
    public void makeAHumanMove() throws DuplicateTokenError {
        Board board = new Board();
        Player player = new HumanPlayer(board, Tokens.X);


        Cell cell = new Cell(1, 1);
        player.move(cell);

        assertThat(board.tokenAtIndex(cell), is(Tokens.X));
    }

    @Test
    public void makeAnAiMove() throws DuplicateTokenError {
        Board board = new Board();
        Player ai = new AiPlayer(board, Tokens.O);

        Cell cell = new Cell(1, 2);
        ai.move(cell);

        assertThat(board.tokenAtIndex(cell), is(Tokens.O));
    }

}
