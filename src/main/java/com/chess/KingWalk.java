package com.chess;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents Walk for King
 * implements getAllPossibleMoves method for piece of type King
 */
public class KingWalk implements Walk {

    @Override
    public List<Cell> getAllPossibleMoves(Cell position, ChessBoard chessBoard) {
        Cell[][] cells = chessBoard.getCells();
        int currentRow = position.getRow();
        int currentColumn = position.getCol();
        List<Cell> possibleMoves = new ArrayList<>();

        addMoveIfWithinBounds(possibleMoves, cells, currentRow+1, currentColumn);
        addMoveIfWithinBounds(possibleMoves, cells, currentRow-1, currentColumn);
        addMoveIfWithinBounds(possibleMoves, cells, currentRow, currentColumn+1);
        addMoveIfWithinBounds(possibleMoves, cells, currentRow, currentColumn-1);
        addMoveIfWithinBounds(possibleMoves, cells, currentRow+1, currentColumn+1);
        addMoveIfWithinBounds(possibleMoves, cells, currentRow+1, currentColumn-1);
        addMoveIfWithinBounds(possibleMoves, cells, currentRow-1, currentColumn+1);
        addMoveIfWithinBounds(possibleMoves, cells, currentRow-1, currentColumn-1);

        return possibleMoves;
    }

    public void addMoveIfWithinBounds(List<Cell> moves, Cell[][] cells, int row, int column) {
        if( row<8 && row>=0 && column<8 && column>=0) {
            moves.add(cells[row][column]);
        }
    }
}
