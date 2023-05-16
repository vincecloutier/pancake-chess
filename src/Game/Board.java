package Game;
import Exceptions.InvalidMovementException;
import Pieces.*;
import java.util.Vector;

/**
 * Created by Anne on 9/11/2014.
 */
public class Board {

    public Piece[][] boardArray;
    public Game game; //Boards can access information about players, pieces and turns.
    public Vector<Piece> whitePieces = new Vector<Piece>(16);
    public Vector<Piece> blackPieces = new Vector<Piece>(16);

    /**
     * The constructor for a board.
     * @param game the game associated with this board
     */
    public Board(Game game) {
        boardArray = new Piece[8][8];
        this.game = game;
    }

    /**
     * Sets pieces on the board and initializes lists of pieces.
     */
    public void setPieces() {

        // Pawns
        for(int i = 0; i < 8; i++) {
            new Pawn(i, 6, this.game.player1);
            new Pawn(i, 1, this.game.player2);
        }

        // Player 1's Named Pieces
        new Rook(0, 7, this.game.player1);
        new Rook(7, 7, this.game.player1);
        new Knight(1, 7, this.game.player1);
        new Knight(6,7, this.game.player1);
        new Bishop(2, 7, this.game.player1);
        new Bishop(5, 7, this.game.player1);
        new Queen(3, 7, this.game.player1);
        new King(4, 7, this.game.player1);

        // Player 2's Named Pieces
        new Rook(0, 0, this.game.player2);
        new Rook(7, 0, this.game.player2);
        new Knight(1, 0, this.game.player2);
        new Knight(6, 0, this.game.player2);
        new Bishop(2, 0, this.game.player2);
        new Bishop(5, 0, this.game.player2);
        new Queen(3, 0, this.game.player2);
        new King(4, 0, this.game.player2);

        // Initialize the game's vectors for both Player 1 and Player 2's pieces.
        for(int i = 0; i < 8; i++) {
            whitePieces.add(this.boardArray[i][6]);
            whitePieces.add(this.boardArray[i][7]);
            blackPieces.add(this.boardArray[i][0]);
            blackPieces.add(this.boardArray[i][1]);
        }
    }

    /**
     * A function to move a piece. It checks to see if the move is valid for any piece, then it checks if
     * that move is valid based on the piece's specific type. It handles capturing, then sets the new location.
     * @param piece the piece to move
     * @param finalX the final X location
     * @param finalY the final Y location
     */
    public void movePiece(Piece piece, int finalX, int finalY) {
        if(isValidMove(piece, finalX, finalY) && piece.isValidPath(finalX, finalY)) {
            if(isCapture(piece, finalX, finalY)) {
                game.capture = true;
                boardArray[finalX][finalY] = null;
            }
            setNewPieceLocation(piece, finalX, finalY);
        } else {
            try {
                throw new InvalidMovementException();
            } catch (InvalidMovementException e) {
                e.printStackTrace();
                game.invalid = true;
            }
        }
    }


    /**
     * A function that determines whether a move is valid for any piece based on the following: 1) the move is within
     * the board's bounds, 2) the move does not involve invalid leaping, 3) the move is not the same as the
     * start location, 4) the move coordinates do not land on an ally piece, and 5) that the player's king is
     * not in check (meaning the player has to move the king).
     * @param piece the piece to move
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether the move is valid
     */
    public boolean isValidMove(Piece piece, int finalX, int finalY) {
        // TODO: Make it so that pieces can't move if the king is in check
        int [][] path = piece.drawPath(piece.x, piece.y, finalX, finalY);
        return isWithinBounds(finalX, finalY) && (validLeaping(piece, path)) && (isNotOrigin(piece, finalX, finalY))
                && (isValidEndPoint(piece, finalX, finalY));
    }

    /**
     * A function determining if coordinates are in bounds of the board.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return  a boolean indicating whether the coordinates are in bounds
     */
    protected boolean isWithinBounds(int finalX, int finalY) {
        return (0 <= finalX && finalX < 8) && (0 <= finalY && finalY < 8);
    }

    /**
     * A function determining if a given path involves invalid leaping for a specific piece.
     * @param piece the piece to move
     * @param movePath the path of the piece, not including origin or endpoint
     * @return  a boolean indicating if there is invalid leaping
     */
    protected boolean validLeaping(Piece piece, int[][] movePath) {
        if(piece.getType() == Type.KNIGHT)
            return true;

        int pairs = movePath[0].length;
        for(int i = 0; i < pairs - 1; i++) {
            if(boardArray[movePath[0][i]][movePath[1][i]] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * A function determining if a given move lands on the origin.
     * @param piece the piece to move
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether the end coordinates are the same as the start coordinates
     */
    protected boolean isNotOrigin(Piece piece, int finalX, int finalY) {
        return (piece.x != finalX) || (piece.y != finalY);
    }

    /**
     * A function determining if a move lands on an allied piece.
     * @param piece the piece to move
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return  a boolean indicating whether the end coordinates are valid
     */
    protected boolean isValidEndPoint(Piece piece, int finalX, int finalY) {
        return (boardArray[finalX][finalY] == null) || ((boardArray[finalX][finalY] != null)
                && boardArray[finalX][finalY].player.playerColor != piece.player.playerColor);
    }

    /**
     * A function determining if the move results in a capture.
     * @param piece the piece to move
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether a capture will occur
     */
    public boolean isCapture(Piece piece, int finalX, int finalY) {
        if(boardArray[finalX][finalY]!= null && boardArray[finalX][finalY].player != piece.player) {
            if(boardArray[finalX][finalY].getType() == Type.KING) {
                boardArray[finalX][finalY].player.isLoser = true;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * A function that transfers a piece to a new location, and clears the board space at
     * its previous location.
     * @param piece the piece to move
     * @param finalX the final X location
     * @param finalY the final Y location
     */
    public void setNewPieceLocation(Piece piece, int finalX, int finalY) {
        int originX = piece.x;
        int originY = piece.y;

        // set piece's new location
        piece.x = finalX;
        piece.y = finalY;

        boardArray[finalX][finalY] = piece; // set array to new piece's position
        boardArray[originX][originY] = null; // set starting point to empty
    }
}
