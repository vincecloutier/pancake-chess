package Pieces;

public class King extends Piece {


    public King(int x, int y, boolean isAi) {
        super(x, y, isAi);
    }
    // a function that checks if the king is moving only one square
    public boolean isValidPath (int finalX, int finalY) {
        int xDistance = Math.abs(finalX - this.x);
        int yDistance = Math.abs(finalY - this.y);
        return xDistance == yDistance;
    }

    @Override
    public String toString() {
        if (isAI) {
            return "k";
        } else {
            return "K";
        }
    }
}