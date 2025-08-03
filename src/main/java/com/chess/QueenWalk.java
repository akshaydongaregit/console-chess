package com.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


/**
 * Represents Walk for Queen
 * implements getAllPossibleMoves method for piece of type Queen
 */
public class QueenWalk implements Walk {

    @Override
    public List<Cell> getAllPossibleMoves(Cell position, ChessBoard chessBoard) {
        Cell[][] cells = chessBoard.getCells();
        int currentRow = position.getRow();
        int currentColumn = position.getCol();
        List<Cell> moves = new ArrayList<>(getNextNSMoves(cells, 8, currentRow, currentColumn, +1, 0));
        moves.addAll(getNextNSMoves(cells, 8, currentRow, currentColumn, -1, 0));
        moves.addAll(getNextNSMoves(cells, 8, currentRow, currentColumn, 0, +1));
        moves.addAll(getNextNSMoves(cells, 8, currentRow, currentColumn, 0, -1));
        moves.addAll(getNextNSMoves(cells, 8, currentRow, currentColumn, +1, +1));
        moves.addAll(getNextNSMoves(cells, 8, currentRow, currentColumn, +1, -1));
        moves.addAll(getNextNSMoves(cells, 8, currentRow, currentColumn, -1, +1));
        moves.addAll(getNextNSMoves(cells, 8, currentRow, currentColumn, -1, -1));
        return moves;
    }

    public List<Cell> getNextNSMoves(Cell[][] cells, int n, int currentRow, int currentColumn,
                                     int rowUpdateFactor, int colUpdateFactor) {
        return Stream.iterate(1, i -> i + 1).limit(n)
                .map(i -> {
                    int row = currentRow + i * rowUpdateFactor;
                    int column = currentColumn + i * colUpdateFactor;
                    if (row < 8 && column < 8 && row >= 0 && column >= 0) {
                        return cells[row][column];
                    } else {
                        return null;
                    }
                }).filter(Objects::nonNull).toList();
    }
}
