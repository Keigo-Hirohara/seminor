package main

import (
	"algo/card"
	"fmt"
)

func main() {
	var deck []card.Card
	for i := 0; i < 11; i++ {
		deck = append(deck, card.Card{
			Color:  "Black",
			Number: i + 1,
		})
	}
	for i := 0; i < 11; i++ {
		deck = append(deck, card.Card{
			Color:  "White",
			Number: i + 1,
		})
	}

	fmt.Printf("success: card: %v\n", deck)
}
