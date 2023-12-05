package main

import "testing"

func TestHasMikan(t *testing.T) {
	if !hasMikan([]string{"リンゴ", "ミカン", "バナナ"}) {
		t.Error("hasMikan([]string{\"リンゴ\", \"ミカン\", \"バナナ\"}) should be true")
	}
	if hasMikan([]string{"リンゴ", "バナナ"}) {
		t.Error("hasMikan([]string{\"リンゴ\", \"バナナ\"}) should be false")
	}
}
