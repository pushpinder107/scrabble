package scrabble;

import java.util.ArrayList;
import java.util.List;

public class Rack {
	List<Tile> rack = new ArrayList<>();

	public Rack(Character[] rackList) {
		for (Character letter : rackList) {
			rack.add(new Tile(letter));
		}
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
	
	public String getBestWord(){
		String bestWord;
		int[] countArr=new int[26]();
		for(int i=0;i<7;i++){
			countArr[rack.get(i).getLetter()-'A']++;
		}
		bestWord = searchForBestMatch(countArr);
	}
	
	public string searchForBestMatch(int[] countArr){
		String bestWord="";
		int bestScore="";
		try{
			// Open the file
			FileInputStream fstream = new FileInputStream("sowpods.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine="";

			ArrayList<String> wordsInALine=new ArrayList<String>();
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
			  if(isPossibleAnagram(countArr,strLine){
				score=generateScore(strLine); //implement This 
				if(score>bestScore){
					bestScore=score;
					bestWord=strLine;
				}
			  }
			}
	        
			//Close the input stream
			br.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return bestWord;
	}
	
	public boolean isPossibleAnagram(int[] countArr, String dictWord){
		boolean isPossible=false;
		int[] dictCountArr= new int[26]();
		int i=0;
		for(i=0;i<dictWord.length();i++){
			dictCountArr[dictWord-'A']++;
		}
		
		for(i=0;i<26;i++){
			if(dictCountArr[i]>arrCount[i]){
				break;
			}
		}
		
		if(i==26)
			isPossible=true;
		return isPossible;
	}
}


