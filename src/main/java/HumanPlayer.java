import java.util.Scanner;

public class HumanPlayer extends Player {

    private final Board board;


    public HumanPlayer(Board board, Tokens token) {
        super(token);
        this.board = board;
    }

    @Override
    public void move(Cell cell) throws DuplicateTokenError {
        try {
            board.add(token, cell);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Its a three by three board! Starting from 0,0 (top right) and ending at 2,2 (bottom left)");
            move();
        }
    }

    @Override
    public void move() {
        Response response = new Response().invoke();
        try {
            move(new Cell(Integer.parseInt(response.getRow()), Integer.parseInt(response.getCol())));
        } catch (DuplicateTokenError duplicateTokenError) {
            System.out.println("Duplicated Cell.... Try again!");
            move();
        }

    }

    private class Response {
        private String row;
        private String col;

        public String getRow() {
            return row;
        }

        public String getCol() {
            return col;
        }

        public Response invoke() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What Row Do You Want To add To? ");
            row = scanner.nextLine();
            System.out.println("What Column Do You Want To add To? ");
            col = scanner.nextLine();
            System.out.println("[" + getCol() +", " + getRow() + "]");
            return this;
        }
    }
}
