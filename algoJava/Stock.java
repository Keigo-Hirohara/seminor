package org.nkjmlab.mabs.prac.algo.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Stock {
	static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

	private final Queue<Card> cards;

	public Stock(List<Card> cards) {
		this.cards = new LinkedList<>(cards);
	}

	/**
	 * 一枚カードを引く
	 *
	 * @return
	 */
	Card drawCard() {
		return cards.poll();
	}

	@Override
	public String toString() {
		return "Stock [cards=" + cards + "]";
	}

	/**
	 * アルゴのルールに基づき，初期化された山を作成する
	 *
	 * @return
	 */
	static Stock create() {
		final int MIN_NUMBER = 0;
		final int MAX_NUMBER = 11;
		List<Card> cards = new ArrayList<>();

		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			Card c = new Card(CardColor.BLACK, i);
			cards.add(c);
		}
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			Card c = new Card(CardColor.WHITE, i);
			cards.add(c);
		}

		Collections.shuffle(cards);

		return new Stock(cards);
	}

	/**
	 * カードの枚数を返す．
	 *
	 * @return
	 */
	int size() {
		return cards.size();
	}
}
