package org.nkjmlab.mabs.prac.algo.v1;

/**
 * カードを表すクラス
 */
public class Card {

	private final CardColor color;
	private final int number;
	private CardFace face;

	public Card(CardColor color, int number) {
		this(color, number, CardFace.DOWN);
	}

	public Card(CardColor color, int number, CardFace face) {
		this.color = color;
		this.number = number;
		this.face = face;
	}

	/**
	 * このカードが白か黒かを返す
	 *
	 * @return
	 */
	public CardColor getColor() {
		return color;
	}

	/**
	 * このカードの番号を返す
	 *
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * このカードが表面か裏面かを返す
	 *
	 * @return
	 */
	public CardFace getFace() {
		return face;
	}

	@Override
	public String toString() {
		return "[" + color + ":" + number + ":" + face + "]";
	}

	/**
	 * TODO 課題 このカードを表面にする．
	 *
	 */
	public void faceUp() {
		this.face = CardFace.UP;
	}

	/**
	 * このカードを裏面にする
	 */
	public void faceDown() {
		this.face = CardFace.DOWN;
	}

}
