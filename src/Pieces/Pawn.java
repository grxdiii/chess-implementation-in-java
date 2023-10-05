package Pieces;

import Graphic.Board;
import Graphic.Tile;

import java.util.ArrayList;

/**
 * @author Gradi Tshielekeja Mbuyi
 * @version 1.0
 */
public class Pawn extends Piece {
    private Boolean isFirstMove;

    public Pawn(String type, boolean color, int locationX, int locationY) {
        super(type, color, locationX, locationY);
        this.isFirstMove = true;
    }

    private ArrayList<Tile> whiteMoves(Board board) {
        Tile[][] squares = board.getTiles();
        ArrayList<Tile> moves = new ArrayList<>();

        if(locationY + 1 > 7) return null;
        if(!squares[locationX][locationY + 1].isOccupied) moves.add(squares[locationX][locationY + 1]);
        if(isFirstMove && !squares[locationX][locationY + 2].isOccupied) moves.add(squares[locationX][locationY + 2]);
        if(locationX - 1 >= 0 && squares[locationX - 1][locationY + 1].checkPieceColor() != color) moves.add(squares[locationX - 1][locationY + 1]);
        if(locationX + 1 <= 7 && squares[locationX + 1][locationY + 1].checkPieceColor() != color) moves.add(squares[locationX + 1][locationY + 1]);
        return moves;
    }

    private ArrayList<Tile> blackMoves(Board board) {
        Tile[][] squares = board.getTiles();
        ArrayList<Tile> moves = new ArrayList<>();

        return moves;
    }

    @Override
    public ArrayList<Tile> legalMoves(Board board) {
        if(color) return whiteMoves(board);
        return blackMoves(board);
    }
}
