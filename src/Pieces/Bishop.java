package Pieces;

public class Bishop extends Piece {


    public Bishop(int x, int y, boolean isAi) {
        super(x, y, isAi);
    }

    // a function that checks if the bishop is moving diagonally
    public boolean isValidPath (int finalX, int finalY) {
        int xDistance = Math.abs(finalX - this.x);
        int yDistance = Math.abs(finalY - this.y);
        return xDistance == yDistance;
    }

    @Override
    public String toString() {
        if (isAI) {
            return "b";
        } else {
            return "B";
        }
    }
}