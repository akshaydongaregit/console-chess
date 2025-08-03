package com.chess.walk;

import com.chess.dto.Cell;
import com.chess.dto.ChessBoard;

import java.util.List;

public interface Walk {
    public abstract List<Cell> getAllPossibleMoves(Cell position, ChessBoard chessBoard);
}
