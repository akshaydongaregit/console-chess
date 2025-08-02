package com.chess;

public class Piece {
    private PieceType type;
    private Cell currentPosition;

    public Piece(PieceType type) {
        this.type = type;
    }

    public Piece(PieceType type, Cell currentPosition) {
        this.type = type;
        this.currentPosition = currentPosition;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                '}';
    }
}
