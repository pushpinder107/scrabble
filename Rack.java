package scrabble;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rack {
	List<Tile> rack = new ArrayList<>();

	public Rack(Character[] rackList) {
		for (Character letter : rackList) {
			rack.add(new Tile(letter));
		}
	}
	public Rack(List<Tile> l) {
		this.rack = l;
	}
	@Override
	public String toString() {
		return "Rack [rack=" + rack + "]";
	}

	public List<Tile> getRack() {
		return rack;
	}

	public void setRack(List<Tile> rack) {
		this.rack = rack;
	}

	public String getBestWord() {
		String best = "";
		for (int i = 0; i < 7; i++) {
			if (rack.get(i).getLetter() == ' ') {
				best = getBestWhenBlank();
			} else {
				best = getBestMatch();
			}
		}
		return best;

	}

	public String getBestWhenBlank() {
		String best ="";
		int lastMaxScore = 0;
		for (int i = 0; i < 7; i++) {
			if (rack.get(i).getLetter() == ' ') {
				List<Tile> newTile =  new ArrayList<>();
				Collections.copy(newTile, rack);
				for (int j = 0; j < 26; j++) {
					char replacement = (char) (j + 'A');
					String currBest = new Rack(newTile).getBestMatch();
					if(generateScore(currBest) > lastMaxScore) {
						lastMaxScore = generateScore(currBest) - getCharacterScore(replacement);
						best = currBest;
					}
				}
			}
		}
		return best;
	}

	public String getBestMatch() {
		int[] countArr = new int[26];
		for (int i = 0; i < 7; i++) {
			countArr[rack.get(i).getLetter() - 'A']++;
		}
		return searchForBestMatch(countArr);

	}

	public String searchForBestMatch(int[] countArr) {
		String bestWord = "";
		int bestScore = 0;
		try {
			// Open the file
			FileInputStream fstream = new FileInputStream("C:\\Users\\pushpisingh\\Desktop\\sowpods.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = "";
			int score = 0;
			ArrayList<String> wordsInALine = new ArrayList<String>();
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				if (isPossibleAnagram(countArr, strLine.toUpperCase())) {
					score = generateScore(strLine); // implement This
					if (score > bestScore) {
						bestScore = score;
						bestWord = strLine;
					}
				}
			}

			// Close the input stream
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bestWord;
	}

	public boolean isPossibleAnagram(int[] countArr, String dictWord) {
		int[] dictCountArr = new int[26];
		int i = 0;
		char[] inputWord = dictWord.toCharArray();

		for (i = 0; i < inputWord.length; i++) {
			dictCountArr[inputWord[i] - 'A']++;
		}

		for (i = 0; i < 26; i++) {
			if (dictCountArr[i] > countArr[i]) {
				return false;
			}
		}
		return true;
	}

	public int generateScore(String s) {
		int score = 0;
		for (int i = 0; i < s.length(); i++) {
			score = score + getCharacterScore(s.charAt(i));
		}
		return score;

	}

	public int getCharacterScore(char ch) {
		if (ch == 'A' || ch == 'I' || ch == 'E' || ch == 'N' || ch == 'O' || ch == 'R' || ch == 'S' || ch == 'T'
				|| ch == 'U') {
			return 1;
		} else if (ch == 'D' || ch == 'G') {
			return 2;
		} else if (ch == 'B' || ch == 'C' || ch == 'M' || ch == 'P') {
			return 3;
		} else if (ch == 'F' || ch == 'H' || ch == 'V' || ch == 'W' || ch == 'Y') {
			return 4;
		} else if (ch == 'K') {
			return 5;
		} else if (ch == 'J' || ch == 'X') {
			return 8;
		} else {
			return 10;
		}
	}

	public String getBestWordWithBalnl() {
		return "";
	}
}
