package Chess;

import Pieces.*;

public class Game {
    private Piece[][] board;
    private boolean aiTurn;

    public Game() {
        board = new Piece[8][8]; // standard chess board size
        aiTurn = false; // let's say the player moves first

        // Initialize player's pieces
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i, false); // Pawns
        }
        board[0][0] = new Rook(0, 0, false); // Rooks
        board[0][7] = new Rook(0, 7, false);
        board[0][1] = new Knight(0, 1, false); // Knights
        board[0][6] = new Knight(0, 6, false);
        board[0][2] = new Bishop(0, 2, false); // Bishops
        board[0][5] = new Bishop(0, 5, false);
        board[0][3] = new Queen(0, 3, false); // Queen
        board[0][4] = new King(0, 4, false); // King

        // Initialize AI's pieces
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(6, i, true); // Pawns
        }
        board[7][0] = new Rook(7, 0, true); // Rooks
        board[7][7] = new Rook(7, 7, true);
        board[7][1] = new Knight(7, 1, true); // Knights
        board[7][6] = new Knight(7, 6, true);
        board[7][2] = new Bishop(7, 2, true); // Bishops
        board[7][5] = new Bishop(7, 5, true);
        board[7][3] = new Queen(7, 3, true); // Queen
        board[7][4] = new King(7, 4, true); // King
    }

    public void playGame() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            printBoard();

            if (aiTurn) {
                // AI logic here
                // ... left out for brevity

            } else {
                System.out.println("Enter your move (startX startY endX endY): ");

                int startX = scanner.nextInt();
                int startY = scanner.nextInt();
                int endX = scanner.nextInt();
                int endY = scanner.nextInt();

                if (isValidMove(startX, startY, endX, endY)) {
                    movePiece(startX, startY, endX, endY);
                    aiTurn = !aiTurn;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece == null) {
                    System.out.print("-");
                } else {
                    System.out.print(piece);
                }
            }
            System.out.println();
        }
    }

    private boolean isValidMove(int startX, int startY, int endX, int endY) {
        Piece piece = board[startX][startY];
        if (piece == null || piece.isAI == aiTurn) {
            return false;
        }

        return piece.isValidPath(endX, endY);
    }

    private void movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board[startX][startY];
        board[startX][startY] = null;
        board[endX][endY] = piece;
        piece.x = endX;
        piece.y = endY;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
