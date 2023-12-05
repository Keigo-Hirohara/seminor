package org.nkjmlab.mabs.prac.algo.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * プレイヤーを表すクラス．
 */
public class HumanPlayer {
	static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

	private final List<Card> cards;

	public HumanPlayer() {
		this.cards = new ArrayList<>();
	}

	/**
	 * 手札にカードを加える．カードはアルゴのルールに基づき適切な位置に挿入される．
	 *
	 * @param card
	 */
	void add(Card card) {
		int index = getIndexOfInsert(card);
		cards.add(index, card);
	}

	/**
	 * TODO アルゴのルールに基づき引いてきたカードを挿入する位置を表すindexを返す。手元のカードは適切に並べ替えられているものとせよ。
	 *
	 * @param drawnCard
	 * @return 引いてきたカードを挿入する位置
	 */
	private int getIndexOfInsert(Card drawnCard) {
		for (int i = 0; i < cards.size(); i++) {
			Card c = cards.get(i);
			if (c.getNumber() < drawnCard.getNumber()) {
				continue;
			} else if (c.getNumber() == drawnCard.getNumber()) {
				return drawnCard.getColor() == CardColor.BLACK ? i : i + 1;
			} else {
				return i;
			}
		}
		return cards.size();
	}

	public List<Card> getCards() {
		return cards;
	}

	/**
	 * TODO アタックされた結果が成功だったときtrue，失敗だったときfalseを返す．
	 * もし，アタックが成功した場合は，アタックされたカードを表向きにする．
	 *
	 * @return
	 */
	AttackResult attackAndFaceUpIfSuccess(Attack attack) {
		Card attackedTargetCard = cards.get(attack.index());
		if (attackedTargetCard.getNumber() == attack.cardNumber()) {
			attackedTargetCard.faceUp();
			return new AttackResult(true, attack);
		} else {
			return new AttackResult(false, attack);
		}
	}

	/**
	 * TODO
	 * ターン終了処理をする．アタックが成功だった場合，引いてきたカードを裏向きで手札に加える．失敗だった場合，引いてきたカードを表向きにして手札に加える．
	 *
	 * @param drawnCard
	 * @param result
	 */
	void turnEnd(Card drawnCard, AttackResult result) {
		if (drawnCard == null) {
			return;
		}
		if (result.result()) {
			drawnCard.faceDown();
		} else {
			drawnCard.faceUp();
		}
		add(drawnCard);
	}

	/**
	 * TODO
	 * 自分の手札はgetCardsでアクセス出来る．引いてきたカードと対戦相手のカードは引数で与えられる．これらの情報を使ってアタックする内容を決めて返す．
	 * 基本的な振る舞いとして，
	 * indexをopponentCardsの有効範囲の乱数，cardNumberを0～11の乱数として，Attackオブジェクトを生成して返すように実装せよ.
	 *
	 * @param drawnCard
	 * @param opponentCards
	 * @return
	 */
	protected Attack decideAttack(Card drawnCard, List<OpponentCard> opponentCards) {
		int index = ThreadLocalRandom.current().nextInt(opponentCards.size());
		int cardNumber = ThreadLocalRandom.current().nextInt(12);
		return new Attack(index, cardNumber);
	}

	/**
	 * TODO 敗北状態の時にtrueを，それ以外の時にfalseを返す
	 *
	 * @return
	 */
	boolean isLose() {
		for (Card card : cards) {
			if (card.getFace() == CardFace.DOWN) {
				return false;
			}
		}
		return true;
	}

}
