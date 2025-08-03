package com.chess;

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
        return List.of(cells[currentRow+1][currentColumn], cells[currentRow-1][currentColumn],
                cells[currentRow][currentColumn+1], cells[currentRow][currentColumn-1],
                cells[currentRow+1][currentColumn+1], cells[currentRow+1][currentColumn-1],
                cells[currentRow-1][currentColumn+1], cells[currentRow-1][currentColumn-1]);
    }
}
