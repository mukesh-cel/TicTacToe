package Models;

import Strategies.BotPlayingStrategy;
import Strategies.EasyPlayingStrategy;

public class BotPlayer extends Player{
    private int Id=0;
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String name, char symbol, PlayerType playerType,DifficultyLevel difficultyLevel) {
        super(name, symbol, playerType);
        this.Id++;
        this.difficultyLevel=difficultyLevel;
        if(difficultyLevel==DifficultyLevel.Easy) {
            this.botPlayingStrategy = new EasyPlayingStrategy();
        }
    }
    @Override
    public Move makemove(Board board){
        return botPlayingStrategy.makemove(board);
    }
}
