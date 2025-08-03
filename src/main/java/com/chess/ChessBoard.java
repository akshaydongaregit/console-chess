package com.chess;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ChessBoard implements Serializable {

    private final Cell[][] cells = new Cell[8][8];

    public ChessBoard() {
        initChessBoard();
    }

    private void initChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String cellId = ((char) (j + 65)) + "" + (i + 1);
                Cell cell = new Cell(cellId, i, j);
                cells[i][j] = cell;
            }
        }
    }

    /**
     * Take cellId as input and return cell object for that cellId from chess board
     * @param cellId
     * @return Cell with given cellId in input
     */
    public Cell findCellById(String cellId) {
        return Arrays.stream(cells).flatMap(Arrays::stream)
                .filter(cell -> cell.getId().equals(cellId.trim().toUpperCase()))
                .findFirst().get();
    }

    /**
     * initialize new piece object with provided piece type and place it at given cell
     * @param pieceType type of piece
     * @param cellId id of cell where we want to place a piece
     */
    public void placePieceAtCell(PieceType pieceType, String cellId) {
        Cell cell = this.findCellById(cellId);
        Piece piece = new Piece(pieceType, cell);
        cell.setPiece(piece);
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }
}