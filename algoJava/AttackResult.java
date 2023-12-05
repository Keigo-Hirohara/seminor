package org.nkjmlab.mabs.prac.algo.v1;

/**
 * アタックの成否を表すクラス
 *
 * @param result アタックの成否
 * @param attack アタックの内容
 */
public record AttackResult(boolean result, Attack attack) {
}
