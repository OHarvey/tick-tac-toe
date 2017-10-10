public abstract class Player {

    Tokens token;

    public Player(Tokens token) {
        this.token = token;
    }

    public abstract void move(Cell cell) throws DuplicateTokenError;

    public abstract void move();
}
