package Pieces;
import Game.*;
// Created by Vince Cloutier on May 6, 2023.
public class Bishop extends Piece {
    Type type;

    /* Constructor for a Bishop
    @param x is the x location of the Bishop
    @param y is the y location of the Bishop
    @param player is the Player object associated with the Bishop
    */
    public Bishop (int x, int y, Player player) {
        super(x, y, player);
        type = Type.BISHOP;
    }

    /* A function that determines if the Bishop is moving diagonally.
     @param finalX is the final X location
     @param finalY is the final y location
     @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        return false;
    }

    public Type getType() {return Type.BISHOP;}
}