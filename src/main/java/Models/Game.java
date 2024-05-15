package Models;

import Controller.GameController;
import Strategies.RowWinnngStrategy;
import Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private DifficultyLevel difficultyLevel;
    private GameStatus gameStatus;
    private Player winner;
    private List<WinningStrategy> winningStrategy;
    private int nextmoveplayerindex;
    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies,
                DifficultyLevel difficultyLevel) {
        this.board = new Board(dimension);
       this.players=players;
       this.winningStrategy=winningStrategies;
       this.moves=new ArrayList<>();
       this.difficultyLevel=difficultyLevel;
       this.gameStatus=GameStatus.In_Progress;
       this.nextmoveplayerindex=0;

    }
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextmoveplayerindex() {
        return nextmoveplayerindex;
    }

    public void setNextmoveplayerindex(int nextmoveplayerindex) {
        this.nextmoveplayerindex = nextmoveplayerindex;
    }

    /*public Game startgame(int n, List<Player> players, List<WinningStrategy> winningStrategies){
        Game game= new Game(n)
    }*/
    public void printboard(){
        board.printboard();
    }
    public boolean validate(int row, int col,Game game){
        if(row>=0 && row< board.getSize() && col>=0 && col< game.board.getSize()
        && game.board.getBoard().get(row).get(col).getCellstatus().equals(CellStatus.Empty)){
            return true;
        }
        return false;
    }
    public boolean checkwinner(Move move,Board board){
        for(WinningStrategy w:winningStrategy){
            if(w.checkWinner(move,board)){
                return true;
            }
        }
        return false;
    }
    public void makemove(Game game){
        Player currentplayer= players.get(nextmoveplayerindex);
        System.out.println(currentplayer.getName() + "s move");
        Move move=currentplayer.makemove(board);
        int n=move.getCell().getRow();
        int m=move.getCell().getCol();
        if(!validate(n,m,game)){
            System.out.println("Invalid Input");
            return;
        }
        Move finalmove=new Move(new Cell(n,m),currentplayer);
        Cell cell= board.getBoard().get(n).get(m);
        cell.setCellstatus(CellStatus.Filled);
        cell.setPlayer(currentplayer);
        moves.add(finalmove);
        if(checkwinner(finalmove,board)){
            gameStatus=GameStatus.Ended;
            winner=currentplayer;
            System.out.println(winner.getName() + "has won the game");
            return;
        } else if (moves.size()==( board.getSize()* board.getSize())) {
            gameStatus=GameStatus.Draw;
            System.out.println("game draw");
        }

        nextmoveplayerindex=nextmoveplayerindex+1;
        nextmoveplayerindex=nextmoveplayerindex%players.size();

    }
}
