import grid.Board;
import org.junit.Test;
import player.AiPlayer;
import player.HumanPlayer;
import player.Player;
import types.Tokens;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ApplicationShould {

    @Test
    public void createATicTacToeBoard(){
        Application application = new Application();
        Application.init();

        assertThat(application.getGameBoard(), is(notNullValue()));
        assertThat(application.getGameBoard(), is(instanceOf(Board.class)));
    }


    @Test
    public void swapPlayersAfterEachTurn(){
        Application application = new Application();
        Player currentPlayer = new HumanPlayer(application.getGameBoard(), Tokens.X);
        Application.setHuman(currentPlayer);
        Application.init();

        currentPlayer = Application.swapPlayer(currentPlayer);
        assertThat(currentPlayer, is(instanceOf(AiPlayer.class)));

        currentPlayer = Application.swapPlayer(currentPlayer);
        assertThat(currentPlayer, is(instanceOf(HumanPlayer.class)));
    }


}
