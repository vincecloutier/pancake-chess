import Pieces.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {

        createPieces();
        boolean whiteTurn = true;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();

            String player = whiteTurn ? "White" : "Black";
            System.out.println(player + "'s turn. Enter move (e.g. e2 e4): ");
            String move = scanner.nextLine();

            if (move.equalsIgnoreCase("quit")) {
                System.out.println("Game over. Quitting...");
                break;
            }

            makeMove(move);
            whiteTurn = !whiteTurn;
        }

        scanner.close();
    }

    private static void createPieces() {

        ArrayList<Piece> humanPieces = new ArrayList<>();
        ArrayList<Piece> aiPieces = new ArrayList<>();

        // Place pawns
        for (int i = 0; i < 8; i++) {
            humanPieces.add(new Pawn(i, 1, false));
            aiPieces.add(new Pawn(i, 6, true));
        }

        // Place human pieces
        humanPieces.add(new Rook(0, 0, false));
        humanPieces.add(new Knight(1, 0, false));
        humanPieces.add(new Bishop(2, 0, false));
        humanPieces.add(new Queen(3, 0, false));
        humanPieces.add(new King(4, 0, false));
        humanPieces.add(new Bishop(5, 0, false));
        humanPieces.add(new Knight(6, 0, false));
        humanPieces.add(new Rook(7, 0, false));

        // Place ai pieces
        aiPieces.add(new Rook(0, 7, true));
        aiPieces.add(new Knight(1, 7, true));
        aiPieces.add(new Bishop(2, 7, true));
        aiPieces.add(new Queen(3, 7, true));
        aiPieces.add(new King(4, 7, true));
        aiPieces.add(new Bishop(5, 7, true));
        aiPieces.add(new Knight(6, 7, true));
        aiPieces.add(new Rook(7, 7, true));

    }

    private static void printBoard() {

    }


    private static void makeMove(String move) {

    }

}

