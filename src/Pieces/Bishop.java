package Pieces;
import Game.*;

public class Bishop extends Piece {

    Type type;

    // the constructor for a bishop
    public Bishop (int x, int y, Player player) {
        super(x, y, player);
        type = Type.BISHOP;
    }

    // a function that checks if the bishop is moving diagonally
    public boolean isValidPath (int finalX, int finalY) {
        int xDistance = Math.abs(finalX - this.x);
        int yDistance = Math.abs(finalY - this.y);
        return xDistance == yDistance;
    }

    // a function that returns a diagonal path from one point to another
    public int[][] getPath (int startX, int startY, int finalX, int finalY) {

        // length of path
        int length = Math.abs(finalX - startX);

        // calculating direction
        int x_dir = 1, y_dir = 1;
        if (finalX - startX < 0)
            x_dir = -1;
        if (finalY - startY < 0)
            y_dir = -1;

        // populate array of coordinates
        int[][] path = new int[2][length - 1];
        if (length - 1 > 0) {
            for (int i = 0; i < length - 1; i++) {
                path[0][i] = startX + x_dir;
                path[1][i] = startY + y_dir;
            }
        }

        return path;
    }

    // a function that gets the piece type
    public Type getType() {return Type.BISHOP;}
}