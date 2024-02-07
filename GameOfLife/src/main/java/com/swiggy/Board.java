package com.swiggy;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private final Cell[][] cells;
    private final double targetPercentOfLife;

    private boolean canEvolve;

    public Board(int rows, int cols, double targetPercentOfLife) {
        this.targetPercentOfLife = targetPercentOfLife;
        this.cells = new Cell[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {
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

    public boolean nextGeneration() {
        canEvolve = false;
        int rows = cells.length, columns = cells[0].length;
        Cell[][] prev = new Cell[rows][];
        for (int i = 0; i < rows; i++) {
            prev[i] = Arrays.copyOf(cells[i], cells[i].length);
            for (int j = 0; j < columns; j++) {
                int liveNeighbors = countLiveNeighbor(i,j);
                cells[i][j].evolve(liveNeighbors);
                if (cells[i][j].isAlive()) canEvolve = true;
            }
        }
        if (Arrays.deepEquals(prev,cells)) canEvolve = false;
        return canEvolve;
    }

    private int countLiveNeighbor (int row, int col) {
        int count =0;
        for(int r = row -1; r <= row +1; r++) {
            for(int c = col-1; c <= col +1; c++) {
                if(r >= 0 && r < cells.length && c >= 0 && c < cells[0].length &&
                        !(r == row && c == col) && cells[r][c].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
}
