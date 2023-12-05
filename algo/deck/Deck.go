package deck

import (
	"algo/card"
	"math/rand"
)

type Deck struct {
	cards []card.Card
}

func GenerateDeck() Deck {
	var deck []card.Card
	for i := 0; i < 12; i++ {
		deck = append(deck, card.Card{
			Color:  "Black",
			Number: i,
		})
	}
	for i := 0; i < 12; i++ {
		deck = append(deck, card.Card{
			Color:  "White",
			Number: i,
		})
	}

	rand.Shuffle(len(deck), func(i, j int) {
		deck[i], deck[j] = deck[j], deck[i]
	})
	return Deck{
		cards: deck,
	}
}

func (deck *Deck) GetTopCard() card.Card {
	topCard := deck.cards[0]
	deck.cards = deck.cards[1:]
	return topCard
}
