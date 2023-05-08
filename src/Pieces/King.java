package Pieces;
import Game.*;

public class King extends Piece {

    Type type;

    // the constructor for a king
    public King (int x, int y, Player player) {
        super(x, y, player);
        type = Type.KING;
    }

    // a function that checks if the king is moving only one square
    public boolean isValidPath (int finalX, int finalY) {
        int xDistance = Math.abs(finalX - this.x);
        int yDistance = Math.abs(finalY - this.y);
        return xDistance == yDistance;
    }

    // TODO ADD CHECK / CHECKMATE CHECKER HERE
    // TODO INTEGRATE THIS CHECKER INTO ISVALIDPATH

    // a function that returns a path from one point to another
    public int[][] getPath (int startX, int startY, int finalX, int finalY) {
        // note that kings will never have a path
        int length = 0;
        return new int[2][length];
    }

    // a function that gets the piece type
    public Type getType() {return Type.KING;}
}