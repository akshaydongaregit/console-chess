package com.chess.dto;

import com.chess.constants.PieceType;
import com.chess.exception.NotFoundException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

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
     * @param cellId cell id
     * @return Cell with given cellId in input
     */
    public Cell findCellById(String cellId) throws NotFoundException {
        Optional<Cell> matchingCell = Arrays.stream(cells).flatMap(Arrays::stream)
                .filter(cell -> cell.getId().equals(cellId.trim().toUpperCase()))
                .findFirst();
        if(!matchingCell.isPresent()) {
            throw new NotFoundException("Invalid cell, Cell with id " + cellId + " not found on chessboard.");
        }
        return matchingCell.get();
    }

    /**
     * initialize new piece object with provided piece type and place it at given cell
     * @param pieceType type of piece
     * @param cellId id of cell where we want to place a piece
     */
    public void placePieceAtCell(PieceType pieceType, String cellId) throws NotFoundException {
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