package org.nkjmlab.mabs.prac.algo.v1;

/**
 * アタックを表すクラス
 * 
 * @param index      左から何番目のカードかを表すインデックス．一番左のインデックスは0
 * @param cardNumber カードの番号
 */

public record Attack(int index, int cardNumber) {
}
