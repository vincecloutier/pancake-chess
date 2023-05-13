import java.util.Scanner;

public class Game {
    private static final int BOARD_SIZE = 8;

    private static char[][] board;
    private static boolean whiteTurn;

    public static void main(String[] args) {
        initializeBoard();
        whiteTurn = true;

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

            if (!isValidMove(move)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            makeMove(move);
            whiteTurn = !whiteTurn;
        }

        scanner.close();
    }

    private static void initializeBoard() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        // Initialize the chess board with empty squares
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }

        // Place white pieces
        board[0][0] = 'r'; // rook
        board[0][1] = 'n'; // knight
        board[0][2] = 'b'; // bishop
        board[0][3] = 'q'; // queen
        board[0][4] = 'k'; // king
        board[0][5] = 'b'; // bishop
        board[0][6] = 'n'; // knight
        board[0][7] = 'r'; // rook

        for (int i = 0; i < BOARD_SIZE; i++) {
            board[1][i] = 'p'; // pawns
        }

        // Place black pieces
        board[7][0] = 'R'; // rook
        board[7][1] = 'N'; // knight
        board[7][2] = 'B'; // bishop
        board[7][3] = 'Q'; // queen
        board[7][4] = 'K'; // king
        board[7][5] = 'B'; // bishop
        board[7][6] = 'N'; // knight
        board[7][7] = 'R'; // rook

        for (int i = 0; i < BOARD_SIZE; i++) {
            board[6][i] = 'P'; // pawns
        }
    }

    private static void printBoard() {
        System.out.println("  a b c d e f g h");
        System.out.println(" -----------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((BOARD_SIZE - i) + "|");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println(" " + (BOARD_SIZE - i));
            System.out.println(" -----------------");
        }
        System.out.println("  a b c d e f g h");
    }

    private static boolean isValidMove(String move) {
        if (move.length() != 5) {
            return false;
        }

        int startX = move.charAt(0) - 'a';
        int startY = Integer.parseInt(move.charAt(1) + "") - 1;
        int endX = move.charAt(3) - 'a';
        int endY = Integer.parseInt(move.charAt(4) + "") - 1;

        // Check if the start and end positions are within the board
        if (startX < 0 || startX >= BOARD_SIZE || startY < 0 || startY >= BOARD_SIZE ||
                endX < 0 || endX >= BOARD_SIZE || endY < 0 || endY >= BOARD_SIZE) {
            return false;
        }

        // Check if the piece at the start position belongs to the player
        char piece = board[startY][startX];
        if (whiteTurn && Character.isLowerCase(piece) || !whiteTurn && Character.isUpperCase(piece)) {
            return false;
        }

        // Check if the piece can make the given move
        switch (Character.toLowerCase(piece)) {
            case 'p':
                // Check pawn's move logic
                if (startY == 1) {
                    // Check if it's the pawn's first move
                    return (endY == startY + 1 || endY == startY + 2) && endX == startX;
                } else {
                    return endY == startY + 1 && endX == startX;
                }
            case 'r':
                // Check rook's move logic
                return startX == endX || startY == endY;
            case 'n':
                // Check knight's move logic
                return (Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 1) ||
                        (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 2);
            case 'b':
                // Check bishop's move logic
                return Math.abs(startX - endX) == Math.abs(startY - endY);
            case 'q':
                // Check queen's move logic
                return startX == endX || startY == endY || Math.abs(startX - endX) == Math.abs(startY - endY);
            case 'k':
                // Check king's move logic
                return Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
            default:
                return false;
        }
    }

    private static void makeMove(String move) {
        int startX = move.charAt(0) - 'a';
        int startY = Integer.parseInt(move.charAt(1) + "") - 1;
        int endX = move.charAt(3) - 'a';
        int endY = Integer.parseInt(move.charAt(4) + "") - 1;

        char piece = board[startY][startX];
        board[startY][startX] = ' ';
        board[endY][endX] = piece;
    }
}

