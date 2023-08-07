public class Board {

    Piece[][] cells;
    Integer size;

    public Board(int size){
        cells = new Piece[size][size];
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
               if(cells[i][j]==null){
                   System.out.println("__");
               }else{
                   System.out.println(cells[i][j].pieceType);
               }
               System.out.println("  ");
            }
        }
    }

    public void createPiece(int x,int y,Piece piece){
          cells[x][y]=piece;
    }
}
