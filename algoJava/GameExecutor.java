
import org.nkjmlab.mabs.prac.algo.v1.Game;
import org.nkjmlab.mabs.prac.algo.v1.Player;

public class GameExecutor {

  public static void main(String[] args) {
    Game game = new Game(new Player(), new Player());
    game.run();
  }
}
