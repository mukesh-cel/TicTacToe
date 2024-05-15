package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;
    public Board(int n){
        this.size=n;
        board= new ArrayList<>();
        for(int i=0;i<n;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
    public void printboard(){
        for(int i=0;i< board.size();i++){
            for(int j=0;j< board.size();j++){
                Cell cell=board.get(i).get(j);
                if(cell.getCellstatus().equals(CellStatus.Empty)){
                    System.out.print("| |");
                }
                else if(cell.getCellstatus().equals(CellStatus.Filled)){
                    System.out.print("|" + cell.getPlayer().getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }
}
