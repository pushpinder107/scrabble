package scrabble;

public class Tile {
	Character letter;
	Integer score;

	public Tile(Character letter) {
		this.letter = letter;
		this.score = scrabbleScore(letter);
	}
	
	
	int scrabbleScore(Character letter) {
		int score = 0;
		char EnglishScoreTable[] = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
		if (letter >= 'A' && letter <= 'Z') {
			score += EnglishScoreTable[letter - 'A'];
		}
		return score;
	}

	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
        @Override
	public String toString() {
		return "Tiles [letter=" + letter + ", score=" + score + "]";
	}

}
