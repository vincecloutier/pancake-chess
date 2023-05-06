package Pieces;
import Game.*;
// Created by Vince Cloutier on May 6, 2023.
public class Knight extends Piece {
    Type type;

    /* Constructor for a Knight
    @param x is the x location of the Knight
    @param y is the y location of the Knight
    @param player is the Player object associated with the Knight
    */
    public Knight (int x, int y, Player player) {
        super(x, y, player);
        type = Type.KNIGHT;
    }

    /* A function that determines if the Knight is moving in an L.
     @param finalX is the final X location
     @param finalY is the final y location
     @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        return false;
    }

    public Type getType() {return Type.KNIGHT;}
}