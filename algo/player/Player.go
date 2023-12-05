package player

import (
	"algo/card"
	"fmt"
)

type Player struct {
	Cards []card.Card
}

// 手札を昇順にソートする。同じ数字だった場合、白が大きい方に来るようにする。
func (player *Player) SortHandCards() {
	for i := 0; i < len(player.Cards); i++ {
		for j := i + 1; j < len(player.Cards); j++ {
			if player.Cards[i].Number > player.Cards[j].Number {
				player.Cards[i], player.Cards[j] = player.Cards[j], player.Cards[i]
			} else if player.Cards[i].Number == player.Cards[j].Number {
				if player.Cards[i].Color == "White" {
					player.Cards[i], player.Cards[j] = player.Cards[j], player.Cards[i]
				}
			}
		}
	}
}

func (player *Player) DisplayCards() {
	fmt.Println("あなたのカードは以下の通りです。")
	for i := 0; i < len(player.Cards); i++ {
		fmt.Printf("|  %v: %v   ", player.Cards[i].Number, player.Cards[i].Color)
	}
}

func (player *Player) DisplayOpponentCard() {
	fmt.Println("相手のカードは以下の通りです。")
	for i := 0; i < len(player.Cards); i++ {
		fmt.Printf("|  *: %v   ", player.Cards[i].Color)
	}
}
