package Game;

public class Game {

    public Board gameBoard;
    public Player player1, player2;
    public int turn;
    public boolean invalid = false, capture = false;

    // this constructor sets up a standard game with two players
    // where player1 is white and player2 is black
    public Game() {
        gameBoard = new Board(this);
        player1 = new Player(this, true, true);
        player2 = new Player(this, false, false);
        gameBoard.setPieces();
        turn = 1;
    }
}