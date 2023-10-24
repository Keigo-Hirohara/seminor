package card

import "fmt"

type Card struct {
	Color  string
	Number int
}

func (card Card) getColor() string {
	return card.Color
}

func (card Card) getNumber() int {
	return card.Number
}

func (card Card) tooString() string {
	return fmt.Sprintf("Card [color = %v, number = %v]", card.Color, card.Number)
}
