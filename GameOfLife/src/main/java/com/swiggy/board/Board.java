package com.swiggy.board;
public class Board {
    private Cell[][] cells;
    private double targetPercentOfLife;

    public Board(int rows, int cols, double targetPercentOfLife) {
        this.targetPercentOfLife = targetPercentOfLife;
        this.cells = new Cell[rows][cols];
    }

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    public int countLiveNeighbor (int row, int col) {
        int count =0;
        for(int r = row -1; r <= row +1; r++) {
            for(int c = col-1; c <= col +1; c++) {
                if(r >= 0 && r < this.cells.length && c >= 0 && c < this.cells[0].length && !(r == row && c == col) && cells[r][c].getStatus() == CellStatus.ALIVE) {
                    count++;
                }
            }
        }
        return count;
    }
//
//    public void initializeBoard(int rows, int cols) {
//        for(int r = 0; r < rows; r++) {
//            for(int c = 0; c < cols; c++) {
//                double chance = Math.random();
//                if(chance < probabilityOfLife) setValue(r,c,1);
//            }
//        }
//    }
    public void DisplayBoard() {
        for (Cell[] cell : cells) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cell[j].getStatus() == CellStatus.DEAD) System.out.print(".");
                else if (cell[j].getStatus() == CellStatus.ALIVE) System.out.print("0");
            }
            System.out.println();
        }
    }
}
