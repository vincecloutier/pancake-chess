package Game;
import Pieces.*;

public class Player {
    public Game myGame;
    public boolean isWhite;
    public boolean goesFirst;
    public boolean isLoser = false;
    public boolean isTurn = false;
    public int score = 0;

    /* The constructor for a Player.
    @param isWhite says if the player is white
    @param goesFirst says if the player goes first
    */
    public Player(Game myGame, boolean isWhite, boolean goesFirst) {
        this.myGame = myGame;
        this.isWhite = isWhite;
        this.goesFirst = goesFirst;
    }

}
