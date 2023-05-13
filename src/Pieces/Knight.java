package Pieces;

// Created by Vince Cloutier on May 6, 2023.
public class Knight extends Piece {

    public Knight(int x, int y, boolean isAi) {
        super(x, y, isAi);
    }
    public boolean isValidPath(int finalX, int finalY) {
        return true;
    }

    @Override
    public String toString() {
        if (isAI) {
            return "n";
        } else {
            return "N";
        }
    }
}