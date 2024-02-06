package com.swiggy;

public class LifeSimulation {
    private final Board board;
    private int liveCellCount;

    private int gen;
    
    public LifeSimulation(Board board) {
        this.board = board;
        this.liveCellCount = countLiveCells();
    }
    
    public void nextGeneration() {
        int rows = board.rows(), columns = board.columns();
        int newLiveCellCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int liveNeighbors = countLiveNeighbor(i,j);
                board.isCellAlive(i,j).evolve(liveNeighbors);
                if (board.isCellAlive(i,j)) newLiveCellCount++;
            }
        }
        this.liveCellCount = newLiveCellCount;
        gen++;
        displayBoard();
    }

    private int countLiveNeighbor (int row, int col) {
        int count =0;
        for(int r = row -1; r <= row +1; r++) {
            for(int c = col-1; c <= col +1; c++) {
                if(r >= 0 && r < board.rows() && c >= 0 && c < board.columns() &&
                        !(r == row && c == col) && board.isCellAlive(r,c)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private int countLiveCells() {
        int liveCellsCount = 0;
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.columns(); j++) {
                if (board.isCellAlive(i,j)) liveCellsCount++;
            }
        }
        return liveCellsCount;
    }

    private void displayBoard() {
        System.out.println("Generation : " + gen);
        int rows = board.rows(), columns = board.columns();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!board.isCellAlive(i,j)) System.out.print("-");
                else System.out.print("*");
            }
            System.out.println();
        }
        try {
            Thread.sleep(500);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public int liveCellCount() {
        return liveCellCount;
    }
}
