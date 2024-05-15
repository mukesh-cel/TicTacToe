package Models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellStatus cellstatus;
    public  Cell(int row, int col){
        this.row= row;
        this.col=col;
        this.cellstatus=CellStatus.Empty;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellStatus getCellstatus() {
        return cellstatus;
    }

    public void setCellstatus(CellStatus cellstatus) {
        this.cellstatus = cellstatus;
    }
}
