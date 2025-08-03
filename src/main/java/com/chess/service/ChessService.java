package com.chess.service;

import com.chess.dto.Cell;
import com.chess.dto.ChessBoard;
import com.chess.exception.NotFoundException;
import com.chess.exception.NotSupportedException;
import com.chess.walk.WalkFactory;
import com.chess.walk.Walk;

import java.util.List;

public class ChessService {

    /**
     * initialize and return empty chessboard
     * @return empty chess board
     */
    public ChessBoard startNewChessGame() {
        return new ChessBoard();
    }

    /**
     * Takes chess board and cell location in input and calculate and return all possible moves for piece
     * by using relevant walking strategy for piece present at cell.
     * @param chessBoard initialized chessboard
     * @param cellId cell id
     * @return list of cells
     */
    public List<Cell> getAllPossibleMovesForCell(ChessBoard chessBoard, String cellId) throws NotSupportedException, NotFoundException {
        Cell cell = chessBoard.findCellById(cellId);
        Walk walk = WalkFactory.getWalkForPiece(cell.getPiece().getType());
        return walk.getAllPossibleMoves(cell, chessBoard);
    }
}
