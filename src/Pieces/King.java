package Pieces;

public class King extends Piece {


    public King(int x, int y) {
        super(x, y);
    }

    // a function that checks if the king is moving only one square
    public boolean isValidPath (int finalX, int finalY) {
        int xDistance = Math.abs(finalX - this.x);
        int yDistance = Math.abs(finalY - this.y);
        return xDistance == yDistance;
    }

}