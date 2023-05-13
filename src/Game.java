package Chess;

import Pieces.*;

public class Game {
    private Piece[][] board;
    private boolean aiTurn;

    public Game() {
        board = new Piece[8][8];
        aiTurn = false;

        // Initialize player's pieces
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i, false);
        }
        board[0][0] = new Rook(0, 0, false);
        board[0][7] = new Rook(0, 7, false);
        board[0][1] = new Knight(0, 1, false);
        board[0][6] = new Knight(0, 6, false);
        board[0][2] = new Bishop(0, 2, false);
        board[0][5] = new Bishop(0, 5, false);
        board[0][3] = new Queen(0, 3, false);
        board[0][4] = new King(0, 4, false);

        // Initialize AI's pieces
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(6, i, true);
        }
        board[7][0] = new Rook(7, 0, true);
        board[7][7] = new Rook(7, 7, true);
        board[7][1] = new Knight(7, 1, true);
        board[7][6] = new Knight(7, 6, true);
        board[7][2] = new Bishop(7, 2, true);
        board[7][5] = new Bishop(7, 5, true);
        board[7][3] = new Queen(7, 3, true);
        board[7][4] = new King(7, 4, true);
    }

    public void playGame() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            printBoard();

            if (aiTurn) {
                // BRUTE FORCE LOGIC -> EVENTUALLY DO REAL AI
                boolean moveMade = false;

                outerloop:
                for (int startX = 0; startX < 8; startX++) {
                    for (int startY = 0; startY < 8; startY++) {
                        Piece piece = board[startX][startY];

                        if (piece != null && piece.isAI) {
                            for (int endX = 0; endX < 8; endX++) {
                                for (int endY = 0; endY < 8; endY++) {
                                    if (isValidMove(startX, startY, endX, endY)) {
                                        movePiece(startX, startY, endX, endY);
                                        moveMade = true;
                                        break outerloop;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!moveMade) {
                    System.out.println("AI cannot make a move, player wins!");
                    break;
                }
                aiTurn = !aiTurn;


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
