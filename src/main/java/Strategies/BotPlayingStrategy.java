package Strategies;

import Models.Board;
import Models.Move;

public interface BotPlayingStrategy {
    public Move makemove(Board board);
}
