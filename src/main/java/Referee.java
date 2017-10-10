import java.util.ArrayList;
import java.util.List;

public class Referee {

    public static Tokens whoWon(Board board) {
        for (List<Cell> line : board.getAllWinningLines()) {
            List<Tokens> valuesInLine = new ArrayList<>();
            for (Cell cell : line) {
                Tokens value = board.tokenAtIndex(cell);
                if (notEmptyToken(value)) {
                    valuesInLine.add(value);
                }
            }
            if (containsThreeOfAKind(valuesInLine)) {
                Tokens winningToken = valuesInLine.iterator().next();
                if (notEmptyToken(winningToken)) {
                    System.out.println(winningToken + " Won with a line containing these cells: " + line);
                    return winningToken;
                }
            }
        }

        return null;
    }

    private static boolean notEmptyToken(Tokens winningToken) {
        return winningToken != Tokens.EMPTY;
    }

    private static boolean containsThreeOfAKind(List<Tokens> valuesInLine) {
        if (valuesInLine.size() != 3) {
            return false;
        }

        Tokens previousToken = Tokens.EMPTY;
        int isAThreeOfAKind = 1;
        for (Tokens token : valuesInLine) {
            if (token == previousToken) {
                isAThreeOfAKind++;
            }
            previousToken = token;
        }
        return isAThreeOfAKind == 3;
    }
}



