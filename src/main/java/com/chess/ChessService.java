package com.chess;

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
    public List<Cell> getAllPossibleMovesForCell(ChessBoard chessBoard, String cellId) {
        Cell cell = chessBoard.findCellById(cellId);
        Walk walk = new PawnWalk();
        if(PieceType.KING.name().equals(cell.getPiece().getType().name())) {
            walk = new KingWalk();
        } else if(PieceType.QUEEN.name().equals(cell.getPiece().getType().name())) {
            walk = new QueenWalk();
        }
        return walk.getAllPossibleMoves(cell, chessBoard);
    }
}
