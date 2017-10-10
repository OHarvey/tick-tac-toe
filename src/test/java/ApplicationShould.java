import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ApplicationShould {

    @Test
    public void createATicTacToeBoard(){
        Application application = new Application();
        application.init();

        assertThat(application.getGameBoard(), is(notNullValue()));
        assertThat(application.getGameBoard(), is(instanceOf(Board.class)));
    }


    @Test
    public void swapPlayersAfterEachTurn(){
        Application application = new Application();
        Player currentPlayer = new HumanPlayer(application.getGameBoard(), Tokens.X);
        application.setHuman(currentPlayer);
        application.init();

        currentPlayer = application.swapPlayer(currentPlayer);
        assertThat(currentPlayer, is(instanceOf(AiPlayer.class)));

        currentPlayer = application.swapPlayer(currentPlayer);
        assertThat(currentPlayer, is(instanceOf(HumanPlayer.class)));
    }



}
