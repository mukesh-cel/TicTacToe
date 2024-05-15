package Strategies;

import Models.Board;
import Models.Cell;
import Models.CellStatus;
import Models.Move;

import java.util.List;

public class EasyPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makemove(Board board) {
        for(List<Cell> cell: board.getBoard()){
            for(Cell c:cell){
                if(c.getCellstatus()== CellStatus.Empty){
                    return new Move(c,null);
                }
            }
        }
        return null;
    }
}
