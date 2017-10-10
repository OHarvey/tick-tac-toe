public class Cell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }


    @Override
    public String toString() {
        return "[x: " + getX() + " y: " + getY() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell cell = (Cell) obj;
            if (cell.getY() == this.getY() && cell.getX() == this.getX()) {
                return true;
            }
        }
        return false;
    }
}
