package com.swiggy;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        int rows = inputManager.getRowsInput();
        int column = inputManager.getColumnsInput();
        double percentage = inputManager.getPercentageInput();

        Board board = new Board(rows,column,percentage);
        board.initializeBoard();

        LifeSimulation simulation = new LifeSimulation(board);
        while (simulation.getLiveCellCount() > 0) {
            simulation.nextGeneration();
        }
    }
}
