package com.swiggy.board;

import java.util.Random;

public class Board {
    private Cell[][] cells;
    private double targetPercentOfLife;

    public Board(int rows, int cols, double targetPercentOfLife) {
        this.targetPercentOfLife = targetPercentOfLife;
        initializeBoard(rows,cols);
    }

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    public void initializeBoard(int rows, int columns) {
        cells = new Cell[rows][columns];
        Random random = new Random();

        int totalCells = rows * columns;
        int numbersAliveCells = (int) (totalCells * targetPercentOfLife);
        int[] allPosition = generateAllPositions(totalCells);
        shuffle(random,allPosition);
        setAliveCells(numbersAliveCells,allPosition,rows,columns);
    }

    public int[] generateAllPositions(int totalCells) {
        int[] allPositions = new int[totalCells];
        for (int i = 0; i < totalCells; i++) {
            allPositions[i] = i;
        }
        return allPositions;
    }

    public void shuffle(Random random, int[] positions) {
        for (int i = 0; i < positions.length; i++) {
            int j = random.nextInt(i+1);
            int temp = positions[i];
            positions[i] = positions[j];
            positions[j] = temp;
        }
    }

    public void setAliveCells(int numberOfAliveCells, int[] positions, int rows, int columns) {
        for (int i = 0; i < numberOfAliveCells; i++) {
            int position = positions[i];
            int row = position / columns;
            int col = position % columns;
            cells[row][col] = new Cell(CellStatus.ALIVE);
        }
        fillRemainingCells(rows,columns);
    }

    private void fillRemainingCells(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(cells[i][j] == null) cells[i][j] = new Cell(CellStatus.DEAD);
            }
        }
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
