package Pieces;

import Game.Color;
import Game.Player;
import Game.Type;

public class Pawn extends Piece {

    Type type;

    /**
     * The constructor for a Pawn.
     * @param x the Pawn's X location
     * @param y the Pawn's Y location
     * @param player the Pawn's associated player
     */
    public Pawn (int x, int y, Player player) {
        super(x, y, player);
        type = Type.PAWN;
    }

    /**
     * A function that gets the Piece type.
     * @return  an integer indicating the Piece type
     */
    public Type getType()
    {
        return Type.PAWN;
    }

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
