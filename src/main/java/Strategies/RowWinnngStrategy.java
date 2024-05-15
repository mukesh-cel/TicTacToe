package Strategies;

import Models.Board;
import Models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinnngStrategy implements WinningStrategy {
    private HashMap<Integer,HashMap<Character, Integer>> rowmap=new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {

        int row=move.getCell().getRow();
        Character symbol=move.getPlayer().getSymbol();
        if(!rowmap.containsKey(row)){
            rowmap.put(row,new HashMap<>());
        }
        HashMap<Character,Integer> currentrow=rowmap.get(row);
        if(currentrow.containsKey(symbol)){
            currentrow.put(symbol,currentrow.get(symbol)+1);
        }
        else{
            currentrow.put(symbol,1);
        }
        if(currentrow.get(symbol)== board.getSize()){
            return true;
        }
        return false;
    }
}
