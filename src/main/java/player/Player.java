package player;

import grid.Cell;
import throwables.DuplicateTokenError;
import types.Token;

public interface Player {

    void move(Cell cell) throws DuplicateTokenError;

    void move();

    Token getToken();

}
