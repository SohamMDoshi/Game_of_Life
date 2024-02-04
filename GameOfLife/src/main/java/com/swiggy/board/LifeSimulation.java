package com.swiggy.board;

public class LifeSimulation {
    private Board board;
    private int liveCellCount;
    
    public LifeSimulation(Board board) {
        this.board = board;
        this.liveCellCount = countLiveCells();
    }
    
    public void nextGeneration() {
        int rows = board.getRows(), columns = board.getColumns();
        Board nextGen = new Board(rows, columns, 0);
        int newLiveCellCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int liveNeighbors = countLiveNeighbor(i,j);
                board.getCell(i,j).evolve(liveNeighbors);
                if (board.getCell(i,j).getStatus() == CellStatus.ALIVE) newLiveCellCount++;
            }
        }
        this.board = nextGen;
        this.liveCellCount = newLiveCellCount;
        displayBoard();
    }

    private void displayBoard() {
    }

    private int countLiveNeighbor (int row, int col) {
        int count =0;
        for(int r = row -1; r <= row +1; r++) {
            for(int c = col-1; c <= col +1; c++) {
                if(r >= 0 && r < board.getRows() && c >= 0 && c < board.getColumns() && !(r == row && c == col) && board.getCell(r,c).getStatus() == CellStatus.ALIVE) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private int countLiveCells() {
        int liveCellsCount = 0;
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board .getCell(i,j).getStatus() == CellStatus.ALIVE) liveCellsCount++;
            }
        }
        return liveCellsCount;
    }
    
    public int getLiveCellCount() {
        return liveCellCount;
    }
}