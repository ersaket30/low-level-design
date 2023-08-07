package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Game {

    private Board board;
    private Dice dice;
    private Queue<Player> players;

    public Game(Board board, Dice dice, Queue<Player> players){
        this.board=board;
        this.dice=dice;
        this.players=players;
    }

   public void startGame(){
        List<Player> winners = new ArrayList<>();
        Map<Integer,Snake> snakes = board.getSnakes();
        Map<Integer,Ladder> ladders = board.getLadders();

        while(players.size()>1){

            Player currentPlayer = players.remove();
            int steps = dice.roll();
            System.out.println(currentPlayer.getName()+" has rolled"+steps);
            int nextPos = currentPlayer.getPosition()+steps;
            boolean isSnake = snakes.containsKey(nextPos);
            boolean isLadder = ladders.containsKey(nextPos);

            if(hasPlayerExceededLastCell(nextPos)){
                players.add(currentPlayer);
                continue;
            }

            while(isSnake || isLadder){
                if(isSnake){
                    nextPos = snakes.get(nextPos).getTo();
                    System.out.println(currentPlayer.getName()+" has biten by snake and moved to "+nextPos);

                }
                if(isLadder){
                    nextPos = ladders.get(nextPos).getTo();
                    System.out.println(currentPlayer.getName()+" has got a ladder and moved to "+nextPos);
                }
                isSnake = snakes.containsKey(nextPos);
                isLadder = ladders.containsKey(nextPos);
            }

            System.out.println(currentPlayer.getName()+" has moved to "+nextPos);
            currentPlayer.setPosition(nextPos);

            if(isPlayerWon(nextPos)){
                winners.add(currentPlayer);
            }else{
                players.add(currentPlayer);
            }

        }

        System.out.println("Game is Over");
        winners.add(players.remove());
        for(int i=0;i<winners.size();i++){
            System.out.println(winners.get(i).getName()+" is won at position "+(i+1));
        }

    }

    private boolean isPlayerWon(int nextPos) {
        return nextPos == board.getSize();
    }

    private boolean hasPlayerExceededLastCell(int nextPos) {
        return nextPos > board.getSize();
    }
}
