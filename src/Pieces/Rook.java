package Pieces;

import Game.Player;
import Game.Type;

// Created by Vince Cloutier on May 6, 2023.
public class Rook extends Piece {
    Type type;

    /* Constructor for a Rook
    @param x is the x location of the Rook
    @param y is the y location of the Rook
    @param player is the Player object associated with the Rook
    */
    public Rook (int x, int y, Player player) {
        super(x, y, player);
        type = Type.ROOK;
    }

    /* A function that determines if the Rook is moving straight.
     @param finalX is the final X location
     @param finalY is the final y location
     @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        return false;
    }

    public Type getType() {return Type.ROOK;}
}