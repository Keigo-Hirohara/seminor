package main

import (
	"fmt"
)

func main() {
	fmt.Printf("hasMikan: %v\n", helper.hasMikan([]string{"リンゴ", "ミカン", "バナナ"}))
	fmt.Printf("hasFruit: %v\n", helper.hasFruit([]string{"リンゴ", "ミカン", "バナナ"}, "ミカン"))
	fmt.Printf("hasNgWords: %v\n", helper.hasNgWords("リンゴはおいしい", []string{"リンゴ", "ミカン"}))
	fmt.Printf("hasAllNgWords: %v\n", helper.hasAllNgWords("リンゴはおいしい", []string{"リンゴ", "ミカン"}))
	fmt.Printf("countNgWord: %v\n", helper.countNgWord([]string{"リンゴはおいしい", "ミカンはおいしい", "バナナはおいしい"}, []string{"リンゴ", "ミカン"}))
}
