# scrabble

We have two classes, Tile and Rack.

The letter combination in the rack is converted to a count-String. 

The Sowpods txt file is searched word by word, to check whether the word is possible to generate from the letters in the rack.

If the word is possible to generate, the score is calculated. 

The (word,Score) Pair is compared with the previous pair generated to identify the word with bigger score. 

If score is bigger, the word is replaced. 

This goes on till EOF. 
