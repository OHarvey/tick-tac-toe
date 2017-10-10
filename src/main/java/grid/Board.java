package grid;

import throwables.DuplicateTokenError;
import types.Tokens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final Tokens EMPTY = Tokens.EMPTY;
    private Tokens[][] grid;

    public Board() {
        grid = new Tokens[][]{
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };
    }

    public Tokens[][] grid() {
        return grid;
    }


    public void add(Tokens token, Cell cell) throws DuplicateTokenError {
        if (grid()[cell.getX()][cell.getY()] == Tokens.EMPTY) {
            this.grid[cell.getX()][cell.getY()] = token;
        } else {
            throw new DuplicateTokenError("Token: " + token + " at grid.Cell: " + cell);
        }
    }

    public Tokens tokenAtIndex(Cell cell) {
        return this.grid[cell.getX()][cell.getY()];
    }

    public List<List<Cell>> getAllLines() {
        Cell topRight = new Cell(0, 0);
        Cell topMiddle = new Cell(0, 1);
        Cell topLeft = new Cell(0, 2);

        Cell middleRight = new Cell(1, 0);
        Cell middleMiddle = new Cell(1, 1);
        Cell middleLeft = new Cell(1, 2);

        Cell bottomRight = new Cell(2, 0);
        Cell bottomMiddle = new Cell(2, 1);
        Cell bottomLeft = new Cell(2, 2);

        List<List<Cell>> lines = new ArrayList<>();
        lines.add(Arrays.asList(topRight, middleRight, bottomRight));
        lines.add(Arrays.asList(topMiddle, middleMiddle, bottomMiddle));
        lines.add(Arrays.asList(topLeft, middleLeft, bottomLeft));

        lines.add(Arrays.asList(topRight, topMiddle, topLeft));
        lines.add(Arrays.asList(middleRight, middleMiddle, middleLeft));
        lines.add(Arrays.asList(bottomRight, bottomMiddle, bottomLeft));

        lines.add(Arrays.asList(topLeft, middleMiddle, bottomRight));
        lines.add(Arrays.asList(topRight, middleMiddle, bottomLeft));

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