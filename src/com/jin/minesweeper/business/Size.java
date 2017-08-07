package com.jin.minesweeper.business;

public class Size {
	private int rowSize, colSize;
	
	public Size() {
		
	}
	public Size(int rowSize, int colSize) {
		this.rowSize = rowSize;
		this.colSize = colSize;
		validate();
	}
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	public void setColSize(int colSize) {
		this.colSize = colSize;
	}
	
	public int getRowSize() {
		return this.rowSize;
	}
	public int getColSize() {
		return this.colSize;
	}
	
	private void validate() {
		if(this.rowSize < 0 || this.colSize > 100) {
			System.exit(0);;
		}
	}
}
