package Pieces;

public class Bishop extends Piece {


    public Bishop(int x, int y) {
        super(x, y);
    }

    // a function that checks if the bishop is moving diagonally
    public boolean isValidPath (int finalX, int finalY) {
        int xDistance = Math.abs(finalX - this.x);
        int yDistance = Math.abs(finalY - this.y);
        return xDistance == yDistance;
    }


}