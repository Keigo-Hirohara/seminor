package helper

import "strings"

func hasMikan(stringList []string) bool {
	for _, str := range stringList {
		if str == "ミカン" {
			return true
		}
	}
	return false
}

func hasFruit(stringList []string, target string) bool {
	for _, str := range stringList {
		if str == target {
			return true
		}
	}
	return false
}

func hasNgWords(sentence string, ngWords []string) bool {
	for _, ngWord := range ngWords {
		if strings.Contains(sentence, ngWord) {
			return true
		}
	}
	return false
}

func hasAllNgWords(sentence string, ngWords []string) bool {
	for _, ngWord := range ngWords {
		if !strings.Contains(sentence, ngWord) {
			return false
		}
	}
	return true
}

func countNgWord(wordList []string, ngWords []string) int {
	count := 0
	for _, word := range wordList {
		if hasNgWords(word, ngWords) {
			count++
		}
	}
	return count
}
