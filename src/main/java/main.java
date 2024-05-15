import Controller.GameController;
import Models.*;
import Strategies.ColWinnngStrategy;
import Strategies.DiagonalWinnngStrategy;
import Strategies.RowWinnngStrategy;
import Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<Player> players= new ArrayList<>();
        players.add(new Player("Mukesh",'X', PlayerType.Human));
        //players.add(new Player("Karthi",'O',PlayerType.Human));

        players.add(new BotPlayer("Bot",'0',PlayerType.Bot,DifficultyLevel.Easy));

        List<WinningStrategy> winningStrategies= new ArrayList<>();
        winningStrategies.add(new RowWinnngStrategy());
        winningStrategies.add(new ColWinnngStrategy());
        winningStrategies.add(new DiagonalWinnngStrategy());

        Game game=gameController.startgame(3,players,winningStrategies,DifficultyLevel.Easy);

        System.out.println("Start the game");
        while(game.getGameStatus()==GameStatus.In_Progress){
            System.out.println("Enter 1 to print board");
            Scanner scn = new Scanner(System.in);
            int ans= scn.nextInt();
            if(ans==1){
                gameController.printboard(game);
                gameController.makemove(game);
            }

        }
    }
}
