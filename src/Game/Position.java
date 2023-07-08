package Game;
import java.util.Collection;

public class Position {
    byte[] squares;
    int moveNumber;
    boolean whiteAllowedCastle;
    boolean blackAllowedCastle;
    int enPassant1;
    int enPassant2;

    public boolean isCheckmate() {
        // Implementation goes here
        return false;
    }

    public boolean isStalemate() {
        // Implementation goes here
        return false;
    }

    public float evaluatePosition() {
        // Implementation goes here
        return 0;
    }

    public Collection<Position> possibleMoves() {
        // Implementation goes here
        return null;
    }
}
