package com.swiggy.board;



public class Main{
    public static void main(String[] args) {
        Board board = new Board(20,20,20.0);
        System.out.print(board.countLiveNeighbor(11,13));
    }
}
