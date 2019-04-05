package com.techlab.tictactoe.business;

public enum Mark {

	CROSS, NOUGHT, EMPTY;
	
	public String toString() {
		switch (this) {
		case NOUGHT:
			return "O";
		case CROSS:
			return "X";
		case EMPTY:
			return " ";
		default:
			return null;
		}
	}
}
