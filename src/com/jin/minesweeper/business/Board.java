package com.jin.minesweeper.business;
import java.util.List;
import java.util.ArrayList;
public class Board {
	private Size size;
	private Cell[][] cells;
	private List<CellIndex> mineCellIndexes;
	
	public Board() {
		
	}
	public Board(Size size) {
		setSize(size);
	}
	public Board getBoard() {
		return this;
	}
	public Size getSize() {
		return this.size;
	}
	public List<CellIndex> getMineCellIndexex() {
		return this.mineCellIndexes;
	}
	private void setSize(Size size) {
		this.size = size;
		createCells();
	}
	public void setMineCells(List<CellIndex> mineCellIndexes) {
		this.mineCellIndexes = mineCellIndexes;
		for(CellIndex index:mineCellIndexes) {
			cells[index.getRowIndex()][index.getColIndex()] = new Cell(new MineCellValue());
		}
	}
	private void createCells(){
		cells = new Cell[size.getRowSize()][size.getColSize()];
		
		for(int i=0; i<size.getRowSize(); i++) {
			for(int j=0; j<size.getColSize(); j++) {
				cells[i][j] = new Cell(new HintCellValue());
			}
		}
	}
	public void generateHints() {
		//1. getAdjacentCells
		//2. increment the cells
		
		for(CellIndex index:mineCellIndexes){ 
			List<Cell> adjacentHintCells = getAdjacentCells(index);
			for(Cell hintCell: adjacentHintCells) {
				((HintCellValue) hintCell.getValue()).increment();
			}
			
		}
	}
	private List<Cell> getAdjacentCells(CellIndex indexes){
		/* ---------------
		 * 1 2 3
		 * 4 * 5
		 * 6 7 8
		 * ---------------
		 */
		List<Cell> adjacentHintCells= new ArrayList<Cell>();
		CellIndex [] adjacentCell = new CellIndex[]{
				new CellIndex(indexes.getRowIndex() -1, indexes.getColIndex() -1), //1
				new CellIndex(indexes.getRowIndex() -1, indexes.getColIndex()),    //2
				new CellIndex(indexes.getRowIndex() -1, indexes.getColIndex() +1), //3
				new CellIndex(indexes.getRowIndex(), indexes.getColIndex() -1),    //4
				new CellIndex(indexes.getRowIndex(), indexes.getColIndex() +1),    //5
				new CellIndex(indexes.getRowIndex()+1, indexes.getColIndex()-1),   //6
				new CellIndex(indexes.getRowIndex()+1, indexes.getColIndex()),     //7
				new CellIndex(indexes.getRowIndex()+1, indexes.getColIndex()+1)    //8
		};
		for(int i=0; i<adjacentCell.length; i++) {
			Cell cell = getCell(adjacentCell[i]);
			
			if(cell!=null && cell.getValue() instanceof HintCellValue) {
				adjacentHintCells.add(cell);
			}
		}
		return adjacentHintCells;
	}
	private Cell getCell(CellIndex index) {
		Cell cell = null;
		if(index.getRowIndex()>=0 && index.getRowIndex()<size.getRowSize() && index.getColIndex()>=0 &&index.getColIndex()<size.getColSize()) {
			cell = cells[index.getRowIndex()][index.getColIndex()];
		}
		return cell;
	}
	public Cell[][] getCells() {
		return cells;
	}
}
