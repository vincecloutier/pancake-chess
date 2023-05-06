package Pieces;
import Game.*;
// Created by Vince Cloutier on May 6, 2023.
public class King extends Piece {
    Type type;

    /* Constructor for a King
    @param x is the x location of the King
    @param y is the y location of the King
    @param player is the Player object associated with the King
    */
    public King (int x, int y, Player player) {
        super(x, y, player);
        type = Type.KING;
    }

    /* A function that determines if the King is moving into danger.
     @param finalX is the final X location
     @param finalY is the final y location
     @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        return false;
    }

    public Type getType() {return Type.KING;}
}
