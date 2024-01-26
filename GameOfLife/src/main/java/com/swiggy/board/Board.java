package com.swiggy.board;

public class Board {
    private static final int ROWS = 20;
    private static final int COLS = 80;

    private static final double probabilityOfLife = 0.2;

    int[][] board;

    public Board(int rows, int cols) {
        board = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return board[row][col];
    }

    public void setValue(int row, int col, int value) {
        this.board[row][col] = value;
    }

    public void initializeBoard() {
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                double chance = Math.random();
                if(chance < probabilityOfLife) setValue(r,c,1);
            }
        }
    }
    public void DisplayBoard() {
        for (int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 0) System.out.print(".");
                else if(board[i][j] == 1) System.out.print("0");
            }
            System.out.println();
        }
    }
}
