package Models;

import java.util.Scanner;

public class Player {
    private int Id=0;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player(String name, char symbol, PlayerType playerType) {
        this.Id++;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makemove(Board board){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter row and Col to make a move");
        int n=scn.nextInt();
        int m=scn.nextInt();
        return  new Move(new Cell(n,m),this);
    }
}
