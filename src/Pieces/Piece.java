package Pieces;
import Game.Player;

public abstract class Piece {

    public int x, y;
    public Player player;

    /**
     * Constructor for a Piece.
     * @param x the x location of the Piece
     * @param y the y location of the Piece
     * @param player the Player object associated with the Piece
     */
    public Piece(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.player.myGame.gameBoard.boardArray[x][y] = this;
    }

    /**
     * A function that determines if their path is valid based on Piece type.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return  a boolean indicating whether the path is valid
     */
    public abstract boolean isValidPath(int finalX, int finalY);

    /**
     * A function that draws a path from one point to another based on Piece type and stores the coordinates.
     * @param startX the initial X location
     * @param startY the initial Y location
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return an array of coordinates of the given path
     */
    public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);

    /**
     * A function that gets the co-ordinate pairs of a path from one point to another.
     * @param startX the initial X location
     * @param startY the initial Y location
     * @param pairs the number of co-ordinate pairs in the path
     * @param x_dir the X direction of the path
     * @param y_dir the Y direction of the path
     * @return an array of coordinates of the given path
     */
    public static int[][] getPairs(int startX, int startY, int pairs, int x_dir, int y_dir) {
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
