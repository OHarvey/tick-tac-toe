public class AiPlayer extends Player {
    private Board board;

    public AiPlayer(Board board, Tokens token) {
        super(token);
        this.board = board;
    }


    @Override
    public void move(Cell cell) throws DuplicateTokenError {
        board.add(token, cell);
    }

    @Override
    public void move() {
        System.out.println("Doing Nothing... for now. ");
    }
}
