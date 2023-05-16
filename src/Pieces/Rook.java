package Pieces;
import Game.Player;

public class Rook extends Piece {

    /**
     * The constructor for a Rook.
     * @param x the Rook's X location
     * @param y the Rook's Y location
     * @param player the Rook's associated player
     */
    public Rook(int x, int y, Player player) {super(x, y, player);}

    /**
     * A function that determines whether the Rook is moving horizontally or vertically.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        return (finalX == this.x) || (finalY == this.y);
    }

    /**
     * A function that draws a path from one point to another based on Piece type and stores the coordinates.
     * @param startX the initial X location
     * @param startY the initial Y location
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return an array of coordinates of the given path
     */
    public int [][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pairs;
        int x_dir = 0, y_dir = 0;
        // if the rook is travelling horizontally
        if (finalX - startX !=0 && startY == finalY) {
            pairs = Math.abs(finalX - startX);
            x_dir = (finalX - startX < 0) ? -1 : 1;
        }
        // if the rook is travelling vertically
        else {
            pairs = Math.abs(finalY - startY);
            y_dir = (finalY - startY < 0) ? -1 : 1;
        }

        int [][] path = new int[2][pairs];
        if(pairs - 1 > 0) {
            for(int i = 0; i < pairs - 1; i++) {
                path[0][i] = startX + x_dir;
                path[1][i] = startY + y_dir;
            }
        }
        return path;
    }
}
