package com.chess;

import java.util.List;

public interface Walk {
    public abstract List<Cell> getAllPossibleMoves(Cell position, ChessBoard chessBoard);
}
