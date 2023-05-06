package Pieces;
import Game.*;
// Created by Vince Cloutier on May 6, 2023.
public class Pawn extends Piece {
    Type type;

    /* Constructor for a Pawn
    @param x is the x location of the Pawn
    @param y is the y location of the Pawn
    @param player is the Player object associated with the Pawn
    */
    public Pawn (int x, int y, Player player) {
        super(x, y, player);
        type = Type.PAWN;
    }

    /* A function that determines if the Pawn is moving appropriately.
     @param finalX is the final X location
     @param finalY is the final y location
     @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        return false;
    }

    public Type getType() {return Type.PAWN;}
}