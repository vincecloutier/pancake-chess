package Pieces;
import Game.Position;
import java.util.Collection;
public interface Piece {
    Collection<Position> possibleMoves(int x, int y, Position position);
}
