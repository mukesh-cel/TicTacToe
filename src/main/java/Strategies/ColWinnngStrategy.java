package Strategies;

import Models.Board;
import Models.Move;

import java.util.HashMap;

public class ColWinnngStrategy implements WinningStrategy{
    private HashMap<Integer, HashMap<Character, Integer>> colmap=new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {

        int row = move.getCell().getCol();
        Character symbol = move.getPlayer().getSymbol();
        if (!colmap.containsKey(row)) {
            colmap.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currentcol = colmap.get(row);
        if (currentcol.containsKey(symbol)) {
            currentcol.put(symbol, currentcol.get(symbol) + 1);
        } else {
            currentcol.put(symbol, 1);
        }
        if (currentcol.get(symbol) == board.getSize()) {
            return true;
        }
        return false;
    }
}
