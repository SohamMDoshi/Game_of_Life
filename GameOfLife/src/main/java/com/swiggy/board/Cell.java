package com.swiggy.board;

import java.util.Objects;

public class Cell {
    private CellStatus status;

    public Cell(CellStatus status) {
        this.status = status;
    }

    public CellStatus getStatus() {
        return this.status;
    }

    public int countLiveNeighbor (int row, int col, Cell[][] cells) {
        int count =0;
        for(int r = row -1; r <= row +1; r++) {
            for(int c = col-1; c <= col +1; c++) {
                if(r >= 0 && r < cells.length && c >= 0 && c < cells[0].length && !(r == row && c == col) && cells[r][c].getStatus() == CellStatus.ALIVE) {
                    count++;
                }
            }
        }
        return count;
    }

    public void evolve(int liveNeighbors) {
        if(status == CellStatus.ALIVE) {
            status = (liveNeighbors < 2 || liveNeighbors > 3) ? CellStatus.DEAD : CellStatus.ALIVE;
        }
        else status = (liveNeighbors == 3) ? CellStatus.ALIVE : CellStatus.DEAD;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return status == cell.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
