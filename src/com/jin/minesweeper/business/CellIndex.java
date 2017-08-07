package com.jin.minesweeper.business;

public class CellIndex {
	private int rowIndex;
	private int colIndex;
	
	public CellIndex() {
		
	}
	public CellIndex(int rowIndex, int colIndex) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
	public void setRowIndex(int rowIndex){
		this.rowIndex = rowIndex;
	}
	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}
	public int getRowIndex() {
		return this.rowIndex;
	}
	public int getColIndex() {
		return this.colIndex;
	}
}
