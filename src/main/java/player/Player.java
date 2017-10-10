package player;

import grid.Cell;
import throwables.DuplicateTokenError;
import types.Tokens;

public abstract class Player {

    Tokens token;

    public Player(Tokens token) {
        this.token = token;
    }

    public abstract void move(Cell cell) throws DuplicateTokenError;

    public abstract void move();

    public Tokens getToken() {
        return token;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName().toString();
    }
}
