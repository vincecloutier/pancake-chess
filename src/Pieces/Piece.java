package Pieces;
import Game.*;

public abstract class Piece {

    public int x, y;
    public Player player;

    // the constructor for a piece
    public Piece (int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;

    }

    // a function that determines if a path is valid based on piece type
    public abstract boolean isValidPath (int finalX, int finalY);

    // a function that returns a path from one point to another based on piece type
    public abstract int[][] getPath(int startX, int startY, int finalX, int finalY);

    // a function that gets the piece type
    public abstract Type getType();
}
