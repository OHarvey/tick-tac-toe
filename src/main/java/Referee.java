import grid.Board;
import grid.Cell;
import types.Tokens;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public static Tokens whoWon(Board board) {
        Tokens winningToken = null;
        for (List<Cell> line : board.getAllWinningLines()) {
            List<Tokens> lineOfTokens = filterEmptyTokensIn(board, line);
            if (!containsThreeOfAKind(lineOfTokens)) {
                continue;
            }
            if (notEmptyToken(winningToken)) {
                winningToken = lineOfTokens.get(0);
                System.out.println(winningToken + " Won with a line containing these cells: " + line);
            }
        }

        return winningToken;
    }

    private static List<Tokens> filterEmptyTokensIn(Board board, List<Cell> line) {
        List<Tokens> valuesInLine = new ArrayList<>();
        for (Cell cell : line) {
            Tokens token = board.tokenAtIndex(cell);
            addValidTokens(token, valuesInLine);
        }
        return valuesInLine;
    }

    private static void addValidTokens(Tokens token, List<Tokens> valuesInLine) {
        if (notEmptyToken(token)) {
            valuesInLine.add(token);
        }
    }

    private static boolean notEmptyToken(Tokens winningToken) {
        return winningToken != Tokens.EMPTY;
    }

    private static boolean containsThreeOfAKind(List<Tokens> line) {
        return line.size() == 3 && hasThreeDuplicatesIn(line);
    }

    private static boolean hasThreeDuplicatesIn(List<Tokens> valuesInLine) {
        Tokens previousToken = Tokens.EMPTY;
        int duplicateCounter = 1;
        for (Tokens token : valuesInLine) {
            if (token == previousToken) duplicateCounter++;
            previousToken = token;
        }
        return duplicateCounter == 3;
    }
}



