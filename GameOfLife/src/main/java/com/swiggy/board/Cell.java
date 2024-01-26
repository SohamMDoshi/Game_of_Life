package com.swiggy.board;
public class Cell {

    private CellStatus status;

    public Cell(CellStatus status) {
        this.status = status;
    }

    public CellStatus getStatus() {
        return this.status;
    }

    public void evolve(int liveNeighbors) {
        if(status == CellStatus.ALIVE) {
            status = (liveNeighbors < 2 || liveNeighbors > 3) ? CellStatus.DEAD : CellStatus.ALIVE;
        }
        else status = (liveNeighbors == 3) ? CellStatus.ALIVE : CellStatus.DEAD;
    }

}
