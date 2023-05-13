package Pieces;

public abstract class Piece {

    public int x, y;

    // the constructor for a piece
    public Piece (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // a function that determines if a path is valid based on piece type
    public abstract boolean isValidPath (int finalX, int finalY);
}
