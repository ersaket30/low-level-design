import java.util.Queue;
import java.util.Scanner;


//https://leetcode.com/discuss/interview-question/object-oriented-design/1684809/tic-tac-toe-lld-review-appreciated-workattech
public class Game {

    Board board;
    Queue<Player> players;

    Scanner s = new Scanner(System.in);

    Game(Board board, Queue<Player> players){
        this.board=board;
        this.players = players;
    }

    void startGame(){
        boolean isGameOver = false;
        Piece[][] cells = board.cells;
        Player currentPlayer = players.remove();
        while(!isGameOver){
            int x= s.nextInt();
            int y = s.nextInt();
            boolean isValidMove = isValidMove(x,y);
            if(isValidMove){
                board.createPiece(x,y,currentPlayer.piece);
                isPlayerWon(x,y,currentPlayer.piece.pieceType);
               Player nextPlayer = players.remove();
               players.add(currentPlayer);
                currentPlayer = nextPlayer;
            }
        }
    }

    private boolean isPlayerWon(int x,int y,PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i< board.size;i++) {

            if(board.cells[x][i] == null || board.cells[x][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i< board.size;i++) {

            if(board.cells[i][y] == null || board.cells[i][y].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.cells[i][j] == null || board.cells[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i< board.size;i++,j--) {
            if (board.cells[i][j] == null || board.cells[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }

    boolean isValidMove(int x,int y){
        return board.cells[x][y]!=null;
    }
}
