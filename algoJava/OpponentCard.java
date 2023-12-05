package org.nkjmlab.mabs.prac.algo.v1;

/**
 * 対戦相手のカードを表すクラス．
 */
public class OpponentCard {

	private final Card card;

	public OpponentCard(Card card) {
		this.card = card;
	}

	/**
	 * このカードの色を返す．
	 *
	 * @return
	 */
	public CardColor getColor() {
		return card.getColor();
	}

	/**
	 * このカードが表向きか裏向きかを返す．
	 *
	 * @return
	 */
	public CardFace getFace() {
		return card.getFace();
	}

	/**
	 * TODO もしこのカードが表だったらこのカードに書かれた数字を返す．もし裏だったらnullを返す．
	 *
	 * @return
	 */
	public Integer getNumberIfFaceUp() {
		return getFace() == CardFace.UP ? card.getNumber() : null;
	}

	@Override
	public String toString() {
		return "OpponentCard [card=" + card + "]";
	}

}
