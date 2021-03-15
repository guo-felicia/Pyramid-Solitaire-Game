## Pyramid Solitair Game
This is a java interaction game.

### Purpose
The model-view-coontroller architecture is used to support parallel program developing. The overall game is umplemented by three level: 
1) Model - Building a.Basic Pyramid Solitair. 
2) Controller - works with the model and "run" a game of Pyramid Solitair, asking for input and outputting the gamestate. 
3) View - improving the view and develop new fatures : b.Pyramid Solitaire with easier rules and c.Muti-Pyramid Solitaire game.

### BasicPyramidSolitair
- 2d List to represent the game board (line 20)
- new helper getPyramids to create list of list Cards.
- refine all remove methods
- refine isExposed method and getScore method
- re-write the checkDuplicate method instead of using HashSet, use lambda

### PyramidSolitaireTextualController
- switch statement in playGame()
- checkNextInput() method line 135

### PyramidSolitaireTextualView
-refine the render method add "\n" after each line
