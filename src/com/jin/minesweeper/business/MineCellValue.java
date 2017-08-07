package com.jin.minesweeper.business;

public class MineCellValue implements ICellValue {
	private final static String mine = "*";
	
	public String toString(){
		return mine;
	}
}
