package com.chess;

import java.util.List;

/**
 * Represents Walk for Pawn
 * implements getAllPossibleMoves method for piece of type Pawn
 */
public class PawnWalk implements Walk {

    @Override
    public List<Cell> getAllPossibleMoves(Cell position, ChessBoard chessBoard) {
        Cell[][] cells = chessBoard.getCells();
        int currentRow = position.getRow();
        int currentColumn = position.getCol();
        return List.of(cells[currentRow+1][currentColumn]);
    }
}
