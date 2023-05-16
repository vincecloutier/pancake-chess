package Game;


public class Game {

    public Board gameBoard;
    public Player player1, player2;
    public int turn;
    public boolean invalid = false, capture = false;

    /**
     * Default constructor for a game.
     */
    public Game() {
        gameBoard = new Board(this);
        player1 = new Player(Color.WHITE, true);
        player2 = new Player(Color.BLACK, false);
        player1.myGame = this;
        player2.myGame = this;
        gameBoard.setPieces();
        turn = 1;
    }
}
