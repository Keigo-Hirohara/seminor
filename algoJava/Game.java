package org.nkjmlab.mabs.prac.algo.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * アルゴゲームを表すクラス
 */
public class Game {

	static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
	private final Player player1;
	private final Player player2;

	/**
	 * ゲームに参加する二人のプレーヤを設定する．
	 *
	 * @param player1
	 * @param player2
	 */
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * TODO ゲームを実行する．ゲーム終了時に勝ったプレーヤを返す．
	 *
	 * @return
	 */
	public Player run() {
		Stock stock = Stock.create();
		player1.add(stock.drawCard());
		player1.add(stock.drawCard());
		player1.add(stock.drawCard());
		player1.add(stock.drawCard());
		player2.add(stock.drawCard());
		player2.add(stock.drawCard());
		player2.add(stock.drawCard());
		player2.add(stock.drawCard());

		int turn = 0;
		while (true) {
			{
				Card drawnCard = stock.drawCard();
				Attack attack = player1.decideAttack(drawnCard, toOpponentCards(player2.getCards()));
				AttackResult result = player2.attackAndFaceUpIfSuccess(attack);
				player1.turnEnd(drawnCard, result);
				if (player2.isLose()) {
					log.debug("p1 win in {}", turn);
					return player1;
				}
			}
			{
				Card drawnCard = stock.drawCard();
				Attack attack = player2.decideAttack(stock.drawCard(), toOpponentCards(player1.getCards()));
				AttackResult result = player1.attackAndFaceUpIfSuccess(attack);
				player2.turnEnd(drawnCard, result);
				if (player1.isLose()) {
					log.debug("p2 win in {}", turn);
					return player2;
				}
			}
			turn++;
		}
	}

	/**
	 * TODO {@link Card}のリストを{@link OpponentCard}のリストに変換する
	 *
	 * @param cards
	 * @return
	 */
	private static List<OpponentCard> toOpponentCards(List<Card> cards) {
		List<OpponentCard> result = new ArrayList<>();
		for (Card card : cards) {
			result.add(new OpponentCard(card));
		}
		return result;
	}
}
