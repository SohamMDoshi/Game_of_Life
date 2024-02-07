package com.swiggy;

public enum CellStatus {
    ALIVE("*"),
    DEAD("-");

    private final String symbol;

    CellStatus(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
