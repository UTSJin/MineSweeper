package com.jin.minesweeper.console;

import java.util.Scanner;
import com.jin.minesweeper.business.Size;
import java.util.ArrayList;
import java.util.List;
import com.jin.minesweeper.business.CellIndex;
import com.jin.minesweeper.business.Board;
import com.jin.minesweeper.business.Cell;


public class ConsoleBoard {
	private Scanner scanner = new Scanner(System.in);
	
	public void run() {
		Size boardSize = readBoardSize();
		Board board = new Board(boardSize); //Set board size and create cells on the board
		List<CellIndex> mineCellIndexes = readBoardCells(boardSize);
		
		board.setMineCells(mineCellIndexes);
		board.generateHints();
		display(board);
	}
	
	public Size readBoardSize() {
		System.out.println("The input: \n");
		scanner = new Scanner(System.in);
		int rowSize = scanner.nextInt();
		int colSize = scanner.nextInt();
		
		Size size = new Size(rowSize, colSize);
		return size;
	}
	
	public List<CellIndex> readBoardCells(Size size){
		List<CellIndex> mineCellIndexes = new ArrayList<CellIndex>();
		for(int i=0; i<size.getRowSize(); i++) {
			String line = scanner.next();
			for(int j=0; j<size.getColSize(); j++) {
				char charVal = line.charAt(j);
				if(charVal == '*') {
					mineCellIndexes.add(new CellIndex(i,j));
				}
			}
		}
		return mineCellIndexes;
	}
	
	public void display(Board board) {
		Size boardSize = board.getSize();
		Cell[][] cells= board.getCells();
		for (int i=0; i<boardSize.getRowSize(); i++){
			for(int j=0; j<boardSize.getColSize(); j++){
				System.out.print(cells[i][j].getValue());
			}
			System.out.println("");
		}
	}
}
