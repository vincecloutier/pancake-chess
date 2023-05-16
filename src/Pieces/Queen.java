package Pieces;

import Game.Player;
import Game.Type;
/**
 * Created by Anne on 9/11/2014.
 */
public class Queen extends Piece {

    Type type;

    /**
     * The constructor for a Queen.
     * @param x the Queen's X location
     * @param y the Queen's Y location
     * @param player the Queen's associated player
     */
    public Queen(int x, int y, Player player) {
        super(x, y, player);
        type = Type.QUEEN;
    }

    /**
     * A function that gets the Piece type.
     * @return  an integer indicating the Piece type
     */
    public Type getType() {
        return Type.QUEEN;
    }

    /**
     * A function that determines whether the Queen is moving horizontally, vertically, or diagonally.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        int x_diff = Math.abs(finalX - this.x);
        int y_diff = Math.abs(finalY - this.y);
        return (x_diff == y_diff) || (finalX == this.x) || (finalY == this.y);
    }

    /**
     * A function that draws a path from one point to another based on Piece type and stores the coordinates.
     * @param startX   the initial X location
     * @param startY   the initial Y location
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return an array of coordinates of the given path
     */
    public int [][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pairs;
        int x_dir = 0, y_dir = 0;

        // the queen is travelling horizontally
        if(finalY == startY) {
            pairs = Math.abs(finalX - startX);
            x_dir = (finalX - startX < 0) ? -1 : 1;
        }
        // the queen is travelling vertically
        else if (finalX == startX) {
            pairs = Math.abs(finalY - startY);
            y_dir = (finalY - startY < 0) ? -1 : 1;
        }
        // the queen is travelling diagonally
        else {
            pairs = Math.abs(finalX - startX);
            x_dir = (finalX - startX < 0) ? -1 : 1;
            y_dir = (finalY - startY < 0) ? -1 : 1;
        }

        int [][] path = new int[2][pairs];
        if (pairs - 1 > 0) {
            for (int i = 0; i < pairs - 1; i++) {
                path[0][i] = startX + x_dir;
                path[1][i] = startY + y_dir;
            }
        }
        return path;
    }
}
