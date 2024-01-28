package com.swiggy.board;

import java.util.Random;

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

    public Board() {}

    public void initializeBoard() {
        int rows = cells.length;
        int columns = cells[0].length;
        Random random = new Random();

        int totalCells = rows * columns;
        int numbersAliveCells = (int) (totalCells * targetPercentOfLife);
        int[] allPosition = generateAllPositions(totalCells);
        shuffle(random,allPosition);
        setAliveCells(numbersAliveCells,allPosition,rows,columns);
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

    private int countLiveNeighbor (int row, int col) {
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

    public void nextGeneration () {
        Cell[][] newGeneration = new Cell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                int alvieNeighbors = countLiveNeighbor(i,j);
                newGeneration[i][j] = new Cell(cells[i][j].getStatus());
                newGeneration[i][j].evolve(alvieNeighbors);
            }
        }
        cells = newGeneration;
    }

    public void DisplayBoard() {
        for (Cell[] cell : this.cells) {
            for (int j = 0; j < this.cells[0].length; j++) {
                if (cell[j].getStatus() == CellStatus.DEAD) System.out.print(".");
                else if (cell[j].getStatus() == CellStatus.ALIVE) System.out.print("0");
            }
            System.out.println();
        }
        System.out.print("\r");
    }
}
