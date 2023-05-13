package Pieces;

public abstract class Piece {

    public int x, y;
    public boolean isAI;

    // the constructor for a piece
    public Piece (int x, int y, boolean isAI) {
        this.x = x;
        this.y = y;
        this.isAI = isAI;
    }

    // a function that determines if a path is valid based on piece type
    public abstract boolean isValidPath (int finalX, int finalY);
}
