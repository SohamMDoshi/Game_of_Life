package com.swiggy.board;

public class Board {
    int[][] board;

    public Board(int rows, int cols) {
        board = new int[rows][cols];
    }

    public int get(int row, int col) {
        return board[row][col];
    }

    public void set(int row,int col,int value) {
        board[row][col] = value;
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
