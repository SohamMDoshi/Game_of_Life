package com.swiggy;

import java.util.Objects;

public class Cell {
    private CellStatus status;

    public Cell(CellStatus status) {
        this.status = status;
    }

    public boolean isAlive() {
        return this.status == CellStatus.ALIVE;
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

    public void evolve(int liveNeighbors) {
        if(status == CellStatus.ALIVE) {
            status = (liveNeighbors < 2 || liveNeighbors > 3) ? CellStatus.DEAD : CellStatus.ALIVE;
        }
        else status = (liveNeighbors == 3) ? CellStatus.ALIVE : CellStatus.DEAD;
    }


}
