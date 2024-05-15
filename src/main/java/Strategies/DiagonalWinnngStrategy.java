package Strategies;

import Models.Board;
import Models.Move;

import java.util.Calendar;
import java.util.HashMap;

public class DiagonalWinnngStrategy implements WinningStrategy{
    private HashMap<Character, Integer> leftdiagonalmap=new HashMap<>();
    private HashMap<Character, Integer> rightdiagonalmap=new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Character symbol=move.getPlayer().getSymbol();
        if(row==col){
            if(leftdiagonalmap.containsKey(symbol)){
                leftdiagonalmap.put(symbol,leftdiagonalmap.get(symbol)+1);
            }
            else{
                leftdiagonalmap.put(symbol,1);
            }
        }
        if(row+col==board.getSize()-1){
            if(rightdiagonalmap.containsKey(symbol)){
                rightdiagonalmap.put(symbol,rightdiagonalmap.get(symbol)+1);
            }
            else{
                rightdiagonalmap.put(symbol,1);
            }
        }
        if(row==col && leftdiagonalmap.get(symbol)== board.getSize()){
            return true;
        }
        if(row+col==board.getSize()-1 && rightdiagonalmap.get(symbol)== board.getSize()){
            return  true;
        }
        return false;
    }
}
