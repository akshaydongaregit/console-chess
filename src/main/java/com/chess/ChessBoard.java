package com.chess;

import java.util.Arrays;
import java.util.List;

public class ChessBoard {

    private final Cell[][] cells = new Cell[8][8];

    public ChessBoard() {
        initChessBoard();
    }

    private void initChessBoard() {
        for(int i=0;i<8;i++) {
            for(int j = 0;j<8;j++) {
                String cellId = ((char) (j + 65)) + "" + (i+1) ;
                Cell cell = new Cell(cellId, i, j);
                cells[i][j] = cell;
            }
        }
    }

    public List<Cell> getAllPossibleMoves(Cell cell, Walk walk) {
        return walk.getAllPossibleMoves(cell, this);
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }
}