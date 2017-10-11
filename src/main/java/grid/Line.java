package grid;

import types.Token;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Cell> lineCells = new ArrayList<>();

    public Line(Cell... cells) {
        for (Cell cell : cells) {
            lineCells.add(cell);
        }
    }

    private static void addValidToken(Token token, List<Token> valuesInLine) {
        if (notEmptyToken(token)) {
            valuesInLine.add(token);
        }
    }

    private static boolean notEmptyToken(Token token) {
        return token != Token.EMPTY;
    }

    public Token isLineAWinnerIn(Board board) {
        List<Token> tokensInLine = getTokensInLineFrom(board);
        Token previousTokenFromBoard = Token.EMPTY;
        int counter = 1;
        for (Token currentTokenFromBoard : tokensInLine) {
            if (currentTokenFromBoard == previousTokenFromBoard) {
                counter++;
            }
            previousTokenFromBoard = currentTokenFromBoard;
        }
        return counter == getLineCells().size() ? tokensInLine.get(0) : Token.EMPTY;
    }

    public List<Token> getTokensInLineFrom(Board board) {
        List<Token> tokenInLine = new ArrayList<>();
        for (Cell cell : getLineCells()) {
            Token token = board.tokenAtIndex(cell);
            addValidToken(token, tokenInLine);
        }
        return tokenInLine;
    }

    private List<Cell> getLineCells() {
        return lineCells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell cell : getLineCells()) {
            sb.append("[" + cell.toString() + "]");
        }
        return sb.toString();
    }
}
