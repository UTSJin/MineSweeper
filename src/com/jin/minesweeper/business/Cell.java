package com.jin.minesweeper.business;

public class Cell {
	private ICellValue value;
	
	public Cell() {
		
	}
	public Cell(ICellValue value) {
		this.value = value;
	}
	public ICellValue getValue() {
		return value;
	}
}
