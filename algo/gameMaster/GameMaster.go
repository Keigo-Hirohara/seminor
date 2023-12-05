package gameMaster

import (
	"algo/card"
	"algo/deck"
	"algo/player"
	"fmt"
)

type GameMaster struct {
}

func (gameMaster *GameMaster) StartGame() {

	deck := deck.GenerateDeck()

	player1HandCards := []card.Card{}
	player2HandCards := []card.Card{}

	// プレイヤーを生成し、手札を配る
	for i := 0; i < 5; i++ {
		player1HandCards = append(player1HandCards, deck.GetTopCard())
		player2HandCards = append(player2HandCards, deck.GetTopCard())
	}
	playerMain := player.Player{
		Cards: player1HandCards,
	}
	playerOpponent := player.Player{
		Cards: player2HandCards,
	}
	// プレイヤーの手札を昇順にソート
	playerMain.SortHandCards()
	playerOpponent.SortHandCards()

	// プレイヤーの手札を表示
	fmt.Println("\n---------------------------------\n")
	playerMain.DisplayCards()
	fmt.Println("\n\n---------------------------------\n")

	// ターンを決める
	// turn := 0
	// ゲームを開始
	// for {
	// }

	// ターンを進める
	gameMaster.processTurn(playerMain, deck)
}

func (gameMaster *GameMaster) processTurn(player player.Player, deck deck.Deck) {
	// 引数のプレイヤーがカードをドローし、手札を昇順にソートする
	player.Cards = append(player.Cards, deck.GetTopCard())
	player.SortHandCards()

	// ドローしたカードを表示
	fmt.Printf("あなたは %v: %v をドローしました。\n", player.Cards[len(player.Cards)-1].Number, player.Cards[len(player.Cards)-1].Color)
	fmt.Println("\n---------------------------------\n")

	// 相手カードを表示
	player.DisplayOpponentCard()

}
