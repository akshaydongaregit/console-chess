package com.chess;

public class Cell {

    private String id;

    private int row, col;

    private Piece piece;

    public Cell(String id, int row, int col) {
        this.id = id;
        this.row = row;
        this.col = col;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "id='" + id + '\'' +
                ", row=" + row +
                ", col=" + col +
                ", piece=" + piece +
                '}';
    }
}
