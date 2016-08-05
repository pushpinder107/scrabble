package scrabble;

public class MainClass {

	public static void main(String[] args) {
		Character[] rackList = {'A','B','C','E','T','P','U'};
		Rack a = new Rack(rackList);
		System.out.println(a.getBestScore());
	}

}
