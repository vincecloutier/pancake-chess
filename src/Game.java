import Pieces.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    private static ArrayList<Piece> whitePieces;
    private static ArrayList<Piece> blackPieces;

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

        // Place pawns
        for (int i = 0; i < 8; i++) {
            whitePieces.add(new Pawn(i, 1));
            blackPieces.add(new Pawn(i, 6));
        }

        // Place white pieces


        // Place black pieces

    }

    private static void printBoard() {

    }


    private static void makeMove(String move) {

    }

}

