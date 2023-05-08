package Game;
import Pieces.*;

public class Board {
    private Piece[][] boardArray; // the board itself, represented as a 2D array of ChessPiece objects
    public Game game;

    public Board(Game game) {
        boardArray = new Piece[8][8]; // this sets it to the chess standard of 8 x 8
        this.game = game;
    }

    // initializes the board with starting positions of all the pieces
    public void setPieces() {
        // place pawns on row 2 and 7
        for (int i = 0; i < 8; i++) {
            boardArray[i][1] = new Pawn(i, 1, this.game.player2);
            boardArray[i][6] = new Pawn(i, 6, this.game.player1);
        }

        // place rooks, knights, bishops, queens, and kings on row 1 and 8
        boardArray[0][0] = new Rook(0, 0, this.game.player2);
        boardArray[0][7] = new Rook(0, 7, this.game.player2);
        boardArray[0][1] = new Knight(0, 1, this.game.player2);
        boardArray[0][6] = new Knight(0, 6, this.game.player2);
        boardArray[0][2] = new Bishop(0, 2, this.game.player2);
        boardArray[0][5] = new Bishop(0, 6, this.game.player2);
        boardArray[0][3] = new Queen(0, 3, this.game.player2);
        boardArray[0][4] = new King(0, 4, this.game.player2);

        boardArray[7][0] = new Rook(7,0, this.game.player1);
        boardArray[7][7] = new Rook(7,7, this.game.player1);
        boardArray[7][1] = new Knight(7,1, this.game.player1);
        boardArray[7][6] = new Knight(7, 6, this.game.player1);
        boardArray[7][2] = new Bishop(7,2, this.game.player1);
        boardArray[7][5] = new Bishop(7,5, this.game.player1);
        boardArray[7][3] = new Queen(7, 3, this.game.player1);
        boardArray[7][4] = new King(7,4, this.game.player1);
    }
}