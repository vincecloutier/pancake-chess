package Game;
import Pieces.*;
import java.util.Vector;

/**
 * Created by Anne on 9/11/2014.
 */
public class Player {

    public boolean goesFirst;
    public boolean isLoser = false;
    public Game myGame;
    public boolean isTurn = false;

    /**
     * Constructor for a Player.
     * @param goesFirst if the Player goes first
     */
    public Player(boolean goesFirst)  {
        this.goesFirst = goesFirst;
    }

    /**
     * Gets a list of the Player's pieces.
     * @return allyPieces a vector of the Player's pieces
     */
    public Vector<Piece> getAllyPieces() {
        return goesFirst ? myGame.gameBoard.whitePieces : myGame.gameBoard.blackPieces;
    }

    /**
     * Gets a list of the enemy's pieces.
     * @return enemyPieces  a vector of the enemy's pieces
     */
    public Vector<Piece> getEnemyPieces() {
        return goesFirst ? myGame.gameBoard.blackPieces : myGame.gameBoard.whitePieces;
    }
}
