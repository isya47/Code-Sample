package F28DA_CW2;

import java.util.List;

public class Journey implements IJourneyPartB<Airport, Flight>, IJourneyPartC<Airport, Flight> {

	private List<String> stops;
	private List<String> flight;
	private int hop;
	private int cost;

	public Journey(List<String> stops, List<String> flight, int hop, int cost){
		this.stops = stops;
		this.flight = flight;
		this.hop = hop;
		this.cost = cost;
		
		
	}
	
	@Override
	public List<String> getStops() {
		return stops;
	}

	@Override
	public List<String> getFlights() {
		return flight;
	}

	@Override
	public int totalHop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int airTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int connectingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalTime() {
		// TODO Auto-generated method stub
		return 0;
	}

}
