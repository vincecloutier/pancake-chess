package Pieces;
import Game.Player;

public class Pancake extends Piece {

    /**
     * The constructor for a Pancake.
     * @param x the Pancake's X location
     * @param y the Pancake's Y location
     * @param player the Pancake's associated player
     */
    public Pancake (int x, int y, Player player) {super(x, y, player);}

    /**
     * A function that determines whether the Pancake is trying to capture or not.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        return this.player.myGame.gameBoard.boardArray[finalX][finalY] == null;
    }

    /**
     * A function that draws a path from one point to another based on Piece type and stores the coordinates.
     * @param startX the initial X location
     * @param startY the initial Y location
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return an array of coordinates of the given path
     */
    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {
        return new int[2][0]; // since Pancakes can go anywhere, a path is unnecessary
    }
}
