package com.jin.minesweeper.business;

public class HintCellValue implements ICellValue {
	private int hint =0;
	
	public void increment() {
		hint=hint+1;
	}
	public int getHint() {
		return hint;
	}
	public String toString() {
		return String.format("%d", hint); 
	}
}
