package Controller;

import Models.DifficultyLevel;
import Models.Game;
import Models.Player;
import Strategies.WinningStrategy;

import java.util.List;

public class GameController {
   // private Game game;
    //Game game= new Game();

    public Game startgame(int n, List<Player> players, List<WinningStrategy> winningStrategies, DifficultyLevel difficultyLevel){
         Game game= new Game(n,players,winningStrategies,difficultyLevel);
         return game;
    }
    public void printboard(Game game){
        game.printboard();
    }
    public void makemove(Game game){
        game.makemove(game);
    }
}
