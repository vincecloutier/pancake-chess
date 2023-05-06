package Pieces;
import Game.*;
// Created by Vince Cloutier on May 6, 2023.
public abstract class Piece {
    public int x, y;
    public Player player;

    /* Constructor for a Piece
     @param x is the x location of the Piece
     @param y is the y location of the Piece
     @param player is the Player object associated with the Piece
     */
    public Piece (int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;

    }

    /* A function that determines if their path is valid based on Piece type.
     @param finalX is the final X location
     @param finalY is the final y location
     @return a boolean indicating whether the path is valid
     */
    public abstract boolean isValidPath (int finalX, int finalY);

    public abstract Type getType();
}
