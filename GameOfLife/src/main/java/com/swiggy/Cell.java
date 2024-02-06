package com.swiggy;

public class Cell {
    private CellStatus status;

    public Cell(CellStatus status) {
        this.status = status;
    }

    public boolean isAlive() {
        return this.status == CellStatus.ALIVE;
    }

    public void evolve(int liveNeighbors) {
        if(status == CellStatus.ALIVE) {
            status = (liveNeighbors < 2 || liveNeighbors > 3) ? CellStatus.DEAD : CellStatus.ALIVE;
        }
        else status = (liveNeighbors == 3) ? CellStatus.ALIVE : CellStatus.DEAD;
    }
}
