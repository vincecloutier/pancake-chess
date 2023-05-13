package Pieces;


// Created by Vince Cloutier on May 6, 2023.
public class Queen extends Piece {

    public Queen(int x, int y, boolean isAi) {
        super(x, y, isAi);
    }

    public boolean isValidPath(int finalX, int finalY) {
        return false;
    }

}