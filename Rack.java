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

}
