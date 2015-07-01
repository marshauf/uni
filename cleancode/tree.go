package main

import "fmt"
import "strings"

func main() {
	drawTree(5, true)
	fmt.Println()
	drawTree(10, false)
}

func drawTree(height int, tip bool) {
	beforeCenter := height - 1
	spacesBeforeCenter := strings.Repeat(" ", beforeCenter);
	if tip { fmt.Println(spacesBeforeCenter + "*") }
	
	for i := 0; i < height; i++ {
		fmt.Println(spacesBeforeCenter[:beforeCenter-i] + strings.Repeat("X", 2 * i + 1))
	}
	fmt.Println(spacesBeforeCenter + "X")
}
