
import model.Board;
import model.Dice;
import model.Game;
import model.Ladder;
import model.Player;
import model.Snake;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Driver {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Snake> snakes = new HashMap<>();
        HashMap<Integer, Ladder> ladders = new HashMap<>();
        snakes.put(10,new Snake(10,1));
        ladders.put(11,new Ladder(11,12));

        Board board = new Board(10,10,snakes,ladders);
        Queue<Player> players = new LinkedList<>();
        players.add(new Player("Niharika"));
        players.add(new Player("Jeevan"));
        players.add(new Player("Mom"));
        players.add(new Player("Dad"));

        Game game = new Game(board,new Dice(6),players);

        game.startGame();
    }
}
