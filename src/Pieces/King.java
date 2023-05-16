package Pieces;
import Game.Player;

public class King extends Piece {

    /**
     * The constructor for a King.
     * @param x the King's X location
     * @param y the King's Y location
     * @param player the King's associated player
     */
    public King(int x, int y, Player player) {super(x, y, player);}

    /**
     * A function that determines whether the King is moving one space in any direction, is not in check, and
     * is not in checkmate.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        int x_diff = Math.abs(finalX - this.x);
        int y_diff = Math.abs(finalY - this.y);
        return (x_diff < 2) && (y_diff < 2);
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
        return new int[2][0]; // kings will never have a path since they can only move one square
    }
}
