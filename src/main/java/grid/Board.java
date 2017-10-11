package grid;

import throwables.DuplicateTokenError;
import types.Token;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Token EMPTY = Token.EMPTY;
    private Token[][] grid;

    public Board() {
        grid = new Token[][]{
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };
    }

    public Token[][] grid() {
        return grid;
    }


    public void add(Token token, Cell cell) throws DuplicateTokenError {
        if (grid()[cell.getX()][cell.getY()] == Token.EMPTY) {
            this.grid[cell.getX()][cell.getY()] = token;
        } else {
            throw new DuplicateTokenError("Token: " + token + " at grid.Cell: " + cell);
        }
    }

    public Token tokenAtIndex(Cell cell) {
        return this.grid[cell.getX()][cell.getY()];
    }

    public List<Line> getAllLines() {
        Cell topRight = new Cell(0, 0);
        Cell topMiddle = new Cell(0, 1);
        Cell topLeft = new Cell(0, 2);

        Cell middleRight = new Cell(1, 0);
        Cell middleMiddle = new Cell(1, 1);
        Cell middleLeft = new Cell(1, 2);

        Cell bottomRight = new Cell(2, 0);
        Cell bottomMiddle = new Cell(2, 1);
        Cell bottomLeft = new Cell(2, 2);

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(topRight, middleRight, bottomRight));
        lines.add(new Line(topMiddle, middleMiddle, bottomMiddle));
        lines.add(new Line(topLeft, middleLeft, bottomLeft));

        lines.add(new Line(topRight, topMiddle, topLeft));
        lines.add(new Line(middleRight, middleMiddle, middleLeft));
        lines.add(new Line(bottomRight, bottomMiddle, bottomLeft));

        lines.add(new Line(topLeft, middleMiddle, bottomRight));
        lines.add(new Line(topRight, middleMiddle, bottomLeft));

        return lines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                sb.append(grid[x][y] + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}