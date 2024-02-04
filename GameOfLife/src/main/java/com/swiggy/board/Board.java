package com.swiggy.board;

import java.util.Random;

public class Board {
    private Cell[][] cells;
    private double targetPercentOfLife;

    public Board(int rows, int cols, double targetPercentOfLife) {
        this.targetPercentOfLife = targetPercentOfLife;
        this.cells = new Cell[rows][cols];
    }

    public void initializeBoard() {
        int rows = cells.length;
        int columns = cells[0].length;
        Random random = new Random();

        int totalCells = rows * columns;
        int countOfAliveCells = (int) (totalCells * targetPercentOfLife);
        int[] allPosition = generateAllPositions(totalCells);
        shuffle(random,allPosition);
        setAliveCells(countOfAliveCells,allPosition,rows,columns);
    }

    private int[] generateAllPositions(int totalCells) {
        int[] allPositions = new int[totalCells];
        for (int i = 0; i < totalCells; i++) {
            allPositions[i] = i;
        }
        return allPositions;
    }

    private void shuffle(Random random, int[] positions) {
        for (int i = 0; i < positions.length; i++) {
            int j = random.nextInt(i+1);
            int temp = positions[i];
            positions[i] = positions[j];
            positions[j] = temp;
        }
    }

    private void setAliveCells(int numberOfAliveCells, int[] positions, int rows, int columns) {
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

    public int getRows() {
        return cells.length;
    }

    public int getColumns() {
        return cells[0].length;
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }
}
